package com.example.healthkeep;

import android.content.res.ColorStateList;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;


import com.example.healthkeep.adapter.ViewPagerAdapter;
import com.example.healthkeep.app.BaseActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import butterknife.BindView;

public class MainActivity extends BaseActivity {
    @BindView(R.id.viewPager)
    ViewPager viewPager;
    @BindView(R.id.bottomNavigationView)
    BottomNavigationView bottomNavigationView;

    private MenuItem menuItem;
    private BottomNavigationView.OnNavigationItemSelectedListener navItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            switch (menuItem.getItemId()) {
                case R.id.nav_item_home:
                    viewPager.setCurrentItem(0);
                    break;
                case R.id.nav_item_mine:
                    viewPager.setCurrentItem(1);
                    break;
            }
            return false;
        }
    };
    private ViewPager.OnPageChangeListener onPageChangeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            for (int i = 0; i < bottomNavigationView.getMenu().size(); i++) {
                bottomNavigationView.getMenu().getItem(i).setChecked(false);
            }
            menuItem = bottomNavigationView.getMenu().getItem(position);
            menuItem.setChecked(true);
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getLayout() {
        return R.layout.layout_activity_main;
    }


    @Override
    protected void initView() {
        initNav();
        initViewPager();
    }

    private void initViewPager() {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new HomeFragment());
        adapter.addFragment(new MineFragment());
        viewPager.setAdapter(adapter);
    }



    private void initNav() {
        bottomNavigationView.setItemIconTintList(null);
        ColorStateList csl = getResources().getColorStateList(R.color.navigation_menu_item_color, null);
        bottomNavigationView.setItemTextColor(csl);
    }

    @Override
    protected void initEventAndData() {
        bottomNavigationView.setOnNavigationItemSelectedListener(navItemSelectedListener);
        viewPager.addOnPageChangeListener(onPageChangeListener);
    }

    @Override
    protected void createPresenter() {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
//        App.getInstance().exitApp();
    }
}

