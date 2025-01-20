package task3;

import java.util.ArrayList;

class Point {
    private float x; 
    private float y; 
    public Point(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public void changeCoords(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public void display() {
        System.out.println("(" + x + ", " + y + ")");
    }
}

class  Polygon {
    private ArrayList<Point> points;

    public Polygon(int n) {
        points = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            points.add(new Point(0, 0));
        }
    }

    public Polygon(ArrayList<Float> coordinates) {
      
        int n = coordinates.size() / 2;
        points = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
      
            points.add(new Point(coordinates.get(2 * i), coordinates.get(2 * i + 1)));
        }
    }

    public void displayPolygon() {
        
        for (Point p : points) {
            p.display();
        }
    }
}


