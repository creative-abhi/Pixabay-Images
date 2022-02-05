package com.example.pixabayimages.viewcontractor;

import com.example.pixabayimages.modalresponse.PixaImagesResponse;

import java.util.List;

public interface MainContract {

    public interface View{
        void onSuccess(List<PixaImagesResponse.Hit> data);
        void onError(String response);
    }

    public interface Presenter{
        void getImageData();
    }
}
