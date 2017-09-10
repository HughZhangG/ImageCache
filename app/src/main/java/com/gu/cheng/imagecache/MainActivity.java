package com.gu.cheng.imagecache;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.gu.cheng.imagecache.adapter.ImageAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 利用 glide4.0 实现图片缓存
 */
public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    List<String> urlList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = (RecyclerView) findViewById(R.id.id_recycler);

        if (urlList == null)
            urlList = new ArrayList<>();

        String[] stringArray = getResources().getStringArray(R.array.image_url);

        List<String> strings = Arrays.asList(stringArray);

        if (strings != null)
            urlList.addAll(strings);


        ImageAdapter imageAdapter = new ImageAdapter(this,urlList);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(imageAdapter);

    }
}
