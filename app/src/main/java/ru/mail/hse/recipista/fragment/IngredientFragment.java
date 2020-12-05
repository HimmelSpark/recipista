package ru.mail.hse.recipista.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import lombok.RequiredArgsConstructor;
import ru.mail.hse.recipista.R;
import ru.mail.hse.recipista.adapter.IngredientAdapter;

@RequiredArgsConstructor
public class IngredientFragment extends Fragment {

    private RecyclerView recycler;
    private final IngredientAdapter ingredientAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.ingredient_list_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recycler = view.findViewById(R.id.ingredient_recycler);
        recycler.setAdapter(ingredientAdapter);
        recycler.setLayoutManager(new LinearLayoutManager(requireContext()));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        recycler = null;
    }
}
