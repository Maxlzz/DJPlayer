package com.max.djplayer;

import android.content.Context;
import android.media.MediaPlayer;

/**
 * Created by Administrator on 2015/12/22.
 */
public class AudioPlayer {
    private MediaPlayer mMediaPlayer;

    public void stop() {
        if (mMediaPlayer != null ){
            mMediaPlayer.release();
            mMediaPlayer = null;
        }
    }



    public void pause(){
        if (mMediaPlayer.isPlaying()){
            mMediaPlayer.pause();
        }else {
            mMediaPlayer.start();
        }


    }


    public void play(Context context) {
        stop();//强化卸除循环播放，强调只有一个MedioPlayer，播放时长即止，实例强化规则
        mMediaPlayer = MediaPlayer.create(context,R.raw.kickass_stand_up);

        mMediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                stop();//强化卸除循环播放，强调只有一个MedioPlayer实例
            }
        });
        mMediaPlayer.start();

    }
}
