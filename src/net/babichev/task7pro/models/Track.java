package net.babichev.task7pro.models;

import javafx.beans.property.DoubleProperty;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import net.babichev.task7pro.Model;

public class Track extends Model {

    public Track(Canvas canvas, DoubleProperty x, DoubleProperty y, double pY) {
        super(canvas, x, y, pY);
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.setFill(Color.CORNSILK);

        Image track = new Image("file:" + path + "/models/track.png");
        gc.drawImage(track, positionX.doubleValue(), positionY.doubleValue(), getWidth() * 5, getHeight());

        gc.setFill(Color.GOLD);
        gc.fillRect(getWidth() * 5 + positionX.doubleValue() - 140
                , getHeight() / 4, 8, getHeight() / 2);
    }

    public void f(int x, int y) {}

}