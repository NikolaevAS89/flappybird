package ru.timestop.objects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.utils.Align;

import ru.timestop.Assets;

public class Bird extends SolidObject {
    public final static String NAME = "Bird";
    public final static float GRAVITY_FORCE = -900.0f;
    public final static float MAX_SPEED = 700.0f;
    private float time;
    private float gravity;
    private float speed;

    public Bird() {
        super(Assets.BIRD_WINGS_UP, new Circle());
        setName(NAME);
        setWidth(getTexture().getWidth());
        setHeight(getTexture().getHeight());
        getShape().setRadius(Math.min(getTexture().getHeight(), getTexture().getWidth()));
    }

    public Texture getTexture() {
        return Assets.BIRD.getKeyFrame(time, true);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(getTexture(), getX(), getY());
        getShape().setPosition(getX(Align.center), getY(Align.center));
    }

    public void punch() {
        this.speed = MAX_SPEED;
        this.gravity = GRAVITY_FORCE;
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        this.time += delta;
        float y = getY() + (speed + gravity * delta) * delta;
        speed += gravity * delta;
        speed = speed <= -MAX_SPEED ? -MAX_SPEED : Math.min(speed, MAX_SPEED);
        y = y <= 0 ? 0 : Math.min(y, getStage().getHeight() - getHeight());
        if (getY() != y) {
            setY(y);
        }
    }
}
