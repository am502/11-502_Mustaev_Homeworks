package ru.itis.inform;

import java.util.ArrayList;

public class Sort {
    public ArrayList<Point> ConvexHull(ArrayList<Point> array){
        ArrayList<Point> result = new ArrayList<Point>();

        Point p1 = array.get(0);

        int min = array.get(0).getY();
        int indexof1 = 0;

        for(int i = 1; i < array.size(); i++){
            if(min > array.get(i).getY() ) {
                p1 = array.get(i);
                min = array.get(i).getY();
                indexof1 = i;
            }
            else if(min == array.get(i).getY()){
                if(p1.x < array.get(i).getX()){
                    p1 = array.get(i);
                    min = array.get(i).getY();
                    indexof1 = i;
                }
            }
        }

        result.add(p1);

        // первый шаг

        double minPolarAngle = polar_angle(array.get(0), p1);
        int indexof2 = 0;

        for(int i = 0; i < array.size(); i++){
            if(i!=indexof1) {
                double polarAngle = polar_angle(array.get(i), p1);
                if (polarAngle < minPolarAngle) {
                    minPolarAngle = polarAngle;
                    indexof2 = i;
                }
            }
        }

        Point p2 = array.get(indexof2);

        result.add(p2);

        array.remove(indexof2);

        // второй шаг

        Point pim1 = p1;

        Point pi = p2;

        int index = 0;

        Point pip1 = array.get(0);

        while(pip1 != result.get(0) && array.size() != 0) {
            double min_angle = angle(pim1, pi, array.get(0));

            index = 0;

            for (int j = 0; j < array.size(); j++) {
                double cur_angle = angle(pim1, pi, array.get(j));
                if (cur_angle > min_angle) {
                    min_angle = cur_angle;
                    index = j;
                }
                else if(cur_angle == min_angle){
                    if(dlina(pi, array.get(j)) < dlina(pi, array.get(0))) {
                        min_angle = cur_angle;
                        index = j;
                    }
                }
            }
            pim1 = pi;

            pi = array.get(index);

            pip1 = array.get(index);

            array.remove(index);

            result.add(pip1);
        }

        return result;
    }

    public double polar_angle(Point p1, Point centre) {
        double angle = Math.atan2(p1.y - centre.y, p1.x - centre.x);
        if (angle < 0) angle += 2*Math.PI;
        return angle;
    }

    public double angle(Point pim1, Point pi, Point pip1){
        double x1 = pi.x - pim1.x;
        double y1 = pi.y - pim1.y;

        double x2 = pip1.x - pi.x;
        double y2 = pip1.y - pi.y;

        double result = 0.0;
        double angle = 0.0;
        double v1 = 0;
        double v2 = 0;

        if(x1*x2+y1*y2 == 0)
            angle = Math.PI/2;
        else {
            v1 = (x1 * x2 + y1 * y2);
            v2 = (Math.sqrt(x1 * x1 + y1 * y1) * Math.sqrt(x2 * x2 + y2 * y2));
            result = v1/v2;
            angle = Math.PI - Math.acos(result);
        }

        return angle;
    }

    public double dlina(Point p1, Point p2){
        return Math.sqrt((p2.x - p1.x)*(p2.x - p1.x)+(p2.y - p1.y)*(p2.y - p1.y));
    }
}
