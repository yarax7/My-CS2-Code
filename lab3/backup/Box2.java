public class Box {
    private double length;
    private double width;
    private double height;


    public Box(double length, double width, double height) {
        this.length = length;
        this.width = width;
        this.height = height;
    }


    public double getLength() {
        return length;
    }


    public double getWidth() {
        return width;
    }


    public double getHeight() {
        return height;
    }


    public double getSurfaceArea() {
        return 2 * (length * width + length * height + width * height);
    }


    public int compareTo(Box b) {
        double surface1 = this.getSurfaceArea();
        double surface2 = b.getSurfaceArea();
       
        if (surface1 < surface2) {
            return -1;
        } else if (surface1 > surface2) {
            return 1;
        } else {
            return 0;
        }
    }
}