package com.smile.gilberto.gless20activity;

import android.opengl.GLES20;

/**
 * Created by Registered User on 4/10/16.
 */
public class GLES20Renderer extends GLRenderer {

    @Override
    public void onCreate(int width, int height,
                         boolean contextLost) {
        GLES20.glClearColor(0f, 0f, 0f, 1f);
    }

    @Override
    public void onDrawFrame(boolean firstDraw) {
        GLES20.glClear(GLES20.GL_COLOR_BUFFER_BIT
                | GLES20.GL_DEPTH_BUFFER_BIT);
    }
}
