package ru.timestop.objects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Rectangle;

public class Tube extends GameObject<Rectangle> {

    public Tube(Texture texture) {
        super(texture, new Rectangle());
        this.getShape().setSize(texture.getWidth(), texture.getHeight());
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        getShape().setPosition(getX(), getY());
        batch.draw(getTexture(), getX(), getY());
    }
}
