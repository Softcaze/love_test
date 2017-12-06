package com.softcaze.nicolas.testdamour;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import org.w3c.dom.Text;

public class ResultActivity extends Activity {
    String score;

    TextView title_names, title;
    TextView scoreTxt;

    Button play_again, rate_us;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        AdView adView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder()
                .setRequestAgent("android_studio:ad_template").build();
        adView.loadAd(adRequest);

        Typeface custom_font = Typeface.createFromAsset(getAssets(),  "fonts/jandles.ttf");

        title = (TextView) findViewById(R.id.title);

        title.setTypeface(custom_font);

        title_names = (TextView) findViewById(R.id.title_names);
        scoreTxt = (TextView) findViewById(R.id.score);

        play_again = (Button) findViewById(R.id.play_again);
        rate_us = (Button) findViewById(R.id.rate_us);

        Intent intent = getIntent();
        score = intent.getStringExtra("score");
        title_names.setText(intent.getStringExtra("name1") + " + " + intent.getStringExtra("name2"));

        scoreTxt.setText(score + " %");

        play_again.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ResultActivity.this, MainActivity.class);
                ResultActivity.this.startActivity(intent);
            }
        });

        rate_us.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse ("market://details?id=com.softcaze.nicolas.testdamour"));
                startActivity(intent);
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        Intent intent = new Intent(ResultActivity.this, MainActivity.class);
        ResultActivity.this.startActivity(intent);
    }
}
