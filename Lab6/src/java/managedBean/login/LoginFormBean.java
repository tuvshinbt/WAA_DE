/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBean.login;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author tuvshuu
 */
@ManagedBean(name = "loginFrom")
@RequestScoped
public class LoginFormBean {

    /**
     * Creates a new instance of LogingFormBean
     */
    public LoginFormBean() {
    }

    private String userId;
    private String password;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String doLogin() {
        if (this.userId.equals("kl01") && this.password.equals("yoyo")) {
            return "ok";
        } else {
            return "failed";
        }
    }
    
    public String jumpToOrder() {
        return "order";
    }

}
