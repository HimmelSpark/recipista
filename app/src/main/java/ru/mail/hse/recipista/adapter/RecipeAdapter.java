package ru.mail.hse.recipista.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import ru.mail.hse.recipista.R;
import ru.mail.hse.recipista.viewholder.RecipeViewHolder;

public class RecipeAdapter extends RecyclerView.Adapter<RecipeViewHolder> {

    private List<Integer> recipes;
    private static Random rnd = new Random();
    public static final Integer TEST_SIZE = 20;

    public RecipeAdapter() {
        recipes = new ArrayList<>();
        for (int i = 0; i <TEST_SIZE; i++) {
            recipes.add(rnd.nextInt(300) + 400);
        }
    }

    @NonNull
    @Override
    public RecipeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View layout = inflater.inflate(R.layout.recipe_list_element, parent, false);
        return new RecipeViewHolder(layout);
    }

    @Override
    public void onBindViewHolder(@NonNull RecipeViewHolder holder, int position) {
        holder.bind(recipes.get(position));
    }

    @Override
    public int getItemCount() {
        return recipes.size();
    }
}
