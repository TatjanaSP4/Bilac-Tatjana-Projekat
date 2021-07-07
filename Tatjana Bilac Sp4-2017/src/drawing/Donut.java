package drawing;

import java.awt.Color;
import java.awt.Graphics;

public class Donut extends Circle {

	private int innerRadius;

	public Donut() {
		
	}
	
	public Donut(Point center,int radius, int innerRadius) {
		super(center,radius);
		this.innerRadius = innerRadius;
	}
	
	public Donut(Point center, int radius, int innerRadius, boolean selected) {
		this(center,radius,innerRadius);
		setSelected(selected);
	}
	
	public boolean contains(int x, int y) {
		return super.contains(x, y) && this.getCenter().distance(x, y) >= this.getInnerRadius();
	}
	
	public void draw(Graphics g) {
		super.draw(g);
		g.setColor(getOutline());
		g.drawOval(this.getCenter().getX() - this.getInnerRadius(), this.getCenter().getY() - this.getInnerRadius(), this.getInnerRadius()*2, this.getInnerRadius()*2);
	}	

	public int getInnerRadius() {
		return innerRadius;
	}

	public void setInnerRadius(int innerRadius) {
		this.innerRadius = innerRadius;
	}
	
	public String toString() {
		return  super.toString() + ", inner radius: "+ innerRadius + " , " +isSelected() + "]";
	}
	
	@Override
	public void DialogEdit() {
		DialogDonut dialogDonut = new DialogDonut();
		for (Shape shape : PnlDrawing.shapesList) {
			if (shape.isSelected()) {
				String[] split = shape.toString().split(" ");
				dialogDonut.getTxtXCoord().setText(split[1]);
				dialogDonut.getTxtYCoord().setText(split[4]);
				dialogDonut.getTxtRadius().setText(split[9]);
				dialogDonut.getTxtInnerRadius().setText(split[14]);
			}
		}
		dialogDonut.setVisible(true);
	}
	
	
	@Override
	public void Fill(Graphics g) {
		super.Fill(g);
		g.setColor(getFill());
		g.drawOval(this.getCenter().getX() - this.getInnerRadius(), this.getCenter().getY() - this.getInnerRadius(), this.getInnerRadius() * 2, this.getInnerRadius() * 2);
		g.setColor(Color.WHITE);
		g.fillOval(this.getCenter().getX() - this.getInnerRadius(), this.getCenter().getY() - this.getInnerRadius(), this.getInnerRadius() * 2, this.getInnerRadius() * 2);	
	}
	
}
