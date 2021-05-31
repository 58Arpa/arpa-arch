package com.arpa.and.basearch.logic;

import android.os.Bundle;

import com.arpa.and.basearch.BR;
import com.arpa.and.basearch.R;
import com.arpa.and.basearch.base.WrapBaseActivity;
import com.arpa.and.basearch.bean.res.ResWarehouse;
import com.arpa.and.basearch.databinding.ActivityLoginBinding;
import com.arpa.and.basearch.ui.callback.ViewListener;
import com.arpa.and.basearch.ui.dialog.DialogWarehouseSelect;

import androidx.annotation.Nullable;
import dagger.hilt.android.AndroidEntryPoint;


/**
 * author: 李一方(<a href="mailto:leergo@dingtalk.com">leergo@dingtalk.com</a>)<br/>
 * version: 1.0.0<br/>
 * since: 2021-04-21 2:04 PM
 *
 * <p>
 * 页面：登录
 * </p>
 */
@AndroidEntryPoint
public class LoginActivity extends WrapBaseActivity<VMLogin, ActivityLoginBinding>
        implements ViewListener.DataTransCallback<ResWarehouse> {

    @Override
    public int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    public void initData(@Nullable Bundle savedInstanceState) {
        super.initData(savedInstanceState);

        viewBind.setVariable(BR.vmLogin, viewModel);
        viewModel.getWarehouseLiveData().observe(this, list -> {
            if (list.size() == 1) {
                viewModel.login(list.get(0));
            } else {
                showDialogFragment(new DialogWarehouseSelect(list, this));
            }
        });
    }

    @Override
    public void transfer(ResWarehouse data) {
        viewModel.login(data);
    }
}
