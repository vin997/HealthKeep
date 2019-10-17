package com.example.healthkeep;

import android.content.Intent;
import android.graphics.Color;
import android.view.View;
import android.widget.RelativeLayout;

import androidx.cardview.widget.CardView;

import com.example.healthkeep.app.BaseFragment;
import com.google.android.material.appbar.AppBarLayout;

import butterknife.BindView;

public class HomeFragment extends BaseFragment {

    @BindView(R.id.cd_search_up)
    CardView cdSearchUp;
    @BindView(R.id.rl_record)
    RelativeLayout rlRecord;
    @BindView(R.id.app_barlayout)
    AppBarLayout appBarlayout;

    @BindView(R.id.rl_title)
    RelativeLayout rlTitle;

    @Override
    protected int getLayout() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initView() {
        cdSearchUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), SearchActivity.class);
                startActivity(intent);
            }
        });
        rlRecord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), RecordActivity.class);
                startActivity(intent);
            }
        });
        appBarlayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (verticalOffset == 0) {
                    rlTitle.setBackgroundColor(Color.argb(0, 221, 48, 10));
                } else if (Math.abs(verticalOffset) >= appBarLayout.getTotalScrollRange()) {
                    rlTitle.setBackgroundColor(Color.argb(255, 221, 48, 10));
                } else {
                    int alpha = (int) (255 - verticalOffset / (float) appBarLayout.getTotalScrollRange() * 255);
                    rlTitle.setBackgroundColor(Color.argb(alpha, 221, 48, 10));
                }
            }
        });
    }

    @Override
    public void showError() {

    }
}
