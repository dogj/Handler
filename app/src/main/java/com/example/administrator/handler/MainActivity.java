package com.example.administrator.handler;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Handler handler = new Handler();
    TextView textView;
    Button button;
    ImageView imageview;
    MyRunnable myRunable = new MyRunnable();

    int images[]={R.drawable.face_007,R.drawable.face_008,R.drawable.face_009};
    private int i = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.text);
        button = (Button) findViewById(R.id.button);
        imageview= (ImageView) findViewById(R.id.imageView);




    }

    public void remove(View view) {
        handler.removeCallbacks(myRunable);
    }


    public class MyRunnable implements Runnable{


        @Override
        public void run() {
            i++;
            i=i%3;
            imageview.setImageResource(images[i]);
            handler.postDelayed(myRunable,1000);
        }
    }



    public void change(View view) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        handler.postDelayed(myRunable,3500);

                        textView.setText("haha");
                    }
                });
            }
        }).start();
    }
}

