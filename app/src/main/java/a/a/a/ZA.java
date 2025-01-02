package a.a.a;

import android.app.Dialog;
import android.content.Context;
import android.view.Window;
import android.widget.TextView;

import androidx.core.view.WindowCompat;

import com.airbnb.lottie.LottieAnimationView;
import pro.sketchware.R;

import mod.hey.studios.util.Helper;

public class ZA extends Dialog {

    private final LottieAnimationView animationView;

    public ZA(Context context) {
        super(context, R.style.progress);
        setContentView(R.layout.progress);
        animationView = findViewById(R.id.anim_sketchware);
        TextView tvProgress = findViewById(R.id.tv_progress);
        tvProgress.setText(Helper.getResString(R.string.common_message_loading));
        super.setCancelable(false);

        Window window = getWindow();
        if (window != null) {
            window.setStatusBarColor(0);
            WindowCompat.setDecorFitsSystemWindows(window, false);
        }
    }

    public void cancelAnimation() {
        if (animationView != null && animationView.isAnimating()) {
            animationView.cancelAnimation();
        }
    }

    public void pauseAnimation() {
        if (animationView != null && animationView.isAnimating()) {
            animationView.pauseAnimation();
        }
    }

    public void resumeAnimation() {
        if (animationView != null && !animationView.isAnimating()) {
            animationView.resumeAnimation();
        }
    }

}
