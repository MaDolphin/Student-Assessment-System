package project;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class ModifyStudentFrm_info extends JFrame implements ActionListener{
	StudentDao studentDao = new StudentDao();
	JButton btn_add = new JButton("ȷ��");
	JButton btn_del = new JButton("ȡ��");
	JLabel lb_sno = new JLabel("ѧ��");
	JLabel lb_sname = new JLabel("����");
	JLabel lb_sex = new JLabel("�Ա�");
	JLabel lb_add = new JLabel("��ͥ��ַ");
	JLabel lb_tel = new JLabel("��ϵ�绰");
	JTextField txt_sno = new JTextField();
	JTextField txt_sname = new JTextField();
	JComboBox cmb_sex = new JComboBox();
	JTextField txt_add = new JTextField();
	JTextField txt_tel = new JTextField();

	public ModifyStudentFrm_info(String sno) {
		String[] temp =studentDao.queryStudents_info_one(sno);
		txt_sno.setText(temp[0]);
		txt_sname.setText(temp[1]);
		cmb_sex.addItem("��");
		cmb_sex.addItem("Ů");
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
		this.setTitle("�޸�ѧ����Ϣ");
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btn_add) {
			if(studentDao.modifyStudent_info(txt_sno.getText(), txt_sname.getText(), cmb_sex.getSelectedItem().toString(), txt_add.getText(), txt_tel.getText()))
			JOptionPane.showMessageDialog(this, "ѧ��Ϊ" + txt_sno.getText() + "�ļ�¼�޸ĳɹ�!");
			dispose();
		}
		if (e.getSource() == btn_del) {
			dispose();
		}
	}
}

