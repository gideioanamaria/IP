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
import ro.web.app.GASF.business.boundary.Marks;
import ro.web.app.GASF.business.entity.Mark;

/**
 *
 * @author Oana
 */
@Named
@ViewScoped
@ManagedBean
public class MarkView implements Serializable{
    @Inject
    private Marks marks;
    private Mark mark;
    private List<Mark> marksList;
    private String productId;
    
    @PostConstruct
    public void initMark() {
        mark = new Mark();
        marksList = marks.getMarksList();
    }

    public void saveMark() {

        if (mark.getMark() == null) {
            marks.saveMark(mark);
            marksList.add(mark);

        } else {
            marks.editMark(mark);
        }
       mark = new Mark();
        addMessageToMark("Successful!", "The mark has been added.");
    }

    public void deleteMark() {
        marks.deleteMark(mark);
        marksList.remove(mark);
        mark= new Mark();
        addMessageToMark("Successful!", "The mark has been deleted.");
    }

    public void addMessageToMark(String summary, String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public Marks getMarks() {
        return marks;
    }

    public void setMark(Marks marks) {
        this.marks = marks;
    }

    public Mark getMark() {
        return mark;
    }

    public void setMark(Mark mark) {
        this.mark = mark;
    }

    public List<Mark> getMarksList() {
        return marksList;
    }

    public void setMarksList(List<Mark> marksList) {
        this.marksList = marksList;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }
    
    
}
