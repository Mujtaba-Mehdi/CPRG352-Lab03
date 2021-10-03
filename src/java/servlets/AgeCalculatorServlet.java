package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class AgeCalculatorServlet extends HttpServlet {

  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // load up agecalculator.jsp
        getServletContext().getRequestDispatcher("/WEB-INF/agecalculator.jsp").forward(request,response);
        return;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // capture the parameters 
        String ageS = request.getParameter("age");
        
        int correctage = 0;
        boolean check;
        
        // It will set the attributes in the request objects and will be passed though 
        // to the agecalculator.jsp by the forward() method
        request.setAttribute("age", ageS);
        
        try {
            correctage = Integer.parseInt(ageS);
            check = true;
            correctage += 1;
        } 
        catch (NumberFormatException e) {
            check = false;
        }
        
        // if the age is blank or empty the user will be required to enter it again
        if (ageS == null || ageS.equals("")) {
            request.setAttribute("message","You must give your current age");
            getServletContext().getRequestDispatcher("/WEB-INF/agecalculator.jsp").forward(request, response);
            return;
        }
        //checks the if it is a number
        else if (!check){
            request.setAttribute("message", "You must enter a number.");
            getServletContext().getRequestDispatcher("/WEB-INF/agecalculator.jsp").forward(request, response);
            return;
            
        } 
        //after checking if a number is entered it will print your next age birthday
        else {
            request.setAttribute("message", "Your age next birthday will be " + correctage);
            //redisplay the age calculator
            getServletContext().getRequestDispatcher("/WEB-INF/agecalculator.jsp").forward(request,response);
            return;
        }
      
    }

}
