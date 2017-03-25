package com.example.android.a051;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tv;
    Integer ss;
    String cc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //
        tv=(TextView)findViewById(R.id.textView);
        tv.setText(getResources().getString(R.string.news));
    }

    public void buttonsClick(View v){
    switch (v.getId())
    {
        case R.id.button:
            Intent ii=new Intent(this,SetupActivity.class); //到下一頁用intent
            startActivityForResult(ii,1); // 帶資料回來在Main要打的東西
            break;
    }
    }
//右鍵 override method onActivityResult, 目的套用在新聞裡面
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode== 1 & resultCode==RESULT_OK)
        {
            ss=Integer.parseInt(data.getStringExtra("fontSize"));
            cc=data.getStringExtra("color");//大小寫要一樣!!!!!!!!!!!!!! bug!!!!!!!!!
            tv.setTextSize(ss);
            if (cc.equals("Red"))
            {
                tv.setTextColor(getResources().getColor(R.color.maroon));
            }
            else if (cc.equals("Green"))
            {
                tv.setTextColor(getResources().getColor(R.color.darkGreen));
            }
            else {
                tv.setTextColor(getResources().getColor(R.color.mediumBlue));
            }
        }
    }
}
