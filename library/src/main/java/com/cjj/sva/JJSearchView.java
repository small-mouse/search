package com.cjj.sva;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.util.AttributeSet;
import android.view.View;

import com.cjj.sva.anim.JJBaseController;
import com.cjj.sva.anim.controller.JJChangeArrowController;
import com.cjj.sva.anim.controller.JJCircleToLineAlphaController;

/**
 * 这是一个神奇的类，今天心情郁闷
 * <p>
 * Created by androidcjj on 2016/3/30.
 */
public class JJSearchView extends View {
    private Paint mPaint;
    private PathMeasure mPahtMeasure;
    private Path mPath;
    private JJBaseController mController = new JJChangeArrowController();

    public JJSearchView(Context context) {
        this(context, null);
    }

    public JJSearchView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public JJSearchView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setStrokeWidth(4);

        mPath = new Path();
        mPahtMeasure = new PathMeasure(mPath, false);
        mController.setSearchView(this);
    }

    public void setController(JJBaseController controller) {
        this.mController = controller;
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mController.draw(canvas, mPaint);
    }

    public void startAnim() {
        if (mController != null)
            mController.startAnim();
    }

    public void stopAnim() {
        if (mController != null)
            mController.stopAnim();
    }

    public void searchingAnim() {
        if (mController != null)
            mController.searchingAnim();
    }
}
