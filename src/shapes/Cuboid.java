package shapes;

import java.awt.geom.Area;

public class Cuboid extends Rectangle
{
    private int height = 0;
    public Cuboid(int length, int width, int height)
    {
        super(length, width);
        this.height = height;
    }


    public double Area()
    {
        return 2 * (Length() * Width() + Length() * height + Width() * height);
    }

    public double Volume()
    {
        return super.Area() * height;
    }

    public int Height()
    {
        return height;
    }

    public String Name()
    {
        return "Cuboid";
    }
}
