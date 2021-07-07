package drawing;

import java.awt.Color;
import java.awt.Graphics;

public class Circle extends Shape {

	private Point center;
	private int radius;	
	
	public Circle() {
	}
	
	public Circle(Point center, int radius) {
		this.center = center;
		this.radius = radius;
	}
	
	public Circle(Point center, int radius, boolean selected) {
		this(center, radius);
		setSelected(selected);	
	}
	
	public Point getCenter() {
		return center;
	}
	
	public void setCenter(Point center) {
		this.center = center;
	}
	
	public int getRadius() {
		return radius;
	}
	
	public void setRadius(int radius) {
		this.radius = radius;
	}
	
	public String toString() {
		return "[" + center + " , radius= " + radius + " , " + super.isSelected() + "]";
	}

	@Override
	public int compareTo(Object o) {
		return 0;
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(getOutline());
		g.drawOval(this.getCenter().getX() - this.getRadius(),this.getCenter().getY() - this.getRadius(), this.getRadius()*2, this.getRadius()*2);
		if(isSelected() == true) {
			g.setColor(Color.black);
			g.drawRect(this.getCenter().getX() -3, this.getCenter().getY() - 3, 6, 6);
			g.drawRect(this.getCenter().getX() - 3, this.getCenter().getY() - this.getRadius() - 3, 6, 6);
			g.drawRect(this.getCenter().getX() -3, this.getCenter().getY() + this.getRadius() - 3, 6, 6);
			g.drawRect(this.getCenter().getX() - this.getRadius() - 3, this.getCenter().getY() - 3, 6, 6);
			g.drawRect(this.getCenter().getX() + this.getRadius() -3, this.getCenter().getY() -3, 6, 6);
		}
	}

	@Override
	public boolean contains(int x, int y) {
		return this.getCenter().distance(x, y) <= this.getRadius();
	}

	@Override
	public void move(int newX, int newY) {
		center.move(newX, newY);		
	}

	@Override
	public void DialogEdit() {
		DialogCircle dialogCircle = new DialogCircle();
		for (Shape shape : PnlDrawing.shapesList) {
			if (shape.isSelected()) {
				String[] split = shape.toString().split(" ");
				dialogCircle.getTxtXCoord().setText(split[1]);
				dialogCircle.getTxtYCoord().setText(split[4]);
				dialogCircle.getTxtRadius().setText(split[9]);
			}
		}
		dialogCircle.setVisible(true);		
	}

	@Override
	public void Fill(Graphics g) {
		g.setColor(getFill());
		g.fillOval(this.getCenter().getX() - this.getRadius(), this.getCenter().getY() - this.getRadius(), this.getRadius() * 2, this.getRadius() * 2);		
	}
	
}
