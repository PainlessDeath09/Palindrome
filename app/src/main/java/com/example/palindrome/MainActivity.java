package com.example.palindrome;

import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button c = findViewById(R.id.check);
        c.setOnClickListener(this);
        getWindow().getDecorView().setBackgroundColor(Color.parseColor("#bebebe"));

    }

    @Override
    public void onClick(View v)
    {
        EditText in = findViewById(R.id.input);
        final TextView o = findViewById(R.id.textView);
        if (in.getText().toString().trim().length() == 0)
        {
            Toast.makeText(this, "Please input some text and try again", Toast.LENGTH_SHORT).show();
            return;
        }
        else
        {
            String s = in.getText().toString().toLowerCase();
            switch(Test(s))
            {
                case 1:
                {
                    getWindow().getDecorView().setBackgroundColor(Color.parseColor("#1ed760"));
                    final String s1 = "Text is Palindrome!";
                    final String t = "Palindrome Test";
                    o.setText(s1);
                    new CountDownTimer(1000, 1000)
                    {
                        @Override
                        public void onTick(long l)
                        {

                        }

                        @Override
                        public void onFinish()
                        {
                            getWindow().getDecorView().setBackgroundColor(Color.parseColor("#bebebe"));
                            o.setText(t);
                        }
                    }.start();
                    break;
                }
                case -1:
                {
                    getWindow().getDecorView().setBackgroundColor(Color.parseColor("#d91921"));
                    final String s1 = "Text is NOT Palindrome!";
                    final String t = "Palindrome Test";
                    o.setText(s1);
                    new CountDownTimer(1000, 1000)
                    {
                        public void onTick(long l){}
                        @Override
                        public void onFinish()
                        {
                            getWindow().getDecorView().setBackgroundColor(Color.parseColor("#bebebe"));
                            o.setText(t);
                        }
                    }.start();
                    break;
                }
            }

        }

    }

    public int Test(String str)
    {
        String rev = "";
        int length = str.length();
        for ( int i = length - 1; i >= 0; i-- )
            rev = rev + str.charAt(i);

        if (str.equals(rev))
            return 1;
        else
            return -1;
    }


}
