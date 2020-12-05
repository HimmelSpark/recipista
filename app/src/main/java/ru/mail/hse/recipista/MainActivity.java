package ru.mail.hse.recipista;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import ru.mail.hse.recipista.fragment.IngredientFragment;
import ru.mail.hse.recipista.tag.Tags;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.main_layout, new IngredientFragment(), Tags.TAG_INGREDIENT_LIST)
                .commit();

        /*getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.main_layout, new RecipeFragment(), Tags.TAG_RECIPE_LIST)
                .commit();*/
    }
}
