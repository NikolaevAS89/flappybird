package ru.timestop;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class Assets {
    public static Animation<Texture> BIRD;
    public static Texture BIRD_WINGS_UP;
    public static Texture BIRD_WINGS_DOWN;
    public static Texture BACKGRAUND;
    public static Texture TUBE_UP;
    public static Texture TUBE_DOWN;
    public static Texture GAME_OVER;
    public static Skin UI_SKIN;

    public static void load() {
        BIRD_WINGS_DOWN = new Texture("bird_wings_down.png");
        BIRD_WINGS_UP = new Texture("bird_wings_up.png");
        BACKGRAUND = new Texture("background.png");
        TUBE_UP = new Texture("top_tube.png");
        TUBE_DOWN = new Texture("bottom_tube.png");
        GAME_OVER = new Texture("game_over.png");
        BIRD = new Animation<>(0.1f, BIRD_WINGS_DOWN, BIRD_WINGS_UP);
        UI_SKIN = new Skin(Gdx.files.internal("uiskin.json"));
    }

    public static void dispose() {
        BACKGRAUND.dispose();
        TUBE_DOWN.dispose();
        TUBE_UP.dispose();
        GAME_OVER.dispose();
        BIRD_WINGS_DOWN.dispose();
        BIRD_WINGS_UP.dispose();
        UI_SKIN.dispose();
    }
}
