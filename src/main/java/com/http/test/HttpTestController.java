package com.http.test;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HttpTestController {
	@GetMapping("/get")
	public String get() {
		return "http get test";
	}
	
	@GetMapping("/get/json")
	public @ResponseBody Map<String, Object> getJson() {
		Map<String, Object> returnData = new HashMap<String, Object>();
		returnData.put("test", 123);
		return returnData;
	}
	
	@PostMapping("/post")
	public @ResponseBody Map<String, Object> post(@RequestParam HashMap<String, Object> param) {
		Map<String, Object> returnData = new HashMap<String, Object>();
		
		param.forEach((key, value) -> {
			returnData.put(key, value);
		});
		returnData.put("result", "Y");
		return returnData;
	}
}
