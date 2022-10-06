/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shapes;


import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;


/**
 *
 * @author dw
 */
public abstract class Shape {
    public abstract double Area();
    public abstract String Name();
      /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        ArrayList<Shape> shapes = new ArrayList<Shape>();
        boolean quit = false;
        do
        {
            String name;
            switch (inputShapeChoice())
            {
                case 1:
                    name = "rectangle";
                    Rectangle rectangle = new Rectangle(inputDimension(name, "length"),
                                                        inputDimension(name, "width"));
                    shapes.add(rectangle);
                    printAttributes(rectangle);
                    break;
                case 2:
                    name = "circle";
                    Circle circle = new Circle(inputDimension(name, "radius"));
                    shapes.add(circle);
                    printAttributes(circle);
                    break;
                case 3:
                    name = "cylinder";
                    Cylinder cylinder = new Cylinder(inputDimension(name, "radius"),
                                                     inputDimension(name, "height"));
                    shapes.add(cylinder);
                    printAttributes(cylinder);
                    break;
                case 4:
                    name = "cuboid";
                    Cuboid cuboid = new Cuboid(inputDimension(name,"length"),
                                               inputDimension(name, "width"),
                                               inputDimension(name, "height"));
                    shapes.add(cuboid);
                    printAttributes(cuboid);
                    break;
                default:
                    quit = true;
            }
        } while (!quit);

        if (shapes.size() > 0) //Array could be empty
        {
            int largestAreaIndex = 0;
            for (int i = 0; i < shapes.size(); i++)
            {
                if (shapes.get(i).Area() > shapes.get(largestAreaIndex).Area())
                {
                    largestAreaIndex = i;
                }
            }
            System.out.println("Here is the shape with the largest area: ");
            printAttributes(shapes.get(largestAreaIndex));
        }
    }

    static int inputShapeChoice()
    {
        Scanner userInput = new Scanner(System.in);
        System.out.println("Select your shape (-1 to quit):");
        System.out.println("1 - Rectangle");
        System.out.println("2 - Circle");
        System.out.println("3 - Cylinder");
        System.out.println("4 - Cuboid");
        try
        {
            int shapeChoice = userInput.nextInt();
            if (shapeChoice == -1 || (shapeChoice >= 1 && shapeChoice <= 4))
            {
                return shapeChoice;
            } else
            {
                System.out.println("Enter a choice between 1 and 4! (-1 to quit)");
                return inputShapeChoice();
            }
        }
        catch (InputMismatchException e)
        {
            System.out.println("Enter an integer!");
            return inputShapeChoice();
        }
    }

    static int inputDimension(String shapeName, String dimensionName)
    {
        Scanner userInput = new Scanner(System.in);
        System.out.print("Please enter the "+dimensionName+" of the "+shapeName+": ");
        try
        {
            int dimension = userInput.nextInt();
            if (dimension > 0)
            {
                return dimension;
            }
            else
            {
                System.out.println("The "+dimensionName+" of a "+shapeName+" must be positive!");
                return inputDimension(shapeName, dimensionName);
            }
        }
        catch (InputMismatchException e)
        {
            System.out.println("The "+dimensionName+" of a "+shapeName+" must be an integer!");
            return inputDimension(shapeName, dimensionName);
        }
    }

    static void printAttributes(Shape shape)
    {
        System.out.println("----------SHAPE DETAILS----------");
        System.out.println("Name: "+shape.Name());
        if (shape instanceof Polygon)
        {//Printout the Polygon attributes

            if (shape instanceof Rectangle)
            {// Print out the Rectangle attributes
                System.out.println("Length: " + ((Rectangle)shape).Length());
                System.out.println("Width: " + ((Rectangle)shape).Width());
            }
            if (shape instanceof Cuboid)
            {
                System.out.println("Height: " + ((Cuboid)shape).Height());
                System.out.println("Volume: " + ((Cuboid)shape).Volume());
            }
        }
        else if (shape instanceof Circle)
        {
            System.out.println("Radius: "+((Circle)shape).Radius());
            if (shape instanceof Cylinder)
            {
                System.out.println("Height: "+((Cylinder)shape).Height());
                System.out.println("Volume: "+((Cylinder)shape).Volume());

            }
        }
        System.out.println("Area: " + shape.Area());
        System.out.println();
    }
}
