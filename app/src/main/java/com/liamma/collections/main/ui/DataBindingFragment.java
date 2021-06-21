package com.liamma.collections.main.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.liamma.collections.bean.UserDetails;
import com.liamma.collections.databinding.UserDetailsBinding;
import com.liamma.collections.R;

/**
 * @author Liam
 * @version 1.0
 * DATE: Created on 2021/6/21 10:42
 * DESCRIPTION:
 */
public class DataBindingFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        UserDetailsBinding dataBinding = DataBindingUtil.inflate(inflater, R.layout.main_fragment_data_binding, container, false);

        UserDetails userDetails = new UserDetails("Alice", "No.152646465", "address not included", "");
        dataBinding.setUserDetails(userDetails);
        return dataBinding.getRoot();
    }
}
