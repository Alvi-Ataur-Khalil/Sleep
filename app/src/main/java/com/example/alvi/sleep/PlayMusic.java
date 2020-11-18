package com.example.alvi.sleep;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class PlayMusic extends AppCompatActivity {

    ImageView imageViewBack;

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_music);

        String header = getIntent().getStringExtra("Name");

        textView = findViewById(R.id.head);
        imageViewBack = findViewById(R.id.back);

        textView.setText(header);

        imageViewBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }
}
