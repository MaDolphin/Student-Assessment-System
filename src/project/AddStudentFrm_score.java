package project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddStudentFrm_score extends JFrame implements ActionListener {
	StudentDao studentDao = new StudentDao();
	JButton btn_add = new JButton("ȷ��");
	JButton btn_del = new JButton("ȡ��");
	JLabel lb_sno = new JLabel("ѧ��");
	JLabel lb_sname = new JLabel("����");
	JLabel lb_math = new JLabel("�ߵ���ѧ");
	JLabel lb_physics = new JLabel("����");
	JLabel lb_english = new JLabel("Ӣ��");
	JLabel lb_score_tog = new JLabel("ͬѧ������");
	JLabel lb_score_pol = new JLabel("Ʒ�³ɼ�");
	JLabel lb_score_tea = new JLabel("�ον�ʦ����");
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
		this.setTitle("���ѧ���ɼ�");
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btn_add) {
			double score_ave,score_syn;
			score_ave=(Double.valueOf(txt_math.getText())+Double.valueOf(txt_physics.getText())+Double.valueOf(txt_english.getText()))/3;
			score_syn=score_ave*0.6+Double.valueOf(txt_score_tog.getText())*0.1+Double.valueOf(txt_score_pol.getText())*0.1+Double.valueOf(txt_score_tea.getText())*0.2;
			int temp=studentDao.addStudent_score(txt_sno.getText(),Double.valueOf(txt_math.getText()),Double.valueOf(txt_physics.getText()),Double.valueOf(txt_english.getText()),
					score_ave,Double.valueOf(txt_score_tog.getText()),Double.valueOf(txt_score_pol.getText()),Double.valueOf(txt_score_tea.getText()),score_syn);
			switch(temp){
				case 3:JOptionPane.showMessageDialog(this, "ѧ��Ϊ" + txt_sno.getText() + "��¼��ӳɹ�!");break;
				case 2:JOptionPane.showMessageDialog(this, "Worning:ѧ��Ϊ" + txt_sno.getText() + "��¼�Ѿ����ڣ���ѡ���޸�!");break;
				case 1:JOptionPane.showMessageDialog(this, "ѧ��Ϊ" + txt_sno.getText() + "�Ļ�����Ϣ������������д�������ٽ������!");break;
				case 0:JOptionPane.showMessageDialog(this, "ѧ��Ϊ" + txt_sno.getText() + "�ļ�¼������!");break;
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
