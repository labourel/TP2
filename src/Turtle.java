import tp2.lib.Painter;

import java.awt.*;

import static tp2.lib.Tools.sleep;

/**
 * Created by Arnaud Labourel on 21/09/2018.
 */

public class Turtle {
    public static final int SLEEP_DURATION = 10;
    private Color penColor;
    private double angleDirection;
    private Point position;
    private boolean penIsDown;
    private Painter painter;


    public Turtle(int width, int height) {
        this.painter = new Painter(width, height);
        this.angleDirection = -90;
        penIsDown = true;
        position = new Point(width/2,height/2);
    }

    public void moveForward(double distance){
        sleep(SLEEP_DURATION);
        Point destination = new Point(distance, 0);
        destination = destination.rotate(angleDirection).translate(position.x, position.y);

        if(penIsDown){
            destination.drawLine(position, painter, penColor);
        }

        position = destination;
    }

    public void setColor(Color color){
        penColor = color;
    }

    public void turnLeft(double angle){
        angleDirection -= angle;
    }

    public void turnRight(double angle){
        angleDirection += angle;
    }

    public void setPenDown(){
        penIsDown = true;
    }

    public void setPenUp(){
        penIsDown = false;
    }


    public void applyChar(char character, double length, double angle){
        switch(character){
            case 'A': {
                moveForward(length);
                break;
            }
            case '+': {
                turnRight(angle);
                break;
            }
            case '-': {
                turnLeft(angle);
                break;
            }
        }
    }

    public void drawString(String sequence, double length, double angle){
        for(int index = 0; index < sequence.length(); index++)
            applyChar(sequence.charAt(index), length, angle);
    }
}
