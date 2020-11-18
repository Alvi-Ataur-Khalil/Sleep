package com.example.alvi.sleep;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.alvi.sleep.Adapters.MusicsRecyclerAdapter;
import com.example.alvi.sleep.Classes.Musics;

import java.util.ArrayList;
import java.util.List;

public class Details extends AppCompatActivity {


    RecyclerView vRecyclerView;

    ImageView imageView,imageViewBack;

    TextView textView;

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);


        Integer image=getIntent().getIntExtra("Image",0);
        final String header = getIntent().getStringExtra("Name");

        imageView = findViewById(R.id.image);
        imageViewBack = findViewById(R.id.back);
        textView = findViewById(R.id.texth);
        button = findViewById(R.id.play);


        imageView.setImageResource(image);
        textView.setText(header);

        imageViewBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(Details.this,PlayMusic.class);
                intent.putExtra("Name",header);
                startActivity(intent);
            }
        });

        List<Musics> arrayListOfSoS = new ArrayList<>();
        String [] headers = new String[]{"Night Sleep","Sweet Sleep", "Moon Cloud","Night Island"};
        String [] bodies = new String[]{"45 MIN • SLEEP MUSIC","45 MIN • SLEEP MUSIC", "45 MIN • SLEEP MUSIC", "45 MIN • SLEEP MUSIC"};
        Integer [] Images = new Integer[]{R.drawable.one,R.drawable.two,R.drawable.three,R.drawable.four};

        vRecyclerView = findViewById(R.id.verti_recycl);
        vRecyclerView.setLayoutManager(new GridLayoutManager(this, 2));


        for(int i=0;i<Images.length;i++){
            Musics musics= new Musics();


            musics.setHeader(headers[i]);
            musics.setBody(bodies[i]);
            musics.setImage(Images[i]);

            //LogPrint("Kiklo",numbers[i]+" "+headers[i]+" "+Images[i]+"\n");

            arrayListOfSoS.add(musics);
        }


        MusicsRecyclerAdapter customAdapter = new MusicsRecyclerAdapter(this, arrayListOfSoS);
        vRecyclerView.setAdapter(customAdapter);
        vRecyclerView.setFocusable(false);
    }
}
