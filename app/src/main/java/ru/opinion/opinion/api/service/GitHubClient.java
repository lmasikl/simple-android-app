package ru.opinion.opinion.api.service;
import retrofit2.Call;
import retrofit2.http.Path;
import retrofit2.http.GET;
import java.util.List;

import ru.opinion.opinion.api.model.GitHubRepo;

public interface GitHubClient {
    @GET("/users/{user}/repos")
    Call<List<GitHubRepo>> reposForUser(@Path("user") String user);
}
