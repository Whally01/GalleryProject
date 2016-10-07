package com.dinar.myapplication1;

/**
 * Created by Dr on 06.10.2016.
 */

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class GalleryAdapter extends RecyclerView.Adapter<GalleryAdapter.ViewHolder> {
    private ArrayList<Item> mItem;
    private Context mContext;
    private GalleryPhotoClick mGalleryPhotoClick;

    public GalleryAdapter(Context context, ArrayList<Item> item) {
        mItem = item;
        mContext = context;
    }

    public void setGalleryPhotoClick(GalleryPhotoClick galleryPhotoClick) {
        mGalleryPhotoClick = galleryPhotoClick;
    }

    public void setList(ArrayList<Item> item) {
        mItem = item;
        notifyDataSetChanged();
    }


    @Override
    public GalleryAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_layout, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(GalleryAdapter.ViewHolder viewHolder, int position) {

        final int res_photo = getItemCount();

        if (viewHolder instanceof ViewHolder) {
            viewHolder.tv.setText(mItem.get(position).getDescription());
            Picasso.with(mContext).load(mItem.get(position).getImage_url()).resize(500, 500).into(viewHolder.iv);
        }

    }

    @Override
    public int getItemCount() {
        return mItem.size();
    }


    ///////
    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tv;
        private ImageView iv;

        public ViewHolder(View view) {
            super(view);

            tv = (TextView) view.findViewById(R.id.tv);
            iv = (ImageView) view.findViewById(R.id.img);
        }
    }

}