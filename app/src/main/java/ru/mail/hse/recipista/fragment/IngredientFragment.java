package ru.mail.hse.recipista.fragment;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import ru.mail.hse.recipista.R;
import ru.mail.hse.recipista.adapter.IngredientAdapter;

public class IngredientFragment extends Fragment implements SearchView.OnQueryTextListener {

    private RecyclerView recycler = null;
    private IngredientAdapter ingredientAdapter = new IngredientAdapter();


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.list_fragment, container, false);
        SearchView searchView = (SearchView) view.findViewById(R.id.search_element);
        searchView.setOnQueryTextListener(this);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recycler = view.findViewById(R.id.recycler);
        recycler.setAdapter(ingredientAdapter);
        recycler.setLayoutManager(new LinearLayoutManager(requireContext()));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        recycler = null;
    }


    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        if (TextUtils.isEmpty(newText)) {
            ingredientAdapter.getFilter().filter("");
        } else {
            ingredientAdapter.getFilter().filter(newText.toString());
        }

        return true;
    }
}
