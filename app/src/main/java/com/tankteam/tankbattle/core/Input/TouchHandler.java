package com.tankteam.tankbattle.core.Input;

import android.view.View;

import java.util.List;

/**
 * Created by leiyong on 15/10/15.
 */
public interface TouchHandler extends View.OnTouchListener {
    boolean isTouchDown(int pointer);
    int getTouchX(int pointer);
    int getTouchY(int pointer);
    List<Input.TouchEvent> getTouchEvents();
}
