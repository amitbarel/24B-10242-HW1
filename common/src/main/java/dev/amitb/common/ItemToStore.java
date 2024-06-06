package dev.amitb.common;

public class ItemToStore {

    private String title;
    private String description;

    public ItemToStore(){

    }

    public String getTitle(){
        return title;
    }

    public String getDescription(){
        return description;
    }

    public ItemToStore setTitle(String title){
        this.title = title;
        return this;
    }

    public ItemToStore setDescription(String description){
        this.description = description;
        return this;
    }
}
