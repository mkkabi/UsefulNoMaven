package Adapter;

/*Calculate the area of a Adapter.Triangle using CalculatorAdapter. Please note here: this time our
input is a Adapter.Triangle.*/
public class CalculatorAdapter {
    Calculator calculator;
    Triangle triangle;

    public double getArea(Triangle t) {
        calculator = new Calculator();
        triangle = t;
        Rect r = new Rect();
//Area of Adapter.Triangle=0.5*base*height
        r.l = triangle.b;
        r.w = 0.5 * triangle.h;
        return calculator.getArea(r);
    }
}
