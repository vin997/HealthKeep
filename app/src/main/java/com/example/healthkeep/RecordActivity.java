package com.example.healthkeep;

import android.os.Bundle;
import android.view.View;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.example.healthkeep.app.BaseActivity;

import butterknife.BindView;

public class RecordActivity extends BaseActivity implements View.OnClickListener {
    @BindView(R.id.cv_record)
    CalendarView calendarView;
    @BindView(R.id.tv_calender)
    TextView tvCalender;
    @BindView(R.id.iv_edit)
    ImageView ivEdit;
    @BindView(R.id.iv_add)
    ImageView ivAdd;
    @BindView(R.id.et_breakfast)
    EditText etBreakfast;
    @BindView(R.id.et_breakfast_cal)
    EditText etBreakfastCal;
    @BindView(R.id.et_lunch)
    EditText etLunch;
    @BindView(R.id.et_lunch_cal)
    EditText etLunchCal;
    @BindView(R.id.et_dinner)
    EditText etDinner;
    @BindView(R.id.et_dinner_cal)
    EditText etDinnerCal;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getLayout() {
        return R.layout.layout_activity_record;
    }

    @Override
    protected void initView() {
        setUnEdit();
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView calendarView, int year, int month, int dayOfMonth) {
                month = month + 1;
                tvCalender.setText(year + "-" + month + "-" +dayOfMonth);
            }
        });
        ivEdit.setOnClickListener(this);
        ivAdd.setOnClickListener(this);
    }

    @Override
    protected void initEventAndData() {

    }

    @Override
    protected void createPresenter() {

    }

    public void setEdit() {
        etBreakfast.setFocusable(true);
        etBreakfastCal.setFocusable(true);
        etDinner.setFocusable(true);
        etDinnerCal.setFocusable(true);
        etLunch.setFocusable(true);
        etLunchCal.setFocusable(true);

        etBreakfast.setFocusableInTouchMode(true);
        etBreakfastCal.setFocusableInTouchMode(true);
        etLunchCal.setFocusableInTouchMode(true);
        etLunch.setFocusableInTouchMode(true);
        etDinnerCal.setFocusableInTouchMode(true);
        etDinner.setFocusableInTouchMode(true);
    }

    public void setUnEdit(){
        etBreakfast.setFocusable(false);
        etBreakfastCal.setFocusable(false);
        etDinner.setFocusable(false);
        etDinnerCal.setFocusable(false);
        etLunch.setFocusable(false);
        etLunchCal.setFocusable(false);

        etBreakfast.setFocusableInTouchMode(false);
        etBreakfastCal.setFocusableInTouchMode(false);
        etLunchCal.setFocusableInTouchMode(false);
        etLunch.setFocusableInTouchMode(false);
        etDinnerCal.setFocusableInTouchMode(false);
        etDinner.setFocusableInTouchMode(false);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_edit:
                setEdit();
                ivAdd.setVisibility(View.VISIBLE);
                ivEdit.setVisibility(View.GONE);
                break;
            case R.id.iv_add:
                setUnEdit();
                ivEdit.setVisibility(View.VISIBLE);
                ivAdd.setVisibility(View.GONE);
                break;
        }
    }
}
