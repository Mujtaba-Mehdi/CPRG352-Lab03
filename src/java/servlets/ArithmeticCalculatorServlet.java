package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ArithmeticCalculatorServlet extends HttpServlet {

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("messagetwo", "---");
        getServletContext().getRequestDispatcher("/WEB-INF/arithmeticcalculator.jsp").forward(request, response);
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // input variables requested from buttons
        String firstN = request.getParameter("first");
        String secondN = request.getParameter("second");
        String addB = request.getParameter("add");
        String subtractB = request.getParameter("subtract");
        String multiplyB = request.getParameter("multiply");
        String divideB = request.getParameter("divide");
        
        int firstI = 0;
        int secondI = 0;
        int resultI = 0;
        boolean check;
        
        // setting parameters 
        request.setAttribute("first", firstN);
        request.setAttribute("second", secondN);
        
        // checking to see if its a valid entry. 
        try {
            firstI = Integer.parseInt(firstN);
            secondI = Integer.parseInt(secondN);
            check = true;
        } catch (NumberFormatException e) {
            check = false;
        }
        
        // checking to see the if there is invalid inputs
        if (firstN == null || firstN.equals("") || secondN == null || secondN.equals("") || !check) {
            request.setAttribute("message", "Result: Invalid");
            getServletContext().getRequestDispatcher("/WEB-INF/arithmeticcalculator.jsp").forward(request, response);
            return;
        }
        
        // doing the calculations based on user inputs of first and second value
        if (addB != null) {
            resultI = firstI + secondI;
        } else if (subtractB != null) {
            resultI = firstI - secondI;
        } else if (multiplyB != null) {
            resultI = firstI * secondI;
        } else if (divideB != null) {
            // check to see if it is divided by 0
            if (secondI == 0) {
                request.setAttribute("message", "Result: Invalid (Divide by 0)");
                getServletContext().getRequestDispatcher("/WEB-INF/arithmeticcalculator.jsp").forward(request, response);
                return;
            }
            resultI = firstI % secondI;
        }
        
        // display the results
        request.setAttribute("messagetwo", resultI);
        getServletContext().getRequestDispatcher("/WEB-INF/arithmeticcalculator.jsp").forward(request, response);
    }
}