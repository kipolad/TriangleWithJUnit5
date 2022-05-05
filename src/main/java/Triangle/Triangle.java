/**
 * Created by Yulya Telysheva
 */
package Triangle;

public class Triangle {
    private int a;
    private int b;
    private int c;

    public Triangle() {
        this.a = 1;
        this.b = 1;
        this.c = 1;
    }

    public Triangle(int a, int b, int c) {
        if (a <= 0 || b <= 0 || c <= 0) throw new ArithmeticException("Side can't be less or equals than zero!");
        if (c >= (a + b) || b >= (a + c) || a >= (c + b))
            throw new ArithmeticException("Side can't be greater than the sum of the other two sides!");
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public int getC() {
        return c;
    }

    public void setC(int c) {
        this.c = c;
    }

    public int getPerimeter() {
        return a + b + c;
    }

    public double getSquare() {
        double pp = getPerimeter() * 1.0 / 2;
        double result = Math.sqrt(Math.abs(pp * (pp - a) * (pp - b) * (pp - c)));
        return reduceNum(result);
    }

    private double reduceNum(double number) {
        double scale = Math.pow(10, 2);
        return Math.ceil(number * scale) / scale;
    }
}
