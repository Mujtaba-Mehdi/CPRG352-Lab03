import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author mujtaba
 */
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
        String age = request.getParameter("age");
        
        // It will set the attributes in the request objects and will be passed though 
        // to the agecalculator.jsp by the forward() method
        request.setAttribute("age", age);
        
        
        // if the age is blank or empty the user will be required to enter it again
        if (age == null || age.equals("")) {
            
            request.setAttribute("error","You must give your current age");
            
            //redisplay the age calculator
            getServletContext().getRequestDispatcher("/WEB-INF/agecalculator.jsp").forward(request,response);
            return;
        }
       
        if (age == null || age.equals("")) {
            
            request.setAttribute("error","You must give your current age");
            
            //redisplay the age calculator
            getServletContext().getRequestDispatcher("/WEB-INF/agecalculator.jsp").forward(request,response);
            return;
        }
        
        
        getServletContext().getRequestDispatcher("/WEB-INF/agecalculator.jsp").forward(request,response);
        
    }

}
