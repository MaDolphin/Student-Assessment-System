package project;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class DeleteStudentFrm_info extends JFrame implements ActionListener{
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
	JTextField txt_sex = new JTextField();
	JTextField txt_add = new JTextField();
	JTextField txt_tel = new JTextField();

	public DeleteStudentFrm_info(String sno) {
		String[] temp =studentDao.queryStudents_info_one(sno);
		txt_sno.setText(temp[0]);
		txt_sname.setText(temp[1]);
		txt_sex.setText(temp[2]);
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
		jp1.add(txt_sex);
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
		this.setTitle("删除学生信息");
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btn_add) {
			studentDao.deleteStudent_sno(txt_sno.getText());
			JOptionPane.showMessageDialog(this, "学号为" + txt_sno.getText() + "的记录删除成功!");
			dispose();
		}
		if (e.getSource() == btn_del) {
			dispose();
		}
	}

}

