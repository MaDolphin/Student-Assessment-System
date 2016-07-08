package project;
import java.math.BigDecimal;
import java.sql.*;
public class StudentDao {
	private String driver = "sun.jdbc.odbc.JdbcOdbcDriver";
	private String url = "jdbc:odbc:mydb";

	private void executeUpdate(String sql) {
		try {
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url);
			Statement cmd = con.createStatement();
			cmd.executeUpdate(sql);
			con.close(); 
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public boolean modifyStudent_info(String sno, String sname, String sex, String add ,String tel) {
		String sql = "update stu_pro set sno = '"+sno+"',sname = '"+sname+"',sex = '"+sex+"',add = '"+add
				+"',tel = '"+tel+"'where sno = '"+sno+"' ";
		executeUpdate(sql);
		orderStudent_no_test();
		orderStudent_no_syn();
		return true ;
	}
	
	public boolean modifyStudent_score(String sno,double math,double physics,double english,double score_ave,
			double score_tog,double score_pol,double score_tea,double score_syn){
		String sql = "update stu_pro set math = '"+math+"',physics = '"+physics+"',english = '"+english
				+"',score_ave = '"+score_ave+"',score_tog = '"+score_tog+"',score_pol = '"+score_pol
				+"',score_tea = '"+score_tea+"',score_syn = '"+score_syn+"' where sno = '"+sno+"' ";
		executeUpdate(sql);
		orderStudent_no_test();
		orderStudent_no_syn();
		return true;
	}
	
	public void orderStudent_no_syn(){
		String[][] rows = null;
		int rowcount=0;
		try {
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url);
			Statement cmd = con.createStatement();
			String sql = "select count(*) from stu_pro";
			ResultSet rs = cmd.executeQuery(sql);
			rs.next();
			rowcount = rs.getInt(1);
			rows = new String[rowcount][3];
			sql = "select * from stu_pro order by score_syn desc";
			rs = cmd.executeQuery(sql);
			rowcount = 0;
			while (rs.next()) {
					rows[rowcount][0] = rs.getString(1);
					rows[rowcount][1] = rs.getString(15);
					rows[rowcount][2] = String.valueOf(rowcount+1);
				rowcount++;
			}
			con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		for(int i=0;i<rows.length;i++){
			executeUpdate("update stu_pro set no_syn = '"+rows[i][2]+"' where sno='"+rows[i][0]+"'");
		}
	}
	
	public void orderStudent_no_test(){
		String[][] rows = null;
		int rowcount=0;
		try {
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url);
			Statement cmd = con.createStatement();
			String sql = "select count(*) from stu_pro";
			ResultSet rs = cmd.executeQuery(sql);
			rs.next();
			rowcount = rs.getInt(1);
			rows = new String[rowcount][3];
			sql = "select * from stu_pro order by score_ave desc";
			rs = cmd.executeQuery(sql);
			rowcount = 0;
			while (rs.next()) {
					rows[rowcount][0] = rs.getString(1);
					rows[rowcount][1] = rs.getString(9);
					rows[rowcount][2] = String.valueOf(rowcount+1);
				rowcount++;
			}
			con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		for(int i=0;i<rows.length;i++){
			executeUpdate("update stu_pro set no_test = '"+rows[i][2]+"' where sno='"+rows[i][0]+"'");
		}
	}
	
	public boolean addStudent_info(String sno, String sname, String sex, String add ,String tel) {
		int flag=-1;
		try {
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url);
			Statement cmd = con.createStatement();
			String sql = "select count(sno) from stu_pro where sno = '"+sno+"' ";
			ResultSet rs = cmd.executeQuery(sql);
			rs.next();
			flag=rs.getInt(1);
			con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		if(flag==0){
			String sql = "insert into stu_pro(sno,sname,sex,add,tel) values('"+sno+"','"+sname+"','"+sex+"','"+add+"','"+tel+"')";
			executeUpdate(sql);
			return true ;
		}else return false;
	}
	
	public int addStudent_score(String sno,double math,double physics,double english,double score_ave,
			double score_tog,double score_pol,double score_tea,double score_syn) {
		int flag=-1;
		StudentDao studentDao = new StudentDao();
		try {
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url);
			Statement cmd = con.createStatement();
			String sql = "select count(sno) from stu_pro where sno = '"+sno+"' ";
			ResultSet rs = cmd.executeQuery(sql);
			rs.next();
			flag=rs.getInt(1);
			con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		if(flag==0)
			return flag;
		else{
			String[] temp_info=studentDao.queryStudents_info_one(sno);
			String[] temp_score=studentDao.queryStudents_score_one(sno);
			for(int i=1;i<temp_info.length;i++){
				if(temp_info[i]==null){
					flag=1;return flag;
				}
			}
			for(int i=2;i<temp_score.length;i++){
				if(temp_score[i]!=null){
					flag=2;return flag;
				}
			}
			String sql = "update stu_pro set math = '"+math+"',physics = '"+physics+"',english = '"+english
					+"',score_ave = '"+score_ave+"',score_tog = '"+score_tog+"',score_pol = '"+score_pol
					+"',score_tea = '"+score_tea+"',score_syn = '"+score_syn+"' where sno = '"+sno+"' ";
			executeUpdate(sql);
			orderStudent_no_test();
			orderStudent_no_syn();
			return flag=3;

		}
	}

	public void deleteStudent_sno(String sno) {
		String sql = "delete  from stu_pro where sno='" + sno + "'";
		executeUpdate(sql);
		orderStudent_no_test();
		orderStudent_no_syn();
	}

	public String[][] queryStudents_all() {
		String[][] rows = null;
		try {
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url);
			Statement cmd = con.createStatement();
			String sql = "select count(*) from stu_pro";
			ResultSet rs = cmd.executeQuery(sql);
			rs.next();
			int rowcount = rs.getInt(1);
			rows = new String[rowcount][15];
			sql = "select * from stu_pro order by sno asc";
			rs = cmd.executeQuery(sql);
			rowcount = 0;
			while (rs.next()) {
				for (int i = 1; i <= 15; i++)
					rows[rowcount][i - 1] = rs.getString(i);
				rowcount++;
			}
			con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return rows;
	}
	
	public String[][] queryStudents_info_all() {
		String[][] rows = null;
		try {
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url);
			Statement cmd = con.createStatement();
			String sql = "select count(*) from stu_pro";
			ResultSet rs = cmd.executeQuery(sql);
			rs.next();
			int rowcount = rs.getInt(1);
			rows = new String[rowcount][5];
			sql = "select * from stu_pro order by sno asc";
			rs = cmd.executeQuery(sql);
			rowcount = 0;
			while (rs.next()) {
				for (int i = 1; i <= 5; i++)
					rows[rowcount][i - 1] = rs.getString(i);
				rowcount++;
			}
			con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return rows;
	}
	
	public String[][] queryStudents_score_all(int t) {
		String[][] rows = null;
		try {
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url);
			Statement cmd = con.createStatement();
			String sql = "select count(*) from stu_pro";
			ResultSet rs = cmd.executeQuery(sql);
			rs.next();
			int rowcount = rs.getInt(1);
			rows = new String[rowcount][12];
			switch(t){
			case 0:sql = "select * from stu_pro order by sno asc";break;
			case 1:sql = "select * from stu_pro order by no_test asc";break;
			case 2:sql = "select * from stu_pro order by no_syn asc";break;
			}
			rs = cmd.executeQuery(sql);
			rowcount = 0;
			while (rs.next()) {
				rows[rowcount][0] = rs.getString(1);
				rows[rowcount][1] = rs.getString(2);
				for (int i = 6; i <= 15; i++)
					rows[rowcount][i - 4] = rs.getString(i);
				rowcount++;
			}
			con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return rows;
	}

	public String[] queryStudents_score_one(String sno) {
		String[] rows = null;
		try {
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url);
			Statement cmd = con.createStatement();
			String sql = "select * from stu_pro where sno = '"+sno+"'";
			ResultSet rs = cmd.executeQuery(sql);
			rs.next();
			rows = new String[12];
			rows[0] = rs.getString(1);
			rows[1] = rs.getString(2);
			for (int i = 6; i <= 15; i++)
				rows[i - 4] = rs.getString(i);
			con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return rows;
	}
	
	public String[] queryStudents_info_one(String sno) {
		String[] rows = null;
		try {
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url);
			Statement cmd = con.createStatement();
			String sql = "select * from stu_pro where sno = '"+sno+"'";
			ResultSet rs = cmd.executeQuery(sql);
			rs.next();
			rows = new String[5];
			for (int i = 1; i <= 5; i++)
				rows[i-1] = rs.getString(i);
			con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return rows;
	}	

	public boolean isExist(String sno){
		int flag=0;
		try {
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url);
			Statement cmd = con.createStatement();
			String sql = "select count(sno) from stu_pro where sno = '"+sno+"' ";
			ResultSet rs = cmd.executeQuery(sql);
			rs.next();
			flag=rs.getInt(1);
			con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		if(flag==1)
			return true;
		else return false;
	}
}
