
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

//{}
public class contactQuery {
    
      public void insertContact(Contact cont){
          
         
          Connection con = MyConnection.getConnection();
          PreparedStatement ps ;
          try {
              ps = con.prepareStatement("INSERT INTO `mycontact`( `nom`, `tel1`, `tel2`, `email`, `mention`, `pic`, `userid`) VALUES (?,?,?,?,?,?,?)");
              ps.setString(1, cont.getnom());
              ps.setString(2, cont.gettel1() );
              ps.setString(3, cont.gettel2());
              ps.setString(4, cont.getemail());
              ps.setString(5, cont.getmention());
              ps.setBytes(6, cont.getpic());
              ps.setInt(7, cont.getuid());
              
              if(ps.executeUpdate()!= 0){
                        
                        JOptionPane.showMessageDialog(null, "New Contact added");
                        
                    }else{
                        JOptionPane.showMessageDialog(null, "Somthing wrong");
              }
                    
              
          } catch (SQLException ex) {
              Logger.getLogger(contactQuery.class.getName()).log(Level.SEVERE, null, ex);
          }
          
      
      
      }
      
      
       public void updateContact(Contact cont, boolean withImage){
          
          
          Connection con = MyConnection.getConnection();
          PreparedStatement ps ;
          String updateQuery = "" ;
                  
          
          // si l’utilisateur souhaite mettre à jour l’image du profil de contact
          if(withImage == true){
              updateQuery ="UPDATE `mycontact` SET `nom`=?,`tel1`=?,`tel2`=?,`email`=?,`mention`=?,`pic`=?  WHERE `id`=?" ;
              
              try {
              ps = con.prepareStatement(updateQuery);
              ps.setString(1, cont.getnom());
              ps.setString(2, cont.gettel1() );
              ps.setString(3, cont.gettel2());
              ps.setString(4, cont.getemail());
              ps.setString(5, cont.getmention());
              ps.setBytes(6, cont.getpic());
              ps.setInt(7, cont.getCid());
              
              if(ps.executeUpdate()!= 0){
                        
                        JOptionPane.showMessageDialog(null, " modification des données de contact");
                       
                        
                    }else{
                        JOptionPane.showMessageDialog(null, "Somthing wrong");
                    }
                    
              
          } catch (SQLException ex) {
              Logger.getLogger(contactQuery.class.getName()).log(Level.SEVERE, null, ex);
          }
          
         
          
          }
          else{
              //l’utilisateur souhaite conserver la même image[supprimer l’image de la mise à jour]
              updateQuery ="UPDATE `mycontact` SET `nom`=?,`tel1`=?,`tel2`=?,`email`=?,`mention`=?  WHERE `id`=?" ;
              
              try {
              ps = con.prepareStatement(updateQuery);
              ps.setString(1, cont.getnom());
              ps.setString(2, cont.gettel1() );
              ps.setString(3, cont.gettel2());
              ps.setString(4, cont.getemail());
              ps.setString(5, cont.getmention());

              ps.setInt(6, cont.getCid());
              
              if(ps.executeUpdate()!= 0){
                        
                        JOptionPane.showMessageDialog(null, "modification des données de contact");
                       
                        
                    }else{
                        JOptionPane.showMessageDialog(null, "Somthing wrong");
                    }
                    
              
          } catch (SQLException ex) {
              Logger.getLogger(contactQuery.class.getName()).log(Level.SEVERE, null, ex);
          }
          }
          }
      
       
      
      // pour supprimer
       
       public void deleteContact( int cid){
          
          
          Connection con = MyConnection.getConnection();
          PreparedStatement ps ;
          try {
              ps = con.prepareStatement("DELETE FROM `mycontact` WHERE `id`= ?");
              ps.setInt(1,cid);
              
              if(ps.executeUpdate()!= 0){
                        
                        JOptionPane.showMessageDialog(null, "Contact Supprimé");
                       
                        
                    }else{
                        JOptionPane.showMessageDialog(null, "Somthing wrong");
                    }
                    
              
          } catch (SQLException ex) {
              Logger.getLogger(contactQuery.class.getName()).log(Level.SEVERE, null, ex);
          }
          
      
      
      }
  
       
       
       
       
       
      // creat a list of contact
      public ArrayList<Contact> contactList(int userId){
         
          ArrayList<Contact> clist = new ArrayList<Contact>();
         Connection con = MyConnection.getConnection();
         Statement st;
         ResultSet rs;
         
          try {
              st = con.createStatement();
              rs = st.executeQuery("SELECT `id`, `nom`, `tel1`, `tel2`, `email`, `mention`, `pic` FROM `mycontact` WHERE userid = " +userId);
              
              Contact ct;
              while(rs.next()){
                  ct = new Contact(rs.getInt("id"),
                                   rs.getString("nom"),
                                   rs.getString("tel1"),
                                   rs.getString("tel2"),
                                   rs.getString("email"),
                                   rs.getString("mention"),
                                   rs.getBytes("pic"),
                                   userId );
                  clist.add(ct);
              }
              
          } catch (SQLException ex) {
              Logger.getLogger(contactQuery.class.getName()).log(Level.SEVERE, null, ex);
          }
        
         
          return clist;
          
          
      }
    
    
    
}
