package com.seeksolution.myapplication.adapter;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.StringRes;
import androidx.recyclerview.widget.RecyclerView;

import com.facebook.shimmer.ShimmerFrameLayout;
import com.seeksolution.myapplication.R;
import com.seeksolution.myapplication.model.TrendingModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class TrendingAdapter extends RecyclerView.Adapter<TrendingAdapter.MyView> {
    public Context context;
    public ArrayList<TrendingModel> arrayList;

    //ArrayList<TrendingModel> arrayList
    public TrendingAdapter(Context context,ArrayList<TrendingModel> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public MyView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.trendingcustomlayout,parent,false);
        return new MyView(view);
    }
    @Override
    public void onBindViewHolder(@NonNull MyView holder, int position) {
        final int i=position;
        holder.imageView.setVisibility( View.GONE);
        holder.shimmerImage.setVisibility( View.VISIBLE );
        holder.shimmerFrameLayout.startShimmer();
        Picasso.get()
                .load(Uri.parse(arrayList.get(i).getImageUrls()))
                .into(holder.imageView);

     new Handler().postDelayed( new Runnable() {
         @Override
         public void run() {

             holder.shimmerFrameLayout.stopShimmer();
             holder.imageView.setVisibility( View.VISIBLE );
             holder.shimmerImage.setVisibility( View.GONE );
         }
     },2000 );

    }
    @Override
    public int getItemCount() {
        return arrayList.size();
    }
    public class MyView extends RecyclerView.ViewHolder implements View.OnClickListener {
        public ImageView imageView;
        public ShimmerFrameLayout shimmerFrameLayout;
        public  ImageView shimmerImage;
        public MyView(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.trending_list);
            shimmerFrameLayout=itemView.findViewById( R.id.trending_list_shimmer_container );
            shimmerImage=itemView.findViewById( R.id.trending_list_shimmer );
            imageView.setOnClickListener( this );


        }

        @Override
        public void onClick(View v) {
            Toast.makeText( context, "Item click Listner", Toast.LENGTH_SHORT ).show();
        }
    }
}
