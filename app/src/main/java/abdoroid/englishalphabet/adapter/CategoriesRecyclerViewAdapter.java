package abdoroid.englishalphabet.adapter;

import android.content.Context;
import android.graphics.Color;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import abdoroid.englishalphabet.R;
import abdoroid.englishalphabet.model.DataModel;


public class CategoriesRecyclerViewAdapter extends RecyclerView.Adapter<CategoriesRecyclerViewAdapter.RecyclerViewViewHolder> {

    private List<DataModel> mList;
    private static onRecyclerViewItemClickListener mItemClickListener;
    private Context mContext;

    public CategoriesRecyclerViewAdapter(Context context, ArrayList<DataModel> list){
        this.mList = list;
        this.mContext = context;
    }
    @NonNull
    @Override
    public RecyclerViewViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, parent, false);
        return new RecyclerViewViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewViewHolder holder, int position) {
        DisplayMetrics displayMetrics = mContext.getResources().getDisplayMetrics();
        int pxHeight = displayMetrics.heightPixels;
        float height = pxHeight / displayMetrics.density;
        float txtsize = height*0.042f;
        holder.title.setTextSize(txtsize);
        final DataModel data = mList.get(position);
        holder.title.setText(data.getTitle());
        holder.image.setImageResource(data.getImageReference());
        holder.cardView.setCardBackgroundColor(Color.parseColor(data.getColor()));
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public void setOnItemClickListener(onRecyclerViewItemClickListener mItemClickListener) {
        this.mItemClickListener = mItemClickListener;
    }

    public interface onRecyclerViewItemClickListener {
        void onItemClickListener(View view, int position);
    }

    static class RecyclerViewViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView title;
        ImageView image;
        CardView cardView;
        RecyclerViewViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.cat_name);
            image = itemView.findViewById(R.id.cat_image);
            cardView = itemView.findViewById(R.id.card);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mItemClickListener != null) {
                mItemClickListener.onItemClickListener(view, getAdapterPosition());
            }
        }
    }
}
