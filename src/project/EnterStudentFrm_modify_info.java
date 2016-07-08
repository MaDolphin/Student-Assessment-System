package project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EnterStudentFrm_modify_info extends JFrame implements ActionListener{
	StudentDao studentDao = new StudentDao();
	JButton btn_add = new JButton("确定");
	JLabel lb_sno = new JLabel("学号");
	JTextField txt_sno = new JTextField();

	public EnterStudentFrm_modify_info() {
		JPanel jp = (JPanel) this.getContentPane();
		JPanel jp1 = new JPanel();
		JPanel jp2 = new JPanel();
		jp1.setLayout(new GridLayout(1, 2, 5, 10));
		jp1.add(lb_sno);
		jp1.add(txt_sno);
		jp2.add(btn_add);
		jp.add(jp1, BorderLayout.NORTH);
		jp.add(jp2, BorderLayout.SOUTH);
		btn_add.addActionListener(this);
		this.setSize(400, 100);
		this.setVisible(true);
		this.setTitle("请输入学生的学号");
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btn_add) {
			String sno=txt_sno.getText();
			if(studentDao.isExist(sno)){
				new ModifyStudentFrm_info(sno);
			}
			else JOptionPane.showMessageDialog(this, "学号为" + txt_sno.getText() + "的记录不存在!");
			dispose();
		}
	}

	public static void main(String[] args) {
		new EnterStudentFrm_modify_info();
	}
}