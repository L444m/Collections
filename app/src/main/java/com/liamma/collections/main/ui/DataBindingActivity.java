package com.liamma.collections.main.ui;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.BindingAdapter;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.Observable;
import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableList;
import androidx.databinding.ObservableLong;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.liamma.collections.BR;
import com.liamma.collections.R;
import com.liamma.collections.bean.Image;
import com.liamma.collections.bean.ObservableUser;
import com.liamma.collections.bean.User;
import com.liamma.collections.databinding.TestDataBinding;
import com.liamma.commons.log.LogUtils;
import com.liamma.commons.utils.ToastUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Liam
 * @version 1.0
 * DATE: Created on 2021/6/21 9:35
 * DESCRIPTION:
 */
public class DataBindingActivity extends AppCompatActivity {

    private User user;
    private ObservableUser observableUser;
    private List<User> list;
    private ObservableList<User> observableList;
    private int index;

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
        observableUser = new ObservableUser("Candy", "password1010", 1111);
        list = new ArrayList<>();
        list.add(new User("list001", "pwd001", "0001"));
        list.add(new User("list002", "pwd002", "0002"));
        observableList = new ObservableArrayList<>();
        observableList.addAll(list);
        index = 1;
        dataBinding.setUserInfo(user);
        dataBinding.setObservableUser(observableUser);
        dataBinding.setList(observableList);
        dataBinding.setIndex(index);
        dataBinding.setUserPresenter(new UserPresenter());
        dataBinding.setImage(new Image("wwww.baidu.com/fuckyou/index.jsp"));

        //addListeners();
        //addChangeIdListener();
        addFragment();
    }

    private void addChangeIdListener() {
        dataBinding.tvChangUser.setOnClickListener(v -> {
            LogUtils.i("click change Id button");
            dataBinding.tvID.setText("manual changed id " + userIndex);
        });
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
        /*dataBinding.tvChangUser.setOnClickListener(v -> {
            userIndex++;
            ToastUtils.showShort(DataBindingActivity.this, "change user index = " + userIndex);
            //user = new User("Bob", "user_pwd_" + userIndex);
            observableUser.setName("Doggie user_" + userIndex);
            observableUser.setPassword("observable password_user_" + userIndex);
            observableUser.setId(1111L + Long.valueOf(userIndex));
        });*/
        dataBinding.tvChangUser.setOnClickListener(v -> {
            ToastUtils.showShort(DataBindingActivity.this, "change user");
            observableList.add(1, new User("changed User", "changed pwd", "changed 0000"));
        });
    }

    private void addFragment() {
        Fragment dataBindingFragment = new DataBindingFragment();
        FragmentTransaction transaction = this.getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.flFragmentContainer, dataBindingFragment, "dataBinding");
        //transaction.show(dataBindingFragment);
        transaction.commit();
    }

    public class UserPresenter {
        public void onChangeUserClick(User user) {
            LogUtils.i("on change user button clicked.");
        }
    }

}
