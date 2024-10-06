package assignmentinnovationcenter2.Servlet;

import assignmentinnovationcenter2.Dao.ContactDao;
import assignmentinnovationcenter2.Model.Contact;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/viewContacts")
public class ViewContact extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    private ContactDao contactDao;

    public void init() throws ServletException {
        contactDao = new ContactDao();
            System.out.println("Servlet initialized");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve all contacts
        List<Contact> contactList = contactDao.getAllContacts();
        System.out.println("Number of contacts: " + contactList.size());

        // Set the contact list as a request attribute
        request.setAttribute("contacts", contactList);

        // Forward the request to the JSP page
        request.getRequestDispatcher("/ViewContacts.jsp").forward(request, response);
    	
    }
}

