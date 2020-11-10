package ru.mail.hse.recipista;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class IngredinentRepository {
    // Константы
    public static final int DATA_SIZE = 100;

    // Для генерации случайных чисел
    public static final Random RANOMIZER = new Random();

    // Объекты для реализации хардкорного синглтона в java
    private static volatile IngredinentRepository mInstance;

    public static IngredinentRepository getInstance() {
        if (mInstance == null) {
            synchronized (IngredinentRepository.class) {
                if (mInstance == null) {
                    mInstance = new IngredinentRepository();
                }
            }
        }
        return mInstance;
    }

    protected final List<String> ingredinents;

    private IngredinentRepository() {
        ingredinents = initializeData();
    }

    public List<String> list() {
        return ingredinents;
    }

    public String item(int index) {
        return ingredinents.get(index);
    }

    // Функция инициализации списка
    protected List<String> initializeData() {

        final List<String> sample = new ArrayList<>();
        sample.add("onion");
        sample.add("dill");
        sample.add("rice");
        sample.add("tomato");
        sample.add("cucumber");
        sample.add("chicken");
        sample.add("pork");
        sample.add("turkey");

        final List<String> data = new ArrayList<>();

        // Наполняем лист в цикле
        for (int position = 0; position < DATA_SIZE; position++) {
            data.add(sample.get(RANOMIZER.nextInt(sample.size())));
        }

        return data;
    }
}