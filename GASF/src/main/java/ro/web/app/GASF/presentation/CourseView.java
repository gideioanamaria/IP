/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.web.app.GASF.presentation;

import java.io.Serializable;
import java.util.List;
import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import ro.web.app.GASF.business.boundary.Courses;
import ro.web.app.GASF.business.entity.Course;

/**
 *
 * @author Oana
 */
@Named
@ViewScoped
@ManagedBean
public class CourseView implements Serializable{
    @Inject
    private Courses courses;
    private Course course;
    private List<Course> coursesList;
    private String productId;
    
    @PostConstruct
    public void initCourse() {
        course = new Course();
        coursesList = courses.getCoursesList();
    }

    public void saveCourse() {

        if (course.getCourseid() == null) {
            courses.saveCourse(course);
            coursesList.add(course);

        } else {
            courses.editCourse(course);
        }
        course = new Course();
        addMessageToCourse("Successful!", "The course has been add.");
    }

    public void deleteCourse() {
        courses.deleteCourse(course);
        coursesList.remove(course);
        course= new Course();
        addMessageToCourse("Successful!", "The course has been delete.");
    }

    public void addMessageToCourse(String summary, String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public Courses getCourses() {
        return courses;
    }

    public void setCourses(Courses courses) {
        this.courses = courses;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public List<Course> getCoursesList() {
        return coursesList;
    }

    public void setCoursesList(List<Course> coursesList) {
        this.coursesList = coursesList;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }
    
    
}
