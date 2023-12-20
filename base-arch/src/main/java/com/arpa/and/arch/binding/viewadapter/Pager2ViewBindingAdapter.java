package com.arpa.and.arch.binding.viewadapter;

import androidx.databinding.BindingAdapter;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.arpa.and.arch.binding.adapter.SimpleFragmentStateAdapter;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.List;

/**
 * author: 李一方(<a href="mailto:leergo@dingtalk.com">leergo@dingtalk.com</a>)<br/>
 * version: 1.0.0<br/>
 * since: 2021-04-26 9:25 AM
 *
 * <p>
 * 内容描述区域
 * </p>
 */
public class Pager2ViewBindingAdapter {

    @BindingAdapter("pageLimit")
    public static void setPageLimit(ViewPager2 viewPager, Integer pageLimit) {
        if (null != pageLimit) {viewPager.setOffscreenPageLimit(pageLimit);}
    }

    @BindingAdapter(value = {"fragments", "tab", "titles"}, requireAll = false)
    public static void setFragments(ViewPager2 viewPager, final List<? extends Fragment> fragments, TabLayout tab, List<String> titles) {
        if (null != fragments) {
            viewPager.setAdapter(new SimpleFragmentStateAdapter((FragmentActivity) viewPager.getContext(), fragments));
        }
        if (null != tab && null != titles && !titles.isEmpty()) {
            new TabLayoutMediator(tab, viewPager, (v, position) -> v.setText(titles.get(position))).attach();
        }
    }
}
