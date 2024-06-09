package dev.amitb.common;

public class ItemToStore {

    private String title;
    private String description;
    private String date;

    public ItemToStore(){
    }

    public String getTitle(){
        return title;
    }

    public String getDescription(){
        return description;
    }

    public String getDate(){
        return date;
    }

    public ItemToStore setTitle(String title){
        this.title = title;
        return this;
    }

    public ItemToStore setDescription(String description){
        this.description = description;
        return this;
    }

    public ItemToStore setDate(String date){
        this.date = date;
        return this;
    }
}
