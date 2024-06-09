package dev.amitb.a24b_10242_hw1;

import android.os.Bundle;
import android.widget.ListView;
import dev.amitb.common.BaseActivity;
import dev.amitb.common.CommonAdapter;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        baseDataManager = new NotesDataManager();
        super.onCreate(savedInstanceState);
    }
}