package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.BookingDTO;
import model.BookingDAO;
import model.Service;


@WebServlet("/search")
public class SearchController extends HttpServlet {

    public SearchController() {
        super();
    }

    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String bookingSearchNo = request.getParameter("bookingSearchNo");
				
		Service service = new Service();
		String bookingNo = String.valueOf(service.getBooking());
		
		
		for(BookingDTO d : dtoList) {
			if(bookingNo != null && bookingNo.equals(bookingSearchNo)) {
				request.getRequestDispatcher("bookingDetail.jsp").forward(request, response);
			}
			else {
				response.sendRedirect("failSearch.jsp");
			}
		}

	}

}
