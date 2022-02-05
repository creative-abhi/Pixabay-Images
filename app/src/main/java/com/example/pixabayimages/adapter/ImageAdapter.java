package com.example.pixabayimages.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pixabayimages.R;
import com.example.pixabayimages.activity.MainActivity;
import com.example.pixabayimages.modalresponse.PixaImagesResponse;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ViewHolder> {
    private Context context;
    private List<PixaImagesResponse.Hit> data;

    public ImageAdapter(MainActivity mainActivity, List<PixaImagesResponse.Hit> data){
        context = mainActivity;
        this.data = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflater = LayoutInflater.from(context).inflate(R.layout.images_item,parent,false);
        return new ViewHolder(inflater);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        PixaImagesResponse.Hit obj = data.get(position);
        Picasso.get().load(obj.getLargeImageURL()).into(holder.img);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        public ViewHolder(@NonNull View itemView)
        {
            super(itemView);
            img = itemView.findViewById(R.id.imageView);
        }

    }
}
