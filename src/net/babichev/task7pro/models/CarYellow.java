package net.babichev.task7pro.models;

import javafx.beans.property.DoubleProperty;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import net.babichev.task7pro.Model;

public class CarYellow extends Model {

    public CarYellow(Canvas canvas, DoubleProperty x, DoubleProperty y, double pY) {
        super(canvas, x, y, pY);
    }

    @Override
    public void draw(GraphicsContext gc) {
        Image image = new Image("file:" + path + "/models/cars/yellow.png");
        this.drawImage(gc, image);
    }

    @Override
    public void f(int x, int y) {
        super.f(x, y);
        if (y == 0) return;
        x ^= y;
    }
}