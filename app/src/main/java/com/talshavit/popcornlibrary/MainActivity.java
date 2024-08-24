package com.talshavit.popcornlibrary;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import com.google.android.material.textfield.TextInputEditText;
import com.talshavit.popanimationlibrary.AnimationDirection;
import com.talshavit.popanimationlibrary.AnimationType;
import com.talshavit.popanimationlibrary.PopAnimationView;

public class MainActivity extends AppCompatActivity {

    private AppCompatButton confirm_btton;
    private PopAnimationView popcornView;
    private TextInputEditText image_size, duration, interval, count;
    private RadioGroup radioGroup1, radioGroup2;
    private RadioButton from_top, from_bottom, rotate, not_rotate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViews();
        initViews();
    }

    private void initViews() {
        onDirection();
        onType();
        onConfirmButton();
    }

    private void onConfirmButton() {
        confirm_btton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onImageSizeEditTxt();
                onCountEditTxt();
                onDurationEditTxt();
                onInterval();

                popcornView.setImage(R.drawable.popcorn);

                popcornView.post(new Runnable() {
                    @Override
                    public void run() {
                        popcornView.startAnimation();
                    }
                });
            }
        });
    }

    private void onType() {
        radioGroup2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedID) {
                if(checkedID == R.id.not_rotate){
                    popcornView.setAnimationType(AnimationType.FALL_NO_ROTATION);
                }else{
                    popcornView.setAnimationType(AnimationType.FALL_WITH_ROTATION);
                }
            }
        });
    }

    private void onDirection() {
        radioGroup1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedID) {
                if(checkedID == R.id.from_bottom){
                    popcornView.setAnimationDirection(AnimationDirection.BOUNCE_FROM_BOTTOM);
                }else if(checkedID == R.id.from_top){
                    popcornView.setAnimationDirection(AnimationDirection.FALL_FROM_TOP);
                }
            }
        });
    }

    private void onInterval() {
        int intervalTxt = Integer.parseInt(interval.getText().toString().trim());
        popcornView.setInterval(intervalTxt);
    }

    private void onDurationEditTxt() {
        int durationTxt = Integer.parseInt(duration.getText().toString().trim());
        popcornView.setDuration(durationTxt);
    }

    private void onImageSizeEditTxt() {
        int imgSize = Integer.parseInt(image_size.getText().toString().trim());
        popcornView.setSize(imgSize);
    }

    private void onCountEditTxt() {
        int countTxt = Integer.parseInt(count.getText().toString().trim());
        popcornView.setPopcornCount(countTxt);
    }

    private void findViews() {
        popcornView = findViewById(R.id.popcorn_view);
        confirm_btton = findViewById(R.id.confirm_btton);
        image_size = findViewById(R.id.image_size);
        duration = findViewById(R.id.duration);
        interval = findViewById(R.id.interval);
        count = findViewById(R.id.count);
        radioGroup1 = findViewById(R.id.radioGroup1);
        radioGroup2 = findViewById(R.id.radioGroup2);
        from_top = findViewById(R.id.from_top);
        from_bottom = findViewById(R.id.from_bottom);
        rotate = findViewById(R.id.rotate);
        not_rotate = findViewById(R.id.not_rotate);
    }
}