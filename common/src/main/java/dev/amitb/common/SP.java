package dev.amitb.common;

import static android.content.Context.MODE_PRIVATE;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class SP {

    private final String PREFS_NAME = "MyPreferences";
    private final String LIST_KEY = "myList";
    private final Type TYPE = new TypeToken<ArrayList<ItemToStore>>() {}.getType();
    private final Gson GSON = new Gson();

    public ArrayList<ItemToStore> getData(Context context) {
        ArrayList<ItemToStore> data;
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        String itemList = sharedPreferences.getString(LIST_KEY, "");
        data = GSON.fromJson(itemList, TYPE);
        if (data != null) {
            return GSON.fromJson(itemList, TYPE);
        }
        return new ArrayList<>();
    }

    public void setData(Context context, ArrayList<ItemToStore> data) {
        String json = GSON.toJson(data, TYPE);
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(LIST_KEY, json);
        editor.apply();
    }

    public void addItem(Context context, ItemToStore item) {
        ArrayList<ItemToStore> data = getData(context);
        data.add(item);
        setData(context, data);
    }

    public void removeItem(Context context, ItemToStore item) {
        ArrayList<ItemToStore> data = getData(context);
        Log.d("data", data.toString());
        data.removeIf(item::equals);
        setData(context, data);
        Log.d("data", data.toString());
    }
}
