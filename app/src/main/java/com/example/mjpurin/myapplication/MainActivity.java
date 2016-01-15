package com.example.mjpurin.myapplication;

import android.graphics.RadialGradient;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView lv;
    EditText etName;
    EditText etAge;
    RadioGroup rg;
    Button bt;
    List<Person> list=new ArrayList<>();
    PersonAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findView();
        addEvent();
    }

    private void findView(){
        lv=(ListView)findViewById(R.id.listView);
        etName=(EditText)findViewById(R.id.etName);
        etAge=(EditText)findViewById(R.id.etAge);
        rg=(RadioGroup)findViewById(R.id.rg);
        bt=(Button)findViewById(R.id.button);

    }

    private void addEvent(){
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=etName.getText().toString();
                int age=Integer.parseInt(etAge.getText().toString());
                String sex=((RadioButton)findViewById(rg.getCheckedRadioButtonId())).getText().toString();
                list.add(new Person(name,age,sex));
                adapter=new PersonAdapter(MainActivity.this,R.layout.cell,list);
                lv.setAdapter(adapter);
                etName.setText("");
                etName.requestFocus();
                etAge.setText("");
                ((RadioButton) rg.getChildAt(0)).setChecked(true);
            }
        });
        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                adapter.remove(list.get(position));
                return true;
            }
        });
    }




}
