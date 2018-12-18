import tp2.lib.Painter;

import java.awt.*;

/**
 * Created by Arnaud Labourel on 15/10/2018.
 */
public interface Shape {
    double getPerimeter();
    void draw(Painter painter, Color color);
    Shape translate(int dx, int dy);
    double getArea();
}
