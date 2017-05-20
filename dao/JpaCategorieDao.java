/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.Collection;
import models.Categorie;

/**
 *
 * @author sebastien
 */
public class JpaCategorieDao extends JpaDao<Categorie> implements CategorieDao {
    private static JpaCategorieDao instance = new JpaCategorieDao();

    private JpaCategorieDao() {
    }

    protected static JpaCategorieDao getInstance(){
        if(instance == null){
            instance = new JpaCategorieDao();
        }
        return instance;
    }

}
