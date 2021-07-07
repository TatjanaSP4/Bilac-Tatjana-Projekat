package sort;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import drawing.Point;
import drawing.Rectangle;

import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Color;

public class FrameSort extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	DefaultListModel<String> dlm = new DefaultListModel<String>();
	ArrayList<Rectangle> arrayListRect = new ArrayList<Rectangle>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameSort frame = new FrameSort();
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
	public FrameSort() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Bojana Bubulj SP8-2017");
		setBounds(100, 100, 420, 447);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setResizable(false);
		JPanel pnlCenter = new JPanel();
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_pnlCenter = new GroupLayout(pnlCenter);
		gl_pnlCenter.setHorizontalGroup(
			gl_pnlCenter.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlCenter.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_pnlCenter.setVerticalGroup(
			gl_pnlCenter.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlCenter.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		JList<String> list = new JList<String>();
		scrollPane.setViewportView(list);
		pnlCenter.setLayout(gl_pnlCenter);
		list.setModel(dlm);
		
		JPanel pnlDown = new JPanel();
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setToolTipText("");
		btnAdd.setBackground(Color.CYAN);
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DialogSort dialogSort = new DialogSort();
				dialogSort.setVisible(true);
				if(dialogSort.isOk == true) {
					Rectangle rec = new Rectangle(new Point(Integer.parseInt(dialogSort.getTxtXCoord().getText()),
							 (Integer.parseInt(dialogSort.getTxtYCoord().getText()))),
							 (Integer.parseInt(dialogSort.getTxtWidth().getText())),
							 (Integer.parseInt(dialogSort.getTxtHeight().getText())));

					arrayListRect.add(rec);
					Collections.sort(arrayListRect); 

					dlm.add(arrayListRect.indexOf(rec), "X: " + rec.getUpperLeftPoint().getX() + " , Y: " + rec.getUpperLeftPoint().getY() + " , Width: " + rec.getWidth() 
					+ " , Height: " + rec.getHeight());
				}
			}
		});
		
		JButton btnRemove = new JButton("Remove");
		btnRemove.setForeground(Color.WHITE);
		btnRemove.setBackground(Color.RED);
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (dlm.isEmpty()){
					JOptionPane.showMessageDialog(null, "Nothing to remove", "Error", JOptionPane.ERROR_MESSAGE);
				} else {
					DialogSort dialogsortdelete = new DialogSort();
					String[] split = dlm.firstElement().toString().split(" "); 

					dialogsortdelete.getTxtXCoord().setText(split[1]);
					dialogsortdelete.getTxtYCoord().setText(split[4]);
					dialogsortdelete.getTxtWidth().setText(split[7]);
					dialogsortdelete.getTxtHeight().setText(split[10]);
					dialogsortdelete.getTxtXCoord().setEditable(false); 
					dialogsortdelete.getTxtYCoord().setEditable(false);
					dialogsortdelete.getTxtWidth().setEditable(false);
					dialogsortdelete.getTxtHeight().setEditable(false);
					dialogsortdelete.setVisible(true);
					if(dialogsortdelete.isDelete()==true) {
						arrayListRect.remove(0); 
						dlm.removeElementAt(0);
					}
					
				}
			}
		});
		GroupLayout gl_pnlDown = new GroupLayout(pnlDown);
		gl_pnlDown.setHorizontalGroup(
			gl_pnlDown.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_pnlDown.createSequentialGroup()
					.addContainerGap(87, Short.MAX_VALUE)
					.addComponent(btnAdd)
					.addGap(80)
					.addComponent(btnRemove)
					.addGap(91))
		);
		gl_pnlDown.setVerticalGroup(
			gl_pnlDown.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlDown.createParallelGroup(Alignment.BASELINE)
					.addComponent(btnAdd)
					.addComponent(btnRemove))
		);
		pnlDown.setLayout(gl_pnlDown);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(pnlDown, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(pnlCenter, GroupLayout.PREFERRED_SIZE, 392, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(pnlCenter, GroupLayout.DEFAULT_SIZE, 345, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(pnlDown, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
