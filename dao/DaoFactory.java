/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

/**
 *
 * @author sebastien
 */
public abstract class DaoFactory {
    	public abstract JpaAuteurDao getAuteurDao();
	public abstract JpaCategorieDao getCategorieDao();
	public abstract JpaInfoprincipaleDao getInfoprincipaleDao();
	public abstract JpaInformationDao getInformationDao();
	public abstract JpaInfosecondaireDao getInfosecondaireDao();
	public abstract JpaParagrapheDao getParagrapheDao();


    public static DaoFactory getDaoFactory (PersistenceType type){
        switch(type){
            case JPA:
            default:
                return new DaoFactoryJpa();
        }
    }
}
