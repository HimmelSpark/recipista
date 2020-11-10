package ru.mail.hse.recipista;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class IngredientFragment extends Fragment {
    RecyclerView recycler = null;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.list_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recycler = view.findViewById(R.id.recycler);
        recycler.setAdapter(new IngredientAdapter(IngredinentRepository.getInstance().list()));
        recycler.setLayoutManager(new LinearLayoutManager(requireContext()));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        recycler = null;
    }
}