package com.example.biithrmsystem.api;

public class WebService {
    public static WebApi webApi;

    public static WebApi getWebApi() {
        if (webApi == null) {
            webApi = RetrofitClient.getInstance().create(WebApi.class);
        }
        return webApi;
    }
}
