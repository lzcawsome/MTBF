package com.example.signaldetect;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    LoadingView loadingView;
    Button startpauserbt;
    Button record;
    boolean isshowloadingview=false;
    TextView loadingviewtext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initview();

    }

    private void initview() {
        loadingView = findViewById(R.id.loadingview);
        startpauserbt = findViewById(R.id.startpausebt);
        record = findViewById(R.id.recoredbt);
        startpauserbt.setOnClickListener(this);
        record.setOnClickListener(this);
        loadingView.setVisibility(View.INVISIBLE);
        loadingviewtext=findViewById(R.id.loadingviewtext);
        loadingviewtext.setVisibility(View.INVISIBLE);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.startpausebt:
                if (isshowloadingview==false) {
                    loadingView.setVisibility(View.VISIBLE);
                    loadingviewtext.setVisibility(View.VISIBLE);
                    loadingView.start();
                    // TODO: 2020/9/23  以下启动一个服务去监听信号变换广播

                }
                else {
                    loadingView.stop();
                    loadingView.setVisibility(View.INVISIBLE);
                    loadingviewtext.setVisibility(View.INVISIBLE);
                }
                isshowloadingview=!isshowloadingview;
                break;
            case R.id.recoredbt:
                Intent intent=new Intent(this,SinalChangeActivity.class);
                startActivity(intent);
                break;


        }
    }
}