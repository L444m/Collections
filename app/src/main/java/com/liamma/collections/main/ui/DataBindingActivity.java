package com.liamma.collections.main.ui;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.Observable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.liamma.collections.BR;
import com.liamma.collections.R;
import com.liamma.collections.bean.User;
import com.liamma.collections.databinding.TestDataBinding;
import com.liamma.commons.log.LogUtils;
import com.liamma.commons.utils.ToastUtils;

/**
 * @author Liam
 * @version 1.0
 * DATE: Created on 2021/6/21 9:35
 * DESCRIPTION:
 */
public class DataBindingActivity extends AppCompatActivity {

    private User user;
    private TestDataBinding dataBinding;
    private int userIndex = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 数据绑定类 的名称是根据布局文件生成的，将布局文件名中的“_”去掉，再改为大驼峰。

        // 可以在 <data></data> 中的 <data class....> 标签中自定义 DataBinding 名称。
        dataBinding = DataBindingUtil.setContentView(this, R.layout.main_activity_data_binding);

        // 这是先给 tvName 设置一个默认值。
        dataBinding.tvName.setText("王小强");

        user = new User("Alice", "password0088", "0000");
        dataBinding.setUserInfo(user);

        addListeners();
        addFragment();
    }

    private void addListeners() {
        user.addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback() {
            @Override
            public void onPropertyChanged(Observable sender, int propertyId) {
                if (propertyId == BR.password) {
                    LogUtils.i("BR.password");
                } else if (propertyId == BR.id) {
                    LogUtils.i("BR.id");
                } else if (propertyId == BR._all) {
                    LogUtils.i("BR._all");
                }
            }
        });
        dataBinding.tvChangUser.setOnClickListener(v -> {
            userIndex++;
            ToastUtils.showShort(DataBindingActivity.this, "change user index = " + userIndex);
            //user = new User("Bob", "user_pwd_" + userIndex);
            user.setName("Bob user_" + userIndex);
            user.setPassword("password_user_" + userIndex);
            user.setId("0000 user_" + userIndex);
        });
    }

    private void addFragment() {
        Fragment dataBindingFragment = new DataBindingFragment();
        FragmentTransaction transaction = this.getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.flFragmentContainer, dataBindingFragment, "dataBinding");
        //transaction.show(dataBindingFragment);
        transaction.commit();
    }

}
