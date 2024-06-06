package dev.amitb.common;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import android.widget.ArrayAdapter;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textview.MaterialTextView;

public class BaseActivity extends AppCompatActivity {

    protected BaseDataManager baseDataManager;

    private MaterialTextView LBL_title;
    private ListView LIST_base;
    private MaterialButton BTN_add;
    private MaterialButton BTN_remove;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        findViews();

        ArrayList<String> items = new ArrayList<>();
        items.add("Item 1");
        items.add("Item 2");
        items.add("Item 3");
        items.add("Item 4");
        items.add("Item 5");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, items);
        LIST_base.setAdapter(adapter);

        initViews();
    }

    private void initViews() {

    }

    private void findViews() {
        LBL_title = findViewById(R.id.LBL_title);
        LIST_base = findViewById(R.id.LIST_base);
        BTN_add = findViewById(R.id.BTN_add);
        BTN_remove = findViewById(R.id.BTN_remove);
    }
}