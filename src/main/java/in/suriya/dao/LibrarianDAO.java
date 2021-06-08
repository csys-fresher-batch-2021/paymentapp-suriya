package in.suriya.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import in.suriya.model.Librarian;
import in.suriya.util.ConnectionUtil;

public class LibrarianDAO {
      
      
      public boolean findLibrarian(Librarian librarian) throws ClassNotFoundException, SQLException {
  		boolean isValid=false;
  		Connection connection=null;
  		PreparedStatement pst=null;
  		ResultSet rs=null;
  		try {
  		     connection=ConnectionUtil.getConnection();
               String sql="select (user_name) from librarian where user_name=? and password=?";
          
               pst=connection.prepareStatement(sql);
               pst.setString(1, librarian.getUserName());
               pst.setString(2, librarian.getPassword());
          
               rs =pst.executeQuery();
               while(rs.next()) {
                    isValid=true;
                
               }
               
  		}catch(ClassNotFoundException | SQLException e) {
  			e.printStackTrace();
  		}finally {
  			ConnectionUtil.close(connection,pst,rs);
  		
  		}
  	
          return isValid;
      }

      

}

