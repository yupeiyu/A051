package com.example.android.a051;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class SetupActivity extends AppCompatActivity {


    String[] color={"Red","Green","Blue"};
    Integer[] fontSize={18,24,36,48,72};

    Spinner spFontSize,spColor;
    Integer ss=fontSize[0]; //預設在第0個位置
    String cc=color[2];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setup);
        //
        spFontSize=(Spinner)findViewById(R.id.spinner);
        spColor=(Spinner)findViewById(R.id.spinner2);

        ArrayAdapter<Integer> aa=new ArrayAdapter<Integer>(this,android.R.layout.simple_spinner_item,fontSize);
        //處理整數，轉接器Adapter(一定要有),然後塑膠袋把資料放進去，上面宣告的陣列資料
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //設定下拉
        spFontSize.setAdapter(aa);
//event listener 事件傾聽 setOn在甚麼情況下 new實作一個
        //用於Spinner點選之後有作用(button是用onClick)
        spFontSize.setOnItemSelectedListener(new Spinner.OnItemSelectedListener(){
            //右鍵 generate
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ss=fontSize[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ArrayAdapter<String> bb=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,color);
        bb.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spColor.setAdapter(bb);
        spColor.setOnItemSelectedListener(new Spinner.OnItemSelectedListener(){
            //右鍵 generate
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                cc=color[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }
    //回去上一頁用finish
    public void buttonsClick(View v){

        switch (v.getId()){
            case  R.id.button2:
                //資料帶回來,用intent 在finish之上
                Intent ii=new Intent();
                ii.putExtra("fontSize",ss.toString());
                ii.putExtra("color",cc);
                setResult(RESULT_OK,ii); //1=ok  資料過來，RESULT_OK資料過去
                finish();
                break;
        }
    }
}
