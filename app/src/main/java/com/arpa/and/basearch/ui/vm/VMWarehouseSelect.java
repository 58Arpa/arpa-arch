package com.arpa.and.basearch.ui.vm;

import android.app.Application;

import com.arpa.and.arch.base.BaseModel;
import com.arpa.and.basearch.BR;
import com.arpa.and.basearch.R;
import com.arpa.and.basearch.base.WrapDataViewModel;
import com.arpa.and.basearch.bean.res.ResWarehouse;
import com.arpa.and.basearch.ui.adapter.SingleSelectAdapter;
import com.arpa.and.basearch.ui.callback.ViewListener;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableArrayList;
import dagger.hilt.android.lifecycle.HiltViewModel;
import me.tatarka.bindingcollectionadapter2.ItemBinding;

/**
 * author: 李一方(<a href="mailto:leergo@dingtalk.com">leergo@dingtalk.com</a>)<br/>
 * version: 1.0.0<br/>
 * since: 2021-05-31 13:44
 */
@HiltViewModel
public class VMWarehouseSelect extends WrapDataViewModel {
    public final SingleSelectAdapter adapter = new SingleSelectAdapter();
    private final ItemBinding<ResWarehouse> itemBinding = ItemBinding.of(BR.data, R.layout.item_warehouse_select);

    public ObservableArrayList<ResWarehouse> warehouses = new ObservableArrayList<>();
    public ResWarehouse result;

    @Inject
    public VMWarehouseSelect(@NonNull Application application, BaseModel model) {
        super(application, model);
    }

    public ItemBinding<ResWarehouse> getItemBinding() {
        itemBinding.bindExtra(BR.onItemClick, (ViewListener.OnItemClickListener<ResWarehouse>) (view, position, data) -> {
            warehouses.get(position).setSelect(true);
            if (adapter.getPositionSel() != -1)
                warehouses.get(adapter.getPositionSel()).setSelect(false);
            result = data;
            adapter.setPositionSel(position);
        });
        return itemBinding;
    }
}
