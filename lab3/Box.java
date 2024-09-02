class Box{
	private double length;
	private double width;
	private double height;

	Box(){

	}

	Box(double l, double w, double h){
		this.length=l;
		this.width=w;
		this.height=h;
	}

	double getLength() {
        return length;
    }


    double getWidth() {
        return width;
    }


    double getHeight() {
        return height;
    }

	double getSurfaceArea(){
		double area= 2*((length*width)+(length*height)+(width*height));
		return area;
	}

	int compareTo(Box b){
		double surface1 = this.getSurfaceArea();
		double surface2 = b.getSurfaceArea();

		if(surface1<surface2){
			return 1;
		}

		if(surface1>surface2){
			return -1;
		}

		else {
			return 0;
		}
	}
}