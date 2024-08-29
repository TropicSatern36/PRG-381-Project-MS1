package Servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "RegistrationServlet", urlPatterns = {"/RegistrationServlet"})
public class RegistrationServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException
    {
        //Fecthing the form parameters
        String username = req.getParameter("txtUsername");
        String name = req.getParameter("txtName");
        String surname = req.getParameter("txtSurname");
        String password = req.getParameter("txtPassword");
        String phone = req.getParameter("txtPhone");
        String email = req.getParameter("txtEmail");
        
        try
        {
            //Database connections
            String dbURL = "jdbc:postgresql://localhost:5432/Java DB";
            String dbUser = "yourUsername";
            String dbPassword = "yourPassword";
            
            try(
                Connection con = DriverManager.getConnection(dbURL, dbUser, dbPassword);
                PreparedStatement pstmt = con.prepareStatement("INSERT INTO Registration (username, name, surname, password, phone, email) VALUES (?, ?, ?, ?, ?, ?)");    )
            {
                pstmt.setString(1, username);
                pstmt.setString(2, name);
                pstmt.setString(3, surname);
                pstmt.setString(4, password);
                pstmt.setString(5, phone);
                pstmt.setString(6, email);
            
                int result = pstmt.executeUpdate();
                
                if (result > 0)
            {
                //Redirecting to login page if successful regestration
                res.sendRedirect("login.jsp");
            } else
            {
                //Return error message if registration failed
                req.setAttribute("errorMessage", "Registration failed. Please try again.");
                req.getRequestDispatcher("register.jsp").forward(req, res);
            }
            }
             
            
        } catch(SQLException ex)
        {
           
           res.sendRedirect("register.jsp?error=databaseError");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
