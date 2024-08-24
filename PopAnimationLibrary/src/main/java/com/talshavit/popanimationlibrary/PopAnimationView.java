package com.talshavit.popanimationlibrary;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.animation.ValueAnimator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PopAnimationView extends View {
    private Bitmap popAnimationBitmap;
    private List<Float> popAnimtionYPositions, rotationAngles;
    private List<Integer> startXPositions;
    private int count = 10, duration = 0,  interval = 0, size = 100;
    private float startY, endY;
    private AnimationType animationType = AnimationType.FALL_WITH_ROTATION;
    private AnimationDirection animationDirection = AnimationDirection.FALL_FROM_TOP;
    private ValueAnimator animator;
    private Random random = new Random();

    public PopAnimationView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        popAnimtionYPositions = new ArrayList<>();
        startXPositions = new ArrayList<>();
        rotationAngles = new ArrayList<>();
    }

    public void startAnimation() {
        for (int i = 0; i < count; i++) {
            int startX = random.nextInt(getWidth() - popAnimationBitmap.getWidth());
            startXPositions.add(startX);
            float initialRotationAngle = random.nextFloat() * 360f;
            rotationAngles.add(initialRotationAngle);
            //rotationAngles.add(0f);

            int startDelay = i * interval;
            int animationDuration = duration + random.nextInt(2000);
            int finalI = i;

            setStartPosition();
            setAnimationOnY(animationDuration, startDelay, finalI);
            setRotateAnimation(animationDuration, startDelay, finalI);
            animator.start();
        }
    }

    private void setRotateAnimation(int animationDuration, int startDelay, int finalI) {
        if (animationType == AnimationType.FALL_WITH_ROTATION) {
            ValueAnimator rotateAnimator = ValueAnimator.ofFloat(0f, random.nextBoolean() ? 360f : -360f);
            rotateAnimator.setDuration(animationDuration);
            rotateAnimator.setStartDelay(startDelay);

            rotateAnimator.addUpdateListener(animation -> {
                rotationAngles.set(finalI, (float) animation.getAnimatedValue());
                invalidate();
            });
            rotateAnimator.start();
        }
    }

    private void setAnimationOnY(int animationDuration, int startDelay, int finalI) {
        animator = ValueAnimator.ofFloat(startY, endY);
        animator.setDuration(animationDuration);
        animator.setStartDelay(startDelay);

        animator.addUpdateListener(animation -> {
            float yPosition = (float) animation.getAnimatedValue();
            popAnimtionYPositions.set(finalI, yPosition);
            invalidate();
        });
    }

    private void setStartPosition() {
        if (animationDirection == AnimationDirection.FALL_FROM_TOP) {
            startY = -popAnimationBitmap.getHeight() - 400;
            endY = getHeight() + 400;
        } else {
            startY = getHeight() + 400;
            endY = -400;
        }
        popAnimtionYPositions.add(startY);
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setPopcornCount(int count) {
        this.count = count;
    }

    public void setInterval(int interval) {
        this.interval = interval;
    }

    public void setAnimationType(AnimationType type) {
        this.animationType = type;
    }

    public void setAnimationDirection(AnimationDirection direction) {
        this.animationDirection = direction;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setImage(int popcorn) {
        Bitmap originalBitmap = BitmapFactory.decodeResource(getResources(), popcorn);
        popAnimationBitmap = Bitmap.createScaledBitmap(originalBitmap, size, (int) (originalBitmap.getHeight() * ((float) size / originalBitmap.getWidth())), true);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (popAnimtionYPositions.isEmpty() || startXPositions.isEmpty() || rotationAngles.isEmpty()) {
            return;
        }
        for (int i = 0; i < count; i++) {
            canvas.save();
            if (animationType == AnimationType.FALL_WITH_ROTATION) {
                canvas.rotate(rotationAngles.get(i), startXPositions.get(i), popAnimtionYPositions.get(i));
            }
            canvas.drawBitmap(popAnimationBitmap, startXPositions.get(i), popAnimtionYPositions.get(i), null);
            canvas.restore();
        }
    }
}
