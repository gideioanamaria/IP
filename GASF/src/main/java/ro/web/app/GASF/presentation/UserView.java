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
import ro.web.app.GASF.business.boundary.Users;
import ro.web.app.GASF.business.entity.Login;

/**
 *
 * @author Oana
 */
@Named
@ViewScoped
@ManagedBean
public class UserView implements Serializable{
    @Inject
    private Users users;
    private Login user;
    private List<Login> usersList;
    private String productId;
    
    @PostConstruct
    public void initUser() {
        user = new Login();
        usersList = users.getUsersList();
    }

    public void saveUser() {

        if (user.getId() == null) {
            users.saveUser(user);
            usersList.add(user);

        }
        user = new Login();
        addMessageToUser("Successful!", "The user has been added.");
    }

    

    public void addMessageToUser(String summary, String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public Login getUser() {
        return user;
    }

    public void setUser(Login user) {
        this.user = user;
    }

    public List<Login> getUsersList() {
        return usersList;
    }

    public void setUsersList(List<Login> usersList) {
        this.usersList = usersList;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    
   
    
}
