import tp2.lib.Painter;

import java.awt.*;

/**
 * Created by Arnaud Labourel on 15/10/2018.
 */
public class Triangle implements Shape {
    private final Point[] vertices;

    public Triangle(Point p1, Point p2, Point p3) {
        vertices = new Point[]{p1, p2, p3};
    }

    private Triangle(Point[] vertices){
        this.vertices = vertices;
    }

    @Override
    public double getPerimeter() {
        double sum = 0;
        for(int i=0; i<vertices.length; i++){
            sum += vertices[i].distanceTo(
                    vertices[(i+1)%vertices.length]);
        }
        return sum;
    }

    @Override
    public void draw(Painter painter, Color color) {
        for(int i=0; i<vertices.length; i++){
            vertices[i].drawLine(vertices[(i+1)%vertices.length],
                    painter, color);
        }
    }

    @Override
    public Shape translate(int dx, int dy) {
        Point[] vertices = new Point[3];
        for(int i=0; i<vertices.length; i++){
            vertices[i] = this.vertices[i].translate(dx, dy);
        }
        return new Triangle(vertices);
    }

    @Override
    public double getArea() {
        double p = getPerimeter()/2;
        double result = p;
        for(int i=0; i<vertices.length; i++){
            result *= p - vertices[i].distanceTo(
                    vertices[(i+1)%vertices.length]);
        }
        return Math.sqrt(result);
    }
}
