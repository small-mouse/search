package com.cjj.sva.anim.controller;

import android.graphics.Canvas;
import android.graphics.Paint;

import com.cjj.sva.anim.JJBaseController;

/**
 * Created by androidcjj on 2016/3/30.
 */
public class JJDefaultController extends JJBaseController {

    @Override
    public void draw(Canvas canvas, Paint paint) {
        switch (mState) {
            case STATE_ANIM_NONE:
                drawNormalView(paint, canvas);
                break;
//            case STATE_ANIM_START:
//                drawStartAnimView(paint, canvas);
//                break;
//            case STATE_ANIM_STOP:
//                drawStopAnimView(paint, canvas);
//                break;
        }
    }

    private void drawNormalView(Paint paint, Canvas canvas) {

    }
}
