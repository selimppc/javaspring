package com.avatar.user.tax.entity;

import jakarta.persistence.*;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import java.util.Date;

@Entity
@Table(name = "tax")
public class Tax {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int tin;

    @NonNull
    private String surname;
    private String firstName;
    private String lastName;

    @Nullable
    private int nid;
    private Date dob;

    public Tax(){
    }

    public Tax(int id, int tin, String surname, String firstName, String lastName, int nid, Date dob) {
        this.id = id;
        this.tin = tin;
        this.surname = surname;
        this.firstName = firstName;
        this.lastName = lastName;
        this.nid = nid;
        this.dob = dob;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTin() {
        return tin;
    }

    public void setTin(int tin) {
        this.tin = tin;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
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

    public int getNid() {
        return nid;
    }

    public void setNid(int nid) {
        this.nid = nid;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }
}
