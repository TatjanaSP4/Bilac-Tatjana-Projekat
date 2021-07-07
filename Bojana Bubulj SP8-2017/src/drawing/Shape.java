package drawing;

import java.awt.Color;
import java.awt.Graphics;

public abstract class Shape implements Comparable, Moveable{

	private boolean selected;
	private Color outline = Color.black;
	private Color fill = Color.white;
	
	
	public Shape() {
		
	}
	public abstract void Fill (Graphics g);

	public abstract void DialogEdit();

	public abstract void draw(Graphics g);

	public abstract boolean contains(int x, int y); 
		
	public Shape(boolean selected) {
		super();
		this.selected = selected;
	}

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}

	public Color getOutline() {
		return outline;
	}

	public void setOutline(Color outline) {
		this.outline = outline;
	}

	public Color getFill() {
		return fill;
	}

	public void setFill(Color fill) {
		this.fill = fill;
	}
	
}
