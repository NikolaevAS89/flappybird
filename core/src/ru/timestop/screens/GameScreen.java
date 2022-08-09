package ru.timestop.screens;

import static ru.timestop.Assets.UI_SKIN;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.Align;

import java.util.concurrent.atomic.AtomicInteger;

import ru.timestop.Assets;
import ru.timestop.actions.CompliteListener;
import ru.timestop.actions.RandomMoveParrallelXAction;
import ru.timestop.objects.Bird;
import ru.timestop.objects.ObstacleListener;
import ru.timestop.objects.Tubes;

public class GameScreen extends ScreenAdapter implements ObstacleListener
        , CompliteListener {
    private final Stage stage;
    private final Bird bird;
    private final AtomicInteger score = new AtomicInteger(0);
    private final Label lbScore;

    public GameScreen() {
        this.stage = new Stage();
        this.lbScore = new Label("0", UI_SKIN, "default");
        lbScore.setName("Score");
        lbScore.setPosition(0.2f * stage.getWidth(), stage.getHeight() - 200.0f);
        lbScore.setWidth(600.0f);
        lbScore.setHeight(200.0f);
        lbScore.setAlignment(Align.right);
        lbScore.setFontScale(5);
        this.bird = new Bird();
        this.bird.setPosition(0.20f * stage.getWidth(), 0.5f * stage.getHeight());
        this.bird.setListener(this);
        Image background = new Image(Assets.BACKGRAUND);
        background.setAlign(Align.center);
        background.setFillParent(true);
        this.stage.addActor(background);
        this.stage.addActor(bird);
        Tubes tubes = new Tubes(stage, 6.0f * bird.getHeight());
        tubes.getTubes().forEach(bird::addObstacle);
        RandomMoveParrallelXAction randomMove = new RandomMoveParrallelXAction(stage.getWidth(), -tubes.getWidth()
                , tubes.getMaxY(), Math.max(tubes.getMinY(), 5.0f * bird.getHeight()));
        randomMove.setListener(this);
        randomMove.setDuration(5);
        randomMove.setActor(tubes);
        Action infiniteMove = Actions.forever(randomMove);
        tubes.addAction(infiniteMove);
        this.stage.addActor(tubes);
        stage.addActor(lbScore);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        if (Gdx.input.isTouched()) {
            bird.punch();
        }
        stage.act();
        stage.draw();

    }

    @Override
    public void dispose() {
        stage.dispose();
    }

    @Override
    public void isCrushed(Actor actor) {
        score.set(0);
        lbScore.setText(0);
    }

    @Override
    public void complite() {
        lbScore.setText(score.incrementAndGet());
    }
}
