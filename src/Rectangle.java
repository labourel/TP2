import tp2.lib.Painter;

import java.awt.*;

/**
 * Created by Arnaud Labourel on 17/10/2018.
 */
public class Rectangle implements Shape{
    Point p1, p2;
    public Rectangle(Point p1, Point p2){
        this.p1 = p1;
        this.p2 = p2;
    }

    private int height(){
        return Math.round(Math.abs((int)p1.y-(int)p2.y));
    }

    private int width(){
        return Math.round(Math.abs((int)p1.x-(int)p2.x));
    }


    @Override
    public double getPerimeter() {
        return 2*width() + 2*height();
    }

    @Override
    public void draw(Painter painter, Color color) {
        int maxX = (int)Math.max(Math.round(p1.x), Math.round(p2.x));
        int maxY = (int)Math.max(Math.round(p1.y), Math.round(p2.y));
        int minX = (int)Math.min(Math.round(p1.x), Math.round(p2.x));
        int minY = (int)Math.min(Math.round(p1.y), Math.round(p2.y));
        Point [] vertices = new Point[]{
                new Point(maxX, maxY),
                new Point(maxX, minY),
                new Point(minX, minY),
                new Point(minX, maxY)
        };
        for(int i=0; i<vertices.length; i++){
            vertices[i].drawLine(vertices[(i+1)%vertices.length],
                    painter, color);
        }
    }

    @Override
    public Shape translate(int dx, int dy) {
        return new Rectangle(p1.translate(dx, dy),
                p2.translate(dx, dy));
    }

    @Override
    public double getArea() {
        return width() * height();
    }
}
