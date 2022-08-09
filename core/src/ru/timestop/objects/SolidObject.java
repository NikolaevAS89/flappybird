package ru.timestop.objects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Intersector;

import java.util.ArrayList;
import java.util.List;

public class SolidObject extends GameObject<Circle> {
    private final List<Tube> obstacles;

    public ObstacleListener listener = null;

    public SolidObject(Texture texture, Circle shape) {
        super(texture, shape);
        obstacles = new ArrayList<>();
    }

    public SolidObject addObstacle(Tube obstacle) {
        obstacles.add(obstacle);
        return this;
    }

    public void setListener(ObstacleListener listener) {
        this.listener = listener;
    }

    public void act(float delta) {
        super.act(delta);
        if (listener != null) {
            for (Tube obstacle : obstacles) {
                if (Intersector.overlaps(getShape(), obstacle.getShape())) {
                    listener.isCrushed(obstacle);
                    break;
                }
            }
        }
    }
}
