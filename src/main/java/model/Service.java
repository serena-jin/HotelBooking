package model;

import java.sql.SQLException;
import java.util.ArrayList;

import dto.BookingDTO;
import dto.CustomerDTO;
import dto.RoomDTO;
import exception.NotExistException;
import util.DBUtil;

public class Service {
	
	//customer CURD
	//no customer
	public static void notExistCustomer(String cId) throws SQLException, NotExistException{
		CustomerDTO customer = CustomerDAO.getCustomer(cId);
		if(cId == null) {
			throw new NotExistException("검색하신 ID는 존재하지 않습니다.");
		}
	}
	
	
	//Get Customer All
	public static ArrayList<CustomerDTO> getCustomers() throws SQLException{
		return CustomerDAO.getCustomers();
	}
	
	
	//Get Customer One
	public static CustomerDTO getCustomer(String cId) throws SQLException, NotExistException{
		CustomerDTO customer = CustomerDAO.getCustomer(cId);
		if(cId == null) {
			throw new NotExistException("검색하신 ID는 존재하지 않습니다.");
		}
		return customer;
	}
	
	
	//Add a new customer
	public static boolean addCustomer(CustomerDTO customer) throws SQLException{
		return CustomerDAO.addCustomer(customer);
	}
	
	
	//Update a customer
	public static boolean updateCustomer(String cId, String cPw) throws SQLException, NotExistException{
		notExistCustomer(cId);
		return CustomerDAO.updateCustomer(cId, cPw);
	}
	
	
	//Delete a customer
	public static boolean deleteCustomer(String cId) throws SQLException, NotExistException{
		notExistCustomer(cId);
		return CustomerDAO.deleteCustomer(cId);
	}
	
	
	
	///////////////////////////////////////////////////////////////////////////////////////
	//room CURD
	//no room
	public static void notExistRoom(String rId) throws SQLException, NotExistException{
		RoomDTO room = RoomDAO.getRoom(rId);
		if(rId == null) {
			throw new NotExistException("검색하신 객실은 존재하지 않습니다.");
		}
	}
	
	
	//Rooms All
	public static ArrayList<RoomDTO> getRooms() throws SQLException{
		return RoomDAO.getRooms();
	}
	
	
	//Room One
	public static RoomDTO getRoom(String rId) throws SQLException, NotExistException{
		RoomDTO room = RoomDAO.getRoom(rId);
		if(room == null) {
			throw new NotExistException("검색하신 객실은 존재하지 않습니다.");
		}
		return room;
	}
	
	
	//Add a new room
	public static boolean addRoom(RoomDTO room) throws SQLException{
		return RoomDAO.addRoom(room);
	}
	
	
	//Update a customer
	public static boolean updateRoom(String rId, int rPrice) throws SQLException, NotExistException{
		notExistRoom(rId);
		return RoomDAO.updateRoom(rId, rPrice);
	}
	
	
	//Delete a room
	public static boolean deleteRoom(String rId) throws SQLException, NotExistException{
		notExistRoom(rId);
		return RoomDAO.deleteRoom(rId);
	}
	
	
	
	///////////////////////////////////////////////////////////////////////////////////////
	//booking CURD
	//no booking
	public static void notExistBooking(int bNo) throws SQLException, NotExistException{
		BookingDTO booking = BookingDAO.getBooking(bNo);
		if(booking == null) {
			throw new NotExistException("검색하진 예약 정보가 없습니다.");
		}
	}
	
	
	//Booking All
	public static ArrayList<BookingDTO> getBookings() throws SQLException{
		return BookingDAO.getBookings();
	}
	
	
	//Booking One
	public static BookingDTO getBooking(int bNo) throws SQLException, NotExistException{
		BookingDTO booking = BookingDAO.getBooking(bNo);
		if(booking == null) {
			throw new NotExistException("검색하진 예약은 존재하지 않습니다.");
		}
		return booking;
	}
	
	
	//Add a new booking
	public static boolean addBooking(BookingDTO booking) throws SQLException{
		return BookingDAO.addBooking(booking);
	}
	
	
	//Update a booking
	public static boolean updateBooking(int bNo, int bAdults, int bKids) throws SQLException, NotExistException{
		notExistBooking(bNo);
		return BookingDAO.updateBooking(bNo, bAdults, bKids);
	}
	
	
	//Delete a booking
	public static boolean deleteBooking(int bNo) throws SQLException, NotExistException{
		notExistBooking(bNo);
		return BookingDAO.deleteBooking(bNo);
	}
	
	
	
	
	//////////////////////////////////////////////////////////////////////
	//validateCustomer
	public static int validateCustomer(String loginId, String loginPw) throws SQLException{
		return CustomerDAO.validateCustomer(loginId, loginPw);
	}


	
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) throws SQLException, NotExistException {
		
		
//		System.out.println(getCustomer("cst_1"));
//		System.out.println(getCustomers());
//		
//		System.out.println(getRoom("room1"));
//		System.out.println(getRooms());
//		
//		System.out.println(getBooking(1));
//		System.out.println(getBookings());
//		
//		//validateCustomer(CustomerDTO customer)
//		System.out.println(validateCustomer("cst_4", "444"));
		

	}

}
