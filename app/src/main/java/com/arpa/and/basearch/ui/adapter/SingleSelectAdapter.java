package com.arpa.and.basearch.ui.adapter;


import com.arpa.and.basearch.BR;
import com.arpa.and.basearch.base.WrapBindingRVAdapter;
import com.arpa.and.basearch.bean.SelectItem;

import androidx.annotation.NonNull;
import androidx.databinding.ViewDataBinding;

/**
 * author: 李一方(<a href="mailto:leergo@dingtalk.com">leergo@dingtalk.com</a>)<br/>
 * version: 1.0.0<br/>
 * since: 2021-05-14 16:07
 *
 * <p>
 * adapter：单选适配器
 * </p>
 */
public class SingleSelectAdapter <T extends SelectItem> extends WrapBindingRVAdapter<T> {
    private int positionSel = -1;

    @Override
    public void onBindBinding(@NonNull ViewDataBinding binding, int variableId, int layoutRes, int position, T item) {
        super.onBindBinding(binding, variableId, layoutRes, position, item);
        binding.setVariable(BR.positionSel, positionSel);
    }

    public int getPositionSel() {
        return positionSel;
    }

    public void setPositionSel(int positionSel) {
        this.positionSel = positionSel;
        notifyDataSetChanged();
    }
}
