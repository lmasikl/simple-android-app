package ru.opinion.opinion.ui.adapter;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import ru.opinion.opinion.R;
import ru.opinion.opinion.api.model.GitHubRepo;

public class GitHubRepoAdapter extends RecyclerView.Adapter<GitHubRepoAdapter.GitHubVH> {

    private Context context;
    private List<GitHubRepo> gitHubRepoList = new ArrayList<>();

    public GitHubRepoAdapter(Context context) {
        this.context = context;
    }

    public void setRepos(List<GitHubRepo> gitHubRepoList) {
        this.gitHubRepoList = gitHubRepoList;
        notifyDataSetChanged(); //refresh recycler view
    }

    @Override
    public GitHubVH onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.github_repos_list_item, parent, false); // inflating list item

        return new GitHubVH(view);
    }

    @Override
    public void onBindViewHolder(GitHubVH holder, int position) {
        GitHubRepo repo = gitHubRepoList.get(position);

        holder.tvName.setText(repo.getName());
    }

    @Override
    public int getItemCount() {
        if (gitHubRepoList == null) {
            return 0;
        }
        return gitHubRepoList.size();
    }

    public class GitHubVH extends RecyclerView.ViewHolder {

        TextView tvName;
        TextView tvID;

        public GitHubVH(View itemView) {
            super(itemView);

            tvName = (TextView) itemView.findViewById(R.id.tv_repo_name);
            tvID = (TextView) itemView.findViewById(R.id.tv_repo_id);
        }
    }
}
