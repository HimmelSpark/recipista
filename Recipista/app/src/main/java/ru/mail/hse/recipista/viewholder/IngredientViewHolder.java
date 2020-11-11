package ru.mail.hse.recipista.viewholder;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import ru.mail.hse.recipista.R;

public class IngredientViewHolder extends RecyclerView.ViewHolder {

    private TextView ingredientTV = itemView.findViewById(R.id.ingredient_tv);

    public IngredientViewHolder(@NonNull View itemView) {
        super(itemView);
    }

    public void bind(String ingredient) {
        ingredientTV.setText(ingredient);
    }
}
