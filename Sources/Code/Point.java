public class Point{

    public double x,y;

    public Point(double x, double y){
        this.x=x;
        this.y=y;
    }

    public double distanceTo(Point other){
        double xdif = x - other.x;
        double ydif = y - other.y;
        return Math.sqrt( xdif * xdif + ydif * ydif );
    }
}