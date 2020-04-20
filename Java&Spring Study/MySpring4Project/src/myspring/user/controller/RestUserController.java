package myspring.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import myspring.user.service.UserService;
import myspring.user.vo.UserVO;

@RestController
//@RequestMapping("/users")
public class RestUserController {
	@Autowired
	UserService userService;

	// ����� ���
	@GetMapping("/users") //GET
	public List<UserVO> userList() {
		return userService.getUserList();
	}

	// ����ȸ
	@GetMapping("/users/{id}") //GET
	public UserVO userDetail(@PathVariable String id) {
		return userService.getUser(id);
	}
	
	// ����ϱ�
	@PostMapping("/users")
	//Json -> java object
	public Boolean userInsert(@RequestBody UserVO user) {
		if(user != null) {
			userService.insertUser(user);
			return Boolean.TRUE;
		}
		else {
			return Boolean.FALSE;
		}
	}
	
	//�����ϱ�
	@PutMapping("/users")
	public Boolean userUpdate(@RequestBody UserVO user) {
		if(user != null) {
			userService.updateUser(user);
			return Boolean.TRUE;
		}
		else {
			return Boolean.FALSE;
		}
	}
	
	//�����ϱ�
	@DeleteMapping("/users/{id}")
	public Boolean userDelete(@RequestBody String id) {
		if(id != null) {
			userService.deleteUser(id);
			return Boolean.TRUE;
		}
		else {
			return Boolean.FALSE;
		}
	}
}
