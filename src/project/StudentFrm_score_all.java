package project;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.*;
public class StudentFrm_score_all extends JFrame{
	private JTable table = null;
	private JButton no_testBtn = new JButton("��������������");
	private JButton no_synBtn = new JButton("���ۺ���������");
	private String[] cols = { "ѧ��","����","�ߵ���ѧ","����","Ӣ��",
					"����ƽ���ɼ�","��������","ͬѧ������","Ʒ�³ɼ�","�ον�ʦ����","�ۺϲ����ܷ�","�ۺϲ�������"};
	private StudentDao studentDao = new StudentDao();

	private void initTable() {
		String[][] rows = studentDao.queryStudents_score_all(0);
		table = new JTable(rows, cols);
	}

	private void updateTable(int t) {
		String[][] rows = studentDao.queryStudents_score_all(t);
		table.setModel(new DefaultTableModel(rows, cols));
	}
	public StudentFrm_score_all() {
		JPanel jp = (JPanel) this.getContentPane();
		initTable();
		JScrollPane jsp_table = new JScrollPane(table);
		jp.add(jsp_table);
		JPanel jp_top = new JPanel();
		jp_top.add(no_testBtn);
		jp_top.add(no_synBtn);
		jp.add(jp_top, BorderLayout.NORTH);
		this.setSize(600, 400);
		this.setTitle("ѧ���ɼ�");
		this.setVisible(true);
		no_testBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateTable(1);
			}
		});
		no_synBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateTable(2);
			}
		});
	}
	public static void main(String[] args) {
		new StudentFrm_score_all();
	}
}
