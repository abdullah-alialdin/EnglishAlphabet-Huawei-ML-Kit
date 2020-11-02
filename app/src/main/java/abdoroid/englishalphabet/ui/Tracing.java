package abdoroid.englishalphabet.ui;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.huawei.hms.ads.AdParam;
import com.huawei.hms.ads.HwAds;
import com.huawei.hms.ads.InterstitialAd;
import com.huawei.hms.ads.banner.BannerView;

import java.util.ArrayList;
import java.util.List;

import abdoroid.englishalphabet.R;
import abdoroid.englishalphabet.model.TraceModel;
import abdoroid.englishalphabet.utils.GetTTS;

public class Tracing extends Activity implements View.OnClickListener {

    private DrawingView dv ;
    private Paint mPaint;
    private ImageButton  red, blue, brown, green, pink, purple, eraser;
    private ImageView next, back, speaker, home;
    private int count = 0;
    private int color;
    private InterstitialAd interstitialAd;
    private List<TraceModel> resources = new ArrayList<TraceModel>(){
        {
            add(new TraceModel(R.drawable.trace_a, "A- is for Aligator")) ;
            add(new TraceModel(R.drawable.trace_b, "B- is for bear")) ;
            add(new TraceModel(R.drawable.trace_c, "C- is for cat")) ;
            add(new TraceModel(R.drawable.trace_d, "D- is for dog")) ;
            add(new TraceModel(R.drawable.trace_e, "E- is for elephant")) ;
            add(new TraceModel(R.drawable.trace_f, "F- is for fox")) ;
            add(new TraceModel(R.drawable.trace_g, "G- is for giraffe")) ;
            add(new TraceModel(R.drawable.trace_h, "H- is for Hippo")) ;
            add(new TraceModel(R.drawable.trace_i, "I- is for Iguana")) ;
            add(new TraceModel(R.drawable.trace_j, "J- is for jellyfish")) ;
            add(new TraceModel(R.drawable.trace_k, "K- is for kangaroo")) ;
            add(new TraceModel(R.drawable.trace_l, "L- is for lion")) ;
            add(new TraceModel(R.drawable.trace_m, "M- is for monkey")) ;
            add(new TraceModel(R.drawable.trace_n, "N- is for nest")) ;
            add(new TraceModel(R.drawable.trace_o, "O- is for owl")) ;
            add(new TraceModel(R.drawable.trace_p, "P- is for penguin")) ;
            add(new TraceModel(R.drawable.trace_q, "Q- is for quail")) ;
            add(new TraceModel(R.drawable.trace_r, "R- is for rhino")) ;
            add(new TraceModel(R.drawable.trace_s, "S- is for squirrel")) ;
            add(new TraceModel(R.drawable.trace_t, "T- is for turtle")) ;
            add(new TraceModel(R.drawable.trace_u, "U- is for unicorn")) ;
            add(new TraceModel(R.drawable.trace_v, "V- is for vulture")) ;
            add(new TraceModel(R.drawable.trace_w, "W- is for whale")) ;
            add(new TraceModel(R.drawable.trace_x, "X- is for xerus")) ;
            add(new TraceModel(R.drawable.trace_y, "Y- is for yak")) ;
            add(new TraceModel(R.drawable.trace_z, "Z- is for zebra")) ;
        }};
    private MediaPlayer mediaPlayer;

    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_tracing);
        GetTTS.initVoice(this);
        HwAds.init(this);
        AdParam adParam = new AdParam.Builder().build();
        interstitialAd = new InterstitialAd(this);
        interstitialAd.setAdId(getString(R.string.interstitial_ad_id));
        interstitialAd.loadAd(adParam);
        final RelativeLayout mTile = findViewById(R.id.mTile);
        next = findViewById(R.id.forward_button);
        back = findViewById(R.id.backward_button);
        dv = new DrawingView(this);
        mTile.addView(dv);
        final View rvTrans = new View(this);
        rvTrans.setBackgroundResource(R.drawable.trace_a);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count += 1;
                if (count % 5 == 0 && (interstitialAd != null && interstitialAd.isLoaded())){
                    interstitialAd.show();
                    interstitialAd.loadAd(adParam);
                }
                if (count > 25) {
                    playSound(R.raw.applause);
                    count = 25;
                }else{
                    playSound(R.raw.arrow);
                    dv.removePaint();
                    rvTrans.setBackgroundResource(resources.get(count).getImageSource());
                }

            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count -= 1;
                if (count < 0){
                    count = 0;
                }else{
                    playSound(R.raw.arrow);
                    dv.removePaint();
                    rvTrans.setBackgroundResource(resources.get(count).getImageSource());
                }

            }
        });
        eraser = findViewById(R.id.eraser);
        eraser.setOnClickListener(this);
        home = findViewById(R.id.home);
        home.setOnClickListener(this);
        speaker = findViewById(R.id.voice);
        speaker.setOnClickListener(this);
        color = getResources().getColor(R.color.red);
        red = findViewById(R.id.red);
        red.setOnClickListener(this);
        brown = findViewById(R.id.brown);
        brown.setOnClickListener(this);
        green = findViewById(R.id.green);
        green.setOnClickListener(this);
        blue = findViewById(R.id.blue);
        blue.setOnClickListener(this);
        purple = findViewById(R.id.purple);
        purple.setOnClickListener(this);
        pink = findViewById(R.id.pink);
        pink.setOnClickListener(this);
        mTile.addView(rvTrans);
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setDither(true);
        mPaint.setColor(color);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeJoin(Paint.Join.ROUND);
        mPaint.setStrokeCap(Paint.Cap.ROUND);
        mPaint.setStrokeWidth(40);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.red:
                GetTTS.startVoice("red");
                color = getResources().getColor(R.color.red);
                mPaint.setColor(color);
                break;
            case R.id.blue:
                GetTTS.startVoice("blue");
                color = getResources().getColor(R.color.blue);
                mPaint.setColor(color);
                break;
            case R.id.green:
                GetTTS.startVoice("green");
                color = getResources().getColor(R.color.green);
                mPaint.setColor(color);
                break;
            case R.id.purple:
                GetTTS.startVoice("purple");
                color = getResources().getColor(R.color.purple);
                mPaint.setColor(color);
                break;
            case R.id.pink:
                GetTTS.startVoice("pink");
                color = getResources().getColor(R.color.pink);
                mPaint.setColor(color);
                break;
            case R.id.brown:
                GetTTS.startVoice("brown");
                color = getResources().getColor(R.color.brown);
                mPaint.setColor(color);
                break;
            case R.id.voice:
                GetTTS.startVoice(resources.get(count).getText());
                break;
            case R.id.eraser:
                dv.removePaint();
                break;
            case R.id.home:
                startActivity(new Intent(Tracing.this, MainActivity.class));
                break;
        }
    }

    private void playSound(int sound){
        mediaPlayer = MediaPlayer.create(Tracing.this, sound);
        mediaPlayer.start();
    }

    public class DrawingView extends View {

        private Bitmap mBitmap;
        private Canvas mCanvas;
        private Path mPath;
        private Paint   mBitmapPaint;
        Context context;
        private Paint circlePaint;
        private Path circlePath;

        public DrawingView(Context c) {
            super(c);
            context=c;
            mPath = new Path();
            mBitmapPaint = new Paint(Paint.DITHER_FLAG);
            circlePaint = new Paint();
            circlePath = new Path();
            circlePaint.setAntiAlias(true);
            circlePaint.setColor(Color.BLUE);
            circlePaint.setStyle(Paint.Style.STROKE);
            circlePaint.setStrokeJoin(Paint.Join.MITER);
            circlePaint.setStrokeWidth(4f);
        }

        public void removePaint(){
            mBitmap.eraseColor(Color.TRANSPARENT);
            mPath.reset();
        }

        @Override
        protected void onSizeChanged(int width, int height, int oldWidth, int oldHeight) {
            super.onSizeChanged(width, height, oldWidth, oldHeight);

            mBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
            mCanvas = new Canvas(mBitmap);

        }
        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            canvas.drawBitmap( mBitmap, 0, 0, mBitmapPaint);
            canvas.drawPath( mPath,  mPaint);
            canvas.drawPath( circlePath,  circlePaint);
        }

        private float mX, mY;
        private static final float TOUCH_TOLERANCE = 4;

        private void touch_start(float x, float y) {
            mPath.reset();
            mPath.moveTo(x, y);
            mX = x;
            mY = y;
            Log.d("start xy==>", x+","+y);
        }
        private void touch_move(float x, float y) {
            Log.d("move xy==>", x+","+y);
            float dx = Math.abs(x - mX);
            float dy = Math.abs(y - mY);
            if ((dx >= TOUCH_TOLERANCE || dy >= TOUCH_TOLERANCE)) {
                mPath.quadTo(mX, mY, (x + mX)/2, (y + mY)/2);
                mX = x;
                mY = y;
            }
        }
        private void touch_up() {
            mPath.lineTo(mX, mY);
            circlePath.reset();
            mCanvas.drawPath(mPath,  mPaint);
            mPath.reset();
        }

        @SuppressLint("ClickableViewAccessibility")
        @Override
        public boolean onTouchEvent(MotionEvent event) {
            float x = event.getX();
            float y = event.getY();
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    touch_start(x, y);
                    invalidate();
                    break;
                case MotionEvent.ACTION_MOVE:
                    touch_move(x, y);
                    invalidate();
                    break;
                case MotionEvent.ACTION_UP:
                    touch_up();
                    invalidate();
                    break;
            }
            return true;
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (mediaPlayer != null) {
            mediaPlayer.release();
        }
    }
}