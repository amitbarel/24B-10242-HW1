package dev.amitb.common;

import android.app.Dialog;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import java.util.List;
import java.util.Objects;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

public class BaseActivity extends AppCompatActivity {

    protected BaseDataManager baseDataManager;

    private List<ItemToStore> items;

    private ListView LIST_base;
    private MaterialButton BTN_add;
    private MaterialButton BTN_remove;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);

        findViews();
        items = baseDataManager.getItems();

        CommonAdapter adapter = new CommonAdapter(this, items);
        LIST_base.setAdapter(adapter);

        LIST_base.setOnItemClickListener((parent, view, position, id) ->
                adapter.setSelectedPosition(position));

        BTN_remove.setOnClickListener(v-> {
            BaseDataManager.sharedPreferences.removeItem(this,
                    items.get(adapter.getSelectedPosition()));
            adapter.removeSelectedItem();
        });
        BTN_add.setOnClickListener(v->{
            Dialog dialog = new Dialog(this);
            dialog.setContentView(R.layout.dialogue_add);
            TextInputEditText ET_title = dialog.findViewById(R.id.ET_title);
            TextInputEditText ET_description = dialog.findViewById(R.id.ET_description);
            TextInputEditText ET_datePicker = dialog.findViewById(R.id.ET_datePicker);
            MaterialButton saveBTN = dialog.findViewById(R.id.BTN_save);

            saveBTN.setOnClickListener(v1->{
                String title = Objects.requireNonNull(ET_title.getText()).toString();
                String description = ET_description.getText().toString();
                String date = ET_datePicker.getText().toString();

                ItemToStore newItem = new ItemToStore()
                        .setTitle(title)
                        .setDescription(description)
                        .setDate(date);

                adapter.addItem(newItem);
                BaseDataManager.sharedPreferences.addItem(this, newItem);
                dialog.dismiss();
            });

            dialog.show();
        });

    }

    private void findViews() {
        LIST_base = findViewById(R.id.LIST_base);
        BTN_add = findViewById(R.id.BTN_add);
        BTN_remove = findViewById(R.id.BTN_remove);
    }
}