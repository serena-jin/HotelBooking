package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dto.CustomerDTO;
import util.DBUtil;

public class CustomerDAO {
	
	
	//Create
	public static boolean addCustomer(CustomerDTO customer) throws SQLException{
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement("INSERT INTO customer VALUES(?,?,?)");
			
			pstmt.setString(1, customer.getcId());
			pstmt.setString(2, customer.getcNname());
			pstmt.setString(3, customer.getcPw());
			
			int result = pstmt.executeUpdate();
			
			if(result == 1){
				return true;
			}		
		}finally{
			DBUtil.close(conn, pstmt);
		}
		return false;
	}
	
	
	
	//Update
	public static boolean updateCustomer(String cId, String cPw) throws SQLException{
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement("UPDATE customer SET c_pw=? WHERE c_id=?");
			
			pstmt.setString(1, cPw);
			pstmt.setString(2, cId);
			
			int result = pstmt.executeUpdate();
			if(result == 1){
				return true;
			}
		}finally {
			DBUtil.close(conn, pstmt);
		}
		return false;
	}
	
	
	
	//Delete
	public static boolean deleteCustomer(String cId) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement("DELETE FROM customer WHERE c_id=?");
			
			pstmt.setString(1, cId);
			
			int result = pstmt.executeUpdate();
			if(result == 1){
				return true;
			}	
		}finally {
			DBUtil.close(conn, pstmt);
		}
		return false;
	}
	
	
	
	//Select (single user)
	public static CustomerDTO getCustomer(String cId) throws SQLException{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		CustomerDTO customer = null;
		
		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement("SELECT * FROM customer WHERE c_id=?");
			
			pstmt.setString(1, cId);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				customer = new CustomerDTO();
				customer.setcId(rs.getString("c_id"));
				customer.setcNname(rs.getString("c_name"));
				customer.setcPw(rs.getString("c_pw"));
			}
		}finally {
			DBUtil.close(conn, pstmt, rs);
		}
		return customer;
	}
	
	
	
	//Select (all)
	public static ArrayList<CustomerDTO> getCustomers() throws SQLException{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		ArrayList<CustomerDTO> al = new ArrayList<CustomerDTO>();
		
		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement("SELECT * FROM customer");
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				CustomerDTO customer = new CustomerDTO();
				customer.setcId(rs.getString("c_id"));
				customer.setcNname(rs.getString("c_name"));
				customer.setcPw(rs.getString("c_pw"));
				
				al.add(customer);
			}
		}finally {
			DBUtil.close(conn, pstmt, rs);
		}
		return al;
	}
	
	
	
	public static int validateCustomer(String loginId, String loginPw) throws SQLException{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = -1;
		
		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement("SELECT c_pw FROM customer WHERE c_id=?");
			
			pstmt.setString(1, loginId);
			rs = pstmt.executeQuery();
			
			if(rs.next()) { //아이디 존재
				if(rs.getString("c_pw").equals(loginPw)) {
					return 1; //pw 일치
				}else {
					return 0; //pw 불일치
				}
			}else {
					result = -1; //아이디 미존재
				}			
		}finally {
			DBUtil.close(conn, pstmt, rs);
		}
		return result;
	}
	
	
	
	
	//validateCustomer
//	public static int validateCustomer(CustomerDTO customer) throws SQLException{
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		int result = -1;
//		
//		try {
//			conn = DBUtil.getConnection();
//			pstmt = conn.prepareStatement("SELECT c_pw FROM customer WHERE c_id=?");
//			
//			pstmt.setString(1, customer.getcId());
//			rs = pstmt.executeQuery();
//			
//			if(rs.next()) { //아이디 존재
//				if(rs.getString("c_pw").equals(customer.getcPw())) {
//					return 1; //pw 일치
//				}else {
//					return 0; //pw 불일치
//				}
//			}else {
//					result = -1; //아이디 미존재
//				}			
//		}finally {
//			DBUtil.close(conn, pstmt, rs);
//		}
//		return result;
//	}
	

 
	public static void main(String[] args) throws SQLException{
		
//		//Select all
//		System.out.println("--------select all--------");
//		System.out.println(getCustomers());
//		
//		
//		
//		//Select one
//		System.out.println("--------select one--------");
//		System.out.println(getCustomer("cst_4"));
//		
//		
//		
//		//Delete
//		System.out.println("--------Delete--------");
//		System.out.println(deleteCustomer("cst_4"));
//		//Select all
//		System.out.println("--------select all after delete--------");
//		System.out.println(getCustomers());
//		
//		
//
//		//Create
//		System.out.println("--------Create--------");
//		System.out.println(addCustomer(new CustomerDTO("cst_4", "진미란", "4444")));
//		//Select all
//		System.out.println("--------select all after create--------");
//		System.out.println(getCustomers());
//		
//		
//		
//		//Update
//		System.out.println("--------Update--------");
//		System.out.println(updateCustomer("cst_4", "444"));
//		//Select all
//		System.out.println("--------select all after update--------");
//		System.out.println(getCustomers());
		
		
		
//		//validateCustomer
//		System.out.println(validateCustomer("cst_4","444"));
		
		
	}


}
