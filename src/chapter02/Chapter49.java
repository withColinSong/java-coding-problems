package chapter02;

final class Point {
    private final double x;
    private final double y;
    private final Radius radius;

    public Point(double x, double y, Radius radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public Radius getRadius() {
        return radius;
    }
}

final class PointImmutable {
    private final double x;
    private final double y;
    private final Radius radius;

    public PointImmutable(double x, double y, Radius radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public Radius getRadius() {
        Radius clone = new Radius();
        clone.setStart(radius.getStart());
        clone.setEnd(radius.getEnd());
        return clone;
    }
}

class Radius {
    private int start;
    private int end;

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    @Override
    public String toString() {
        return "Radius{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }
}
/**
 * 불변 클래스 작성
 */
public class Chapter49 {
    public static void main(String[] args) {

        ////////////
        //// 가변 객체
        ////////////
        Radius r = new Radius();
        r.setStart(0);
        r.setEnd(120);

        Point p = new Point(1.23, 4.12, r);
        System.out.println("redis start :" + p.getRadius().getStart()); // 0
        p.getRadius().setStart(5);
        System.out.println("redis start :" + p.getRadius().getStart()); // 5

        PointImmutable pointImmutable = new PointImmutable(1.23, 4.12, r);
        System.out.println("redis start :" + pointImmutable.getRadius().getStart());   // 5
        pointImmutable.getRadius().setStart(10);
        System.out.println("redis start :" + pointImmutable.getRadius().getStart());   // 5

    }
}
