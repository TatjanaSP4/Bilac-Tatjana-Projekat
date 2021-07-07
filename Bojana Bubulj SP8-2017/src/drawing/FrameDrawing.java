package drawing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrameDrawing extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private PnlDrawing pnlDrawing = new PnlDrawing(); 
	static Color outline = Color.BLACK;
	static Color fill = Color.WHITE;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameDrawing frame = new FrameDrawing();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrameDrawing() {
		setTitle("Bojana Bubulj SP8-2017");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 925, 557);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		pnlDrawing.setBackground(Color.WHITE);
		pnlDrawing.setBorder(null);
		contentPane.add(pnlDrawing,BorderLayout.CENTER);
		
		
		JPanel pnlButton = new JPanel();
		contentPane.add(pnlButton, BorderLayout.EAST);
		
		JButton btnPoint = new JButton("Point");
		btnPoint.setBackground(Color.CYAN);
		btnPoint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PnlDrawing.obj = 1;
				for (Shape shape : PnlDrawing.shapesList) {
					shape.setSelected(false);
				}
			}
		});
		
		JButton btnLine = new JButton("Line");
		btnLine.setBackground(Color.CYAN);
		btnLine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PnlDrawing.obj = 2;
				for (Shape shape : PnlDrawing.shapesList) {
					shape.setSelected(false);
				}
			}
		});
		
		JButton btnRectangle = new JButton("Rectangle");
		btnRectangle.setBackground(Color.CYAN);
		btnRectangle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PnlDrawing.obj = 3;
				for (Shape shape : PnlDrawing.shapesList) {
					shape.setSelected(false);
				}
			}
		});
		
		JButton btnCircle = new JButton("Circle");
		btnCircle.setBackground(Color.CYAN);
		btnCircle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PnlDrawing.obj = 4;
				for (Shape shape : PnlDrawing.shapesList) {
					shape.setSelected(false);
				}
			}
		});
		
		JButton btnDonut = new JButton("Donut");
		btnDonut.setBackground(Color.CYAN);
		btnDonut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PnlDrawing.obj = 5;
				for (Shape shape : PnlDrawing.shapesList) {
					shape.setSelected(false);
				}
			}
		});
		
		JButton btnSelect = new JButton("Select");
		btnSelect.setBackground(Color.CYAN);
		btnSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(PnlDrawing.shapesList.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Nothing to select!", "Error", JOptionPane.ERROR_MESSAGE);
					return;
				} else {
					PnlDrawing.obj = 6;
				}			
			}
		});
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.setBackground(Color.CYAN);
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(PnlDrawing.shapesList.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Nothing to edit!", "Error", JOptionPane.ERROR_MESSAGE);
					return;
				}
				for (Shape shape : PnlDrawing.shapesList) {
					if(shape.isSelected()) {
						shape.DialogEdit();
						return;
					}
				}
				JOptionPane.showMessageDialog(null, "You must select an object first!", "Error", JOptionPane.ERROR_MESSAGE);
				
			}
		});
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setBackground(Color.CYAN);
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(PnlDrawing.shapesList.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Nothing to delete!", "Error", JOptionPane.ERROR_MESSAGE);
					return;
				}
				for (Shape shape : PnlDrawing.shapesList) {
					if(shape.isSelected()) {
						int ans = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete the selected object?","Warning",JOptionPane.YES_NO_OPTION);
						if(ans == 0) {
							PnlDrawing.shapesList.remove(shape);
						}
							return;
							
						}
					}
					
				JOptionPane.showMessageDialog(null, "You must select an object first!", "Error", JOptionPane.ERROR_MESSAGE);
			}
				
			
		});
		
		JButton btnOutlineColor = new JButton("Outline");
		btnOutlineColor.setBackground(Color.CYAN);
		btnOutlineColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				outline = JColorChooser.showDialog(null, "Choose a color", Color.BLACK);
				if(outline == null) {
					outline = Color.BLACK;
				}
			}
		});
		
		JButton btnAreaColor = new JButton("Fill");
		btnAreaColor.setBackground(Color.CYAN);
		btnAreaColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fill = JColorChooser.showDialog(null, "Choose a color", Color.WHITE);
				if(fill == null) {
					fill = Color.WHITE;
				}
			}
		});
		GroupLayout gl_pnlButton = new GroupLayout(pnlButton);
		gl_pnlButton.setHorizontalGroup(
			gl_pnlButton.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlButton.createSequentialGroup()
					.addGap(5)
					.addGroup(gl_pnlButton.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnPoint, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
						.addComponent(btnLine, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
						.addComponent(btnCircle, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
						.addComponent(btnRectangle, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
						.addComponent(btnSelect, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
						.addComponent(btnEdit, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
						.addComponent(btnDelete, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
						.addComponent(btnDonut, GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
						.addComponent(btnOutlineColor, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
						.addComponent(btnAreaColor, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_pnlButton.setVerticalGroup(
			gl_pnlButton.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlButton.createSequentialGroup()
					.addGap(5)
					.addComponent(btnPoint)
					.addGap(18)
					.addComponent(btnLine)
					.addGap(18)
					.addComponent(btnRectangle)
					.addGap(18)
					.addComponent(btnCircle)
					.addGap(18)
					.addComponent(btnDonut)
					.addGap(18)
					.addComponent(btnSelect)
					.addGap(18)
					.addComponent(btnEdit)
					.addGap(18)
					.addComponent(btnDelete)
					.addGap(18)
					.addComponent(btnOutlineColor)
					.addGap(18)
					.addComponent(btnAreaColor)
					.addContainerGap(62, Short.MAX_VALUE))
		);
		pnlButton.setLayout(gl_pnlButton);
	}
}
