package com.qzy.laobiao.common.base;

import android.app.Activity;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

/**
 * artifact  判读是否输入管理
 */
public abstract class BaseInputActivity extends Activity {

    private final List<EditText> mInputViews = new ArrayList<>();

    private boolean mAllNotEmpty;

    private InputWatcher mInputWatcher;

    protected void watchEditText(EditText editText) {
        if (mInputWatcher == null) {
            mInputWatcher = new InputWatcher();
        }
        mInputViews.add(editText);
        editText.addTextChangedListener(mInputWatcher);
    }

    /**
     * 输入框空白状态发生变化时回调
     *
     * @param allNotEmpty 是否为空
     */
    protected void onInputEmptyChanged(boolean allNotEmpty) {

    }


    class InputWatcher implements TextWatcher {

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            boolean allNotEmpty = true;
            for (int i = 0; i < mInputViews.size(); i++) {
                if (TextUtils.isEmpty(mInputViews.get(i).getText())) {
                    allNotEmpty = false;
                    break;
                }
            }

            if (mAllNotEmpty != allNotEmpty) {
                onInputEmptyChanged(allNotEmpty);
                mAllNotEmpty = allNotEmpty;
            }

        }
    }


}
