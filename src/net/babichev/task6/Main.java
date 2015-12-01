package net.babichev.task6;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Scanner;

/**
 * 1.	Прямоугольная область задана координатами x1 y1,x2 y2 концов ее диагонали.
 * <p>
 * Область разбита на прямоугольники так, что одна сторона разбита на n, а другая на m отрезков.
 * <p>
 * В этой области задан треугольник вершинами u1 v1, u2 v2, u3 v3.
 * Вычислить количество прямоугольников области, в которых лежит хотя бы одна точка треугольника.
 * <p>
 * Выделить искомые прямоугольники.
 */


public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int x1, x2, y1, y2;
        int n, m;
        int u1, u2, u3;
        int v1, v2, v3;

        /** input
         * 60 60
         * 300 300
         * 10 8
         * 110 120
         * 105 160
         * 135 190
         */

        System.out.print("dot qPoint1(x, y): ");
        x1 = scanner.nextInt();
        y1 = scanner.nextInt();

        System.out.print("dot qPoint2(x, y): ");
        x2 = scanner.nextInt();
        y2 = scanner.nextInt();

        System.out.print("n, m: ");
        n = scanner.nextInt();
        m = scanner.nextInt();

        System.out.print("dot tPoint1(u, v): ");
        u1 = scanner.nextInt();
        v1 = scanner.nextInt();

        System.out.print("dot tPoint2(u, v): ");
        u2 = scanner.nextInt();
        v2 = scanner.nextInt();

        System.out.print("dot tPoint3(u, v): ");
        u3 = scanner.nextInt();
        v3 = scanner.nextInt();

        int width = 380, height = 400;

        JFrame frame = new JFrame("Graph");
        JApplet app = new MainPaint(new int[]{x1, y1, x2, y2, n, m, u1, v1, u2, v2, u3, v3, width, height});

        Container container = frame.getContentPane();

        container.add("Center", app);

        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        app.init();

        frame.pack();
        frame.setSize(width, height);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        frame.setBackground(Color.WHITE);

    }

}