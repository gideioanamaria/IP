/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.web.app.GASF.business.boundary;

import java.io.Serializable;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import ro.web.app.GASF.business.entity.Login;

/**
 *
 * @author Oana
 */
@Stateless
public class Users implements Serializable{
    @PersistenceContext(name = "StudentPU")
    private EntityManager em;

    public void saveUser(Login user) {
        em.persist(user);
    }
   
    public List<Login> getUsersList() {
        List<Login> rezult = em
                .createQuery("Select a from Login a", Login.class)
                .getResultList();
        return rezult;
    }
}
