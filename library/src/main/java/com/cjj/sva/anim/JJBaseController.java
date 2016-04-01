package com.cjj.sva.anim;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.IntDef;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.LinearInterpolator;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;

/**
 * 这是一个神奇的controller，神奇你妹啊...妹啊...啊。
 *
 * Created by androidcjj on 2016/3/30.
 */
public abstract class JJBaseController {
    public static final int STATE_ANIM_NONE = 0;
    public static final int STATE_ANIM_START = 1;
    public static final int STATE_ANIM_SEARCHING = 2;
    public static final int STATE_ANIM_STOP = 3;

    protected float mPro = -1;
    private WeakReference<View> mSearchView;

    @IntDef({STATE_ANIM_START, STATE_ANIM_SEARCHING, STATE_ANIM_STOP})
    @Retention(RetentionPolicy.SOURCE)
    public @interface State {
    }

    @State
    protected int mState = STATE_ANIM_NONE;

    public int getState() {
        return mState;
    }

    public void setState(int state) {
        mState = state;
    }

    public void setSearchView(View searchView) {
        this.mSearchView = new WeakReference<>(searchView);
    }

    public View getSearchView() {
        return mSearchView != null ? mSearchView.get() : null;
    }

    /**
     * 获取view的宽度
     *
     * @return
     */
    public int getWidth() {
        return getSearchView() != null ? getSearchView().getWidth() : 0;
    }

    /**
     * 获取view的高度
     *
     * @return
     */
    public int getHeight() {
        return getSearchView() != null ? getSearchView().getHeight() : 0;
    }

    /**
     * 绘制就交给我儿子们去做吧
     *
     * @param canvas
     * @param paint
     */
    public abstract void draw(Canvas canvas, Paint paint);

    /**
     * 开启搜索动画
     */
    public void startAnim() {
    }

    /**
     * 搜索动画中
     */
    public void searchingAnim() {
    }

    /**
     * 停止搜索动画
     */
    public void stopAnim() {
    }


    public void startSearchViewAnim() {
        startSearchViewAnim(0, 1, 500);
    }

    public void startSearchViewAnim(float startF, float endF, long time) {
        ValueAnimator valueAnimator = ValueAnimator.ofFloat(startF, endF);
        valueAnimator.setDuration(time);
        valueAnimator.setInterpolator(new LinearInterpolator());
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                mPro = (float) valueAnimator.getAnimatedValue();
                getSearchView().invalidate();
            }
        });
        valueAnimator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
            }
        });
        if (!valueAnimator.isRunning()) {
            valueAnimator.start();
        }
    }

}
