/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.web.app.GASF.presentation;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import ro.web.app.GASF.business.boundary.Students;
import ro.web.app.GASF.business.entity.Student;

/**
 *
 * @author Oana
 */
@Named
@ViewScoped
@ManagedBean
public class StudentView implements Serializable {

    @Inject
    private Students students;
    private Student student;
    private List<Student> studentsList;
    private String productId;

    @PostConstruct
    public void init() {
        student = new Student();
        studentsList = students.getStudentsList();
    }

    public void saveStudent() {

        if (student.getStudentid() == null) {
            students.saveStudent(student);
            studentsList.add(student);

        } else {
            students.editStudent(student);
        }
        student = new Student();
        addMessageToStudent("Successful!", "The student has been add.");
    }

    public void deleteStudent() {
        students.deleteStudent(student);
        studentsList.remove(student);
        student = new Student();
        addMessageToStudent("Successful!", "The student has been delete.");
    }

    public void addMessageToStudent(String summary, String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public Student getStudent() {
        return student;
    }
    
    

    public void setStudent(Student student) {
        this.student = student;
    }

    public Students getStudents() {
        return students;
    }

    public void setStudents(Students students) {
        this.students = students;
    }

    public List<Student> getStudentsList() {
        return studentsList;
    }

    public void setStudentsList(List<Student> studentsList) {
        this.studentsList = studentsList;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }
    


   
}
