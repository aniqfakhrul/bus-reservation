package myservlet;

import java.util.Scanner;
import javax.servlet.annotation.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

@WebServlet("/Price")
public class Price extends HttpServlet{

    // calculate price
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        //contoh kalau tak faham(HTML)
        String input;
//        String option;
        int total=0;
//        Scanner sc = new Scanner(System.in);
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        input = request.getParameter("id");

        //public void doPost(HttpServletRequest request, HttpServletResponse response)
//         System.out.println("Enter seat type");
//         input = sc.nextLine();

        if (input.contains("C") || input.contains("B")) {
            total = total + 2000;
        }
        else if (input.contains("A")) {
            total = total + 10000;
        }
//         System.out.println("Another seat?[Y|N]: ");
//         option = sc.nextLine();
        System.out.println("<h1>Total price is "+total+"</h1>");
    }

}
