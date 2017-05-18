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
import ro.web.app.GASF.business.entity.Course;

/**
 *
 * @author Oana
 */
@Stateless
public class Courses implements Serializable {

    @PersistenceContext(name = "StudentPU")
    private EntityManager em;

    public void saveCourse(Course course) {
        em.persist(course);
    }

    public void deleteCourse(Course course) {
        em.remove(em.merge(course));

    }

    public void editCourse(Course course) {
        em.merge(course);
    }

    public List<Course> getCoursesList() {
        List<Course> rezult = em
                .createQuery("Select a from Course a", Course.class)
                .getResultList();
        return rezult;
    }
}
