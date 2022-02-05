package com.example.pixabayimages.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.pixabayimages.R;
import com.example.pixabayimages.adapter.ImageAdapter;
import com.example.pixabayimages.modalresponse.PixaImagesResponse;
import com.example.pixabayimages.presenter.MainPresenter;
import com.example.pixabayimages.viewcontractor.MainContract;

import java.util.List;

public class MainActivity extends AppCompatActivity implements MainContract.View {
    private MainContract.Presenter presenter;
    private RecyclerView recycler;
    private ImageAdapter adapter;
    private List<PixaImagesResponse.Hit> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new MainPresenter(this,getApplicationContext());
        setContentView(R.layout.activity_main);
        recycler = findViewById(R.id.recyclerview);
        presenter.getImageData();
    }
    @Override
    public void onSuccess(List<PixaImagesResponse.Hit> data) {
        adapter = new ImageAdapter(this, data);
        //      LinearLayoutManager manager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        GridLayoutManager manager1 = new GridLayoutManager(this,2);
        recycler.setLayoutManager(manager1);
        recycler.setAdapter(adapter);
    }

    @Override
    public void onError(String response) {
        Toast.makeText(this, response, Toast.LENGTH_SHORT).show();
    }
}