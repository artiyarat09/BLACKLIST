package com.example.artt.blacklist;

public class User {
    public  String name, image, id, bank, baked, data;



    public User(){



    }

    public String getName() {
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image){
        this.image = image;
    }

    public String getId() {
        return id;
    }

    public void setId(String id){
        this.id = id;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank){
        this.bank = bank;
    }

    public String getBaked() {
        return baked;
    }

    public void setBaked(String baked){
        this.baked = baked;
    }

    public String getData() {
        return data;
    }

    public void setData(String data){
        this.data = data;
    }

    public User (String name, String image, String id, String bank, String baked, String data){
        this.name = name;
        this.image = image;
        this.id = id;
        this.bank = bank;
        this.baked = baked;
        this.data = data;
    }


}
