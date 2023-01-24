package com.seeksolution.myapplication.adapter;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.facebook.shimmer.ShimmerFrameLayout;
import com.seeksolution.myapplication.R;
import com.seeksolution.myapplication.model.OriginalModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class OriginalAdapter extends RecyclerView.Adapter<OriginalAdapter.MyView> {
    public Context context;
    public ArrayList<OriginalModel> arrayList;

    public OriginalAdapter(Context context, ArrayList<OriginalModel> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }
    @NonNull
    @Override
    public MyView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from( context ).inflate( R.layout.originalscustomlayout,parent,false );
        return new MyView( view );
    }

    @Override
    public void onBindViewHolder(@NonNull MyView holder, int position) {
        final  int i=position;
        holder.imageView.setVisibility( View.GONE );
        holder.shimmerImage.setVisibility( View.VISIBLE );
        holder.shimmerFrameLayout.startShimmer();

        new Handler().postDelayed( new Runnable() {
            @Override
            public void run() {
                holder.shimmerFrameLayout.stopShimmer();
                Picasso.get()
                        .load( Uri.parse( arrayList.get( i ).getOriginalImageUrls() ) )
                        .into(holder.imageView  );
                holder.imageView.setVisibility( View.VISIBLE );
                holder.shimmerImage.setVisibility( View.GONE );


            }
        },2000 );
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class MyView extends RecyclerView.ViewHolder {
        ImageView imageView;
        ShimmerFrameLayout shimmerFrameLayout;
        ImageView shimmerImage;
        public MyView(@NonNull View itemView) {
            super( itemView );
            imageView=itemView.findViewById( R.id.original_list );
            shimmerFrameLayout=itemView.findViewById( R.id.original_list_shimmer_container );
            shimmerImage=itemView.findViewById( R.id.original_list_shimmer );

        }
    }
}
