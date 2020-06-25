package myservlet;

import javax.servlet.annotation.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

@WebServlet("/Price")
public class Price extends HttpServlet{

	// calculate price
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int total=0;
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		
		String[] input = request.getParameterValues("seat");
	
		for(int i=0; i<input.length; i++){	
			if (input[i].contains("C") || input[i].contains("B")) {
				total = total + 2000;
			}
			else if (input[i].contains("A")) {
				total = total + 10000;
			}
		}
		
		out.print("<h1>Total price is "+total+"</h1>");
	}
	
}
