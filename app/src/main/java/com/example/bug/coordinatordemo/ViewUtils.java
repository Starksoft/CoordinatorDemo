package com.example.bug.coordinatordemo;

import android.animation.Animator;
import android.support.annotation.NonNull;
import android.view.View;

public class ViewUtils {

    public static void animateViews(final boolean show, final int visibility, View... views) {
        for (final View view : views) {
            animateView(show, view);
        }
    }

    private static void animateView(final boolean show, final View view) {
        view.animate().alpha(show ? 1.0f : 0f).setDuration(300).setListener(new Animator.AnimatorListener() {
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
            public void onAnimationCancel(Animator animation) {}
            @Override
            public void onAnimationRepeat(Animator animation) {}
        });
    }

    /**
     * @param views
     */
    public static void toggleVisibility(@NonNull View... views) {
        for (final View view : views) {
            int visibility = view.getVisibility();

            switch (visibility) {
                case View.GONE:
                    view.setVisibility(View.VISIBLE);
                    break;
                case View.VISIBLE:
                    view.setVisibility(View.GONE);
                    break;
            }
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
}
