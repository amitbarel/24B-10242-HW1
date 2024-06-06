package dev.amitb.a24b_10242_hw1;

import android.app.Dialog;
import android.os.Bundle;
import android.widget.ListView;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

import java.util.Objects;

import dev.amitb.common.BaseActivity;
import dev.amitb.common.ItemToStore;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        baseDataManager = new TasksDataManager();
        super.onCreate(savedInstanceState);

        TaskAdapter adapter = new TaskAdapter(this, baseDataManager.getItems());
        ListView listView = findViewById(dev.amitb.common.R.id.LIST_base);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener((parent, view, position, id) ->
                adapter.setSelectedPosition(position));

        MaterialButton removeButton = findViewById(dev.amitb.common.R.id.BTN_remove);
        removeButton.setOnClickListener(v -> adapter.removeSelectedItem());

        MaterialButton addButton = findViewById(dev.amitb.common.R.id.BTN_add);
        addButton.setOnClickListener(v -> {
            Dialog dialog = new Dialog(this);
            dialog.setContentView(R.layout.dialogue_add_task);
            TextInputEditText title = dialog.findViewById(R.id.TXT_taskTitle);
            TextInputEditText dueDate = dialog.findViewById(R.id.TXT_taskDueDate);
            MaterialButton saveButton = dialog.findViewById(R.id.BTN_addTask);

            saveButton.setOnClickListener(v1 -> {
                String taskTitle = Objects.requireNonNull(title.getText()).toString();
                String taskDueDate = Objects.requireNonNull(dueDate.getText()).toString();
                adapter.addItem(new ItemToStore()
                        .setTitle(taskTitle)
                        .setDescription(taskDueDate));
                dialog.dismiss();
            });

            dialog.show();
        });

    }
}