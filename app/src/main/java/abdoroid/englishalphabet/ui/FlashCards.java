package abdoroid.englishalphabet.ui;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.huawei.hms.ads.AdListener;
import com.huawei.hms.ads.AdParam;
import com.huawei.hms.ads.HwAds;
import com.huawei.hms.ads.InterstitialAd;
import com.huawei.hms.ads.banner.BannerView;

import java.util.ArrayList;

import abdoroid.englishalphabet.R;
import abdoroid.englishalphabet.adapter.CategoriesRecyclerViewAdapter;
import abdoroid.englishalphabet.data.DataArrays;
import abdoroid.englishalphabet.model.CategoryModel;
import abdoroid.englishalphabet.model.DataModel;
import abdoroid.englishalphabet.utils.GetTTS;


public class FlashCards extends AppCompatActivity {

    private ArrayList<DataModel> list = new ArrayList<>();
    public RecyclerView mRecyclerView;
    private String sourceText;
    InterstitialAd interstitialAd;

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_flash_cards);
        HwAds.init(this);
        BannerView bottomBannerView = findViewById(R.id.hw_banner_view);
        AdParam adParam = new AdParam.Builder().build();
        bottomBannerView.loadAd(adParam);

        interstitialAd = new InterstitialAd(this);
        interstitialAd.setAdId(getString(R.string.interstitial_ad_id));
        interstitialAd.loadAd(adParam);
        ArrayList<CategoryModel> mAlphabetList = DataArrays.makeAlphabetList();
        ArrayList<CategoryModel> mAnimalsList = DataArrays.makeAnimalsList();
        ArrayList<CategoryModel> mNumbersList = DataArrays.makeNumbersList();
        ArrayList<CategoryModel> mFoodList = DataArrays.makeFoodList();
        ArrayList<CategoryModel> mSportsList = DataArrays.makeSportsList();
        ArrayList<CategoryModel> mTransportsList = DataArrays.makeTransportsList();
        ArrayList<CategoryModel> mObjectsList = DataArrays.makeObjectsList();
        list.add(new DataModel(R.drawable.alphabet,getString(R.string.cat_alphabet),
                getString(R.color.alphabet_cat_color), mAlphabetList));
        list.add(new DataModel(R.drawable.numbers, getString(R.string.cat_numbers),
                getString(R.color.number_cat_color), mNumbersList));
        list.add(new DataModel(R.drawable.animals, getString(R.string.cat_animals),
                getString(R.color.animals_cat_color), mAnimalsList));
        list.add(new DataModel(R.drawable.food, getString(R.string.cat_food),
                getString(R.color.food_cat_color), mFoodList));
        list.add(new DataModel(R.drawable.sports, getString(R.string.cat_sports),
                getString(R.color.sports_cat_color), mSportsList));
        list.add(new DataModel(R.drawable.transports, getString(R.string.cat_transports),
                getString(R.color.transports_cat_color), mTransportsList));
        list.add(new DataModel(R.drawable.objects,getString(R.string.cat_objects),
                getString(R.color.objects_cat_color), mObjectsList));

        GetTTS.initVoice(getApplicationContext());
        mRecyclerView = findViewById(R.id.recycler_view);
        StaggeredGridLayoutManager staggeredGridLayoutManager =
                new StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(staggeredGridLayoutManager);
        mRecyclerView.setClipToPadding(false);
        mRecyclerView.setHasFixedSize(true);
        CategoriesRecyclerViewAdapter adapter = new CategoriesRecyclerViewAdapter(this, list);
        mRecyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        adapter.setOnItemClickListener(new CategoriesRecyclerViewAdapter.onRecyclerViewItemClickListener() {
            @Override
            public void onItemClickListener(View view, int position) {
                sourceText = list.get(position).getTitle();
                GetTTS.startVoice(sourceText);
                if (interstitialAd != null && interstitialAd.isLoaded()) {
                    interstitialAd.show();
                }
                Intent intent = new Intent(getApplicationContext(), CategoryActivity.class);
                intent.putExtra("Category", list.get(position).getCategory());
                intent.putExtra("catColor", list.get(position).getColor());
                startActivity(intent);
            }
        });

    }

}