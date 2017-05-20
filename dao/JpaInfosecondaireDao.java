/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.Collection;
import models.Infosecondaire;

/**
 *
 * @author sebastien
 */
public class JpaInfosecondaireDao extends JpaDao<Infosecondaire> implements InfosecondaireDao {
    private static JpaInfosecondaireDao instance = new JpaInfosecondaireDao();

    private JpaInfosecondaireDao() {
    }

    protected static JpaInfosecondaireDao getInstance(){
        if(instance == null){
            instance = new JpaInfosecondaireDao();
        }
        return instance;
    }

}
