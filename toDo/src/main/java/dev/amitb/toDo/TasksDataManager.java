package dev.amitb.toDo;

import android.content.Context;

import java.util.ArrayList;

import dev.amitb.common.BaseDataManager;
import dev.amitb.common.ItemToStore;

public class TasksDataManager extends BaseDataManager {

    private ArrayList<ItemToStore> items;

    public TasksDataManager(Context context) {
        items = sharedPreferences.getData(context);
    }

    @Override
    public ArrayList<ItemToStore> getItems() {
        return items;
    }
}
