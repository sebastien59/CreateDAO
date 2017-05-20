/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.Collection;
import models.Paragraphe;

/**
 *
 * @author sebastien
 */
public class JpaParagrapheDao extends JpaDao<Paragraphe> implements ParagrapheDao {
    private static JpaParagrapheDao instance = new JpaParagrapheDao();

    private JpaParagrapheDao() {
    }

    protected static JpaParagrapheDao getInstance(){
        if(instance == null){
            instance = new JpaParagrapheDao();
        }
        return instance;
    }

}
