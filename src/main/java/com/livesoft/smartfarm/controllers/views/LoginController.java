package com.livesoft.smartfarm.controllers.views;

import java.util.HashMap;
import java.util.Map;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.livesoft.smartfarm.models.entities.SecurityUser;
import com.livesoft.smartfarm.models.entities.UserRole.RoleType;
import com.livesoft.smartfarm.models.values.UserValue;
import com.livesoft.smartfarm.services.UserService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class LoginController {

	private final UserService userService;

	@GetMapping(value = "/")
	public String index(@AuthenticationPrincipal SecurityUser securityUser) {
		if (securityUser != null) {
			if (securityUser.getRoleTypes().contains(RoleType.ROLE_VIEW)) {
				return "redirect:/v";
			}
		}
		return "redirect:/v";
	}

	@GetMapping(value = "/login")
	public String login(@AuthenticationPrincipal SecurityUser securityUser) {
		if (securityUser != null && securityUser.getRoleTypes().contains(RoleType.ROLE_VIEW)) {
			return "redirect:/v";
		}
		if (securityUser != null && securityUser.getRoleTypes().contains(RoleType.ROLE_ADMIN)) {
			return "redirect:/v";
		}
		return "login/login";
	}

	@RequestMapping(value = "/err/denied-page")
	public String accessDenied() {
		return "err/deniedPage";
	}

	@GetMapping(value = "/join")
	public String joinForm(@AuthenticationPrincipal SecurityUser securityUser) {
		if (securityUser != null && securityUser.getRoleTypes().contains(RoleType.ROLE_VIEW)) {
			return "redirect:/v";
		}
		return "login/join";
	}

	@ResponseBody
	@PostMapping(value = "/join")
	public Map<String, Object> join(@RequestBody UserValue value) {
		Map<String, Object> response = new HashMap<>();

		if (userService.existsByEmail(value.getEmail())) {
			response.put("duplicate", true);
			return response;
		}

		response.put("success", userService.join(value) != null ? true : false);
		return response;
	}

}
