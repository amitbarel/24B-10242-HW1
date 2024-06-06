package dev.amitb.a24b_10242_hw1;

import java.util.ArrayList;

import dev.amitb.common.BaseDataManager;
import dev.amitb.common.ItemToStore;

public class TasksDataManager extends BaseDataManager {
    @Override
    public ArrayList<ItemToStore> getItems() {
        ArrayList<ItemToStore> items = new ArrayList<>();

        items.add(new ItemToStore().
                setTitle("Task1")
                .setDescription("24 June"));

        items.add(new ItemToStore().
                setTitle("Task2")
                .setDescription("26 June"));

        items.add(new ItemToStore().
                setTitle("Task3")
                .setDescription("27 June"));

        items.add(new ItemToStore().
                setTitle("Task4")
                .setDescription("29 June"));

        items.add(new ItemToStore().
                setTitle("Task5")
                .setDescription("1 July"));

        items.add(new ItemToStore().
                setTitle("Task6")
                .setDescription("5 July"));

        items.add(new ItemToStore().
                setTitle("Task7")
                .setDescription("7 July"));

        return items;
    }
}
