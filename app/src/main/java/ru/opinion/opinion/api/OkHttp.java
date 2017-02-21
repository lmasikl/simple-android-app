package ru.opinion.opinion.api;

import android.support.annotation.NonNull;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;

/**
 * Project CCS
 * Created by Aleksandr Sobol on 21/02/17.
 * email: asobol@ccsteam.ru
 */
final class OkHttp {

    private static final int CONNECT_TIMEOUT = 15;
    private static final int READ_TIMEOUT = 30;
    private static final int WRITE_TIMEOUT = 30;

    private static OkHttpClient sClient = null;

    private OkHttp() {
    }

    @NonNull
    public static OkHttpClient client() {
        OkHttpClient client = sClient;
        if (client == null) {
            synchronized (OkHttp.class) {
                client = sClient;
                if (client == null) {
                    client = sClient = newClient();
                }
            }
        }
        return client;
    }

    @NonNull
    public static OkHttpClient newClient() {
        sClient = new OkHttpClient.Builder()
                .connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
                .writeTimeout(WRITE_TIMEOUT, TimeUnit.SECONDS)
                .build();
        return sClient;
    }

}
