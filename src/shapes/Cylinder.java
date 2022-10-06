package shapes;

public class Cylinder extends Circle
{
    private int height = 0;
    public Cylinder(int radius, int height) {
        super(radius);
        this.height = height;
    }

    public int Height()
    {
        return height;
    }

    @Override
    public double Area()
    {
        return 2 * Math.PI * Radius() * (Radius() + height);
    }

    public double Volume()
    {
        return super.Area() * height;
    }

    public String Name()
    {
        return "Cylinder";
    }
}
