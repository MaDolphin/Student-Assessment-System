package project;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class AddStudentFrm_info extends JFrame implements ActionListener {
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

	public AddStudentFrm_info() {
		JPanel jp = (JPanel) this.getContentPane();
		JPanel jp1 = new JPanel();
		jp1.setLayout(new GridLayout(6, 2, 5, 10));
		jp1.add(lb_sno);
		jp1.add(txt_sno);
		jp1.add(lb_sname);
		jp1.add(txt_sname);
		jp1.add(lb_sex);
		jp1.add(cmb_sex);
		cmb_sex.addItem("男");
		cmb_sex.addItem("女");
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
		this.setTitle("添加学生信息");
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btn_add) {
			if(studentDao.isExist(txt_sno.getText())){
				JOptionPane.showMessageDialog(this, "Worning：学号为" + txt_sno.getText() + "记录已经存在!");
				dispose();
			}
			else if(studentDao.addStudent_info(txt_sno.getText(), txt_sname.getText(), cmb_sex.getSelectedItem().toString(), txt_add.getText(), txt_tel.getText()))
				JOptionPane.showMessageDialog(this, "学号为" + txt_sno.getText() + "记录添加成功!");
			else JOptionPane.showMessageDialog(this, "Worning:学号为" + txt_sno.getText() + "记录已经存在请选择修改!");
			dispose();
		}
		if (e.getSource() == btn_del) {
			dispose();
		}
	}

	public static void main(String[] args) {
		new AddStudentFrm_info();
	}
}
