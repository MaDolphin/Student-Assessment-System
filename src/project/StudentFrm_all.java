package project;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
public class StudentFrm_all extends JFrame{
	private JTable table = null;
	private String[] cols = { "学号","姓名","性别","家庭住址","联系电话","高等数学","物理","英语",
					"考试平均成绩","考试名次","同学互评分","品德成绩","任课教师评分","综合测评总分","综合测评名次"};
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
		this.setTitle("全部学生信息");
		this.setVisible(true);
	}
	public static void main(String[] args) {
		new StudentFrm_all();
	}
}
