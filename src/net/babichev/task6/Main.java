package net.babichev.task6;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Scanner;

/**
 * 1.	Прямоугольная область задана координатами x1 y1,x2 y2 концов ее диагонали.
 *
 *      Область разбита на прямоугольники так, что одна сторона разбита на n, а другая на m отрезков.
 *
 *      В этой области задан треугольник вершинами u1 v1, u2 v2, u3 v3.
 *      Вычислить количество прямоугольников области, в которых лежит хотя бы одна точка треугольника.
 *
 *      Выделить искомые прямоугольники.
 */


public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        
        JFrame frame = new JFrame("Graph");
        JApplet app = new MainPaint();

        frame.getContentPane().add("Center", app);

        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        app.init();

        frame.pack();
        frame.setSize(300, 300);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }

}