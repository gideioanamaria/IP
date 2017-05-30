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
import ro.web.app.GASF.business.entity.Administrator;

/**
 *
 * @author Oana
 */
@Stateless
public class Administrators implements Serializable{
    @PersistenceContext(name = "StudentPU")
    private EntityManager em;

    public void saveAdministrator(Administrator administrator) {
        em.persist(administrator);
    }
   
    public List<Administrator> getAdministratorsList() {
        List<Administrator> rezult = em
                .createQuery("Select a from Administrator a", Administrator.class)
                .getResultList();
        return rezult;
    }
}