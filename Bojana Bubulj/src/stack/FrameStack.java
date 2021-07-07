package stack;

import java.awt.EventQueue;
import java.util.Stack;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import drawing.Point;
import drawing.Rectangle;
import javax.swing.JScrollPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import java.awt.Color;

public class FrameStack extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	DefaultListModel<String> dlm = new DefaultListModel<String>();
	Stack<Rectangle> stack = new Stack<Rectangle>();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameStack frame = new FrameStack();
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
	public FrameStack() {
		setResizable(false);
		setTitle("SP8-2017 Bojana Bubulj");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 420, 447);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel pnlCenter = new JPanel();
		
		JScrollPane scrollPane = new JScrollPane();
		
		JPanel pnlDown = new JPanel();
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setForeground(Color.BLACK);
		btnAdd.setBackground(Color.CYAN);
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DialogStack dialogStack = new DialogStack();
				dialogStack.setVisible(true);
				if(dialogStack.isOk == true) {
					Rectangle rec = new Rectangle(new Point(Integer.parseInt(dialogStack.getTxtXCoord().getText()),
							 (Integer.parseInt(dialogStack.getTxtYCoord().getText()))),
							 (Integer.parseInt(dialogStack.getTxtWidth().getText())),
							 (Integer.parseInt(dialogStack.getTxtHeight().getText())));
				
					stack.push(rec);
					dlm.add(0, "X: " + rec.getUpperLeftPoint().getX() + " , Y: " + rec.getUpperLeftPoint().getY() + " , Width: " + rec.getWidth() 
					+ " , Height: " + rec.getHeight());
			System.out.println(stack);
				}
				
			}
		});
		
		
		JButton btnRemove = new JButton("Remove");
		btnRemove.setForeground(Color.WHITE);
		btnRemove.setBackground(Color.RED);
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (dlm.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Nothing to remove", "Error",JOptionPane.ERROR_MESSAGE);
					getToolkit().beep();
				}else {
					DialogStack dialogstackdelete = new DialogStack();
					String[] split = dlm.firstElement().toString().split(" "); 
					
					dialogstackdelete.getTxtXCoord().setText(split[1]);
					dialogstackdelete.getTxtYCoord().setText(split[4]);
					dialogstackdelete.getTxtWidth().setText(split[7]);
					dialogstackdelete.getTxtHeight().setText(split[10]);
					dialogstackdelete.getTxtXCoord().setEditable(false);
					dialogstackdelete.getTxtYCoord().setEditable(false);
					dialogstackdelete.getTxtWidth().setEditable(false);
					dialogstackdelete.getTxtHeight().setEditable(false);
					dialogstackdelete.setVisible(true);
					if(dialogstackdelete.isDelete()==true) {
						stack.pop();
						dlm.removeElementAt(0);
					}
				}
			}
		});
		GroupLayout gl_pnlDown = new GroupLayout(pnlDown);
		gl_pnlDown.setHorizontalGroup(
			gl_pnlDown.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlDown.createSequentialGroup()
					.addGap(86)
					.addComponent(btnAdd)
					.addGap(78)
					.addComponent(btnRemove)
					.addContainerGap(94, Short.MAX_VALUE))
		);
		gl_pnlDown.setVerticalGroup(
			gl_pnlDown.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlDown.createSequentialGroup()
					.addGroup(gl_pnlDown.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnRemove)
						.addComponent(btnAdd))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		pnlDown.setLayout(gl_pnlDown);
		GroupLayout gl_pnlCenter = new GroupLayout(pnlCenter);
		gl_pnlCenter.setHorizontalGroup(
			gl_pnlCenter.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlCenter.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_pnlCenter.setVerticalGroup(
			gl_pnlCenter.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlCenter.createSequentialGroup()
					.addGap(9)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		JList<String> list = new JList<String>();
		scrollPane.setViewportView(list);
		pnlCenter.setLayout(gl_pnlCenter);
		list.setModel(dlm);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(pnlDown, BorderLayout.SOUTH);
		contentPane.add(pnlCenter);
	}
}
