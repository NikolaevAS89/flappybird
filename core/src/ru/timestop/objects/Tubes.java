package ru.timestop.objects;

import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Align;

import java.util.List;

import ru.timestop.Assets;

public class Tubes extends Group {
    private final Tube upTube;
    private final Tube downTube;
    private final float maxY;
    private final float minY;

    public Tubes(Stage stage, float space) {
        float x = 0.0f;
        float y = 0.0f;
        float halfSpace = 0.5f * space;
        setX(x);
        setY(y);
        setOriginX(x);
        setOriginY(y);
        setTransform(false);
        upTube = new Tube(Assets.TUBE_UP);
        upTube.setName("TubeUp");
        upTube.setX(0.0f);
        upTube.setY(y + halfSpace, Align.bottom);
        downTube = new Tube(Assets.TUBE_DOWN);
        downTube.setName("TubeDown");
        downTube.setX(0.0f);
        downTube.setY(y - halfSpace, Align.top);
        setWidth(downTube.getWidth());
        setHeight(downTube.getHeight() + upTube.getHeight() + space);
        maxY = Math.min(stage.getHeight() - halfSpace, downTube.getHeight() + halfSpace);
        minY = Math.max(halfSpace, stage.getHeight() - upTube.getHeight() - halfSpace);
        addActor(upTube);
        addActor(downTube);
    }

    public List<Tube> getTubes(){
        return List.of(upTube, downTube);
    }

    public float getMaxY() {
        return maxY;
    }

    public float getMinY() {
        return minY;
    }
}
