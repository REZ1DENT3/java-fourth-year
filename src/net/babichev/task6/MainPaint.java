package net.babichev.task6;

import javax.swing.*;
import java.awt.*;

public class MainPaint extends JApplet {

    /**
     * Rect+
     */
    private int x1, x2, y1, y2;
    private int n, m;

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
    }

    private int getR(int d1, int d2) {
        return Math.abs(d1 - d2);
    }

    public void paint(Graphics graphics) {
        this.paint((Graphics2D) graphics);
    }

    void triangle(Graphics graphics) {
        graphics.drawLine(u1, v1, u2, v2);
        graphics.drawLine(u2, v2, u3, v3);
        graphics.drawLine(u3, v3, u1, v1);
        graphics.fillPolygon(new int[]{u1, u2, u3}, new int[]{v1, v2, v3}, 3);
    }

    public void paint(Graphics2D graphics) {

        graphics.setColor(Color.black);

//        graphics.drawLine(10, 20, 50, 160);
//        graphics.drawRect(60, 60, 160, 160);
//        graphics.fillRect(60, 60, 160, 160);

        graphics.drawRect(x1, y1, x2 - x1, y2 - y1);

        int rx = this.getR(x1, x2);
        int rxn = rx / (n + 1);

        int ry = this.getR(y1, y2);
        int rym = ry / (m + 1);

        for (int i = 1; i <= n; ++i) {
            graphics.drawLine(x1 + rxn * i, y1, x1 + rxn * i, y2);
        }

        for (int i = 1; i <= n; ++i) {
            graphics.drawLine(x1, y1 + rym * i, x2, y1 + rym * i);
        }

        this.triangle(graphics);

        

    }

}
