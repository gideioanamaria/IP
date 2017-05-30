/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.web.app.GASF.business.entity;

import ro.web.app.GASF.business.entity.Course;
import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import ro.web.app.GASF.business.entity.Student;

/**
 *
 * @author Oana
 */
@Entity
@Table(name = "specialization")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Specialization.findAll", query = "SELECT s FROM Specialization s"),
    @NamedQuery(name = "Specialization.findBySpecializationid", query = "SELECT s FROM Specialization s WHERE s.specializationid = :specializationid"),
    @NamedQuery(name = "Specialization.findBySpecializationname", query = "SELECT s FROM Specialization s WHERE s.specializationname = :specializationname")})
public class Specialization implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "specializationid")
    private Integer specializationid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "specializationname")
    private String specializationname;
    @ManyToMany(mappedBy = "specializationCollection")
    private Collection<Course> courseCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "specializationid")
    private Collection<Student> studentCollection;

    public Specialization() {
    }

    public Specialization(Integer specializationid) {
        this.specializationid = specializationid;
    }

    public Specialization(Integer specializationid, String specializationname) {
        this.specializationid = specializationid;
        this.specializationname = specializationname;
    }

    public Integer getSpecializationid() {
        return specializationid;
    }

    public void setSpecializationid(Integer specializationid) {
        this.specializationid = specializationid;
    }

    public String getSpecializationname() {
        return specializationname;
    }

    public void setSpecializationname(String specializationname) {
        this.specializationname = specializationname;
    }

    @XmlTransient
    public Collection<Course> getCourseCollection() {
        return courseCollection;
    }

    public void setCourseCollection(Collection<Course> courseCollection) {
        this.courseCollection = courseCollection;
    }

    @XmlTransient
    public Collection<Student> getStudentCollection() {
        return studentCollection;
    }

    public void setStudentCollection(Collection<Student> studentCollection) {
        this.studentCollection = studentCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (specializationid != null ? specializationid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Specialization)) {
            return false;
        }
        Specialization other = (Specialization) object;
        if ((this.specializationid == null && other.specializationid != null) || (this.specializationid != null && !this.specializationid.equals(other.specializationid))) {
            return false;
        }
        return true;
    }

    
    
}
