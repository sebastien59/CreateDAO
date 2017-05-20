/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

/**
 *
 * @author [*Auteur*]
 */
public abstract class DaoFactory {
    [*GetInstanceSignature*]

    public static DaoFactory getDaoFactory (PersistenceType type){
        switch(type){
            case JPA:
            default:
                return new DaoFactoryJpa();
        }
    }
}
