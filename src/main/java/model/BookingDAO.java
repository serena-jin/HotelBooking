package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dto.BookingDTO;
import util.DBUtil;

public class BookingDAO {

	// Create
	public static boolean addBooking(BookingDTO booking) throws SQLException {

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement("INSERT INTO booking VALUES(b_no_seq.nextval,?,?,?,?,?,?)");
			pstmt.setString(1, booking.getbCstId());
			pstmt.setString(2, booking.getbCheckin());
			pstmt.setString(3, booking.getbCheckout());
			pstmt.setInt(4, booking.getbAdults());
			pstmt.setInt(5, booking.getbKids());
			pstmt.setString(6, booking.getbRoomtype());

			int result = pstmt.executeUpdate();

			if (result == 1) {
				return true;
			}
		} finally {
			DBUtil.close(conn, pstmt);
		}
		return false;
	}

	
	
	// Update
	public static boolean updateBooking(int bNo, int bAdults, int bKids) throws SQLException {

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement("UPDATE booking SET b_adults=?, b_kids=? WHERE b_no=?");

			pstmt.setInt(1, bAdults);
			pstmt.setInt(2, bKids);
			pstmt.setInt(3, bNo);

			int result = pstmt.executeUpdate();
			if (result == 1) {
				return true;
			}
		} finally {
			DBUtil.close(conn, pstmt);
		}
		return false;
	}

	
	
	// Delete
	public static boolean deleteBooking(int bNo) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement("DELETE FROM booking WHERE b_no=?");

			pstmt.setInt(1, bNo);

			int result = pstmt.executeUpdate();
			if (result == 1) {
				return true;
			}
		} finally {
			DBUtil.close(conn, pstmt);
		}
		return false;
	}

	
	
	// Select (single user)
	public static BookingDTO getBooking(int bNo) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		BookingDTO booking = null;

		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement("SELECT * FROM booking WHERE b_no=?");

			pstmt.setInt(1, bNo);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				booking = new BookingDTO();
				booking.setbNo(rs.getInt("b_no"));
				booking.setbCstId(rs.getString("b_cst_id"));
				booking.setbCheckin(rs.getString("b_checkin"));
				booking.setbCheckout(rs.getString("b_checkout"));
				booking.setbAdults(rs.getInt("b_adults"));
				booking.setbKids(rs.getInt("b_kids"));
				booking.setbRoomtype(rs.getString("b_room_type"));
			}
		} finally {
			DBUtil.close(conn, pstmt, rs);
		}
		return booking;
	}

	
	
	// Select (all)
	public static ArrayList<BookingDTO> getBookings() throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		ArrayList<BookingDTO> al = new ArrayList<BookingDTO>();

		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement("SELECT * FROM booking");
			rs = pstmt.executeQuery();

			while (rs.next()) {
				BookingDTO booking = new BookingDTO();
				booking.setbNo(rs.getInt("b_no"));
				booking.setbCstId(rs.getString("b_cst_id"));
				booking.setbCheckin(rs.getString("b_checkin"));
				booking.setbCheckout(rs.getString("b_checkout"));
				booking.setbAdults(rs.getInt("b_adults"));
				booking.setbKids(rs.getInt("b_kids"));
				booking.setbRoomtype(rs.getString("b_room_type"));

				al.add(booking);
			}
		} finally {
			DBUtil.close(conn, pstmt, rs);
		}
		return al;
	}

	
	
	
	
	
	public static void main(String[] args) throws SQLException {

//		//select all
//		System.out.println("-----------select all----------");
//		System.out.println(getBookings());
//		
//		//select one
//		System.out.println();
//		System.out.println("-----------select one----------");
		System.out.println(getBooking(2));
//		
//		//create
//		System.out.println();
//		System.out.println("-----------create----------");
//		System.out.println(addBooking(new BookingDTO("cst_3", "2022-02-15", "2022-02-25", 1, 0, "Delux Room")));
//		
//		//updateBooking(int bNo, int bAdults, int bKids)
//		System.out.println();
//		System.out.println("-----------update----------");
//		System.out.println(updateBooking(2, 2, 1));
//		System.out.println(getBookings());
//		
//		//delete
//		System.out.println();
//		System.out.println("-----------delete----------");
//		System.out.println(deleteBooking(3));
//		System.out.println(getBookings());
		
		
		

	}

}
