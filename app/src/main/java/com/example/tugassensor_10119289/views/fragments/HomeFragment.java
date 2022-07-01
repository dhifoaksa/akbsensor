package com.example.tugassensor_10119289.views.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.tugassensor_10119289.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {
    /*
     * NIM : 10119289
     * NAMA : Dhifo Aksa Hermawan
     * Kelas : IF-7
     * */
    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

//        final TextView textView = binding.textHome;
//        textView.setText("Home");
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}