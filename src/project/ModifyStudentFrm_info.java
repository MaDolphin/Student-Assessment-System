package project;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class ModifyStudentFrm_info extends JFrame implements ActionListener{
	StudentDao studentDao = new StudentDao();
	JButton btn_add = new JButton("确定");
	JButton btn_del = new JButton("取消");
	JLabel lb_sno = new JLabel("学号");
	JLabel lb_sname = new JLabel("姓名");
	JLabel lb_sex = new JLabel("性别");
	JLabel lb_add = new JLabel("家庭地址");
	JLabel lb_tel = new JLabel("联系电话");
	JTextField txt_sno = new JTextField();
	JTextField txt_sname = new JTextField();
	JComboBox cmb_sex = new JComboBox();
	JTextField txt_add = new JTextField();
	JTextField txt_tel = new JTextField();

	public ModifyStudentFrm_info(String sno) {
		String[] temp =studentDao.queryStudents_info_one(sno);
		txt_sno.setText(temp[0]);
		txt_sname.setText(temp[1]);
		cmb_sex.addItem("男");
		cmb_sex.addItem("女");
		cmb_sex.setSelectedItem(temp[2]);
		txt_add.setText(temp[3]);
		txt_tel.setText(temp[4]);
		JPanel jp = (JPanel) this.getContentPane();
		JPanel jp1 = new JPanel();
		jp1.setLayout(new GridLayout(6, 2, 5, 10));
		jp1.add(lb_sno);
		jp1.add(txt_sno);
		jp1.add(lb_sname);
		jp1.add(txt_sname);
		jp1.add(lb_sex);
		jp1.add(cmb_sex);
		jp1.add(lb_add);
		jp1.add(txt_add);
		jp1.add(lb_tel);
		jp1.add(txt_tel);
		jp1.add(btn_add);
		jp1.add(btn_del);
		jp.add(jp1, BorderLayout.NORTH);
		btn_add.addActionListener(this);
		btn_del.addActionListener(this);
		this.setSize(400, 260);
		this.setVisible(true);
		this.setTitle("修改学生信息");
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btn_add) {
			if(studentDao.modifyStudent_info(txt_sno.getText(), txt_sname.getText(), cmb_sex.getSelectedItem().toString(), txt_add.getText(), txt_tel.getText()))
			JOptionPane.showMessageDialog(this, "学号为" + txt_sno.getText() + "的记录修改成功!");
			dispose();
		}
		if (e.getSource() == btn_del) {
			dispose();
		}
	}
}

