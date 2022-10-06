/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shapes;

/**
 *
 * @author dw
 */
public class Rectangle extends Polygon {
    private int length = 0;
    private int width = 0;

    public Rectangle(int length, int width)
    {
        this.length = length;
        this.width = width;
    }
    
    @Override
    public double Area()
    {
        return length * width;        
    }
    
    public int Length()
    {
        return length;        
    }
    
    public int Width()
    {
        return width;        
    }

    public int Sides()
    {
        return 4;
    }

    public String Name()
    {
        return "Rectangle";
    }
}
