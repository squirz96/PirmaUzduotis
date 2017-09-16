public class Solver {
    //Kvadratiniu lygciu sprendimas;
    private int a, b, c; // Pilna kvadratine lygtis yra ax^2+bx+c = 0
    private double x1, x2 = 0; // Galimi sprendimai
    private double x; // Kai Diskriminantas == 0

    public double getX() {
        x = -b / 2 * a;
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    private int d; // Diskriminantas

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

    public double getX1() {

        x1 = (-b + Math.sqrt(d)) / (2 * a);
        return x1;
    }

    public void setX1(int x1) {
        this.x1 = x1;
    }

    public double getX2() {
        x2 = (-b - Math.sqrt(d)) / (2 * a);
        return x2;
    }

    public void setX2(int x2) {
        this.x2 = x2;
    }

    public int getD() {

        d = (int) Math.pow(b, 2) - 4 * a * c;
        return d;
    }

    public void setD(int d) {
        this.d = d;
    }

    public Solver(int a, int b, int c) {

        this.a = a;
        this.b = b;
        this.c = c;
        if (getD() < 0)
            System.out.println("Kvadratine lygtis sprendimu neturi");
        else if (getD() == 0)
            System.out.println("Kvadratines lygties sprendinys: " + getX());
        else {
            System.out.println("Kvadratines lygties pirmasis  sprendinys: " + getX1());
            System.out.println("Kvadratines lygties antrasis sprendinys: " + getX2());
        }
    }

}
