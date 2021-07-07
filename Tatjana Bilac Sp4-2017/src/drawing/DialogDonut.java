package drawing;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.LayoutStyle.ComponentPlacement;

public class DialogDonut extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel pnlCenter = new JPanel();
	private JTextField txtXCoord;
	private JTextField txtYCoord;
	private JTextField txtRadius;
	private JTextField txtInnerRadius;
	public boolean isOk;
	private Color outline;
	private Color fill;
	private boolean outlineBool;
	private boolean fillBool;
	private JButton okButton;
	private JButton cancelButton;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DialogDonut dialog = new DialogDonut();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DialogDonut() {
		setModal(true);
		setBounds(100, 100, 320, 389);
		getContentPane().setLayout(new BorderLayout());
		pnlCenter.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(pnlCenter, BorderLayout.CENTER);
		JLabel lblXCoordinate = new JLabel("X coordinate:");
		JLabel lblYCoordinate = new JLabel("Y coordinate:");
		JLabel lblRadius = new JLabel("Radius:");
		JLabel lblInnerRadius = new JLabel("Inner radius:");
		txtXCoord = new JTextField();
		txtXCoord.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!(((c>='0') && (c<='9')) || (c == KeyEvent.VK_BACK_SPACE))) {
					e.consume();
					getToolkit().beep();
				}
			}
		});
		txtXCoord.setColumns(10);
		txtYCoord = new JTextField();
		txtYCoord.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!(((c>='0') && (c<='9')) || (c == KeyEvent.VK_BACK_SPACE))) {
					e.consume();
					getToolkit().beep();
				}
			}
		});
		txtYCoord.setColumns(10);
		txtRadius = new JTextField();
		txtRadius.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!(((c>='0') && (c<='9')) || (c == KeyEvent.VK_BACK_SPACE))) {
					e.consume();
					getToolkit().beep();
				}
			}
		});
		txtRadius.setColumns(10);
		txtInnerRadius = new JTextField();
		txtInnerRadius.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!(((c>='0') && (c<='9')) || (c == KeyEvent.VK_BACK_SPACE))) {
					e.consume();
					getToolkit().beep();
				}
			}
		});
		txtInnerRadius.setColumns(10);
		
		JButton btnOutlineColor = new JButton("Outline color");
		btnOutlineColor.setBackground(Color.CYAN);
		btnOutlineColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				outline = JColorChooser.showDialog(null, "Choose a color", Color.BLACK);
				outlineBool = true;
				if(outline == null) {
					outline = Color.BLACK;
				}
			}
		});
		
		JButton btnFillColor = new JButton("Fill color");
		btnFillColor.setBackground(Color.CYAN);
		btnFillColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fill = JColorChooser.showDialog(null, "Choose a color", Color.WHITE);
				fillBool = true;
				if(fill == null) {
					fill = Color.WHITE;
				}
			}
		});
		GroupLayout gl_pnlCenter = new GroupLayout(pnlCenter);
		gl_pnlCenter.setHorizontalGroup(
			gl_pnlCenter.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlCenter.createSequentialGroup()
					.addGap(28)
					.addGroup(gl_pnlCenter.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pnlCenter.createSequentialGroup()
							.addComponent(lblXCoordinate)
							.addGap(18)
							.addComponent(txtXCoord, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_pnlCenter.createParallelGroup(Alignment.TRAILING, false)
							.addComponent(btnFillColor, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(btnOutlineColor, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGroup(gl_pnlCenter.createSequentialGroup()
							.addGroup(gl_pnlCenter.createParallelGroup(Alignment.LEADING)
								.addComponent(lblYCoordinate)
								.addComponent(lblRadius)
								.addComponent(lblInnerRadius))
							.addGap(18)
							.addGroup(gl_pnlCenter.createParallelGroup(Alignment.LEADING)
								.addComponent(txtInnerRadius, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtRadius, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtYCoord, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(53, Short.MAX_VALUE))
		);
		gl_pnlCenter.setVerticalGroup(
			gl_pnlCenter.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlCenter.createSequentialGroup()
					.addGap(38)
					.addGroup(gl_pnlCenter.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblXCoordinate)
						.addComponent(txtXCoord, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_pnlCenter.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblYCoordinate)
						.addComponent(txtYCoord, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_pnlCenter.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblRadius)
						.addComponent(txtRadius, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_pnlCenter.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblInnerRadius)
						.addComponent(txtInnerRadius, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(btnOutlineColor)
					.addGap(18)
					.addComponent(btnFillColor)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		pnlCenter.setLayout(gl_pnlCenter);
		{
			JPanel pnlButton = new JPanel();
			getContentPane().add(pnlButton, BorderLayout.SOUTH);
			{
				okButton = new JButton("OK");
				okButton.setBackground(Color.CYAN);
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (getTxtXCoord().getText().trim().isEmpty() || getTxtYCoord().getText().trim().isEmpty() || getTxtRadius().getText().trim().isEmpty() || getTxtInnerRadius().getText().trim().isEmpty()) {
							isOk = false;
							JOptionPane.showMessageDialog(null, "Enter in all the values!", "Error", JOptionPane.ERROR_MESSAGE);
							getToolkit().beep();
						}else {
							if(Integer.parseInt(txtRadius.getText()) > Integer.parseInt(txtInnerRadius.getText())) {
								for (Shape shape : PnlDrawing.shapesList) {
									if(shape.isSelected()) {
										shape.move(Integer.parseInt(txtXCoord.getText()), Integer.parseInt(txtYCoord.getText()));
										((Donut)shape).setRadius(Integer.parseInt(txtRadius.getText()));
										((Donut)shape).setInnerRadius(Integer.parseInt(txtInnerRadius.getText()));
										if(isOutlineBool() == true) {
											shape.setOutline(outline);
											setOutlineBool(false);
										}
										if(isFillBool() == true) {
											shape.setFill(fill);
											setFillBool(false);
										}
									
									}
									
								}
								
								isOk = true;
								dispose();
							} else {
								isOk = false;
								JOptionPane.showMessageDialog(null, "The inner radius must be smaller than the outer radius!", "Error", JOptionPane.ERROR_MESSAGE);

							}	
						}
					}
				});
				okButton.setActionCommand("OK");
				getRootPane().setDefaultButton(okButton);
			}
			{
				cancelButton = new JButton("Cancel");
				cancelButton.setForeground(Color.WHITE);
				cancelButton.setBackground(Color.RED);
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
			}
			GroupLayout gl_pnlButton = new GroupLayout(pnlButton);
			gl_pnlButton.setHorizontalGroup(
				gl_pnlButton.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_pnlButton.createSequentialGroup()
						.addGap(154)
						.addComponent(okButton)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(cancelButton)
						.addGap(21))
			);
			gl_pnlButton.setVerticalGroup(
				gl_pnlButton.createParallelGroup(Alignment.LEADING)
					.addGroup(Alignment.TRAILING, gl_pnlButton.createSequentialGroup()
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(gl_pnlButton.createParallelGroup(Alignment.BASELINE)
							.addComponent(okButton)
							.addComponent(cancelButton))
						.addContainerGap())
			);
			pnlButton.setLayout(gl_pnlButton);
		}
	}

	public JTextField getTxtXCoord() {
		return txtXCoord;
	}

	public void setTxtXCoord(JTextField txtXCoord) {
		this.txtXCoord = txtXCoord;
	}

	public JTextField getTxtYCoord() {
		return txtYCoord;
	}

	public void setTxtYCoord(JTextField txtYCoord) {
		this.txtYCoord = txtYCoord;
	}

	public JTextField getTxtRadius() {
		return txtRadius;
	}

	public void setTxtRadius(JTextField txtRadius) {
		this.txtRadius = txtRadius;
	}

	public JTextField getTxtInnerRadius() {
		return txtInnerRadius;
	}

	public void setTxtInnerRadius(JTextField txtInnerRadius) {
		this.txtInnerRadius = txtInnerRadius;
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

	public boolean isOutlineBool() {
		return outlineBool;
	}

	public void setOutlineBool(boolean outlineBool) {
		this.outlineBool = outlineBool;
	}

	public boolean isFillBool() {
		return fillBool;
	}

	public void setFillBool(boolean fillBool) {
		this.fillBool = fillBool;
	}

}
