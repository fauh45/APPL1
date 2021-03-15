public class Cylinder extends Shape {
    private double radius;
    private double height;

    public Cylinder(double radius, double height) {
        super("Cylinder");

        this.radius = radius;
        this.height = height;
    }

    @Override
    public double area() {
        return Math.PI * Math.pow(this.radius, 2) * this.height;
    }

    @Override
    public String toString() {
        return super.toString() + " of radius " + this.height + " and height " + this.height;
    }

}
