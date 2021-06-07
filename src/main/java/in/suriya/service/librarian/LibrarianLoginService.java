package in.suriya.service.librarian;

import in.suriya.dao.LibrarianDAO;
import in.suriya.model.Librarian;
import in.suriya.util.Validation;

public class LibrarianLoginService {
          private LibrarianLoginService() {
        	  //deafult constrctor
           }
          
          
          /**
           * librarian validater
           * 
           * @param userName
           * @param password
           * @return
           * @throws Exception
           */
          public static boolean librarianValidater(String userName, String password) throws Exception {
      		boolean valid=false;
      		Validation.passwordValidater(password);
            Librarian librarian=new Librarian(userName,password);
            valid=LibrarianDAO.findLibrarian(librarian);

      		return valid;
          
          }
          
          
          
}