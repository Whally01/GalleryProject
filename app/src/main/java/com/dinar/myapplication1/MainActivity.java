package com.dinar.myapplication1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.net.URISyntaxException;
import java.util.ArrayList;

/**
 * Created by Dr on 06.10.2016.
 */

public class MainActivity extends AppCompatActivity {

    private final String names[] = {
            "Space",
            "Space",
            "Mountains",
            "Worked place",
            "Space",
            "Space",
            "Street",
            "Sunrest",
            "Tree",
            "Mountains & Lake"
    };

    private final String image_urls[] = {
            "https://snap-photos.s3.amazonaws.com/img-thumbs/960w/KIOM2B4L2R.jpg",
            "https://snap-photos.s3.amazonaws.com/img-thumbs/960w/0ABNAY5RPY.jpg",
            "https://snap-photos.s3.amazonaws.com/img-thumbs/960w/AN6MZHU7UW.jpg",
            "https://snap-photos.s3.amazonaws.com/img-thumbs/960w/7ZPSYLVQNC.jpg",
            "https://snap-photos.s3.amazonaws.com/img-thumbs/960w/0ABNAY5RPY.jpg",
            "https://snap-photos.s3.amazonaws.com/img-thumbs/960w/EQ937DCMCY.jpg",
            "https://snap-photos.s3.amazonaws.com/img-thumbs/960w/7ZUAIZYWL1.jpg",
            "https://snap-photos.s3.amazonaws.com/img-thumbs/960w/27VI8OV9OP.jpg",
            "https://snap-photos.s3.amazonaws.com/img-thumbs/960w/V29EGUHL7H.jpg",
            "https://snap-photos.s3.amazonaws.com/img-thumbs/960w/30284BP2W9.jpg"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.card_recycler_view);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getApplicationContext(), 2);
        recyclerView.setLayoutManager(layoutManager);

        ArrayList<Item> items = prepareData();
        GalleryAdapter adapter = new GalleryAdapter(getApplicationContext(), items);

        adapter.setGalleryPhotoClick(new GalleryPhotoClick() {
            @Override
            public void onClick(Item item) throws URISyntaxException {
                Intent intent = new Intent(MainActivity.this, GalleryPhoto.class);
                intent.putExtra("img_id", item.getImage_url());
                startActivity(intent);
            }
        });

        recyclerView.setAdapter(adapter);

    }
        private ArrayList<Item> prepareData () {
            ArrayList<Item> items = new ArrayList<>();
            for (int i = 0; i < names.length; i++) {
                Item item = new Item();
                item.setDescription(names[i]);
                item.setImage_url(image_urls[i]);
                items.add(item);
            }
            return items;
        }
    }








