package project;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
public class StudentFrm_all extends JFrame{
	private JTable table = null;
	private String[] cols = { "ѧ��","����","�Ա�","��ͥסַ","��ϵ�绰","�ߵ���ѧ","����","Ӣ��",
					"����ƽ���ɼ�","��������","ͬѧ������","Ʒ�³ɼ�","�ον�ʦ����","�ۺϲ����ܷ�","�ۺϲ�������"};
	private StudentDao studentDao = new StudentDao();

	private void initTable() {
		String[][] rows = studentDao.queryStudents_all();
		table = new JTable(rows, cols);
	}

	private void updateTable() {
		String[][] rows = studentDao.queryStudents_all();
		table.setModel(new DefaultTableModel(rows, cols));
	}
	public StudentFrm_all() {
		JPanel jp = (JPanel) this.getContentPane();
		initTable();
		JScrollPane jsp_table = new JScrollPane(table);
		jp.add(jsp_table);
		JPanel jp_top = new JPanel();
		jp.add(jp_top, BorderLayout.NORTH);
		this.setSize(600, 400);
		this.setTitle("ȫ��ѧ����Ϣ");
		this.setVisible(true);
	}
	public static void main(String[] args) {
		new StudentFrm_all();
	}
}
