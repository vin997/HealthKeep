package com.example.healthkeep;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.healthkeep.app.BaseActivity;
import com.example.healthkeep.view.TitleBarView;

import java.io.File;
import java.io.IOException;

import butterknife.BindView;

public class SearchActivity extends BaseActivity implements View.OnClickListener {

    @BindView(R.id.tv_test)
    TextView tvTest;
    @BindView(R.id.tv_test1)
    TextView tvTest1;
    private AssetFileDescriptor file ;
    private MediaPlayer mediaPlayer;
    private static boolean shouldPlayBeep = true;

    @Override
    protected int getLayout() {
        return R.layout.layout_activity_search;
    }

    @Override
    protected void initView() {

        setNotice();

        new TitleBarView(this).setTitleText(getResources().getString(R.string.app_name));
        tvTest.setOnClickListener(this);
        tvTest1.setOnClickListener(this);

    }

    @Override
    protected void initEventAndData() {

    }

    @Override
    protected void createPresenter() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_test:
                play();
//                playBeeAndVibrate(this, 2000, MediaPlayer::clearOnSubtitleDataListener);
                break;
            case R.id.tv_test1:
                cancel();
                break;
            default:
                break;
        }
    }

    private void cancel() {
        mediaPlayer.stop();
    }

    private void play() {
        if (shouldPlayBeep && mediaPlayer != null) {
            mediaPlayer.start();
        }
    }

    private void setNotice() {
        AudioManager audioService = (AudioManager) this.getSystemService(Context.AUDIO_SERVICE);
        if (audioService.getRingerMode() != AudioManager.RINGER_MODE_NORMAL) {
            shouldPlayBeep = false;//检查当前是否是静音模式
        }

        mediaPlayer = MediaPlayer.create(this, R.raw.dingding);
        mediaPlayer.setVolume(0, 1);
    }
}
