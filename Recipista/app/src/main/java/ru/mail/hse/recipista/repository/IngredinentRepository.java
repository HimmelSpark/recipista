package ru.mail.hse.recipista.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class IngredinentRepository {

    public static final int DATA_SIZE = 100;

    public static final Random RANOMIZER = new Random();

    private static List<String> ingredinents = initializeData();

    public static List<String> list() {
        return ingredinents;
    }

    public static String item(int index) {
        return ingredinents.get(index);
    }

    private static List<String> initializeData() {
        final List<String> data = new ArrayList<>();
        data.add("onion");
        data.add("dill");
        data.add("rice");
        data.add("tomato");
        data.add("cucumber");
        data.add("chicken");
        data.add("pork");
        data.add("turkey");

        final List<String> ingredinents = new ArrayList<>();
        for (int position = 0; position < DATA_SIZE; position++) {
            ingredinents.add(data.get(RANOMIZER.nextInt(data.size())));
        }

        return ingredinents;
    }
}
