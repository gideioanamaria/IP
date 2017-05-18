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
import ro.web.app.GASF.business.entity.Mark;
import ro.web.app.GASF.business.entity.Student;

/**
 *
 * @author oana
 */
@Stateless
public class Marks implements Serializable {

    @PersistenceContext(name = "StudentPU")
    private EntityManager em;

    public void saveMark(Mark mark) {
        em.persist(mark);
    }

    public void deleteMark(Mark mark) {
        em.remove(em.merge(mark));

    }

    public void editMark(Mark mark) {
        em.merge(mark);
    }
    
   
    public List<Mark> getMarksList() {
        List<Mark> rezult = em
                .createQuery("Select a from Mark a", Mark.class)
                .getResultList();
        return rezult;
    }
}
