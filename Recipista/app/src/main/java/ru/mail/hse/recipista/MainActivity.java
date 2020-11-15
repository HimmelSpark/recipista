package ru.mail.hse.recipista;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import ru.mail.hse.recipista.client.MealClient;
import ru.mail.hse.recipista.fragment.IngredientFragment;
import ru.mail.hse.recipista.tag.Tags;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.main_layout, new IngredientFragment(), Tags.TAG_LIST)
                .commit();

        MealClient mealClient = new MealClient();
        mealClient.getAllIngredients();
    }
}
