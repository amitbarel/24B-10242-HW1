package dev.amitb.notes;

import android.content.Context;

import java.util.ArrayList;

import dev.amitb.common.BaseDataManager;
import dev.amitb.common.ItemToStore;

public class NotesDataManager extends BaseDataManager {

    private ArrayList<ItemToStore> items;

    public NotesDataManager(Context context) {
        this.items = sharedPreferences.getData(context);
    }

    @Override
    public ArrayList<ItemToStore> getItems() {
        return items;
    }

}
