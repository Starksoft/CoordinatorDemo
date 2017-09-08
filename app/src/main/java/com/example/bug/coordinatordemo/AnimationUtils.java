package com.example.bug.coordinatordemo;


import android.animation.Animator;
import android.support.annotation.NonNull;
import android.view.View;

public final class AnimationUtils {

    private AnimationUtils() {

    }

    public static void setVisibilityWithAnim(boolean show, @NonNull View... views) {
        for (final View view : views) {
            animateView(show, view);
        }
    }

    public static void toggleVisibilityWithAnim(@NonNull View... views) {
        for (final View view : views) {
            int visibility = view.getVisibility();

            switch (visibility) {
                case View.GONE:
                    animateView(true, view);
                    break;
                case View.VISIBLE:
                    animateView(false, view);
                    break;
            }
        }
    }

    private static void animateView(final boolean show, final @NonNull View view) {
        float viewAlpha = view.getAlpha();
        float alpha = show ? 1.0f : 0f;

        if (show && viewAlpha > 0f) {
            view.setAlpha(0f);
        }

        view.animate().alpha(alpha).setDuration(500).setListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                if (show) {
                    view.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                if (!show) {
                    view.setVisibility(View.GONE);
                }
            }

            @Override
            public void onAnimationCancel(Animator animation) {
            }

            @Override
            public void onAnimationRepeat(Animator animation) {
            }
        });
    }
}
