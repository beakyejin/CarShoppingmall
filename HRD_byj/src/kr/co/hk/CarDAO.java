package kr.co.hk;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CarDAO {

	public static List<CarVO> getCarList() {
		System.out.println("------------getCarList Start------------");
		List<CarVO> list= new ArrayList<CarVO>();
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = "  select "
					+" 		c_no, "
					+"		c_name, "
					+"		to_char(c_regdate, 'yyyy-mm-dd') as c_regdate, "
					+" 		SUBSTR(c_price,1, 4) as c_price "
					+"	from car_info "
					+" 	order by c_no desc";
		
		try {
			con = DBConnector.getConn();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()){
				CarVO vo = new CarVO();
				
				int c_no = rs.getInt("c_no");
				String c_name = rs.getString("c_name");
				String c_regdate = rs.getString("c_regdate");
				int c_price = rs.getInt("c_price");

				vo.setC_no(c_no);
				vo.setC_name(c_name);
				vo.setC_regdate(c_regdate);
				vo.setC_price(c_price);
				
				list.add(vo);
				
				System.out.printf("%d %s %s %d\n", 
						c_no, c_name, c_regdate, c_price);
			}
		} catch (Exception e) {
			System.out.println("getCarList 에러!");
			e.printStackTrace();
		} finally {
			DBConnector.close(con, ps, rs);
		}
		
		System.out.println("------------getCarList End------------");
		return list;
	}

	public static int getCarMaxNo() {
		System.out.println("------------getCarMaxNo Start------------");
		int no = 0;
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = " select nvl(max(c_no),100000)+1 from car_info ";
		
		try {
			con = DBConnector.getConn();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			if(rs.next()){
				no = rs.getInt(1);
				System.out.println("no : " + no);
			}
		} catch (Exception e) {
			System.out.println("getCarMaxNo 에러!");
			e.printStackTrace();
		} finally {
			DBConnector.close(con, ps, rs);
		}
		
		System.out.println("------------getCarMaxNo End------------");
		return no;
	}

	public static List<CompanyVO> getComList() {
		System.out.println("------------getComList Start------------");
		List<CompanyVO> list = new ArrayList<CompanyVO>();
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = " select com_no,com_name from company_info ";
		
		try {
			con = DBConnector.getConn();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()){
				CompanyVO vo = new CompanyVO();
				vo.setCom_name(rs.getString("com_name"));
				vo.setCom_no(rs.getInt("com_no"));
				
				System.out.println("com_no: " + vo.getCom_no());
				System.out.println("com_name: " + vo.getCom_name());
				list.add(vo);
			}
			
		} catch (Exception e) {
			System.out.println("getComList 에러!");
			e.printStackTrace();
		} finally {
			DBConnector.close(con, ps, rs);
		}
		
		System.out.println("------------getComList End------------");
		return list;
	}

	public static void insertCar(CarVO vo) {
		System.out.println("------------insertCar Start------------");
		
		Connection con = null;
		PreparedStatement ps = null;
		
		String sql = " insert into car_info "
				+ " (c_no, com_no, c_name, c_type, c_regdate, c_price, c_cc) "
				+ " values "
				+ " (?, ?, ?, ?, ?, ?, ?) ";
		
		try {
			con = DBConnector.getConn();
			ps = con.prepareStatement(sql);
			ps.setInt(1, vo.getC_no());
			ps.setInt(2, vo.getCom_no());
			ps.setString(3, vo.getC_name());
			ps.setString(4, vo.getC_type());
			ps.setString(5, vo.getC_regdate());
			ps.setInt(6, vo.getC_price());
			ps.setInt(7, vo.getC_cc());
			
			ps.execute();
		} catch (Exception e) {
			System.out.println("insertCar 에러!");
			e.printStackTrace();
		} finally {
			DBConnector.close(con, ps, null);
		}
		
		System.out.println("------------insertCar End------------");
	}

	public static int getComMaxNo() {
		System.out.println("------------getComMaxNo Start------------");
		int no = 0;
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = " select nvl(max(com_no),70)+1 from company_info ";
		
		try {
			con = DBConnector.getConn();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			if(rs.next()){
				no = rs.getInt(1);
				System.out.println("maxComNo: " + no );
			}
			
		} catch (Exception e) {
			System.out.println("getComMaxNo 에러!");
		} finally {
			DBConnector.close(con, ps, rs);
		}
		
		System.out.println("------------getComMaxNo End------------");
		return no;
	}

	public static void insertCom(CompanyVO vo) {
		System.out.println("------------insertCom Start------------");
		
		Connection con = null;
		PreparedStatement ps = null;
		
		String sql = " insert into company_info "
					+" (com_no, com_name, com_addr, com_amount, com_total) "
					+" values "
					+" (?, ?, ?, 0, 0) ";
		
		try {
			con = DBConnector.getConn();
			ps = con.prepareStatement(sql);
			ps.setInt(1, vo.getCom_no());
			ps.setString(2, vo.getCom_name());
			ps.setString(3, vo.getCom_addr());
			ps.execute();
		} catch (Exception e) {
			System.out.println("CompanyVO 에러!");
			e.printStackTrace();
		} finally {
			DBConnector.close(con, ps, null);
		}
		
		System.out.println("------------insertCom End------------");
	}

	public static CarVO getCarDetail(int no) {
		System.out.println("------------getCarDetail Start------------");
		CarVO vo = new CarVO();
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = " select " 
					+" 		a.c_no, b.com_name, a.c_name, a.c_type, a.com_no, " 
					+" 		to_char(a.c_regdate, 'yyyy-mm-dd') as c_regdate, " 
					+" 		substr(a.c_price, 1, 4) as c_price, " 
					+"    	a.c_cc "
					+" from car_info a " 
					+" join company_info b " 
					+" on a.com_no = b.com_no "
					+" group by "
					+"		a.c_no, a.c_name, a.c_type, a.c_regdate, "
					+"		a.c_price, a.c_cc, b.com_name, a.com_no"
					+" 		having a.c_no = ? ";
		
		try {
			con = DBConnector.getConn();
			ps = con.prepareStatement(sql);
			ps.setInt(1, no);
			rs = ps.executeQuery();
			
			while(rs.next()){
				int c_no = rs.getInt("c_no");
				String com_name = rs.getString("com_name");
				String c_name = rs.getString("c_name");
				String c_type = rs.getString("c_type");
				String c_regdate = rs.getString("c_regdate");
				int c_price = rs.getInt("c_price");
				int c_cc = rs.getInt("c_cc");
				int com_no =rs.getInt("com_no");
				
				vo.setC_no(c_no);
				vo.setCom_name(com_name);
				vo.setC_name(c_name);
				vo.setC_type(c_type);
				vo.setC_regdate(c_regdate);
				vo.setC_price(c_price);
				vo.setC_cc(c_cc);
				vo.setCom_no(com_no);
				
				System.out.printf("%d %s %s %s %s %s %d %d\n", 
						c_no, com_no, com_name, c_name, c_type, c_regdate, c_price, c_cc);
			}
			
		} catch (Exception e) {
			System.out.println("getCarDetail 에러!");
			e.printStackTrace();
		} finally{
			DBConnector.close(con, ps, rs);
		}
		
		System.out.println("------------getCarDetail End------------");
		return vo;
	}

	public static void updateCompany(int c_price, int com_no) {
		System.out.println("------------updateCompany Start------------");
		
		Connection con = null;
		PreparedStatement ps = null;
		
		String sql = " update company_info "
					+" set "
					+"		com_amount=(select com_amount from company_info where com_no=?)+1 "
					+"	  , com_total =(select com_total from company_info where com_no=?)+"
						+c_price+"0000"
					+" where com_no = ? ";
		
		try {
			con = DBConnector.getConn();
			ps = con.prepareStatement(sql);
			ps.setInt(1, com_no);
			ps.setInt(2, com_no);
			ps.setInt(3, com_no);
			
			ps.execute();
			
		} catch (Exception e) {
			System.out.println("updateCompany 에러!");
			e.printStackTrace();
		} finally {
			DBConnector.close(con, ps, null);
		}
		
		System.out.println("------------updateCompany End------------");
	}

	public static void updateCar(CarVO vo) {
		System.out.println("------------updateCar Start------------");
		
		Connection con = null;
		PreparedStatement ps = null;
		
		String sql = " update car_info "
				+ " set "
				+ "		c_name=?, "
				+ "		c_type=?, "
				+ "		c_regdate=?, "
				+ "		c_price=? , "
				+ "		c_cc=? "
				+ "where c_no=? ";
		
		try {
			con = DBConnector.getConn();
			ps = con.prepareStatement(sql);
			ps.setString(1, vo.getC_name());
			ps.setString(2, vo.getC_type());
			ps.setString(3, vo.getC_regdate());
			ps.setInt(4, vo.getC_price());
			ps.setInt(5, vo.getC_cc());
			ps.setInt(6, vo.getC_no());
			ps.execute();
			
		} catch (Exception e) {
			System.out.println("updateCar 에러!");
			e.printStackTrace();
		} finally {
			DBConnector.close(con, ps, null);
		}
		
		System.out.println("------------updateCar End------------");
	}

	public static List<CompanyVO> getComAllSell() {
		System.out.println("------------getComAllSell Start------------");
		
		List<CompanyVO> list = new ArrayList<CompanyVO>();
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = " select "
				+ "			com_name, com_amount, substr(com_total,1, 4) as com_total "
				+ " from company_info "
				+ " order by com_amount desc ";
		
		try {
			con = DBConnector.getConn();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()){
				CompanyVO vo = new CompanyVO();
				String com_name = rs.getString("com_name");
				int com_amount = rs.getInt("com_amount");
				int com_total = rs.getInt("com_total");
				
				vo.setCom_name(com_name);
				vo.setCom_amount(com_amount);
				vo.setCom_total(com_total);
				
				System.out.printf("%s %d %d\n"
						, com_name, com_amount, com_total);

				list.add(vo);
			}
			
		} catch (Exception e) {
			System.out.println("getComAllSell 에러!");
			e.printStackTrace();
		} finally {
			DBConnector.close(con, ps, rs);
		}
		
		System.out.println("------------getComAllSell End------------");
		return list;
	}	
	
	
}
