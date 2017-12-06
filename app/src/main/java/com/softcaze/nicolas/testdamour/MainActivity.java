package com.softcaze.nicolas.testdamour;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import org.w3c.dom.Text;

import javax.xml.datatype.Duration;

public class MainActivity extends Activity {
    TextView title, txt_error;
    EditText yourname, hername;
    Button btn_test;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AdView adView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder()
                .setRequestAgent("android_studio:ad_template").build();
        adView.loadAd(adRequest);

        title = (TextView)findViewById(R.id.title);
        txt_error = (TextView) findViewById(R.id.txt_error);
        yourname = (EditText) findViewById(R.id.yourname);
        hername = (EditText) findViewById(R.id.hername);
        btn_test = (Button) findViewById(R.id.btn_test);

        yourname.setText("");
        hername.setText("");

        Typeface custom_font = Typeface.createFromAsset(getAssets(),  "fonts/jandles.ttf");

        title.setTypeface(custom_font);

        btn_test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(yourname.getText().toString().equals("") || hername.getText().toString().equals("")){
                    txt_error.setVisibility(View.VISIBLE);
                }
                else{
                    Intent intent = new Intent(MainActivity.this, QuizzActivity.class);
                    intent.putExtra("name1", yourname.getText().toString());
                    intent.putExtra("name2", hername.getText().toString());
                    MainActivity.this.startActivity(intent);
                }
            }
        });
    }
}
