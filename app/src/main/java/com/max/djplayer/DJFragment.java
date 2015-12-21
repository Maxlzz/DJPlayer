package com.max.djplayer;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by Administrator on 2015/12/22.
 */
public class DJFragment extends Fragment{
    private AudioPlayer mPlayer = new AudioPlayer();
    private Button mPlayButton;
    private Button mStopButton;
    private Button mPauseButton;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_dj,parent,false);

        mPlayButton = (Button) v.findViewById(R.id.dj_play);
        mPlayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPlayer.play(getActivity());

            }
        });
        mPauseButton = (Button) v.findViewById(R.id.dj_pause);
        mPauseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPlayer.pause();
            }
        });
        mStopButton = (Button) v.findViewById(R.id.dj_stop);
        mStopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPlayer.stop();
            }
        });
        return v;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mPlayer.stop();
    }
}
