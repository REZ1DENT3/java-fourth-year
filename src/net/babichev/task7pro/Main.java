package net.babichev.task7pro;

import javafx.animation.*;
import javafx.application.Application;
import javafx.beans.property.*;
import javafx.scene.*;
import javafx.scene.canvas.*;
import javafx.stage.Stage;
import javafx.util.Duration;

import net.babichev.task7pro.models.*;

/**
 * 13. реализовать программу гонки
 *      с использованием потока и
 *      оконного интерфейса
 */

public class Main extends Application {

    public static final double w = 640;
    public static final double h = 480;

    public final long getIndex(long a, long b, long c, long d) {
        long sum = 0;
        sum += (a > b) ? 1 : 0;
        sum += (a > c) ? 1 : 0;
        sum += (a > d) ? 1 : 0;
        return sum;
    }

    public long sum(long[] a) {
        long sum = 0;
        for (int i = 0; i < a.length; ++i) {
            sum += a[i];
        }
        return sum;
    }

    public long[][] considerResults(long[] a, long[] b, long[] c, long[] d) {
        long[][] results = new long[4][a.length];
        for (int i = 0; i < a.length; ++i) {
            results[0][i] = getIndex(a[i], b[i], c[i], d[i]);
            results[1][i] = getIndex(b[i], a[i], c[i], d[i]);
            results[2][i] = getIndex(c[i], a[i], b[i], d[i]);
            results[3][i] = getIndex(d[i], a[i], b[i], c[i]);
        }
//        for (int i = 0; i < 4; ++i) {
//            for (int j = 0; j < a.length; ++j) {
//                System.out.print(results[i][j] + " ");
//            }
//            System.out.println();
//        }
        return results;
    }

    @Override
    public void start(Stage stage) throws InterruptedException {

        stage.setTitle("Task 7");

        DoubleProperty x = new SimpleDoubleProperty();
        DoubleProperty y = new SimpleDoubleProperty();

        final Canvas canvas = new Canvas(w, h);

        Timeline timeline = new Timeline(
                new KeyFrame(Duration.seconds(0),
                        new KeyValue(x, 0),
                        new KeyValue(y, 0)
                ),
                new KeyFrame(Duration.seconds(15),
                        new KeyValue(x, -4 * w),
                        new KeyValue(y, 0)
                )
        );

//        timeline.setAutoReverse(true);
//        timeline.setCycleCount(Timeline.INDEFINITE);

        // init winner

        CarRoute carRouteRed = new CarRoute(new CarRed(canvas, x, y, 135.));
        carRouteRed.start();

        CarRoute carRouteYellow = new CarRoute(new CarYellow(canvas, x, y, 195.));
        carRouteYellow.start();

        CarRoute carRouteOrange = new CarRoute(new CarOrange(canvas, x, y, 265.));
        carRouteOrange.start();

        CarRoute carRouteBlue = new CarRoute(new CarBlue(canvas, x, y, 320.));
        carRouteBlue.start();

        while (carRouteRed.isAlive() ||
                carRouteYellow.isAlive() ||
                carRouteOrange.isAlive() ||
                carRouteBlue.isAlive()) ;

        long[][] consider = considerResults(
                carRouteRed.getDimensions(),
                carRouteYellow.getDimensions(),
                carRouteOrange.getDimensions(),
                carRouteBlue.getDimensions()
        );

        carRouteRed.getCar().setDimensions(consider[0]);
        carRouteYellow.getCar().setDimensions(consider[1]);
        carRouteOrange.getCar().setDimensions(consider[2]);
        carRouteBlue.getCar().setDimensions(consider[3]);

        long crr = sum(consider[0]);
        long cyr = sum(consider[1]);
        long cor = sum(consider[2]);
        long cbr = sum(consider[3]);

        long crp = getIndex(crr, cyr, cor, cbr) + 1;
        long cyp = getIndex(cyr, crr, cor, cbr) + 1;
        long cop = getIndex(cor, crr, cyr, cbr) + 1;
        long cbp = getIndex(cbr, crr, cyr, cor) + 1;

        System.out.println(carRouteRed.getCar().getClass() + " take place: " + crp);
        System.out.println(carRouteYellow.getCar().getClass() + " take place: " + cyp);
        System.out.println(carRouteOrange.getCar().getClass() + " take place: " + cop);
        System.out.println(carRouteBlue.getCar().getClass() + " take place: " + cbp);

        // animationTimer

        AnimationTimer timerTrack = new Track(canvas, x, y, 0.);

        AnimationTimer timerCarBlue = carRouteBlue.getCar();
        AnimationTimer timerCarRed = carRouteRed.getCar();
        AnimationTimer timerCarYellow = carRouteYellow.getCar();
        AnimationTimer timerCarOrange = carRouteOrange.getCar();

        carRouteBlue.join();
        carRouteRed.join();
        carRouteYellow.join();
        carRouteOrange.join();

        Group group = new Group(canvas);
        Scene scene = new Scene(group);

        stage.setScene(scene);
        stage.show();

        timerTrack.start();

        timerCarBlue.start();
        timerCarRed.start();
        timerCarYellow.start();
        timerCarOrange.start();

        timeline.play();

    }

    public static void main(String[] args) {
        launch(args);
    }
}