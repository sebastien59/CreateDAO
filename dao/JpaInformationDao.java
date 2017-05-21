/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.Collection;
import models.Information;

/**
 *
 * @author sebastien
 */
public class JpaInformationDao extends JpaDao<Information> implements InformationDao {
    private static JpaInformationDao instance = new JpaInformationDao();

    private JpaInformationDao() {
    }

    protected static JpaInformationDao getInstance(){
        if(instance == null){
            instance = new JpaInformationDao();
        }
        return instance;
    }

}
