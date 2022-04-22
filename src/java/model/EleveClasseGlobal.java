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
public class EleveClasseGlobal {
      private int idEleve;
      private String nom;
      private String prenom;
      private Date dateNaissance;
      private int idClasse;
      private String niveau;
      private int anneeScolaireDebut;
      private int anneeScolaireFin;

      public int getIdEleve() {
            return idEleve;
      }

      public void setIdEleve(int idEleve) {
            this.idEleve = idEleve;
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

      public int getIdClasse() {
            return idClasse;
      }

      public void setIdClasse(int idClasse) {
            this.idClasse = idClasse;
      }

      public String getNiveau() {
            return niveau;
      }

      public void setNiveau(String niveau) {
            this.niveau = niveau;
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
      public EleveClasseGlobal(int idEleve, String nom, String prenom, Date dateNaissance, int idClasse, String niveau, int anneeScolaireDebut, int anneeScolaireFin) {
            this.idEleve = idEleve;
            this.nom = nom;
            this.prenom = prenom;
            this.dateNaissance = dateNaissance;
            this.idClasse = idClasse;
            this.niveau = niveau;
            this.anneeScolaireDebut = anneeScolaireDebut;
            this.anneeScolaireFin = anneeScolaireFin;
      }

      public EleveClasseGlobal() {
      }
      public static ArrayList<EleveClasseGlobal> listeEleveDansClasse(int idClasse){
            
            ArrayList<EleveClasseGlobal> result = new ArrayList();
            Connection connect = JdbcConnection.getPostgresConnection("directeur", "dir1234", "ecole");
            String req= "SELECT * FROM EleveClasseGlobal where idClasse = '"+idClasse+"' order by idEleve";
            try{
                  Statement stmt = connect.createStatement();
                  ResultSet rs = stmt.executeQuery(req);
                  while(rs.next()) {
                        Date dateNaissance1 = rs.getDate("dateNaissance");
                        String niveau1 = rs.getString("niveau");
                        String nom1 = rs.getString("nom");
                        String prenom1 = rs.getString("prenom");
                        int idEleve1 = rs.getInt("idEleve");
                        int idClasse1 = rs.getInt("idClasse");
                        int anneeScolaireDebut1 = rs.getInt("anneeScolaireDebut");
                        int anneeScolaireFin1 = rs.getInt("anneeScolaireFin");
                                
                        EleveClasseGlobal ins = new EleveClasseGlobal(idEleve1,nom1,prenom1,dateNaissance1,idClasse1, niveau1,anneeScolaireDebut1,anneeScolaireFin1);
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
