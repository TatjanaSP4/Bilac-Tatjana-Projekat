package drawing;

import java.awt.Color;
import java.awt.Graphics;

public class Point extends Shape {

	private int x;
	private int y;	
	
	public Point() {

	}

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public Point(int x, int y, boolean selected) {
		this(x,y);
		setSelected(selected);
	}

	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	
	@Override
	public int compareTo(Object o) {
		return 0;
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(getOutline());
		g.drawLine(this.getX()-2, this.getY(), this.getX()+2, this.getY());
		g.drawLine(this.getX(), this.getY()-2, this.getX(), this.getY()+2);
		if(isSelected() == true) {
			g.setColor(Color.BLACK);
			g.drawRect(this.getX()-3, this.getY()-3, 6, 6);
		}
	}

	@Override
	public boolean contains(int x, int y) {
		return this.distance(x, y) <= 3;
	}

	public double distance(int x, int y) {
		double dx = this.x - x;
		double dy = this.y - y;
		double d = Math.sqrt(dx*dx+dy*dy);
		return d;
	}

	@Override
	public void move(int newX, int newY) {
		this.x = newX;
		this.y = newY;		
	}
	
	public String toString() {
		return "[x= " + x + " , y= " + y + " , " + isSelected() + "]";
	}
	
	@Override
	public void DialogEdit() {
		DialogPoint dialogPoint = new DialogPoint();
		for (Shape shape : PnlDrawing.shapesList) {
			if (shape.isSelected()) {
				String[] split = shape.toString().split(" ");
				dialogPoint.getTxtXCoord().setText(split[1]);
				dialogPoint.getTxtYCoord().setText(split[4]);
			}
		}
		dialogPoint.setVisible(true);
	}

	@Override
	public void Fill(Graphics g) {		
	}
	
}
