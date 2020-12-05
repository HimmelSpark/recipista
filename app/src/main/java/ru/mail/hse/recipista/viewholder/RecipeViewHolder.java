package ru.mail.hse.recipista.viewholder;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import ru.mail.hse.recipista.R;

public class RecipeViewHolder extends RecyclerView.ViewHolder {

    private FrameLayout layout = itemView.findViewById(R.id.recipe_element_layout);

    public RecipeViewHolder(@NonNull View itemView) {
        super(itemView);
    }

    public void bind(int height) {
        ViewGroup.LayoutParams params = layout.getLayoutParams();
        params.height = height;
        layout.setLayoutParams(params);
    }
}
