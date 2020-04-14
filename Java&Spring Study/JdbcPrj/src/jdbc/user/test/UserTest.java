package jdbc.user.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jdbc.user.dao.UserDAO;
import jdbc.user.vo.UserVO;

public class UserTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//1. UserDAO ��ü����
		UserDAO dao = new UserDAO();
		UserVO user = dao.getUser("dikang");
		System.out.println(user);
		
//		UserVO updateUser = new UserVO("vega2k", "ȫ�浿3", '��', "����3");
//		int cnt = dao.updateUser(updateUser);
//		System.out.println("���ŵ� �Ǽ� " + cnt);
		
		List<UserVO> list = dao.getUsers();
		for (UserVO userVO : list) {
			System.out.println(userVO);
		}
		
		Map<Integer, UserVO> userMap = new HashMap<>();
		int key = 0;
		for(UserVO userVO : list) {
			key++;
			userMap.put(key, userVO);
		}
		
		//System.out.println(userMap);
		for(Map.Entry<Integer, UserVO> entry : userMap.entrySet()) {
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}
		
	}

}
