/**
 * Created by Arnaud Labourel on 20/09/2018.
 */

import tp2.lib.Painter;

import java.awt.Color;
import java.util.Random;

import static tp2.lib.Tools.sleep;

public class Main {
    static final int WIDTH = 800;
    static final int HEIGHT = 600;

    private static void drawFractale(){
        int width = 590, height = 580, nbIterations = 4;
        Turtle turtle = new Turtle(width, height);

        // Déplacement de la tortue en bas à gauche.
        turtle.setPenUp();
        turtle.turnLeft(90); turtle.moveForward(width/2-10);
        turtle.turnLeft(90); turtle.moveForward(height/2-10);
        turtle.turnLeft(180);
        turtle.setPenDown();

        // Définition des règles
        Rule[] rules = { new Rule('X', "XAYAX+A+YAXAY-A-XAYAX"),
                new Rule('Y', "YAXAY-A-XAYAX+A+YAXAY") };
        SetOfRules setOfRules = new SetOfRules(rules);

        // Application des règles nbIterations fois
        String sequence = "X";
        for (int i = 0; i < nbIterations; i++)
            sequence = setOfRules.apply(sequence);

        // Dessin de la séquence par la tortue
        turtle.drawString(sequence, 7, 90);
    }

    public static void drawSquare(Turtle turtle, int size) {
        for (int i = 0; i < 4; i++) {
            turtle.moveForward(size);
            turtle.turnLeft(90);
        }
    }

    public static void main(String[] args){
        Random random= new Random();
        Painter painter = new Painter(WIDTH, HEIGHT);

        Point p1 = new Point(100,100);
        Point p2 = new Point(200,100);
        Point p3 = new Point(100,300);

        Shape r = new Rectangle(p2, p3);
        r.draw(painter, Color.black);

        for(int i =30; i<400; i+=30) {
            Shape t2 = r.translate(i, i);
            sleep(100);
            t2.draw(painter, new Color(random.nextFloat(),
                    random.nextFloat(), random.nextFloat()));
        }
/*
        Turtle turtle = new Turtle(800,600);
        turtle.setColor(Color.black);
        int n = 20;
        for (int i = 0; i < n; i++) {
            turtle.turnRight(360.0/n);
            drawSquare(turtle, 100);
        }
*/
        //drawCircleAndDiameters(50);
        //drawFractale();
    }

    private static void drawWithSequence() {
        Turtle turtle = new Turtle(WIDTH,HEIGHT);
        turtle.setColor(Color.black);
        turtle.drawString("A+A+A+A", 100, 90);
    }

    private static void drawWithTurtle() {
        Turtle turtle = new Turtle(WIDTH,HEIGHT);
        turtle.setColor(Color.black);
        int n = 20;
        for (int i = 0; i < n; i++) {
            turtle.turnRight(360.0/n);
            drawSquare(turtle, 100);
        }
    }

    private static void drawCircleAndDiameters(int nbPoints) {

        final int NB_POINTS = 10;
        Painter painter = new Painter(WIDTH, HEIGHT);

        Point[] points = new Point[nbPoints];

        createPoints(points);

        drawDiameters(nbPoints, painter, points);

        drawCircle(nbPoints, painter, points);

        drawPoints(painter, points);

    }

    private static void drawPoints(Painter painter, Point[] points) {
        for(int index = 0; index < points.length; index++){
            points[index].draw(painter, Color.red);
        }
    }

    private static void drawCircle(int NB_POINTS, Painter painter, Point[] points) {
        for(int index = 0; index < points.length; index++){
            points[index].drawLine(points[(index+1)%NB_POINTS], painter, Color.black);
        }
    }

    private static void drawDiameters(int NB_POINTS, Painter painter, Point[] points) {
        for(int index = 0; index < points.length/2; index++){
            points[index].drawLine(points[index+NB_POINTS/2], painter, Color.blue);
        }
    }

    private static void createPoints(Point[] points) {
        points[0] = new Point(-180, 0);

        for(int index = 1; index < points.length; index++){
            points[index] = points[index-1].rotate(360.0/points.length);
        }

        for(int index = 0; index < points.length; index++){
            points[index] = points[index].translate(WIDTH/2, HEIGHT/2);
        }
    }
}
