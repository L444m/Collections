package com.liamma.commons.widget.edit;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatEditText;

/**
 * @author Liam
 * @version 1.0
 * DATE: Created on 2021/1/22 16:49
 * DESCRIPTION: An EditText that can automatically divide input content into different parts with specified divider.
 */
public class DivisionEditText extends AppCompatEditText {

    // content type: phone number, bank card, etc
    // specified length : 4 or other
    // divider: blank space, -, _

    public DivisionEditText(@NonNull Context context) {
        super(context);
    }

}
