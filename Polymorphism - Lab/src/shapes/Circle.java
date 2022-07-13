package shapes;

public class Circle extends Shape {
    private Double radius;

    public Circle(Double radius) {
        this.radius = radius;
        calculateArea();
        calculatePerimeter();
    }

    public final Double getRadius() {
        return radius;
    }

    @Override
    protected void calculatePerimeter() {
        super.setPerimeter(2 * Math.PI * this.radius);
    }

    @Override
    protected void calculateArea() {
        super.setArea(Math.PI * Math.pow(this.radius, 2));
    }
}
