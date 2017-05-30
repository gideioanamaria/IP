/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.web.app.GASF.business.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Oana
 */
@Entity
public class Course implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long courseid;
    @NotNull
    private String coursename;

    @ManyToMany(mappedBy = "courseCollection")
    private Collection<Classroom> classroomCollection;
    @JoinTable(name = "student_course", joinColumns = {
        @JoinColumn(name = "courseid", referencedColumnName = "courseid")}, inverseJoinColumns = {
        @JoinColumn(name = "studentid", referencedColumnName = "studentid")})
    @ManyToMany
    private Collection<Student> studentCollection;
    @JoinTable(name = "course_specialization", joinColumns = {
        @JoinColumn(name = "courseid", referencedColumnName = "courseid")}, inverseJoinColumns = {
        @JoinColumn(name = "specializationid", referencedColumnName = "specializationid")})
    @ManyToMany
    private Collection<Specialization> specializationCollection;

    public Long getCourseid() {
        return courseid;
    }

    public void setCourseid(Long courseid) {
        this.courseid = courseid;
    }

    public String getCoursename() {
        return coursename;
    }

    public void setCoursename(String coursename) {
        this.coursename = coursename;
    }

    
    @XmlTransient
    public Collection<Classroom> getClassroomCollection() {
        return classroomCollection;
    }

    public void setClassroomCollection(Collection<Classroom> classroomCollection) {
        this.classroomCollection = classroomCollection;
    }

    @XmlTransient
    public Collection<Student> getStudentCollection() {
        return studentCollection;
    }

    public void setStudentCollection(Collection<Student> studentCollection) {
        this.studentCollection = studentCollection;
    }

    @XmlTransient
    public Collection<Specialization> getSpecializationCollection() {
        return specializationCollection;
    }

    public void setSpecializationCollection(Collection<Specialization> specializationCollection) {
        this.specializationCollection = specializationCollection;
    }

    
}
