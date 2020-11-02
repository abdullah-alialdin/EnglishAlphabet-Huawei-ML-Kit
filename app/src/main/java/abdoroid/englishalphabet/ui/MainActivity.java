package abdoroid.englishalphabet.ui;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.annotation.NonNull;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import abdoroid.englishalphabet.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{


    CardView flashCards, tracing;
    MediaPlayer mediaPlayer;
    TextView flashcardsText, tracingText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setTheme(R.style.AppTheme);
        setContentView(R.layout.activity_main);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        int pxHeight = displayMetrics.heightPixels;
        float height = pxHeight / displayMetrics.density;
        float txtsize = height*0.08f;
        flashcardsText = findViewById(R.id.flashcards_text);
        flashcardsText.setTextSize(txtsize);
        tracingText = findViewById(R.id.tracing_text);
        tracingText.setTextSize(txtsize);
        mediaPlayer = MediaPlayer.create(this, R.raw.click);
        flashCards = findViewById(R.id.flashcards_button);
        flashCards.setOnClickListener(this);
        tracing = findViewById(R.id.tracing_button);
        tracing.setOnClickListener(this);
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_share:
                        Intent sendIntent = new Intent();
                        sendIntent.setAction(Intent.ACTION_SEND);
                        sendIntent.putExtra(Intent.EXTRA_TEXT,
                                getString(R.string.share_message) +" "+
                                        getString(R.string.google_play_url));
                        sendIntent.setType("text/plain");
                        Intent shareIntent = Intent.createChooser(sendIntent, null);
                        if (shareIntent.resolveActivity(getPackageManager()) != null) {
                            startActivity(shareIntent);
                        }
                        break;
                    case R.id.action_rate:
                        Intent intent = new Intent(Intent.ACTION_VIEW);
                        intent.setData(Uri.parse(
                                getString(R.string.google_play_url)));
                        if (intent.resolveActivity(getPackageManager()) != null) {
                            startActivity(intent);
                        }
                        break;
                    case R.id.action_settings:
                        startActivity(new Intent(MainActivity.this, DialogActivity.class));
                        break;
                    case R.id.action_about:
                        Intent aboutIntent = new Intent(MainActivity.this, AboutActivity.class);
                        startActivity(aboutIntent);
                        break;
                }
                return true;
            }
        });
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.flashcards_button:
                mediaPlayer.start();
                Intent flashIntent = new Intent(MainActivity.this, FlashCards.class);
                startActivity(flashIntent);
                break;
            case R.id.tracing_button:
                mediaPlayer.start();
                Intent traceIntent = new Intent(MainActivity.this, Tracing.class);
                startActivity(traceIntent);
                break;
        }


    }

}