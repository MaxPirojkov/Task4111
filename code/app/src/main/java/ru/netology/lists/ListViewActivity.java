package ru.netology.lists;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class ListViewActivity extends AppCompatActivity {

    private static final String FIRST_ITEM = "0";
    private static final String SECOND_ITEM = "1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        List<Map<String, String>> content = new ArrayList<>();
        ListView listView = findViewById(R.id.list);




        String[] arrayContent = getString(R.string.large_text).split("\n\n");
        for (int i = 0; i < arrayContent.length; i++) {
            Map<String, String> rowMap = new HashMap<>();
            rowMap.put(FIRST_ITEM, arrayContent[i]);
            rowMap.put(SECOND_ITEM, String.valueOf(arrayContent[i].length()));
            content.add(rowMap);
        }


        SimpleAdapter adapter = new SimpleAdapter(this, content,  android.R.layout.simple_list_item_2,
                new String[]{FIRST_ITEM, SECOND_ITEM},
                new int[]{android.R.id.text1, android.R.id.text2});
        listView.setAdapter(adapter);

    }
}








