/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mlubanski.wicket.model;

import java.io.Serializable;
import javax.persistence.*;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

/**
 *
 * @author Mateusz Lubański <m.lubanskii@gmail.com>
 */
@Entity
@Table(name="User")
@Inheritance(strategy = InheritanceType.JOINED)
public class User extends BaseEntity<Integer> implements Serializable {
    
   protected Integer id;
   
   protected String firstName;
   protected String lastName;
   protected String email;
   protected String login;
   protected String password;
   protected String phone;
   protected String mobile;
   
   @Transient
   protected String newPassword;

    @Id
    @GeneratedValue
    @Column(name = "userId")
    public Integer getId() {
        return id;
    }
    
    public void setId(Integer userId) {
        this.id = userId;
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    @Transient
    public String getFullName() {
        return firstName + " " + lastName;
    }

    @Column(unique=true)
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        
       this.password = password;        
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }
    
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    
    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 1003). // two randomly chosen prime numbers
                // if deriving: appendSuper(super.hashCode()).
                append(id).
                toHashCode();
    }

    @Override
    public boolean equals(Object obj) {

        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj.getClass() != getClass()) {
            return false;
        }

        User user = (User) obj;
        return new EqualsBuilder(). // if deriving: appendSuper(super.equals(obj)).
                append(id, user.getId()).
                isEquals();
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", login=" + login + ", password=" + password + ", phone=" + phone + ", mobile=" + mobile + ", newPassword=" + newPassword + '}';
    }
}
