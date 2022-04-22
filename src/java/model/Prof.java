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
public class Prof {
    private int id;
    private String nom;
    private int idMatiere;
    private String mdp;

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

    public int getIdMatiere() {
        return idMatiere;
    }

    public void setIdMatiere(int idMatiere) {
        this.idMatiere = idMatiere;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }
    
      public static ArrayList<Prof> listeProf(){
            ArrayList<Prof> result = new ArrayList();
            Connection connect = JdbcConnection.getPostgresConnection("directeur", "dir1234", "ecole");
            String req= "SELECT * FROM Prof";
            try{
                  Statement stmt = connect.createStatement();
                  ResultSet rs = stmt.executeQuery(req);
                  while(rs.next()) {
                        int id1 = rs.getInt("id");
                        String nom1 = rs.getString("nom");
                        int idMatiere = rs.getInt("idMatiere");
                        String mdp = rs.getString("mdp");
                        Prof ins = new Prof(id1,nom1,idMatiere,mdp);
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

    public Prof(int id, String nom, int idMatiere, String mdp) {
        this.id = id;
        this.nom = nom;
        this.idMatiere = idMatiere;
        this.mdp = mdp;
    }
}
