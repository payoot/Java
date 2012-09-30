/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package th.in.java.auth.facade;

import th.in.java.jpa.JPAUtil;

/**
 *
 * @author nuboat
 */
public class MainFacade {
    
    public static void main(final String []args) {
        JPAUtil.getEntityManager("auth_unit");
    }

}
