package assignmentinnovationcenter2.Dao;


import java.util.List;


import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import assignmentinnovationcenter2.Model.Contact;
import assignmentinnovationcenter2.Util.HibernateUtil;


public class ContactDao {

//    public void saveContact(Contact contact) {
//        Transaction transaction = null;
//        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
//            // Start a transaction
//            transaction = session.beginTransaction();
//            // Save the contact object
//            session.save(contact);
//            // Commit the transaction
//            transaction.commit();
//        } catch (Exception e) {
//            if (transaction != null) {
//                transaction.rollback();
//            }
//            e.printStackTrace();
//        }
//    }
    public void saveContactData(Contact contactData) {

		Transaction transaction = null;

		try {
			Session session = HibernateUtil.getSession().getSession();

			transaction = session.beginTransaction();

			session.save(contactData);

			transaction.commit();

			session.close();

		} catch (Exception ex) {
			if (transaction != null) {
				transaction.rollback();
				System.out.println("Failed to save contact data");
			}
		}
	}
//    // Method to retrieve all contacts from the database
    public List<Contact> getAllContacts() {
        Transaction transaction = null;
        List<Contact> contacts = null;
        try {
            // Start a transaction
        	Session session = HibernateUtil.getSession().getSession();

        	transaction = session.beginTransaction();
            // Get all contacts
            contacts = session.createQuery("from Contact", Contact.class).list();
            // Commit the transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return contacts;
    }
 // Method to delete contact by ID
    public void deleteContactById(int contactId) {
        Transaction transaction = null;
        try {
        	Session session = HibernateUtil.getSession().getSession();

            transaction = session.beginTransaction();
            // Get the contact object to be deleted
            Contact contact = session.get(Contact.class, contactId);
            if (contact != null) {
                // Delete the contact object
                session.delete(contact);
                System.out.println("Contact with ID: " + contactId + " was deleted.");
            } else {
                System.out.println("Contact with ID: " + contactId + " not found.");
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

}
