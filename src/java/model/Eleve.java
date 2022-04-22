/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.Date;
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
public class Eleve {

      /// Attributs
      private int id;
      private String nom;
      private String prenom;
      private Date dateNaissance;
      
      /// Constructeur
      public Eleve() {
      }
      public Eleve(int id1, String nom1, String prenom1, Date dateNaissance1) {
            this.setId(id1);
            this.setNom(nom1);
            this.setPrenom(prenom1);
            this.setDateNaissance(dateNaissance1);
      }
      public Eleve(String nom1, String prenom1, Date dateNaissance1) {
            this.setNom(nom1);
            this.setPrenom(prenom1);
            this.setDateNaissance(dateNaissance1);
//            int id1 = selectID();
//            this.setId(id1);
      }

      ///getters et setter
      public int getId() {
            return id;
      }

      public void setId(int id) {
            this.id = id;
      }

      public String getNom() {
            return nom;
      }

      public void setNom(String nom) {
            this.nom = nom;
      }

      public String getPrenom() {
            return prenom;
      }

      public void setPrenom(String prenom) {
            this.prenom = prenom;
      }

      public Date getDateNaissance() {
            return dateNaissance;
      }

      public void setDateNaissance(Date dateNaissance) {
            this.dateNaissance = dateNaissance;
      }
      
      /// fonction DAO
//      public int selectID() throws DonneeInexistant{
//            int result=-1;
//            Connection connect = JdbcConnection.getPostgresConnection("directeur", "dir1234", "ecole");
//            String req= "SELECT * FROM Eleve where nom='"+getNom()+"' and prenom='"+getPrenom()+"' and dateNaissance='"+getDateNaissance()+"'";
//            try{
//                  Statement stmt = connect.createStatement();
//                  ResultSet rs = stmt.executeQuery(req);
//                  while(rs.next()) {
//                        result = rs.getInt("id");
//                  }
//            }
//            catch(SQLException e){ 
//                  e.printStackTrace();
//            } finally{
//                  try {
//                        if(!connect.isClosed()){
//                              connect.close();
//                        }
//                  } catch (SQLException ex) {
//                        Logger.getLogger(Classe.class.getName()).log(Level.SEVERE, null, ex);
//                  }
//            }
//            if(result==-1){
//                throw new DonneeInexistant();
//            }
//        return result;
//      }
      public void inserer(){
            Connection connect = JdbcConnection.getPostgresConnection("directeur", "dir1234", "ecole");
            String req= "insert into Eleve values(default,'"+getNom()+"','"+getPrenom()+"','"+getDateNaissance().toString()+"')";
            try{
                  Statement stmt = connect.createStatement();
                  int insertNbr=stmt.executeUpdate(req);
            }
            catch(SQLException e){ 
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
      }
//      public void modifier(String newNom,String newPrenom,Date newDateNaissance){
//            setNom(newNom);
//            setPrenom(newPrenom);
//            setDateNaissance(newDateNaissance);
//            Connection connect = JdbcConnection.getPostgresConnection("directeur", "dir1234", "ecole");
//            String req= "update Eleve set nom='"+getNom()+"',prenom='"+getPrenom()+"',dateNaissance='"+getDateNaissance().toString()+"' where id ='"+getId()+"'";
//            try{
//                  Statement stmt = connect.createStatement();
//                  int insertNbr=stmt.executeUpdate(req);
//            }
//            catch(SQLException e){ 
//                  e.printStackTrace();
//            } finally{
//                  try {
//                        if(!connect.isClosed()){
//                              connect.close();
//                        }
//                  } catch (SQLException ex) {
//                        Logger.getLogger(Classe.class.getName()).log(Level.SEVERE, null, ex);
//                  }
//            }
//      }
//      public void supprimer(){
//            Connection connect = JdbcConnection.getPostgresConnection("directeur", "dir1234", "ecole");
//            String req= "Delete from Eleve where id ='"+getId()+"'";
//            try{
//                  Statement stmt = connect.createStatement();
//                  int insertNbr=stmt.executeUpdate(req);
//            }
//            catch(SQLException e){ 
//                  e.printStackTrace();
//            } finally{
//                  try {
//                        if(!connect.isClosed()){
//                              connect.close();
//                        }
//                  } catch (SQLException ex) {
//                        Logger.getLogger(Classe.class.getName()).log(Level.SEVERE, null, ex);
//                  }
//            }
//      }
      public static ArrayList<Eleve> listeEleve(){
            ArrayList<Eleve> result = new ArrayList();
            Connection connect = JdbcConnection.getPostgresConnection("directeur", "dir1234", "ecole");
            String req= "SELECT * FROM Eleve";
            try{
                  Statement stmt = connect.createStatement();
                  ResultSet rs = stmt.executeQuery(req);
                  while(rs.next()) {
                        int id1 = rs.getInt("id");
                        String nom1 = rs.getString("nom");
                        String prenom1 = rs.getString("prenom");
                        Date dateNaissance1 = rs.getDate("dateNaissance");
                        Eleve ins = new Eleve(id1,nom1,prenom1,dateNaissance1);
                        result.add(ins);
                  }
            }
            catch(SQLException e){ 
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
