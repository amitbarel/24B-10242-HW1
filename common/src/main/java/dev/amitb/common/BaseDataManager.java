package dev.amitb.common;

import android.content.Context;

import java.util.ArrayList;

public abstract class BaseDataManager {

    public static final SP sharedPreferences = new SP();

    public abstract ArrayList<ItemToStore> getItems();

}
