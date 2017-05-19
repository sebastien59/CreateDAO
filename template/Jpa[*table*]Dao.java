/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.Collection;
import models.[*table*];

/**
 *
 * @author [*Auteur*]
 */
public class Jpa[*table*]Dao extends JpaDao<[*table*]> implements [*table*]Dao {
    private static Jpa[*table*]Dao instance = new Jpa[*table*]Dao();

    private Jpa[*table*]Dao() {
    }

    protected static Jpa[*table*]Dao getInstance(){
        if(instance == null){
            instance = new Jpa[*table*]Dao();
        }
        return instance;
    }

}
