package project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddStudentFrm_score extends JFrame implements ActionListener {
	StudentDao studentDao = new StudentDao();
	JButton btn_add = new JButton("确定");
	JButton btn_del = new JButton("取消");
	JLabel lb_sno = new JLabel("学号");
	JLabel lb_sname = new JLabel("姓名");
	JLabel lb_math = new JLabel("高等数学");
	JLabel lb_physics = new JLabel("物理");
	JLabel lb_english = new JLabel("英语");
	JLabel lb_score_tog = new JLabel("同学互评分");
	JLabel lb_score_pol = new JLabel("品德成绩");
	JLabel lb_score_tea = new JLabel("任课教师评分");
	JTextField txt_sno = new JTextField();
	JTextField txt_sname = new JTextField();
	JTextField txt_math = new JTextField();
	JTextField txt_physics = new JTextField();
	JTextField txt_english = new JTextField();
	JTextField txt_score_tog = new JTextField();
	JTextField txt_score_pol = new JTextField();
	JTextField txt_score_tea = new JTextField();

	public AddStudentFrm_score() {
		JPanel jp = (JPanel) this.getContentPane();
		JPanel jp1 = new JPanel();
		jp1.setLayout(new GridLayout(8, 2, 5, 10));
		jp1.add(lb_sno);
		jp1.add(txt_sno);
		jp1.add(lb_math);
		jp1.add(txt_math);
		jp1.add(lb_physics);
		jp1.add(txt_physics);
		jp1.add(lb_english);
		jp1.add(txt_english);
		jp1.add(lb_score_tog);
		jp1.add(txt_score_tog);
		jp1.add(lb_score_pol);
		jp1.add(txt_score_pol);
		jp1.add(lb_score_tea);
		jp1.add(txt_score_tea);
		jp1.add(btn_add);
		jp1.add(btn_del);
		jp.add(jp1, BorderLayout.NORTH);
		btn_add.addActionListener(this);
		btn_del.addActionListener(this);
		this.setSize(400, 340);
		this.setVisible(true);
		this.setTitle("添加学生成绩");
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btn_add) {
			double score_ave,score_syn;
			score_ave=(Double.valueOf(txt_math.getText())+Double.valueOf(txt_physics.getText())+Double.valueOf(txt_english.getText()))/3;
			score_syn=score_ave*0.6+Double.valueOf(txt_score_tog.getText())*0.1+Double.valueOf(txt_score_pol.getText())*0.1+Double.valueOf(txt_score_tea.getText())*0.2;
			int temp=studentDao.addStudent_score(txt_sno.getText(),Double.valueOf(txt_math.getText()),Double.valueOf(txt_physics.getText()),Double.valueOf(txt_english.getText()),
					score_ave,Double.valueOf(txt_score_tog.getText()),Double.valueOf(txt_score_pol.getText()),Double.valueOf(txt_score_tea.getText()),score_syn);
			switch(temp){
				case 3:JOptionPane.showMessageDialog(this, "学号为" + txt_sno.getText() + "记录添加成功!");break;
				case 2:JOptionPane.showMessageDialog(this, "Worning:学号为" + txt_sno.getText() + "记录已经存在，请选择修改!");break;
				case 1:JOptionPane.showMessageDialog(this, "学号为" + txt_sno.getText() + "的基本信息不完整，请填写完整后再进行添加!");break;
				case 0:JOptionPane.showMessageDialog(this, "学号为" + txt_sno.getText() + "的记录不存在!");break;
			}
			dispose();
		}
		if (e.getSource() == btn_del) {
			dispose();
		}
	}

	public static void main(String[] args) {
		new AddStudentFrm_score();
	}
}
