class circleTest{
	public static void main(String[] args){

		Circle a = new Circle(9);
		Circle b = new Circle(4);
		Circle c = new Circle(13);
		Circle d = new Circle(2);
		Circle e = new Circle(1);

		a.next = b;
		b.next = c;
		c.next = d;
		d.next = e;

		System.out.println(countLarger(a,b));

	}

	static int countLarger(Circle head, Circle given){
		int count=0;
		while(head!=null){
			if(given.getArea()<head.getArea()){
				count++;
				head=head.next;
			}
		}
		return count;
	}
}