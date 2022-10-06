package shapes;

public class Circle extends Shape
{
    private int radius;
    public Circle(int radius)
    {
        this.radius = radius;
    }

    public int Radius()
    {
        return radius;
    }

    public double Area()
    {
        return Math.PI * (radius * radius);
    }

    public String Name()
    {
        return "Circle";
    }
}
