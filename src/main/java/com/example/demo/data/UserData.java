package com.example.demo.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;


@Entity
@Table(name="USER_DATA", uniqueConstraints=@UniqueConstraint(columnNames = {"inn_col", "kpp_col"}))
public class UserData {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @Column(name="inn_col")
    private String inn;

    @Column(name="kpp_col")
    private String kpp;

    private String phone;
    private String company;
    private String manager;

    /*TO-DO: make builder.*/
    public UserData(){
        name = "";
        inn = "";
        kpp = "";
        phone = "";
        company = "";
        manager = "";
    }

    public UserData(String name , String inn, String kpp, String phone, String company, String manager){
        this.name = name;
        this.inn = inn;
        this.kpp = kpp;
        this.phone = phone;
        this.company = company;
        this.manager = manager;
    }

    public Long getId(){
        return  id;
    }

    public String getName(){
        return  name;
    }

    public String getInn(){
        return  inn;
    }

    public String getKpp(){
        return  kpp;
    }

    public String getPhone(){
        return phone;
    }

    public String getCompany(){
        return  company;
    }

    public String getManager(){
        return  manager;
    }
}
