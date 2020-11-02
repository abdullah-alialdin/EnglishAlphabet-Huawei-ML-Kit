package abdoroid.englishalphabet.ui;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import abdoroid.englishalphabet.R;

public class DialogActivity extends AppCompatActivity {

    public static final String MyPREFERENCES = "MyPrefs" ;
    public static final String VOICE_TYPE = "typeKey";
    public static final String VOICE_SPEED = "speedKey";
    public static final String VOICE_VOLUME = "volumeKey";
    String voiceType;
    float voiceSpeed, voiceVolume;
    SharedPreferences sharedpreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);
        sharedpreferences = getApplicationContext().getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);

        voiceType = sharedpreferences.getString(VOICE_TYPE, "Male-en");
        voiceSpeed = sharedpreferences.getFloat(VOICE_SPEED, 1.0f);
        voiceVolume = sharedpreferences.getFloat(VOICE_VOLUME, 1.0f);
        RadioGroup radioGroup = findViewById(R.id.sex_radio_group);
        if (voiceType == "Male-en"){
            radioGroup.check(R.id.male);
        }else{
            radioGroup.check(R.id.female);
        }
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == R.id.male){
                    voiceType = "Male-en";
                }else{
                    voiceType = "Female-en";
                }
            }
        });
        TextView speedText = findViewById(R.id.speed_value);
        speedText.setText(String.valueOf(voiceSpeed));
        SeekBar speedSeekBar = findViewById(R.id.speed_seekBar);
        speedSeekBar.setProgress((int) (voiceSpeed*50));
        speedSeekBar.incrementProgressBy(2);
        speedSeekBar.setMax(100);
        speedSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                voiceSpeed = i/50f;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                speedText.setText(String.valueOf(voiceSpeed));
            }
        });
        TextView volumeText = findViewById(R.id.volume_value);
        volumeText.setText(String.valueOf(voiceVolume));
        SeekBar volumeSeekBar = findViewById(R.id.volume_seekBar);
        volumeSeekBar.setProgress((int) (voiceVolume*50));
        volumeSeekBar.incrementProgressBy(2);
        volumeSeekBar.setMax(100);
        volumeSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                voiceVolume = i/50f;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                volumeText.setText(String.valueOf(voiceVolume));
            }
        });

        Button okButton = findViewById(R.id.ok);
        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = sharedpreferences.edit();
                editor.putString(VOICE_TYPE, voiceType);
                editor.putFloat(VOICE_SPEED, voiceSpeed);
                editor.putFloat(VOICE_VOLUME, voiceVolume);
                editor.commit();
                finish();
            }
        });


    }
}