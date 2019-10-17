package com.example.healthkeep.view;

import android.app.Activity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.healthkeep.R;

public class TitleBarView {

    private ImageView ivBack;
    private TextView tvTitle;

    public TitleBarView(Activity context) {
        ivBack = context.findViewById(R.id.iv_left_icon);
        tvTitle = context.findViewById(R.id.tv_title);

        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.onBackPressed();
            }
        });
    }

    /**
     * 用于设置标题栏文字
     * @param title 传入设置的标题栏文字
     * @return
     */
    public TitleBarView setTitleText(String title) {
        if (title != null) {
            tvTitle.setText(title);
        }
        return this;
    }

//    /**
//     * 用于返回的按钮监听
//     * @param listener
//     * @return
//     */
//    public TitleBarView setBackListening(View.OnClickListener listener) {
//        if (ivBack.getVisibility() == View.VISIBLE) {
//            ivBack.setOnClickListener(listener);
//        }
//        return this;
//    }
}
