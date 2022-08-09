package ru.timestop.objects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Shape2D;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Touchable;

public class GameObject<T extends Shape2D> extends Actor {
    private final Texture texture;
    private final T shape;

    public GameObject(Texture texture, T shape) {
        this.setWidth(texture.getWidth());
        this.setHeight(texture.getHeight());
        this.setTouchable(Touchable.disabled);
        this.texture = texture;
        this.shape = shape;
    }

    public T getShape() {
        return shape;
    }

    public Texture getTexture() {
        return texture;
    }
}
