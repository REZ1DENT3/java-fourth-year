package net.babichev.task7pro;

import javafx.animation.AnimationTimer;
import javafx.beans.property.DoubleProperty;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.nio.file.Path;
import java.nio.file.Paths;

interface IModel {
    public void draw(GraphicsContext gc);
    public void f(int x, int y);
}

public abstract class Model extends AnimationTimer implements IModel {

    protected Canvas canvas;
    protected DoubleProperty positionX, positionY;
    protected double sum;
    protected long[] dimensions;
    protected double pY;
    protected int ind;
    protected double x0;

    protected String path;

    public Model(Canvas canvas, DoubleProperty x, DoubleProperty y, double pY) {
        this.canvas = canvas;
        this.positionX = x;
        this.positionY = y;
        this.pY = pY;
        ind = 0;
        sum = 0.;
        x0 = 0.;

        Path currentRelativePath = Paths.get("");
        path = currentRelativePath.toAbsolutePath().toString();
    }

    public void setDimensions(long[] dimensions) {
        this.dimensions = dimensions;
    }

    public double getWidth() {
        return this.canvas.getWidth();
    }

    public double getHeight() {
        return this.canvas.getHeight();
    }

    @Override
    public void handle(long now) {
        this.draw(canvas.getGraphicsContext2D());
    }

    protected void drawImage(GraphicsContext gc, Image image) {
        if (dimensions.length > ind) {
            sum = sum - dimensions[ind++];
        }
        else if (sum < 0) {
            sum++;
        }

        if (x0 < (-positionX.doubleValue() + sum))
            x0 = -positionX.doubleValue() + sum;

        gc.drawImage(image, x0 / (5 * getWidth()) * getWidth(), pY, 60., 30.);
    }

}
