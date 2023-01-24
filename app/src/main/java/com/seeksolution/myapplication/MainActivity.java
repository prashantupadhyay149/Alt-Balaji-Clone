package com.seeksolution.myapplication;

import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.seeksolution.myapplication.adapter.OriginalAdapter;
import com.seeksolution.myapplication.adapter.TrendingAdapter;
import com.seeksolution.myapplication.model.OriginalModel;
import com.seeksolution.myapplication.model.TrendingModel;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    private RecyclerView trendingRecyclerView;
    private  RecyclerView originalRecyclerView;
    private String[] TrendingImageUrls = {
            "https://m.media-amazon.com/images/I/91RvEuCUQ-L._SY879_.jpg",
            "https://static-koimoi.akamaized.net/wp-content/new-galleries/2015/11/ghayal-once-again-movie-poster-3.jpg",
            "https://boldoutline.in/wp-content/uploads/2019/10/Web-Cover-99.jpg",
            "https://pbs.twimg.com/media/FecploMaYAACNcL?format=jpg&name=large",
            "https://cdn.cinematerial.com/p/297x/nvt33gje/bhoot-police-indian-movie-poster-md.jpg?v=1629529961",
            "https://1.bp.blogspot.com/-xyH0Qs6yPmI/Xvs0bhdcQPI/AAAAAAAAZ_s/9kRuWAaGKLoXcwq-Dz-cgswdrMV3eHYOQCLcBGAsYHQ/s1600/Bhuj-Movie-Poster.jpg",

    };
    private String[] OriginalImageUrls={
            "https://m.media-amazon.com/images/I/91RvEuCUQ-L._SY879_.jpg",
            "https://static-koimoi.akamaized.net/wp-content/new-galleries/2015/11/ghayal-once-again-movie-poster-3.jpg",
            "https://boldoutline.in/wp-content/uploads/2019/10/Web-Cover-99.jpg",
            "https://pbs.twimg.com/media/FecploMaYAACNcL?format=jpg&name=large",
            "https://cdn.cinematerial.com/p/297x/nvt33gje/bhoot-police-indian-movie-poster-md.jpg?v=1629529961",
            "https://1.bp.blogspot.com/-xyH0Qs6yPmI/Xvs0bhdcQPI/AAAAAAAAZ_s/9kRuWAaGKLoXcwq-Dz-cgswdrMV3eHYOQCLcBGAsYHQ/s1600/Bhuj-Movie-Poster.jpg",

    };

    ArrayList<TrendingModel> TrendingModelArrayList;
    ArrayList<OriginalModel>  OriginalModelArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        trendingRecyclerView = (RecyclerView) findViewById(R.id.rc_view_trending_list);
        originalRecyclerView=(RecyclerView) findViewById( R.id.rc_view_originals_list );

        //Layout manager => Horizontal

        TrendingModelArrayList = new ArrayList<TrendingModel>();
        OriginalModelArrayList=new ArrayList<OriginalModel>();

        for(int i=0;i<TrendingImageUrls.length;i++){
            TrendingModelArrayList.add(new TrendingModel(TrendingImageUrls[i]));
        }
        for(int j=0;j<OriginalImageUrls.length;j++){
            OriginalModelArrayList.add(new OriginalModel( OriginalImageUrls[j]));
        }
        TrendingAdapter trendingAdapter = new TrendingAdapter(getApplicationContext(),TrendingModelArrayList);
        trendingRecyclerView.setLayoutManager( new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.HORIZONTAL,false) );
        trendingRecyclerView.setAdapter(trendingAdapter);
        OriginalAdapter originalAdapter=new OriginalAdapter( getApplicationContext(),OriginalModelArrayList );
        originalRecyclerView.setLayoutManager( new LinearLayoutManager( getApplicationContext(),LinearLayoutManager.HORIZONTAL,false));
        originalRecyclerView.setAdapter(originalAdapter);
//        String[] Output = new String[]{
//                OriginalModelArrayList.get(0).getOriginalImageUrls(),
//                OriginalModelArrayList.get(1).getOriginalImageUrls(),
//                OriginalModelArrayList.get(2).getOriginalImageUrls(),
//        };
//        Log.d("mytag",Arrays.toString(Output));


    }
}