package com.dudrnjs.myspringboot.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.dudrnjs.myspringboot.entity.Account;
import com.dudrnjs.myspringboot.entity.User;
import com.dudrnjs.myspringboot.exception.CustomException;
import com.dudrnjs.myspringboot.exception.ResourceNotFoundException;
import com.dudrnjs.myspringboot.repository.UserRepository;
import com.dudrnjs.myspringboot.service.AccountService;

@Controller
public class UserController {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private AccountService accountService;
	
	
	@GetMapping("/accountForm")
	public String accountForm(Account account) {
		return "add-account";
	}
	
	@PostMapping("/addAccount")
	public String addAccount(@ModelAttribute Account account) {
		Account addAccount = accountService.createAccount(account.getUsername(), account.getPassword());
		System.out.println(">>>>>.등록된 Account : " + addAccount);
		return "redirect:/index.html";
	}
	
	
	@GetMapping("/mypage")
	public String mypage() {
		return "mypage";
	}
	
	@ExceptionHandler(Exception.class)
	public ModelAndView handleException(Exception ex) {
		return new ModelAndView("error/generic_error", "errMsg", ex.getMessage());
		
	}
	
	@ExceptionHandler(CustomException.class)
	public ModelAndView handleCustomException(CustomException ex) {
		ModelAndView model = new ModelAndView("error/generic_error");
		model.addObject("errCode", ex.getErrCode());
		model.addObject("errMsg",ex.getErrMsg());
		return model;
	}
	
	@GetMapping("/delete/{id}")
	public String deleteUser(@PathVariable("id") long id) {
//		User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
		User user = userRepository.findById(id).orElseThrow(() -> new CustomException("E001", String.format("해당 User ID : %s 가 존재하지 않습니다.", id)));
		userRepository.delete(user);
		return "redirect:/index";
	}
	
	
	@PostMapping("/edituser/{id}")
	public String updateUser(@PathVariable("id") long id, @Valid User user, BindingResult result) {
		if (result.hasErrors()) {
			user.setId(id);//update-user로 돌아가기 위해서 id를 받아야한다.
			return "update-user";
		}
		userRepository.save(user);
		return "redirect:/index";
	}
	

	@GetMapping("/edit/{id}")
	public ModelAndView showUpdateForm(@PathVariable long id) {
		User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
		return new ModelAndView("update-user", "user", user);
	}

	@PostMapping("/adduser")
	public String addUser(@Valid User user, BindingResult result) {
		if (result.hasErrors()) {
			return "add-user";
		}
		userRepository.save(user);
		return "redirect:/index";
	}

	@GetMapping("/signup")
	public String showSignupForm(User user) {
		return "add-user";
	}

	@GetMapping("/index")
	public String index(Model model) {
		model.addAttribute("users", userRepository.findAll());
		return "index";
	}

	@GetMapping("/leaf")
	public ModelAndView leaf() {
		return new ModelAndView("leaf", "name", "타임리프");
	}
}
