package com.liamma.commons.widget.edit;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatEditText;

/**
 * @author Liam
 * @version 1.0
 * DATE: Created on 2021/1/22 17:17
 * DESCRIPTION: An EditText with an icon on the right which can easily clear enter content by clicking it.
 */
public class ClearEditText extends AppCompatEditText {

    /*
     * +----------------------+
     * |                      |
     * | Input area      icon |
     * +----------------------+
     */

    public ClearEditText(@NonNull Context context) {
        super(context);
    }

}
