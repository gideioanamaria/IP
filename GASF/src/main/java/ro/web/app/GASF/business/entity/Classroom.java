/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.web.app.GASF.business.entity;

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

/**
 *
 * @author Oana
 */
@Entity
@Table(name = "classroom")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Classroom.findAll", query = "SELECT c FROM Classroom c"),
    @NamedQuery(name = "Classroom.findByClassroomid", query = "SELECT c FROM Classroom c WHERE c.classroomid = :classroomid"),
    @NamedQuery(name = "Classroom.findByClassroomname", query = "SELECT c FROM Classroom c WHERE c.classroomname = :classroomname")})
public class Classroom implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "classroomid")
    private Integer classroomid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "classroomname")
    private String classroomname;
    @JoinTable(name = "course_classroom", joinColumns = {
        @JoinColumn(name = "classroomid", referencedColumnName = "classroomid")}, inverseJoinColumns = {
        @JoinColumn(name = "courseid", referencedColumnName = "courseid")})
    @ManyToMany
    private Collection<Course> courseCollection;

    public Classroom() {
    }

    public Classroom(Integer classroomid) {
        this.classroomid = classroomid;
    }

    public Classroom(Integer classroomid, String classroomname) {
        this.classroomid = classroomid;
        this.classroomname = classroomname;
    }

    public Integer getClassroomid() {
        return classroomid;
    }

    public void setClassroomid(Integer classroomid) {
        this.classroomid = classroomid;
    }

    public String getClassroomname() {
        return classroomname;
    }

    public void setClassroomname(String classroomname) {
        this.classroomname = classroomname;
    }

    @XmlTransient
    public Collection<Course> getCourseCollection() {
        return courseCollection;
    }

    public void setCourseCollection(Collection<Course> courseCollection) {
        this.courseCollection = courseCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (classroomid != null ? classroomid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Classroom)) {
            return false;
        }
        Classroom other = (Classroom) object;
        if ((this.classroomid == null && other.classroomid != null) || (this.classroomid != null && !this.classroomid.equals(other.classroomid))) {
            return false;
        }
        return true;
    }

  
    
}
