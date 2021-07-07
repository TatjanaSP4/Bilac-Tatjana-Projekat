package drawing;

public class Test {

	public static void main(String[] args) {
		Point p = new Point(5, 5, false);
		System.out.println(p);
		
		
		Line l1 = new Line(new Point(1,2), new Point(3,4), false);
		System.out.println(l1);
		
		Rectangle r = new Rectangle(new Point(5,5), 100, 200, false);
		System.out.println(r);
		
		Circle c = new Circle(new Point(1,2), 10, false);
		System.out.println(c);
		
		Donut d = new Donut(new Point(1,1), 100, 200, false);
		System.out.println(d);
	}

}
