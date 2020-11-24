package ru.mail.hse.recipista.component;

import dagger.Component;
import ru.mail.hse.recipista.client.MealClient;
import ru.mail.hse.recipista.module.HttpClientModule;

@Component(modules = {HttpClientModule.class})
public interface HttpComponent {

    MealClient getMealClient();
}
