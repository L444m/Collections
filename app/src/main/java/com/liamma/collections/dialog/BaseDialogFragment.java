package com.liamma.collections.dialog;

import android.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;

import com.liamma.collections.R;


/**
 * Created by Liam on 2018/8/9
 */
public class BaseDialogFragment extends DialogFragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        // return super.onCreateView(inflater, container, savedInstanceState);
        return inflater.inflate(R.layout.dialog_test_dialog, container);
    }

}
