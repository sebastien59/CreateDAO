/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dao.DaoFactory;
/**
 *
 * @author sebastien
 */
public class DaoFactoryJpa extends DaoFactory{
  
		@Override
 		public JpaAuteurDao getAuteurDao(){
 			return JpaAuteurDao.getInstance();
 		}
 
		@Override
 		public JpaCategorieDao getCategorieDao(){
 			return JpaCategorieDao.getInstance();
 		}
 
		@Override
 		public JpaInfoprincipaleDao getInfoprincipaleDao(){
 			return JpaInfoprincipaleDao.getInstance();
 		}
 
		@Override
 		public JpaInformationDao getInformationDao(){
 			return JpaInformationDao.getInstance();
 		}
 
		@Override
 		public JpaInfosecondaireDao getInfosecondaireDao(){
 			return JpaInfosecondaireDao.getInstance();
 		}
 
		@Override
 		public JpaParagrapheDao getParagrapheDao(){
 			return JpaParagrapheDao.getInstance();
 		}
 
}
