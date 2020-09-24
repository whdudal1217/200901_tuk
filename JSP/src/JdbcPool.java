import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import conn.ConnectionPool;
import member.dao.MemberDao;
import member.model.Member;

public class JdbcPool {
	public static void main(String[] args) {
		MemberDao memberDao = MemberDao.getInstance();
		ConnectionPool pool = ConnectionPool.getInstance();

		Connection conn = null;

		try {
			System.out.println("커넥션(풀) 시작");
			conn = pool.getConnection();
			System.out.println("커넥션(풀) 성공");

			Member member = new Member();

			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

			System.out.print("id : ");
			member.setMem_id(reader.readLine());
			System.out.print("pwd : ");
			member.setMem_pwd(reader.readLine());
			System.out.print("name : ");
			member.setMem_name(reader.readLine());
			System.out.print("phone : ");
			member.setMem_phone(reader.readLine());
			System.out.print("email :");
			member.setMem_email(reader.readLine());
			int updCnt = memberDao.insertMember(conn, member);
			System.out.println(updCnt + "개의 행이 등록 되었습니다.");

			ArrayList<Member> memberList = memberDao.selectMemberList(conn);

			for (Member m : memberList) {
				System.out.printf(" seqNo : %d id : %s pwd : %s  name : %s  phone :  %s  email : %s \n ",
						m.getMem_seq_no(), m.getMem_id(), m.getMem_pwd(), m.getMem_name(), m.getMem_phone(),
						m.getMem_email());
			}

		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				pool.releaseConnection(conn);
			}
		}

	}
}















