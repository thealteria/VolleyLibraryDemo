package com.thealteria.volleylibrarydemo;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

public class GithubAdapter extends RecyclerView.Adapter<GithubAdapter.GitHubViewHolder> {

    private Context context;
    private User[] data;
    public GithubAdapter(Context context, User[] data) {

        this.context = context;
        this.data = data;

    }

    @NonNull
    @Override
    public GitHubViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.item_user_layout, parent, false);
        return new GitHubViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull GitHubViewHolder holder, int position) {
        final User user = data[position];
        holder.txtuser.setText(user.getLogin());
        Glide.with(holder.imguser.getContext()).load(user.getAvatarUrl()).into(holder.imguser);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, user.getLogin() + " was clicked", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    public class GitHubViewHolder extends RecyclerView.ViewHolder {

        ImageView imguser;
        TextView txtuser;

        public GitHubViewHolder(View itemView) {
            super(itemView);

            imguser = itemView.findViewById(R.id.imguser);
            txtuser = itemView.findViewById(R.id.textuser);
        }
    }
}

