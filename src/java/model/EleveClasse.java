/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
public class EleveClasse {
    ///ATTRIBUTS
      private int id;
      private int idEleve;
      private int idClasse;
      private int anneeScolaireDebut;
      private int anneeScolaireFin;

      ///GETTERS ET STTERS
      public int getId() {
            return id;
      }

      public void setId(int id) {
            this.id = id;
      }

      public int getIdEleve() {
            return idEleve;
      }

      public void setIdEleve(int idEleve) {
            this.idEleve = idEleve;
      }

      public int getIdClasse() {
            return idClasse;
      }

      public void setIdClasse(int idClasse) {
            this.idClasse = idClasse;
      }

      public int getAnneeScolaireDebut() {
            return anneeScolaireDebut;
      }

      public void setAnneeScolaireDebut(int anneeScolaireDebut) {
            this.anneeScolaireDebut = anneeScolaireDebut;
      }

      public int getAnneeScolaireFin() {
            return anneeScolaireFin;
      }

      public void setAnneeScolaireFin(int anneeScolaireFin) {
            this.anneeScolaireFin = anneeScolaireFin;
      }
      
      ///FONCTION DAO
      public static ArrayList<EleveClasse> listeEleveDansClasse(int idClasse){
            
            ArrayList<EleveClasse> result = new ArrayList();
            Connection connect = JdbcConnection.getPostgresConnection("directeur", "dir1234", "ecole");
            String req= "SELECT * FROM EleveClasse where idClasse = '"+idClasse+"'";
            try{
                  Statement stmt = connect.createStatement();
                  ResultSet rs = stmt.executeQuery(req);
                  while(rs.next()) {
                        int id1 = rs.getInt("id");
                        int idEleve1 = rs.getInt("idEleve");
                        int idClasse1 = rs.getInt("idClasse");
                        int anneeScolaireDebut1 = rs.getInt("anneeScolaireDebut");
                        int anneeScolaireFin1 = rs.getInt("anneeScolaireFin");
                                
                        EleveClasse ins = new EleveClasse(id1,idEleve1,idClasse1,anneeScolaireDebut1,anneeScolaireFin1);
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
      public static ArrayList<EleveClasse> listeClasseDEleve(int idEleve){
            
            ArrayList<EleveClasse> result = new ArrayList();
            Connection connect = JdbcConnection.getPostgresConnection("directeur", "dir1234", "ecole");
            String req= "SELECT * FROM EleveClasse where idEleve = '"+idEleve+"'";
            try{
                  Statement stmt = connect.createStatement();
                  ResultSet rs = stmt.executeQuery(req);
                  while(rs.next()) {
                        int id1 = rs.getInt("id");
                        int idEleve1 = rs.getInt("idEleve");
                        int idClasse1 = rs.getInt("idClasse");
                        int anneeScolaireDebut1 = rs.getInt("anneeScolaireDebut");
                        int anneeScolaireFin1 = rs.getInt("anneeScolaireFin");
                                
                        EleveClasse ins = new EleveClasse(id1,idEleve1,idClasse1,anneeScolaireDebut1,anneeScolaireFin1);
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

        ///CONSTRUCTEUR
      public EleveClasse(int id, int idEleve, int idClasse, int anneeScolaireDebut, int anneeScolaireFin) {
            this.id = id;
            this.idEleve = idEleve;
            this.idClasse = idClasse;
            this.anneeScolaireDebut = anneeScolaireDebut;
            this.anneeScolaireFin = anneeScolaireFin;
      }

      public EleveClasse() {
      }

     
}
