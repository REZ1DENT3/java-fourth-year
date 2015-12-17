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
        Image image = new Image("file:///D:/dev/java/simple/src/net/babichev/task7pro/cars/yellow.png");
        this.drawImage(gc, image);
    }

    public void f(int x, int y) {
        if (y == 0) return;
        x ^= y;
    }
}