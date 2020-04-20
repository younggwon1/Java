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

	// 사용자 목록
	@GetMapping("/users") //GET
	public List<UserVO> userList() {
		return userService.getUserList();
	}

	// 상세조회
	@GetMapping("/users/{id}") //GET
	public UserVO userDetail(@PathVariable String id) {
		return userService.getUser(id);
	}
	
	// 등록하기
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
	
	//수정하기
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
	
	//삭제하기
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
