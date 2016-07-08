package project;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class ModifyStudentFrm_score extends JFrame implements ActionListener{
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

	public ModifyStudentFrm_score(String sno) {
		String[] temp =studentDao.queryStudents_score_one(sno);
		txt_sno.setText(temp[0]);
		txt_sname.setText(temp[1]);
		txt_math.setText(temp[2]);
		txt_physics.setText(temp[3]);
		txt_english.setText(temp[4]);
		txt_score_tog.setText(temp[7]);
		txt_score_pol.setText(temp[8]);
		txt_score_tea.setText(temp[9]);
		JPanel jp = (JPanel) this.getContentPane();
		JPanel jp1 = new JPanel();
		jp1.setLayout(new GridLayout(9, 2, 5, 10));
		jp1.add(lb_sno);
		jp1.add(txt_sno);
		jp1.add(lb_sname);
		jp1.add(txt_sname);
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
		this.setSize(400, 380);
		this.setVisible(true);
		this.setTitle("修改学生成绩");
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btn_add) {
			double score_ave,score_syn;
			score_ave=(Double.valueOf(txt_math.getText())+Double.valueOf(txt_physics.getText())+Double.valueOf(txt_english.getText()))/3;
			score_syn=score_ave*0.6+Double.valueOf(txt_score_tog.getText())*0.1+Double.valueOf(txt_score_pol.getText())*0.1+Double.valueOf(txt_score_tea.getText())*0.2;
			if(studentDao.modifyStudent_score(txt_sno.getText(),Double.valueOf(txt_math.getText()),Double.valueOf(txt_physics.getText()),Double.valueOf(txt_english.getText()),
					score_ave,Double.valueOf(txt_score_tog.getText()),Double.valueOf(txt_score_pol.getText()),Double.valueOf(txt_score_tea.getText()),score_syn))
			JOptionPane.showMessageDialog(this, "学号为" + txt_sno.getText() + "的记录修改成功!");
			dispose();
		}
		if (e.getSource() == btn_del) {
			dispose();
		}
	}

}

