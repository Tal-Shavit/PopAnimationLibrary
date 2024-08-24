package com.talshavit.popcornlibrary;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

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
    private AutoCompleteTextView direction, type;
    private String[] directionOption = {"FALL_FROM_TOP", "BOUNCE_FROM_BOTTOM"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViews();
        initViews();
    }

    private void initViews() {
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
                //initAdapter(direction, directionOption);
                /*Log.d("lala", "ll2ll");
                direction.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Log.d("lala", "llll");
                        direction.showDropDown();
                    }
                });*/

                popcornView.setImage(R.drawable.popcorn);
                popcornView.setAnimationType(AnimationType.FALL_WITH_ROTATION);
                popcornView.setAnimationDirection(AnimationDirection.FALL_FROM_TOP);

                popcornView.post(new Runnable() {
                    @Override
                    public void run() {
                        popcornView.startAnimation();
                    }
                });
            }
        });
    }

    private void initAdapters() {
        initAdapter(direction, directionOption);
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

    private void initAdapter(AutoCompleteTextView autoCompleteTextView, String[] arr) {
        Log.d("lala", arr.length+"");
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.dropdown_item, arr);
        autoCompleteTextView.setAdapter(adapter);
    }
    private void findViews() {
        popcornView = findViewById(R.id.popcorn_view);
        confirm_btton = findViewById(R.id.confirm_btton);
        image_size = findViewById(R.id.image_size);
        duration = findViewById(R.id.duration);
        interval = findViewById(R.id.interval);
        count = findViewById(R.id.count);
        direction = findViewById(R.id.direction);
        type = findViewById(R.id.type);
    }
}