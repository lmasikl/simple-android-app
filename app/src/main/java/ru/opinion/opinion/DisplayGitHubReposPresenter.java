package ru.opinion.opinion;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ru.opinion.opinion.api.ApiFactory;
import ru.opinion.opinion.api.model.GitHubRepo;

/**
 * Project CCS
 * Created by Aleksandr Sobol on 21/02/17.
 * email: asobol@ccsteam.ru
 */

public class DisplayGitHubReposPresenter {

    private DisplayGithubMvpView mvpView;

    public DisplayGitHubReposPresenter(DisplayGithubMvpView mvpView) {
        this.mvpView = mvpView;
    }

    public void getRepos() {
         ApiFactory.getProvider()
                .provideGithubCLient()
                .reposForUser("lmasikl")
                .enqueue(new Callback<List<GitHubRepo>>() {
                    @Override
                    public void onResponse(Call<List<GitHubRepo>> call, Response<List<GitHubRepo>> response) {
                        if (response.isSuccessful()) {
                            mvpView.showRepos(response.body());
                        } else {
                            try {
                                mvpView.showError(response.errorBody().string());
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<List<GitHubRepo>> call, Throwable t) {
                        mvpView.showError(t.getLocalizedMessage());
                    }
                });
    }

}
