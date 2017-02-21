package ru.opinion.opinion.api;

import android.support.annotation.NonNull;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import ru.opinion.opinion.api.service.GitHubClient;

/**
 * Project CCS
 * Created by Aleksandr Sobol on 21/02/17.
 * email: asobol@ccsteam.ru
 */

public class DefaultApiProvider  implements ApiProvider {

    private final GitHubClient client;

    public DefaultApiProvider() {
        client = createGihubClient();
    }

    @NonNull
    @Override
    public GitHubClient provideGithubCLient() {
        return client;
    }

    @NonNull
    private GitHubClient createGihubClient() {
        return new Retrofit.Builder()
                .baseUrl("https://api.github.com")
                .client(OkHttp.newClient())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(GitHubClient.class);
    }
}
