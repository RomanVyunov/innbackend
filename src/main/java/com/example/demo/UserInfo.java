package com.example.demo;

public class UserInfo {
    private Long id;
    private String inn;
    private String kpp;
    private String name;
    private String phone;
    private String company;
    private String manager;


    public UserInfo(){

    }

    public UserInfo(Long id,
                    String name,
                    String inn,
                    String kpp,
                    String phone,
                    String company,
                    String manager){
        this.id = id;
        this.inn = inn;
        this.kpp = kpp;
        this.name = name;
        this.company = company;
        this.phone = phone;
        this.manager = manager;
    }

    public Long getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public String getInn(){
        return inn;
    }

    public String getKpp(){
        return kpp;
    }

    public String getPhone(){
        return phone;
    }

    public  String getCompany(){
        return company;
    }

    public String getManager(){
        return manager;
    }

    public void setId(Long id){
        this.id = id;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setInn(String inn){
        this.inn = inn;
    }

    public void setKpp(String kpp){
        this.kpp = kpp;
    }

    public void setCompany(String company){
        this.company = company;
    }

    public void setPhone(String phone){
        this.phone = phone;
    }

    public void setManager(String manager){
        this.manager = manager;
    }

}
