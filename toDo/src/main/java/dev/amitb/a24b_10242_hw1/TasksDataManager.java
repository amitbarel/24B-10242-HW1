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
                .setDate("24/06/24"));

        items.add(new ItemToStore().
                setTitle("Task2")
                .setDate("26/06/24"));

        items.add(new ItemToStore().
                setTitle("Task3")
                .setDate("27/06/24"));

        items.add(new ItemToStore().
                setTitle("Task4")
                .setDate("29/06/24"));

        items.add(new ItemToStore().
                setTitle("Task5")
                .setDate("01/07/24"));

        return items;
    }
}
