package drawing;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JPanel;

public class PnlDrawing extends JPanel implements MouseListener{

	private static final long serialVersionUID = 1L;
	static int obj = 0;
	int mx, my;
	boolean pointBool;
	static ArrayList<Shape> shapesList = new ArrayList<Shape>();
	private Point startLine = null;
	
	public PnlDrawing() {
		addMouseListener(this);
	}
	
	
	@Override
	public void mouseClicked(MouseEvent e) {
		mx = e.getX();
		my = e.getY();
		switch(obj) {
		case 1:
			Point p = new Point(mx,my,false);
			p.setOutline(FrameDrawing.outline);
			shapesList.add(p);
			break;
		
		case 2:
			if (startLine == null) {
				startLine = new Point (mx, my,false);
			}else {
				Point endLine = new Point(mx, my);
				Line line = new Line (startLine, endLine, false);
				line.setOutline(FrameDrawing.outline);
				shapesList.add(line);
				startLine = null;
			}
			break;
		
		case 3:
			DialogRectangle dialogRectangle = new DialogRectangle();
			dialogRectangle.getTxtXCoord().setText(String.valueOf(mx));
			dialogRectangle.getTxtXCoord().setEditable(false);
			dialogRectangle.getTxtYCoord().setText(String.valueOf(my));
			dialogRectangle.getTxtYCoord().setEditable(false);
			dialogRectangle.setVisible(true);
			if(dialogRectangle.isOk == true) {
				Rectangle r = new Rectangle(new Point(mx, my), 
						Integer.parseInt(dialogRectangle.getTxtWidth().getText()),
						Integer.parseInt(dialogRectangle.getTxtHeight().getText()),
						false);
				r.setOutline(FrameDrawing.outline);
				r.setFill(FrameDrawing.fill);
				if(dialogRectangle.isOutlineBool()) {
					r.setOutline(dialogRectangle.getOutline()) ;
				}
				if(dialogRectangle.isFillBool()) {
					r.setFill(dialogRectangle.getFill());
				}
				
				shapesList.add(r);
			}
			break;
			
		case 4:
			DialogCircle dialogCircle = new DialogCircle();
			dialogCircle.getTxtXCoord().setText(String.valueOf(mx));
			dialogCircle.getTxtYCoord().setText(String.valueOf(my));
			dialogCircle.getTxtXCoord().setEditable(false);
			dialogCircle.getTxtYCoord().setEditable(false);
			dialogCircle.setVisible(true);
			if(dialogCircle.isOk == true) {
				Circle c = new Circle(new Point(mx,my), 
						Integer.parseInt(dialogCircle.getTxtRadius().getText()),
						false);
				c.setOutline(FrameDrawing.outline);
				c.setFill(FrameDrawing.fill);
				
				if(dialogCircle.isOutlineBool()) {
					c.setOutline(dialogCircle.getOutline());
				}
				
				if(dialogCircle.isFillBool()) {
					c.setFill(dialogCircle.getFill());
				}
				
				shapesList.add(c);
			}
			break;
			
		case 5:
			DialogDonut dialogDonut = new DialogDonut();
			dialogDonut.getTxtXCoord().setText(String.valueOf(mx));
			dialogDonut.getTxtYCoord().setText(String.valueOf(my));
			dialogDonut.getTxtXCoord().setEditable(false);
			dialogDonut.getTxtYCoord().setEditable(false);
			dialogDonut.setVisible(true);
			if(dialogDonut.isOk == true) {
				Donut d = new Donut(new Point(mx,my), 
						Integer.parseInt(dialogDonut.getTxtRadius().getText()),
						Integer.parseInt(dialogDonut.getTxtInnerRadius().getText()),
						false);
				d.setOutline(FrameDrawing.outline);
				d.setFill(FrameDrawing.fill);
				
				if(dialogDonut.isOutlineBool()) {
					d.setOutline(dialogDonut.getOutline());
				}
				
				if(dialogDonut.isFillBool()) {
					d.setFill(dialogDonut.getFill());
				}
				
				shapesList.add(d);
			}
			break;
			
		case 6:
			boolean match = false;
			Collections.reverse(shapesList);
			for (Shape shape : shapesList) {
				shape.setSelected(false);
				if(match == false) {
					if(shape.contains(mx, my)) {
						shape.setSelected(true);
						match = true;
					}
				}
			}
			Collections.reverse(shapesList);
			break;
		}
	}
	
	
	public void paint(Graphics g) {
		super.paint(g);
		for (Shape shape : shapesList) {
			shape.Fill(g);
			shape.draw(g);
		}	
		repaint();
	}

	
	
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	@Override
	public void mouseReleased(MouseEvent e) {}	
	@Override
	public void mouseEntered(MouseEvent e) {}
	@Override
	public void mouseExited(MouseEvent e) {}
	@Override
	public void mousePressed(MouseEvent e) {}
}
