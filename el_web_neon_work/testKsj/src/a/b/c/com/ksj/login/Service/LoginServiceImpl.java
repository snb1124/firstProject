package a.b.c.com.ksj.login.Service;

import a.b.c.com.ksj.login.Dao.LoginDAO;
import a.b.c.com.ksj.login.Dao.LoginDAOImpl;
import a.b.c.com.ksj.mem.vo.MemberVO;

public class LoginServiceImpl implements LoginService {

	@Override
	public int loginCheckCnt(MemberVO mvo) {
	System.out.println("LoginServiceImpl loginCheckCnt() 함수 진입 >>> : ");		
		
		LoginDAO ldao = new LoginDAOImpl();
		return ldao.loginCheck(mvo);
	}

}
