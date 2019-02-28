package com.example.pupil.retrofit;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

public class RecipeAdapter extends RecyclerView.Adapter<RecipeAdapter.ViewHolder> {
    private List<Result> list;

    public RecipeAdapter(List<Result> results) {
        this.list = results;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new RecipeAdapter.ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.container, viewGroup, false));
    }

    @Override
    public void onBindViewHolder
            (@NonNull ViewHolder viewHolder, int i) {
        viewHolder.bind(list.get(i));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView logo;
        private TextView title;
        private TextView url;
        private TextView ingredients;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            logo = itemView.findViewById(R.id.logo);
            title = itemView.findViewById(R.id.title);
            url = itemView.findViewById(R.id.url);
            ingredients = itemView.findViewById(R.id.ingredients);
        }

        public void bind(Result dataModel) {
            title.setText(dataModel.getTitle());
            url.setText(dataModel.getTitle());
            ingredients.setText(dataModel.getTitle());
            Glide.with(itemView.getContext()).load(dataModel.getThumbnail()).into(logo);
        }
    }
}