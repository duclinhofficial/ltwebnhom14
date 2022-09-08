/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package murach.email;


import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import murach.bussiness.User;
import murach.data.UserDB;


public class EmailListServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws SecurityException, IOException, ServletException {
        String url ="/index.html";
        
        // get current action
        String action = request.getParameter("action");
        if(action == null){
            action = "join"; //default action
        }
        
        //perform action and set URL to approriate page
        if (action.equals("add")){
            //get parameters from the request
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String email = request.getParameter("email");
            
            //store data in User object and save User object in database
            User user = new User(firstName, lastName, email);
            //UserDB.insert(user);
            
            //set User object in request object and set URL
            request.setAttribute("user",user);
            url = "thanks.jsp"; // the "thanks" page
        }
        // forward request and response object to specified URL
        getServletContext()
                .getRequestDispatcher(url)
                .forward(request,response);
    }
    
    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws SecurityException, IOException, ServletException{
        doPost(request,response);
    }

}
