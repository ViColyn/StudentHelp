package com.example.a99710.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ReleaseActivity extends AppCompatActivity {
    private EditText timeText;
    private EditText scoreText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.release_layout);

        scoreText=(EditText)findViewById(R.id.score);
        timeText=(EditText)findViewById(R.id.timeWait);

        Button confir=(Button)findViewById(R.id.submit);

        confir.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent=new Intent();
                OrderInfo order=new OrderInfo(0,Float.parseFloat(timeText.getText().toString()),R.drawable.head1,Float.parseFloat(scoreText.getText().toString()),123,"华工生活区北门","华工c10楼下","Jenny");
                intent.putExtra("order",order);
                setResult(RESULT_OK,intent);
                finish();
            }
        });

    }

}
