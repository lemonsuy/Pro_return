/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Lemon
 */
public class ConnectLogin extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            response.setContentType("text/html;charset=UTF-8");

            HttpSession session = request.getSession();
            String username = request.getParameter("username");
            session.setAttribute("username", username);

            //System.out.println("username = "+username);
            String password = request.getParameter("password");
            session.setAttribute("password", password);

            //System.out.println("password = "+password);
            Connection conn = ConnectionBuilder.getConnection();
            Statement stm = conn.createStatement();

            ResultSet rs = stm.executeQuery("select user.id,user.name from user where username='" + username + "' AND password='" + password + "'");
            int userId = 0;
            String name = null;

            while (rs.next()) {
                userId = rs.getInt("id");
                name = rs.getString("name");
            }

            session.setAttribute("userId", userId);
            session.setAttribute("name", name);

            if (LoginFormDB.checkLogin(username, password)) {
                RequestDispatcher rd = request.getRequestDispatcher("/return-main.jsp");
                rd.forward(request, response);

            } else {
                session.setAttribute("msg", "Username or Password isn't Correct.");
                RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
                rd.include(request, response);
            }
            //System.out.println("userId From Login = " + session.getAttribute("userId"));

        } catch (SQLException e) {
            e.printStackTrace();
        }
//            System.out.close();
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
