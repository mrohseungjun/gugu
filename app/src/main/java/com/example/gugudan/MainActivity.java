package com.example.gugudan;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button btn1, btn2;
    EditText edt1, edt2, edt3;
    TextView tv1, tv2;
    ListView list1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);

        edt1 = (EditText) findViewById(R.id.edt1);
        edt2 = (EditText) findViewById(R.id.edt2);
        edt3 = (EditText) findViewById(R.id.edt3);

        tv1 = (TextView) findViewById(R.id.tv1);
        tv2 = (TextView) findViewById(R.id.tv2);

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int rad1 = new Random().nextInt(10);
                int rad2 = new Random().nextInt(10);

                edt1.setText(String.valueOf((rad1)));
                edt2.setText(String.valueOf((rad2)));
            }
        });
        ArrayList<String> data = new ArrayList<>();

        ArrayAdapter<String>adapter = new ArrayAdapter<String>
                (this, android.R.layout.simple_list_item_1,data);

        btn1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                list1 = (ListView) findViewById(R.id.list1);

                String str1 = edt1.getText().toString();
                String str2 = edt2.getText().toString();
                String str3 = edt3.getText().toString();

                if(str1.length() == 0){
                    Toast.makeText(MainActivity.this, "값을 입력하세요", Toast.LENGTH_SHORT).show();
                    edt1.requestFocus();
                    return;
                }else{
                    int int1 = Integer.parseInt(str1);
                    for(int i = 1;i < 10;i++){
                        int result = int1 * i;
                        String hap = Integer.toString(result);
                        data.add(str1+"x"+i+"="+hap);
                    }
                }
                if(str2.length() == 0){
                    Toast.makeText(MainActivity.this, "값을 입력하세요", Toast.LENGTH_SHORT).show();
                    edt2.requestFocus();
                    return;
                }else{
                    int int2 = Integer.parseInt(str2);
                }
                if(str3.length() == 0){
                    Toast.makeText(MainActivity.this, "값을 입력하세요", Toast.LENGTH_SHORT).show();
                    edt3.requestFocus();
                    return;
                }else{
                    int int3 = Integer.parseInt(str3);
                }
                list1.setAdapter(adapter);
            }
        });

    }
}