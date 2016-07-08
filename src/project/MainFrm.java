package project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainFrm extends JFrame {
	private void initMenu() {
		JMenuBar bar = new JMenuBar();
		JMenu m1 = new JMenu("学生信息管理");
		JMenu m2 = new JMenu("学生成绩管理");
		JMenu m3 = new JMenu("显示所有信息");
		JMenuItem m11 = new JMenuItem("查询学生信息");
		JMenuItem m12 = new JMenuItem("添加学生信息");
		JMenuItem m13 = new JMenuItem("删除学生信息");
		JMenuItem m14 = new JMenuItem("修改学生信息");
		JMenuItem m15 = new JMenuItem("显示所有学生信息");
		JMenuItem m16 = new JMenuItem("退出");
		JMenuItem m21 = new JMenuItem("查询学生成绩");
		JMenuItem m22 = new JMenuItem("添加学生成绩");
		JMenuItem m23 = new JMenuItem("修改学生成绩");
		JMenuItem m24 = new JMenuItem("显示所有学生成绩");
		JMenuItem m31 = new JMenuItem("显示所有信息");
		m11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StudentFrm_info_Clicked();
			}
		});
		m12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddStudent_info_Clicked();
			}
		});
		m13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeleteStudent_info_Clicked();
			}
		});
		m14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ModifyStudent_info_Clicked();
			}
		});
		m15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StudentFrm_info_all_Clicked();
			}
		});
		m16.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				exit_Clicked();
			}
		});
		m21.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StudentFrm_score_Clicked();
			}
		});
		m22.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddStudent_score_Clicked();
			}
		});
		m23.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ModifyStudent_score_Clicked();
			}
		});
		m24.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StudentFrm_score_all_Clicked();
			}
		});
		m31.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StudentFrm_all_Clicked();
			}
		});
		m1.add(m11);
		m1.add(m12);
		m1.add(m13);
		m1.add(m14);
		m1.add(m15);
		m1.addSeparator();   
		m1.add(m16);
		m2.add(m21);
		m2.add(m22);
		m2.add(m23);
		m2.add(m24);
		m3.add(m31);
		bar.add(m1);
		bar.add(m2);
		bar.add(m3);
		this.setJMenuBar(bar);
	}

	protected void StudentFrm_all_Clicked() {
		new StudentFrm_all();
	}

	protected void StudentFrm_score_all_Clicked() {
		new StudentFrm_score_all();
	}

	protected void ModifyStudent_score_Clicked() {
		new EnterStudentFrm_modify_score();
	}

	protected void AddStudent_score_Clicked() {
		new AddStudentFrm_score();
	}

	protected void StudentFrm_score_Clicked() {
		new EnterStudentFrm_disp_score();
	}

	protected void StudentFrm_info_Clicked() {
		new EnterStudentFrm_disp_info();
	}

	protected void ModifyStudent_info_Clicked() {
		new EnterStudentFrm_modify_info();
	}

	protected void StudentFrm_info_all_Clicked() {
		new StudentFrm_info_all();
	}

	private void DeleteStudent_info_Clicked() {
		new EnterStudentFrm_delete_info();
	}

	private void AddStudent_info_Clicked() {
		new AddStudentFrm_info();
	}

	private void exit_Clicked() {
		if (JOptionPane.showConfirmDialog(this, "确认退出？", "退出系统",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION)
			System.exit(0);
	}

	public MainFrm() {
		JPanel jp = (JPanel) this.getContentPane();
		initMenu();
		this.setTitle("学生综合测评系统");
		this.setSize(1000, 600);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new MainFrm();
	}
}
