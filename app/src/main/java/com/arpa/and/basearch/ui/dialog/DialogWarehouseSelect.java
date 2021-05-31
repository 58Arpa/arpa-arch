package com.arpa.and.basearch.ui.dialog;

import android.os.Bundle;

import com.arpa.and.base.arch.base.BaseDialogFragment;
import com.arpa.and.basearch.R;
import com.arpa.and.basearch.bean.res.ResWarehouse;
import com.arpa.and.basearch.databinding.DialogWarehouseSelectBinding;
import com.arpa.and.basearch.ui.callback.ViewListener;
import com.arpa.and.basearch.ui.vm.VMWarehouseSelect;
import com.arpa.and.basearch.utils.ToastUtils;

import java.util.List;

import androidx.annotation.Nullable;
import dagger.hilt.android.AndroidEntryPoint;

/**
 * author: 李一方(<a href="mailto:leergo@dingtalk.com">leergo@dingtalk.com</a>)<br/>
 * version: 1.0.0<br/>
 * since: 2021-04-25 3:58 PM
 *
 * <p>
 * Dialog: 选择仓库
 * </p>
 */
@AndroidEntryPoint
public class DialogWarehouseSelect extends BaseDialogFragment<VMWarehouseSelect, DialogWarehouseSelectBinding> {
    private final List<ResWarehouse> warehouses;
    private final ViewListener.DataTransCallback<ResWarehouse> listener;

    public DialogWarehouseSelect(List<ResWarehouse> warehouses, ViewListener.DataTransCallback<ResWarehouse> listener) {
        this.warehouses = warehouses;
        this.listener = listener;
    }

    @Override
    public int getLayoutId() {
        return R.layout.dialog_warehouse_select;
    }

    @Override
    public void initData(@Nullable Bundle savedInstanceState) {
        viewBind.setViewModel(viewModel);
        viewModel.warehouses.addAll(warehouses);

        viewBind.ivClose.setOnClickListener(v -> dismiss());
        viewBind.btnSure.setOnClickListener(v -> {
            if (null == viewModel.result) {
                ToastUtils.showShort("请选择一个仓库");
            } else {
                listener.transfer(viewModel.result);
                dismiss();
            }
        });
    }
}