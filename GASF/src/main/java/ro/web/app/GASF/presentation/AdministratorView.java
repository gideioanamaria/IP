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
import ro.web.app.GASF.business.boundary.Administrators;
import ro.web.app.GASF.business.entity.Administrator;

/**
 *
 * @author Oana
 */
@Named
@ViewScoped
@ManagedBean
public class AdministratorView implements Serializable{
    @Inject
    private Administrators administrators;
    private Administrator administrator;
    private List<Administrator> administratorsList;
    private String productId;
    
    @PostConstruct
    public void initAdministrator() {
        administrator = new Administrator();
        administratorsList = administrators.getAdministratorsList();
    }

    public void saveAdministrator() {

        if (administrator.getAdminid() == null) {
            administrators.saveAdministrator(administrator);
            administratorsList.add(administrator);

        }
        administrator = new Administrator();
        addMessageToAdministrator("Successful!", "The administrator has been added.");
    }

    

    public void addMessageToAdministrator(String summary, String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public Administrators getAdministrators() {
        return administrators;
    }

    public void setAdministrators(Administrators administrators) {
        this.administrators = administrators;
    }

    public Administrator getAdministrator() {
        return administrator;
    }

    public void setAdministrator(Administrator administrator) {
        this.administrator = administrator;
    }

    public List<Administrator> getAdministratorsList() {
        return administratorsList;
    }

    public void setAdministratorsList(List<Administrator> administratorsList) {
        this.administratorsList = administratorsList;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

   
    
}
