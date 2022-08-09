package ru.timestop.actions;

import com.badlogic.gdx.scenes.scene2d.actions.MoveToAction;

import java.util.Random;

public class RandomMoveParrallelXAction extends MoveToAction {
    private final Random random = new Random();
    private final float maxY;
    private final float minY;
    private CompliteListener listener;

    public RandomMoveParrallelXAction(float fromX, float toX, float maxY, float minY) {
        super();
        float y = nextY();
        this.setX(toX);
        this.setY(y);
        this.setStartPosition(fromX, y);
        this.maxY = maxY;
        this.minY = minY;
    }

    public void setListener(CompliteListener listener) {
        this.listener = listener;
    }

    protected void end() {
        if (listener != null) {
            listener.complite();
        }
    }


    protected void begin() {
        float y = nextY();
        this.setStartPosition(getStartX(), y);
        setY(y);
        target.setX(getStartX());
        target.setY(y);
    }


    private float nextY() {
        return minY + (maxY - minY) * random.nextFloat();
    }
}
