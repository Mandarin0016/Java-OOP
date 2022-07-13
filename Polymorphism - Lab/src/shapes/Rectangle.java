package shapes;

public class Rectangle extends Shape {
    private Double height;
    private Double width;

    public Rectangle(Double height, Double width) {
        this.height = height;
        this.width = width;
        calculateArea();
        calculatePerimeter();
    }

    public Double getHeight() {
        return height;
    }

    public Double getWidth() {
        return width;
    }

    @Override
    protected void calculatePerimeter() {
        super.setPerimeter(2 * (this.height + this.width));
    }

    @Override
    protected void calculateArea() {
        super.setArea(this.width * this.height);
    }
}
