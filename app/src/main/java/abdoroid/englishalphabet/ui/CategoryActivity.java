package abdoroid.englishalphabet.ui;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Point;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.huawei.hms.ads.AdParam;
import com.huawei.hms.ads.HwAds;
import com.huawei.hms.ads.InterstitialAd;
import com.huawei.hms.ads.banner.BannerView;

import java.util.ArrayList;

import abdoroid.englishalphabet.R;
import abdoroid.englishalphabet.model.CategoryModel;
import abdoroid.englishalphabet.utils.GetTTS;

public class CategoryActivity extends AppCompatActivity {

    private AnimatorSet mSetRightOut, mSetLeftIn;
    private boolean mIsBackVisible = false;
    private View mCardFrontLayout, mCardBackLayout;
    private TextView mFrontText;
    private ImageView mBackImage, mHome, mVoice;
    private ArrayList<CategoryModel> category = new ArrayList<>();
    private int count = 0;
    private MediaPlayer mediaPlayer;
    private String sourceText, backgroundColor;
    private Display display;
    private Point size;
    private int width, height;
    private float txtsize;
    InterstitialAd interstitialAd;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_category);
        HwAds.init(this);
        BannerView bottomBannerView = findViewById(R.id.hw_banner_view);
        AdParam adParam = new AdParam.Builder().build();
        bottomBannerView.loadAd(adParam);
        interstitialAd = new InterstitialAd(this);
        interstitialAd.setAdId(getString(R.string.interstitial_ad_id));
        interstitialAd.loadAd(adParam);

        Intent intent = getIntent();
        category = intent.getParcelableArrayListExtra("Category");
        backgroundColor = intent.getStringExtra("catColor");
        mFrontText = findViewById(R.id.front_text);
        mFrontText.setBackgroundColor(Color.parseColor(backgroundColor));
        mBackImage = findViewById(R.id.back_image);
        mBackImage.setBackgroundColor(Color.parseColor(backgroundColor));
        mHome = findViewById(R.id.home);
        mHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CategoryActivity.this, MainActivity.class));
            }
        });
        mVoice = findViewById(R.id.voice);
        mVoice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(category.get(0).getWordString().equals("A a")){
                    if (!mIsBackVisible){
                        sourceText = category.get(count).getLetterSound();
                        GetTTS.startVoice(sourceText);
                    }else{
                        sourceText = category.get(count).getLetterWord();
                        GetTTS.startVoice(sourceText);
                    }

                }else {
                    sourceText = category.get(count).getWordString();
                    GetTTS.startVoice(sourceText);
                }
            }
        });

        display = getWindowManager().getDefaultDisplay();
        size = new Point();
        display.getSize(size);
        width = size.x;
        height = size.y;
        txtsize=height*0.028f;
        mFrontText.setTextSize(txtsize);
        if(category.get(0).getWordString().equals("A a") || category.get(0).getWordString().equals("0")){
            txtsize=height*0.13f;
            mFrontText.setTextSize(txtsize);
        }
        mFrontText.setText(category.get(0).getWordString());
        mBackImage.setImageResource(category.get(0).getPhotoImageSource());
        ImageView mForward = findViewById(R.id.forward_button);
        ImageView mBackward = findViewById(R.id.backward_button);
        mCardBackLayout = findViewById(R.id.card_back);
        mCardFrontLayout = findViewById(R.id.card_front);
        GetTTS.initVoice(getApplicationContext());
        loadAnimations();
        changeCameraDistance();
        mForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count += 1;
                if (count % 5 == 0 && (interstitialAd != null && interstitialAd.isLoaded())){
                    interstitialAd.show();
                    interstitialAd.loadAd(adParam);
                }
                if (count > category.size()-1) {
                    count = category.size()-1;
                    mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.applause);
                    mediaPlayer.start();
                }else{
                    mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.click);
                    mediaPlayer.start();
                    mFrontText.setText(category.get(count).getWordString());
                    mBackImage.setImageResource(category.get(count).getPhotoImageSource());
                }

            }
        });
        mBackward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count -= 1;
                if (count < 0){
                    count = 0;
                }else {
                    mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.click);
                    mediaPlayer.start();
                    mFrontText.setText(category.get(count).getWordString());
                    mBackImage.setImageResource(category.get(count).getPhotoImageSource());
                }

            }
        });

    }


    private void changeCameraDistance() {
        int distance = 8000;
        float scale = getResources().getDisplayMetrics().density * distance;
        mCardFrontLayout.setCameraDistance(scale);
        mCardBackLayout.setCameraDistance(scale);
    }

    @SuppressLint("ResourceType")
    private void loadAnimations() {
        mSetRightOut = (AnimatorSet) AnimatorInflater.loadAnimator(this, R.anim.out_animation);
        mSetLeftIn = (AnimatorSet) AnimatorInflater.loadAnimator(this, R.anim.in_animation);
    }

    public void flipCard(View view) {
        if (!mIsBackVisible) {
            mSetRightOut.setTarget(mCardFrontLayout);
            mSetLeftIn.setTarget(mCardBackLayout);
            mSetRightOut.start();
            mSetLeftIn.start();
            mIsBackVisible = true;

        } else {
            mSetRightOut.setTarget(mCardBackLayout);
            mSetLeftIn.setTarget(mCardFrontLayout);
            mSetRightOut.start();
            mSetLeftIn.start();
            mIsBackVisible = false;
        }
    }

}
