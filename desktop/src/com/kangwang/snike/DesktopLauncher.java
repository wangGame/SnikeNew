package com.kangwang.snike;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

import wk.demo.block.SnakeMain;

public class DesktopLauncher {
    public static void main(String[] arg) {
        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        config.title = "block";
        config.height = 940;
        config.width = 1360;
        new LwjglApplication(new SnakeMain(),config);
    }
}