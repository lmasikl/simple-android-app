package ru.opinion.opinion.api;

import android.support.annotation.NonNull;

import ru.opinion.opinion.api.service.GitHubClient;

/**
 * Project CCS
 * Created by Aleksandr Sobol on 21/02/17.
 * email: asobol@ccsteam.ru
 */

public interface ApiProvider {

    @NonNull
    GitHubClient provideGithubCLient();

}
