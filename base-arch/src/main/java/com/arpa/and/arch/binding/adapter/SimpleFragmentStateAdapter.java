package com.arpa.and.arch.binding.adapter;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

/**
 * author: 李一方(<a href="mailto:leergo@dingtalk.com">leergo@dingtalk.com</a>)<br/>
 * version: 1.0.0<br/>
 * since: 2021-08-16 15:34
 */
public class SimpleFragmentStateAdapter extends FragmentStateAdapter {
    private final List<? extends Fragment> fragments;

    public SimpleFragmentStateAdapter(@NonNull Fragment fragment, List<? extends Fragment> fragments) {
        super(fragment);
        this.fragments = fragments;
    }

    public SimpleFragmentStateAdapter(@NonNull FragmentActivity fragmentActivity, List<? extends Fragment> fragments) {
        super(fragmentActivity);
        this.fragments = fragments;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return fragments.get(position);
    }

    @Override
    public int getItemCount() {
        return fragments.size();
    }
}
