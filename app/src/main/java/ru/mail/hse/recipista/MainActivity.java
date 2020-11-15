package ru.mail.hse.recipista;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

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
    }
}
