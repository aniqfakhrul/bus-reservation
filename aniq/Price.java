package myservlet;

import javax.servlet.annotation.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import java.text.*;

@WebServlet("/Price")
public class Price extends HttpServlet{

	// calculate price
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		int total=0;
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();

		Date dNow = new Date( );
		SimpleDateFormat ft = new SimpleDateFormat ("dd . MM . yyyy");
		
		String[] input = request.getParameterValues("seat");
	
		out.print("<html><head><meta charset='utf-8'><title>A simple, clean, and responsive HTML invoice template</title><style>.invoice-box {max-width: 800px;margin: auto;padding: 30px;border: 1px solid #eee;box-shadow: 0 0 10px rgba(0, 0, 0, .15);font-size: 16px;line-height: 24px;font-family: 'Helvetica Neue', 'Helvetica', Helvetica, Arial, sans-serif;color: #555;}.invoice-box table {width: 100%;line-height: inherit;text-align: left;}.invoice-box table td {padding: 5px;vertical-align: top;}.invoice-box table tr td:nth-child(2) {text-align: right;}.invoice-box table tr.top table td {padding-bottom: 20px;}.invoice-box table tr.top table td.title {font-size: 45px;line-height: 45px;color: #333;}.invoice-box table tr.information table td {padding-bottom: 40px;}.invoice-box table tr.heading td {background: #eee;border-bottom: 1px solid #ddd;font-weight: bold;}.invoice-box table tr.details td {padding-bottom: 20px;}.invoice-box table tr.item td{border-bottom: 1px solid #eee;}.invoice-box table tr.item.last td {border-bottom: none;}.invoice-box table tr.total td:nth-child(2) {border-top: 2px solid #eee;font-weight: bold;}@media only screen and (max-width: 600px) {.invoice-box table tr.top table td {width: 100%;display: block;text-align: center;}.invoice-box table tr.information table td {width: 100%;display: block;text-align: center;}}/** RTL **/.rtl {direction: rtl;font-family: Tahoma, 'Helvetica Neue', 'Helvetica', Helvetica, Arial, sans-serif;}.rtl table {text-align: right;}.rtl table tr td:nth-child(2) {text-align: left;}</style></head><body><div class='invoice-box'><table cellpadding='0' cellspacing='0'><tr class='top'><td colspan='2'><table><tr><td class='title'><h1 style='font-family:stencil'>IACA <h1></td><td>Invoice #: 123<br>Created: "+ ft.format(dNow) +"</td></tr></table></td></tr><tr class='information'><td colspan='2'><table><tr><td>IACA Express<br>Jalan Gombak<br>53100 Kuala Lumpur</td></tr></table></td></tr><tr class='heading'><td>Seats</td><td>Price</td></tr>");
		for(int i=0; i<input.length; i++){	
			if (input[i].contains("C") || input[i].contains("B")) {
				out.print("<tr><td>");
				out.println("<tr class='item'><td>"+ input[i] +"</td><td> RM 40.00</td></tr><br>");
				total = total + 40;
			}
			else if (input[i].contains("A")) {
				out.println("<tr class='item'><td>"+ input[i] +"</td><td> RM 50.00</td></tr><br>");
				total = total + 50;
			}
		}
		
		out.print("<tr class='total'><td></td><td>RM "+ total +".00</td></tr></table></div></body></html>");
	}
	
}
