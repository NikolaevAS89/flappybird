package ru.timestop;

import com.badlogic.gdx.Game;

import ru.timestop.screens.GameScreen;

public class GameLauncher extends Game {

    @Override
    public void create() {
        Assets.load();
        this.setScreen(new GameScreen());
    }

    @Override
    public void dispose() {
        super.dispose();
        Assets.dispose();
    }
}
