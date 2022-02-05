package com.example.pixabayimages.presenter;

import android.content.Context;
import android.content.Intent;

import com.example.pixabayimages.api.ApiClient;
import com.example.pixabayimages.modalresponse.PixaImagesResponse;
import com.example.pixabayimages.utils.ProgressDialogManager;
import com.example.pixabayimages.viewcontractor.MainContract;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainPresenter implements MainContract.Presenter {
    private MainContract.View view;
    private Context context;
    private ProgressDialogManager progressDialogManager;

    public MainPresenter(MainContract.View view, Context context) {
        this.view = view;
        this.context = context;
        progressDialogManager = ProgressDialogManager.getInstance(context);
    }

    @Override
    public void getImageData() {
        progressDialogManager.showProgressDialog();
        Call<PixaImagesResponse> call = ApiClient.getInstance().getApi().getData("25553680-4984b730a685e13d24e6c0967", "flowers");
        call.enqueue(new Callback<PixaImagesResponse>() {
            @Override
            public void onResponse(Call<PixaImagesResponse> call, Response<PixaImagesResponse> response) {
                progressDialogManager.hideProgressDialog();
                if (response.isSuccessful()){
                    PixaImagesResponse result = response.body();
                    List<PixaImagesResponse.Hit> data = result.getHits();
                        view.onSuccess(data);
                    }else {
                    PixaImagesResponse result = response.body();
                        view.onError(result.toString());
                }
            }

            @Override
            public void onFailure(Call<PixaImagesResponse> call, Throwable t) {
                progressDialogManager.hideProgressDialog();
                view.onError(t.getMessage());
            }
        });
    }
}
