/**
 * Created by Arnaud Labourel on 20/09/2018.
 */
import tp2.lib.Painter;

import java.awt.*;

public class Point {
    public final double x;
    public final double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    void draw(Painter painter, Color color){
        painter.addPoint(x,y,color);
    }

    void drawLine(Point p, Painter painter, Color color){
        painter.addLine(x, y, p.x, p.y, color);
    }

    public Point clone(){
        return new Point(x,y);
    }

    public Point translate(double dx, double dy){
        return new Point(x+dx, y+dy);
    }

    public Point rotate(double angle){
        double angleInRadian = (Math.PI * angle)/180;
        double rotatedX = x * Math.cos(angleInRadian) - y * Math.sin(angleInRadian);
        double rotatedY = x * Math.sin(angleInRadian) + y * Math.cos(angleInRadian);
        return new Point(rotatedX, rotatedY);
    }
    public double distanceTo(Point p){
        double dx = this.x - p.x;
        double dy = this.y - p.y;
        return Math.hypot(dx,dy);
    }
}
