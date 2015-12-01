package net.babichev.task6;

import javax.swing.*;
import java.awt.*;

public class MainPaint extends JApplet {

    /**
     * Rect+
     */
    private int x1, x2, y1, y2;
    private int n, m;
    private int width, height;

    /**
     * triangle
     */
    private int u1, v1, u2, v2, u3, v3;

    public MainPaint(int[] data) {
        this.x1 = data[0];
        this.y1 = data[1];
        this.x2 = data[2];
        this.y2 = data[3];
        this.n = data[4];
        this.m = data[5];
        this.u1 = data[6];
        this.v1 = data[7];
        this.u2 = data[8];
        this.v2 = data[9];
        this.u3 = data[10];
        this.v3 = data[11];
        this.width = data[12];
        this.height = data[13];
    }

    private int getR(int d1, int d2) {
        return Math.abs(d1 - d2);
    }

    public void paint(Graphics graphics) {
        this.paint((Graphics2D) graphics);
    }

    void triangle(Graphics graphics) {
        graphics.fillPolygon(new int[]{u1, u2, u3}, new int[]{v1, v2, v3}, 3);
    }

    public void paint(Graphics2D graphics) {

//        graphics.drawLine(10, 20, 50, 160);
//        graphics.drawRect(60, 60, 160, 160);
//        graphics.fillRect(60, 60, 160, 160);

        graphics.setColor(Color.WHITE);
        graphics.fillRect(0, 0, width, height);

        graphics.setColor(Color.black);
        graphics.drawRect(x1, y1, x2 - x1, y2 - y1);

        int rx = this.getR(x1, x2);
        int rxn = rx / (n);

        int ry = this.getR(y1, y2);
        int rym = ry / (m);

        for (int i = 1; i < n; ++i) {
            graphics.drawLine(x1 + rxn * i, y1, x1 + rxn * i, y2);
        }

        for (int i = 1; i < m; ++i) {
            graphics.drawLine(x1, y1 + rym * i, x2, y1 + rym * i);
        }

        graphics.setColor(Color.blue);
        this.triangle(graphics);

        int maxTU = Math.min(Math.max(u1, Math.max(u2, u3)), x2);
        int minTU = Math.max(Math.min(u1, Math.min(u2, u3)), x1);
//        System.out.println("MaxTU: " + maxTU + " MinTU: " + minTU);

        int maxTV = Math.min(Math.max(v1, Math.max(v2, v3)), y2);
        int minTV = Math.max(Math.min(v1, Math.min(v2, v3)), y1);
//        System.out.println("MaxTV: " + maxTV + " MinTV: " + minTV);

//        For debug
//        graphics.setColor(Color.red);
//        graphics.drawRect(minTU, minTV, maxTU - minTU, maxTV - minTV);

        int[][] matrix = new int[m + 1][n + 1];
        int sum = 0;
        for (int i = minTU; i <= maxTU; ++i) {
            for (int j = minTV; j <= maxTV; ++j) {
                if (matrix[s(j, y1, rym) - 1][s(i, x1, rxn) - 1] != 0) continue;
                matrix[s(j, y1, rym) - 1][s(i, x1, rxn) - 1] = test(i, j) ? 1 : 0;
            }
        }

        graphics.setColor(Color.ORANGE);
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (matrix[i][j] == 1) {
                    sum += 1;
                    graphics.drawRect(x1 + rxn * j, y1 + rym * i, rxn, rym);
                }
            }
        }

        graphics.setColor(Color.BLACK);
        graphics.drawString("quantity of rectangles: " + sum, 100, 40);

    }

    protected int s(int l, int ll, int size) {
        int d = l - ll;
        int d2 = d / size;
        int d1 = d % size;
        return d1 == 0 ? d2 : d2 + 1;
    }

    private boolean test(int x, int y) {
        double k = (u1 - x) * (v2 - v1) - (u2 - u1) * (v1 - y);
        double m = (u2 - x) * (v3 - v2) - (u3 - u2) * (v2 - y);
        double n = (u3 - x) * (v1 - v3) - (u1 - u3) * (v3 - y);
        return (k >= 0 && m >= 0 && n >= 0) || (k <= 0 && m <= 0 && n <= 0);
    }

}
