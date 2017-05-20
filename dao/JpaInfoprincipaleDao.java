/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.Collection;
import models.Infoprincipale;

/**
 *
 * @author sebastien
 */
public class JpaInfoprincipaleDao extends JpaDao<Infoprincipale> implements InfoprincipaleDao {
    private static JpaInfoprincipaleDao instance = new JpaInfoprincipaleDao();

    private JpaInfoprincipaleDao() {
    }

    protected static JpaInfoprincipaleDao getInstance(){
        if(instance == null){
            instance = new JpaInfoprincipaleDao();
        }
        return instance;
    }

}
