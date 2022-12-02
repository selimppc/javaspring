package tax.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name ="tax")
public class Tax {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int tin;
    private String surname;
    private String first_name;
    private int nid;
    private Date date;

    public Tax(){

    }
    public Tax(int id, int tin, String surname, String first_name, int nid, Date date) {
        this.id = id;
        this.tin = tin;
        this.surname = surname;
        this.first_name = first_name;
        this.nid = nid;
        this.date = date;
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

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public int getNid() {
        return nid;
    }

    public void setNid(int nid) {
        this.nid = nid;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

}
