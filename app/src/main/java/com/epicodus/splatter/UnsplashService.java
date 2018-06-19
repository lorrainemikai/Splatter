package com.epicodus.splatter;



import com.epicodus.splatter.models.Image;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Response;

public class UnsplashService {

    public static void search(String query, Callback callback) {
        OkHttpClient client = new OkHttpClient.Builder().build();
        HttpUrl.Builder urlBuilder = HttpUrl.parse(Constants.UNSPLASH_BASE_URL).newBuilder();
        String url = urlBuilder
                .addQueryParameter(Constants.UNSPLASH_NAME_QUERY_PARAMETER, query)
                .build().toString();

        Request request = new Request.Builder().header("Authorization", "Client-ID " + Constants.UNSPLASH_ACCESS_KEY)
                .url(url)

                .build();
        Call call = client.newCall(request);
        call.enqueue(callback);
    }

    public List<Image> processResults(Response response) {
        List<Image> images = new ArrayList<>();
        try {
            String jsonData = response.body().string();
            if (response.isSuccessful()) {
                // The response JSON is an array of business objects within an object so we need to get that array
                JSONObject unsplashJSON = new JSONObject(jsonData);
                JSONArray carsJSON = unsplashJSON.getJSONArray("results");
                Type collectionType = new TypeToken<List<Image>>() {
                }.getType();
                Gson gson = new GsonBuilder().create();
                images = gson.fromJson(carsJSON.toString(), collectionType);
            }
        } catch (JSONException | NullPointerException | IOException e) {
            e.printStackTrace();
        }

        return images;
    }

}