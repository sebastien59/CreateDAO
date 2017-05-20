/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.Collection;
import models.Auteur;

/**
 *
 * @author sebastien
 */
public class JpaAuteurDao extends JpaDao<Auteur> implements AuteurDao {
    private static JpaAuteurDao instance = new JpaAuteurDao();

    private JpaAuteurDao() {
    }

    protected static JpaAuteurDao getInstance(){
        if(instance == null){
            instance = new JpaAuteurDao();
        }
        return instance;
    }

}
