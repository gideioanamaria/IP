/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.web.GASF.business.entity;

import ro.web.GASF.business.entity.Classroom;
import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import ro.web.GASF.business.entity.Student;

/**
 *
 * @author Oana
 */
@Entity
@Table(name = "course")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Course.findAll", query = "SELECT c FROM Course c"),
    @NamedQuery(name = "Course.findByCourseid", query = "SELECT c FROM Course c WHERE c.courseid = :courseid"),
    @NamedQuery(name = "Course.findByCoursename", query = "SELECT c FROM Course c WHERE c.coursename = :coursename")})
public class Course implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "courseid")
    private Integer courseid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "coursename")
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

    public Course() {
    }

    public Course(Integer courseid) {
        this.courseid = courseid;
    }

    public Course(Integer courseid, String coursename) {
        this.courseid = courseid;
        this.coursename = coursename;
    }

    public Integer getCourseid() {
        return courseid;
    }

    public void setCourseid(Integer courseid) {
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (courseid != null ? courseid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Course)) {
            return false;
        }
        Course other = (Course) object;
        if ((this.courseid == null && other.courseid != null) || (this.courseid != null && !this.courseid.equals(other.courseid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ro.netrom.practica.business.boundary.Course[ courseid=" + courseid + " ]";
    }
    
}
