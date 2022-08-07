package com.example.soccer.favorites;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.soccer.databinding.ActivityFavoritesFragmentBinding;

public class FavoritesFragment extends Fragment {

    private FavoritesViewModel favoritesViewModel;
    private ActivityFavoritesFragmentBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        favoritesViewModel = new ViewModelProvider( this ).get( FavoritesViewModel.class );

        binding = ActivityFavoritesFragmentBinding.inflate( inflater, container, false );
        View root = binding.getRoot();

        favoritesViewModel.getText().observe( getViewLifecycleOwner(), binding.textFavorites::setText );
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}