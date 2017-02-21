package ru.opinion.opinion;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.List;

import ru.opinion.opinion.api.model.GitHubRepo;
import ru.opinion.opinion.ui.adapter.GitHubRepoAdapter;

public class DisplayGitHubReposActivity extends AppCompatActivity implements DisplayGithubMvpView {

    private GitHubRepoAdapter adapter;
    private DisplayGitHubReposPresenter presenter;

    private RecyclerView gitHubReposRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_github_repos);

        gitHubReposRecyclerView = (RecyclerView) findViewById(R.id.rv_github_repos);

        presenter = new DisplayGitHubReposPresenter(this);
        adapter = new GitHubRepoAdapter(this);
        LinearLayoutManager llm = new LinearLayoutManager(this);

        gitHubReposRecyclerView.setLayoutManager(llm);
        gitHubReposRecyclerView.setAdapter(adapter);

        presenter.getRepos();
    }

    @Override
    public void showRepos(List<GitHubRepo> repos) {
        adapter.setRepos(repos);
    }

    @Override
    public void showError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
