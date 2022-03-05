package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dto.RoomDTO;
import util.DBUtil;

public class RoomDAO {
	
	
	//Create
	public static boolean addRoom(RoomDTO room) throws SQLException {

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement("INSERT INTO room VALUES(?,?,?,?)");

			pstmt.setString(1, room.getrId());
			pstmt.setString(2, room.getrType());
			pstmt.setInt(3, room.getrPrice());
			pstmt.setString(4, room.getrBedsize());

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
	public static boolean updateRoom(String rId, int rPrice) throws SQLException {

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement("UPDATE room SET r_price=? WHERE r_id=?");

			pstmt.setInt(1, rPrice);
			pstmt.setString(2, rId);

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
	public static boolean deleteRoom(String rId) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement("DELETE FROM room WHERE r_id=?");

			pstmt.setString(1, rId);

			int result = pstmt.executeUpdate();
			if (result == 1) {
				return true;
			}
		} finally {
			DBUtil.close(conn, pstmt);
		}
		return false;
	}

	
	
	// Select (single room)
	public static RoomDTO getRoom(String rId) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		RoomDTO room = null;

		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement("SELECT * FROM room WHERE r_id=?");

			pstmt.setString(1, rId);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				room = new RoomDTO();
				room.setrId(rs.getString("r_id"));
				room.setrType(rs.getString("r_type"));
				room.setrPrice(rs.getInt("r_price"));
				room.setrBedsize(rs.getString("r_bedsize"));
			}
		} finally {
			DBUtil.close(conn, pstmt, rs);
		}
		return room;
	}

	
	
	// Select (all)
	public static ArrayList<RoomDTO> getRooms() throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		ArrayList<RoomDTO> al = new ArrayList<RoomDTO>();

		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement("SELECT * FROM room");
			rs = pstmt.executeQuery();

			while (rs.next()) {
				RoomDTO room = new RoomDTO();
				room.setrId(rs.getString("r_id"));
				room.setrType(rs.getString("r_type"));
				room.setrPrice(rs.getInt("r_price"));
				room.setrBedsize(rs.getString("r_bedsize"));
				
				al.add(room);
			}
		} finally {
			DBUtil.close(conn, pstmt, rs);
		}
		return al;
	}


	
	
	public static void main(String[] args) throws SQLException {
		
//		//select all
//		System.out.println(getRooms());
//		System.out.println("-------------------------------------------------------------");
//		
//		
//		//select one
//		System.out.println(getRoom("room3"));
//		System.out.println("-------------------------------------------------------------");
//		
//		
//		//create
//		System.out.println(addRoom(new RoomDTO("room4", "Suite", 500000, "ExtraLargeKing")));
//		System.out.println(getRooms());
//		System.out.println("-------------------------------------------------------------");
//		
//		//update
//		System.out.println(updateRoom("room4", 600000));
//		System.out.println(getRooms());
//		System.out.println("-------------------------------------------------------------");
//		
//		//delete
//		System.out.println(deleteRoom("room4"));
//		System.out.println(getRooms());

	}

	
}
