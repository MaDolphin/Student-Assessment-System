package project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DispStudentFrm_score extends JFrame implements ActionListener{
	StudentDao studentDao = new StudentDao();
	JButton btn_add = new JButton("�رմ���");
	JLabel lb_sno = new JLabel("ѧ��");
	JLabel lb_sname = new JLabel("����");
	JLabel lb_math = new JLabel("�ߵ���ѧ");
	JLabel lb_physics = new JLabel("����");
	JLabel lb_english = new JLabel("Ӣ��");
	JLabel lb_score_ave = new JLabel("����ƽ����");
	JLabel lb_no_test = new JLabel("���ƿ�������");
	JLabel lb_score_tog = new JLabel("ͬѧ������");
	JLabel lb_score_pol = new JLabel("Ʒ�³ɼ�");
	JLabel lb_score_tea = new JLabel("�ον�ʦ����");
	JLabel lb_score_syn = new JLabel("�ۺϲ����ܷ�");
	JLabel lb_no_syn = new JLabel("�ۺϲ�������");
	JTextField txt_sno = new JTextField();
	JTextField txt_sname = new JTextField();
	JTextField txt_math = new JTextField();
	JTextField txt_physics = new JTextField();
	JTextField txt_english = new JTextField();
	JTextField txt_score_ave = new JTextField();
	JTextField txt_no_test = new JTextField();
	JTextField txt_score_tog = new JTextField();
	JTextField txt_score_pol = new JTextField();
	JTextField txt_score_tea = new JTextField();
	JTextField txt_score_syn = new JTextField();
	JTextField txt_no_syn = new JTextField();

	public DispStudentFrm_score(String sno) {
		String[] temp =studentDao.queryStudents_score_one(sno);
		txt_sno.setText(temp[0]);
		txt_sname.setText(temp[1]);
		txt_math.setText(temp[2]);
		txt_physics.setText(temp[3]);
		txt_english.setText(temp[4]);
		txt_score_ave.setText(temp[5]);
		txt_no_test.setText(temp[6]);
		txt_score_tog.setText(temp[7]);
		txt_score_pol.setText(temp[8]);
		txt_score_tea.setText(temp[9]);
		txt_score_syn.setText(temp[10]);
		txt_no_syn.setText(temp[11]);
		JPanel jp = (JPanel) this.getContentPane();
		JPanel jp1 = new JPanel();
		JPanel jp2 = new JPanel();
		jp1.setLayout(new GridLayout(12, 2, 5, 10));
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
		jp1.add(lb_score_ave);
		jp1.add(txt_score_ave);
		jp1.add(lb_no_test);
		jp1.add(txt_no_test);
		jp1.add(lb_score_tog);
		jp1.add(txt_score_tog);
		jp1.add(lb_score_pol);
		jp1.add(txt_score_pol);
		jp1.add(lb_score_tea);
		jp1.add(txt_score_tea);
		jp1.add(lb_score_syn);
		jp1.add(txt_score_syn);
		jp1.add(lb_no_syn);
		jp1.add(txt_no_syn);
		jp2.add(btn_add);
		jp.add(jp1, BorderLayout.NORTH);
		jp.add(jp2, BorderLayout.SOUTH);
		btn_add.addActionListener(this);
		this.setSize(400, 460);
		this.setVisible(true);
		this.setTitle("��ѯѧ���ɼ�");
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btn_add) {
			dispose();
		}
	}

}

