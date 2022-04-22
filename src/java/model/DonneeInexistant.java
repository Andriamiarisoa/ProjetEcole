/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author YASSER
 */
public class DonneeInexistant extends Exception {

    public DonneeInexistant() {
    }
    public DonneeInexistant(String msg){
        super(msg);
    }
}
