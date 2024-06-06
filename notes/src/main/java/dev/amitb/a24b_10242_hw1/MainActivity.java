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
        baseDataManager = new NotesDataManager();
        super.onCreate(savedInstanceState);

        NoteAdapter adapter = new NoteAdapter(this, baseDataManager.getItems());
        ListView listView = findViewById(dev.amitb.common.R.id.LIST_base);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener((parent, view, position, id) ->
                adapter.setSelectedPosition(position));

        MaterialButton removeButton = findViewById(dev.amitb.common.R.id.BTN_remove);
        removeButton.setOnClickListener(v -> adapter.removeSelectedItem());

        MaterialButton addButton = findViewById(dev.amitb.common.R.id.BTN_add);
        addButton.setOnClickListener(v -> {
            Dialog dialog = new Dialog(this);
            dialog.setContentView(R.layout.dialogue_add_note);
            TextInputEditText title = dialog.findViewById(R.id.TXT_noteTitle);
            TextInputEditText description = dialog.findViewById(R.id.TXT_noteDescription);
            MaterialButton saveButton = dialog.findViewById(R.id.BTN_addNote);

            saveButton.setOnClickListener(v1 -> {
                String noteTitle = Objects.requireNonNull(title.getText()).toString();
                String noteDescription = Objects.requireNonNull(description.getText()).toString();
                adapter.addItem(new ItemToStore()
                        .setTitle(noteTitle)
                        .setDescription(noteDescription));
                dialog.dismiss();
            });

            dialog.show();
        });
    }
}