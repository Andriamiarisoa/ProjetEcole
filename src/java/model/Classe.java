package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.DAO.JdbcConnection;

/**
 *
 * @author YASSER
 */
public class Classe {
      
      /// Attributs
      private int id;
      private String niveau;
      
      /// Constructeur
      public Classe(int id, String niveau) {
            this.id = id;
            this.niveau = niveau;
      }

      ///getters et setter
      public int getId() {
            return id;
      }

      public void setId(int id) {
            this.id = id;
      }

      public String getNiveau() {
            return niveau;
      }

      public void setNiveau(String niveau) {
            this.niveau = niveau;
      }
      
      /// fonction DAO
      public static ArrayList<Classe> getAllClasse(){
            ArrayList<Classe> result = new ArrayList();
            Connection connect = JdbcConnection.getPostgresConnection("directeur", "dir1234", "ecole");
            String req= "SELECT * FROM Classe ORDER BY id";
            try{
                  Statement stmt = connect.createStatement();
                  ResultSet rs = stmt.executeQuery(req);
                  while(rs.next()) {
                        int id1 = rs.getInt("id");
                        String niveau1 = rs.getString("niveau");
                        Classe ins = new Classe(id1,niveau1);
                        result.add(ins);
                  }
            }
            catch(Exception e){ 
                  e.printStackTrace();
            } finally{
                  try {
                        if(!connect.isClosed()){
                              connect.close();
                        }
                  } catch (SQLException ex) {
                        Logger.getLogger(Classe.class.getName()).log(Level.SEVERE, null, ex);
                  }
            }
            return result;
      }
}
