package com.dinar.myapplication1;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

/**
 * Created by Dr on 07.10.2016.
 */

public class GalleryPhoto extends AppCompatActivity {

    ImageView photo = (ImageView) findViewById(R.id.photo);

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.photo_layout);

        Intent intent = getIntent();
        Uri imgUri = Uri.parse(intent.getStringExtra("img_id"));
        photo.setImageURI(imgUri);


    }
}
