package sort;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class DialogSort extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel pnlCenter = new JPanel();
	private JTextField txtXCoord;
	private JTextField txtYCoord;
	private JTextField txtWidth;
	private JTextField txtHeight;
	private JLabel lblXCoordinate;
	private JLabel lblYCoordinate;
	private JLabel lblWidth;
	private JLabel lblHeight;
	public boolean isOk;
	private boolean delete;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DialogSort dialog = new DialogSort();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DialogSort() {
		setResizable(false);
		setBounds(100, 100, 346, 408);
		setModal(true);
		pnlCenter.setBorder(new EmptyBorder(5, 5, 5, 5));
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
		txtWidth = new JTextField();
		txtWidth.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!(((c>='0') && (c<='9')) || (c == KeyEvent.VK_BACK_SPACE))) {
					e.consume();
					getToolkit().beep();
				}
			}
		});
		txtWidth.setColumns(10);
		txtHeight = new JTextField();
		txtHeight.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!(((c>='0') && (c<='9')) || (c == KeyEvent.VK_BACK_SPACE))) {
					e.consume();
					getToolkit().beep();
				}
			}
		});
		txtHeight.setColumns(10);
		lblXCoordinate = new JLabel("X coordinate:");
		lblYCoordinate = new JLabel("Y coordinate:");
		lblWidth = new JLabel("Width:");
		lblHeight = new JLabel("Height:");
		GroupLayout gl_pnlCenter = new GroupLayout(pnlCenter);
		gl_pnlCenter.setHorizontalGroup(
			gl_pnlCenter.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_pnlCenter.createSequentialGroup()
					.addGap(24)
					.addGroup(gl_pnlCenter.createParallelGroup(Alignment.LEADING)
						.addComponent(lblXCoordinate)
						.addComponent(lblYCoordinate)
						.addComponent(lblWidth)
						.addComponent(lblHeight))
					.addPreferredGap(ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
					.addGroup(gl_pnlCenter.createParallelGroup(Alignment.LEADING)
						.addComponent(txtHeight, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtWidth, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtYCoord, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtXCoord, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(76))
		);
		gl_pnlCenter.setVerticalGroup(
			gl_pnlCenter.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlCenter.createSequentialGroup()
					.addGap(40)
					.addGroup(gl_pnlCenter.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblXCoordinate)
						.addComponent(txtXCoord, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_pnlCenter.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtYCoord, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblYCoordinate))
					.addGap(18)
					.addGroup(gl_pnlCenter.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtWidth, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblWidth))
					.addGap(18)
					.addGroup(gl_pnlCenter.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtHeight, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblHeight))
					.addContainerGap(143, Short.MAX_VALUE))
		);
		pnlCenter.setLayout(gl_pnlCenter);
		
		JPanel btnPanel = new JPanel();
		
		JButton btnOk = new JButton("Ok");
		btnOk.setBackground(Color.CYAN);
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtXCoord.getText().trim().isEmpty()||txtYCoord.getText().trim().isEmpty()||
						txtWidth.getText().trim().isEmpty()||txtHeight.getText().trim().isEmpty()) {
					isOk=false;
					getToolkit().beep();
					JOptionPane.showMessageDialog(null, "Fill in all the blanks", "Error", JOptionPane.ERROR_MESSAGE);
				} else {
					isOk=true;
					setDelete(true);
					dispose();
				}
			}
		});
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setForeground(Color.WHITE);
		btnCancel.setBackground(Color.RED);
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setDelete(false);
				dispose();
			}
		});
		GroupLayout gl_btnPanel = new GroupLayout(btnPanel);
		gl_btnPanel.setHorizontalGroup(
			gl_btnPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_btnPanel.createSequentialGroup()
					.addContainerGap(170, Short.MAX_VALUE)
					.addComponent(btnOk)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnCancel)
					.addGap(28))
		);
		gl_btnPanel.setVerticalGroup(
			gl_btnPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_btnPanel.createSequentialGroup()
					.addGroup(gl_btnPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnCancel)
						.addComponent(btnOk))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		btnPanel.setLayout(gl_btnPanel);
		getContentPane().setLayout(new BorderLayout(0, 0));
		getContentPane().add(pnlCenter);
		getContentPane().add(btnPanel, BorderLayout.SOUTH);
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

	public JTextField getTxtWidth() {
		return txtWidth;
	}

	public void setTxtWidth(JTextField txtWidth) {
		this.txtWidth = txtWidth;
	}

	public JTextField getTxtHeight() {
		return txtHeight;
	}

	public void setTxtHeight(JTextField txtHeight) {
		this.txtHeight = txtHeight;
	}

	public boolean isDelete() {
		return delete;
	}

	public void setDelete(boolean delete) {
		this.delete = delete;
	}
}
