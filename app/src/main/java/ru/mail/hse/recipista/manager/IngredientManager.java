package ru.mail.hse.recipista.manager;

import androidx.fragment.app.FragmentManager;

import lombok.RequiredArgsConstructor;
import ru.mail.hse.recipista.R;
import ru.mail.hse.recipista.adapter.IngredientAdapter;
import ru.mail.hse.recipista.fragment.IngredientFragment;
import ru.mail.hse.recipista.provider.IngredientProvider;
import ru.mail.hse.recipista.tag.Tags;

@RequiredArgsConstructor
public class IngredientManager {

    private IngredientAdapter ingredientAdapter;

    public void setUpIngredientsPage(FragmentManager fm) {
        ingredientAdapter = new IngredientAdapter();
        IngredientProvider.loadIngredientDTOs(ingredientAdapter::setIngredients);
        IngredientFragment ingredientFragment = new IngredientFragment(ingredientAdapter);
        fm.beginTransaction()
                .add(R.id.main_layout, ingredientFragment, Tags.TAG_INGREDIENT_LIST)
                .commit();
    }
}
