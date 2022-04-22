/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author YASSER
 */
public class TraitementLogin {
    private boolean estConnecte;

    public boolean isConnected() {
        return estConnecte;
    }

    public TraitementLogin(HttpServletRequest request, HttpServletResponse response) {
        String nom=request.getParameter("nom");
        String mdp=request.getParameter("mdp");
        String matiere=request.getParameter("matiere");
        int idMatiere=Integer.parseInt(matiere);
    }
    
}
