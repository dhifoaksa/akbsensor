package com.example.tugassensor_10119289.views.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.tugassensor_10119289.adapter.AboutPageAdapter;
import com.example.tugassensor_10119289.databinding.FragmentNotificationsBinding;

public class NotificationsFragment extends Fragment {
    /*
     * NIM : 10119289
     * NAMA : Dhifo Aksa Hermawan
     * Kelas : IF-7
     * */
    private FragmentNotificationsBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentNotificationsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        ViewPager viewPager = (ViewPager) binding.viewpager;
        viewPager.setAdapter(new AboutPageAdapter(getContext()));
//        final TextView textView = binding.textNotifications;
//        textView.setText("NOTIF PAGE");
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}