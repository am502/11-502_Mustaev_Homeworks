package ru.itis.inform;

import java.util.ArrayList;

/**
 * Created by HP on 21.03.2016.
 */
public class Fast_Hull {

    public ArrayList<Point> Fast_Hull(ArrayList<Point> array){
        ArrayList<Point> result = new ArrayList<Point>();

        // Find left

        Point left = array.get(0);

        int min = array.get(0).getX();

        int indexoOfLeft = 0;

        for(int i = 0; i < array.size(); i++) {
            if (array.get(i).getX() < min) {
                min = array.get(i).getX();
                left = array.get(i);
                indexoOfLeft = i;
            }
        }

        result.add(left);

        array.remove(indexoOfLeft);

        // Find Right

        Point right = array.get(0);

        int max = array.get(0).getX();

        int indexoOfRight = 0;

        for(int i = 0; i < array.size(); i++) {
            if (array.get(i).getX() > max) {
                max = array.get(i).getX();
                right = array.get(i);
                indexoOfRight = i;
            }
        }

        result.add(right);

        array.remove(indexoOfRight);

        // Next Stage

        double max_square = square(left, array.get(0), right);

        Point current = array.get(0);

        int index = 0;

        for(int i = 0; i < array.size(); i++){
            if (square(left, array.get(i), right) > max_square) {
                max_square = square(left, array.get(i), right);
                current = array.get(i);
                index = i;
            }
        }

        result.add(current);

        array.remove(index);



        return result;
    }

    public double square(Point left, Point current, Point right){
        return Math.abs(0.5*((left.x - right.x)*(current.y - right.y) - (current.x - right.x)*(left.y - right.y)));
    }

    public int triangle_belong(Point p1, Point p2, Point p3, Point p) {
        int check = -1;

        double sign1 = (p1.x - p.x) * (p2.y - p1.y) - (p2.x - p1.x) * (p1.y - p.y);
        double sign2 = (p2.x - p.x) * (p3.y - p2.y) - (p3.x - p2.x) * (p2.y - p.y);
        double sign3 = (p3.x - p.x) * (p1.y - p3.y) - (p1.x - p3.x) * (p3.y - p.y);

        if(sign1 > 0 && sign2 > 0 && sign3 > 0 || sign1 < 0 && sign2 < 0 && sign3 < 0)
            check = 1;
        else if(sign1 == 0 || sign2 == 0 || sign3 == 0)
            check = 0;

        return check;
    }
}
