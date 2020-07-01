package web04;

public class JDBCUtil {
	
	public static JDBCUtil instance = new JDBCUtil();
	
	private JDBCUtil() {
		
	}
	
	public void GetConnection() {
		System.out.println("得到一个数据库连接");
	}
	
	public static void main(String[] args) {
		JDBCUtil.instance.GetConnection();
		
		JDBCUtil util = new JDBCUtil();
		util.GetConnection();
	}
}
