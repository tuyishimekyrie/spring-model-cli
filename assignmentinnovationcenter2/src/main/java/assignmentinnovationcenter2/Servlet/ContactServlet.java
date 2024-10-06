package assignmentinnovationcenter2.Servlet;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import assignmentinnovationcenter2.Dao.ContactDao;
import assignmentinnovationcenter2.Model.Contact;

@WebServlet("/addContact")
public class ContactServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    private ContactDao contactDao;

    public void init() throws ServletException {
        contactDao = new ContactDao();  
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String message = request.getParameter("message");

      
        Contact contact = new Contact();
        contact.setName(name);
        contact.setEmail(email);
        contact.setMessage(message);

       
        contactDao.saveContactData(contact);

    
        response.sendRedirect("success.html");
    }
}
