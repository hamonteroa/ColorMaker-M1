package com.hamonteroa.colormaker;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String LOG_TAG = "MainActivity";

    private View mColorView;
    private TextView mColorTextView;
    private SeekBar mRedSeekBar;
    private SeekBar mGreenSeekBar;
    private SeekBar mBlueSeekBar;

    private final String CONST_INITIAL_COLOR = "#000000";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.mColorView = findViewById(R.id.color_view);
        this.mColorTextView = (TextView) findViewById(R.id.color_textView);
        this.mRedSeekBar = (SeekBar) findViewById(R.id.red_seekBar);
        this.mGreenSeekBar = (SeekBar) findViewById(R.id.green_seekBar);
        this.mBlueSeekBar = (SeekBar) findViewById(R.id.blue_seekBar);

        this.mColorView.setBackgroundColor(Color.parseColor(CONST_INITIAL_COLOR));
        this.mColorTextView.setText(CONST_INITIAL_COLOR);


        this.mRedSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                setColorViewBackgroundColor();
            }
        });

        this.mGreenSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                setColorViewBackgroundColor();
            }
        });

        this.mBlueSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                setColorViewBackgroundColor();
            }
        });

    }

    private void setColorViewBackgroundColor() {
        String color = "#" +
                getTwoCharHexString(Integer.toHexString(this.mRedSeekBar.getProgress())) +
                getTwoCharHexString(Integer.toHexString(this.mGreenSeekBar.getProgress())) +
                getTwoCharHexString(Integer.toHexString(this.mBlueSeekBar.getProgress()));
        Log.v(LOG_TAG, "color: " + color +
        ", red: " + this.mRedSeekBar.getProgress() +
        ", green: " + this.mGreenSeekBar.getProgress() +
        ", blue: " + this.mBlueSeekBar.getProgress());
        this.mColorView.setBackgroundColor(Color.parseColor(color));
        this.mColorTextView.setText(color);
    }

    private String getTwoCharHexString(String hex) {
        return (hex.length() < 2) ? "0" + hex : hex;
    }
}
