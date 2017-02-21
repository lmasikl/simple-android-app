package ru.opinion.opinion;

import java.util.List;

import ru.opinion.opinion.api.model.GitHubRepo;

/**
 * Project CCS
 * Created by Aleksandr Sobol on 21/02/17.
 * email: asobol@ccsteam.ru
 */

public interface DisplayGithubMvpView {

    void showRepos(List<GitHubRepo> repos);

    void showError(String message);

}
