/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.web.app.GASF.business.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Oana
 */
@Entity
@Table(name = "mark")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Mark.findAll", query = "SELECT m FROM Mark m"),
    @NamedQuery(name = "Mark.findByMark", query = "SELECT m FROM Mark m WHERE m.mark = :mark"),
    @NamedQuery(name = "Mark.findByCourseid", query = "SELECT m FROM Mark m WHERE m.courseid = :courseid")})
public class Mark implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "mark")
    private Integer mark;
    @Basic(optional = false)
    @NotNull
    @Column(name = "courseid")
    private int courseid;

    public Mark() {
    }

    public Mark(Integer mark) {
        this.mark = mark;
    }

    public Mark(Integer mark, int courseid) {
        this.mark = mark;
        this.courseid = courseid;
    }

    public Integer getMark() {
        return mark;
    }

    public void setMark(Integer mark) {
        this.mark = mark;
    }

    public int getCourseid() {
        return courseid;
    }

    public void setCourseid(int courseid) {
        this.courseid = courseid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mark != null ? mark.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mark)) {
            return false;
        }
        Mark other = (Mark) object;
        if ((this.mark == null && other.mark != null) || (this.mark != null && !this.mark.equals(other.mark))) {
            return false;
        }
        return true;
    }

    
    
}
