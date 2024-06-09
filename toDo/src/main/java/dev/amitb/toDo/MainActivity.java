package dev.amitb.toDo;

import android.os.Bundle;

import dev.amitb.common.BaseActivity;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        baseDataManager = new TasksDataManager();
        super.onCreate(savedInstanceState);
    }
}