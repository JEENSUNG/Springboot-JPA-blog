package com.cos.blog.test;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
//사용자가 요청 -> 응답(HTML 파일)
//@Controller
//해당 경로 이하에 있는 파일을 리턴하므로 슬러시(/) 필요
//사용자가 요청 -> 응답(Data)
@RestController//String을 보내면 String을 리턴해줌
public class HttpControllerTest {
	
	private static final String TAG= "HttpControllerTest :";
	@GetMapping("/http/lombok")
	public String lombokTest() {
		Member m = new Member(1, "ff", "gg", "gg");
		System.out.println(TAG + "getter :" + m.getId());
		m.setId(5000);
		return "lombok test 끝";
	}
	//인터넷 브라우저 요청은 무조건 get만된다. post,put은 실행안됨
	//http://localhost:8080/http/get(select)
	@GetMapping("/http/get")
	public String getTest(Member m) {
		m.setId(5000);
		System.out.println(TAG +"getter : "+ m.getId());
		return "get 요청 : " + m.getId() + "," + m.getUsername();
	} // 이렇게 해도 되고
	
	//public String getTest(Member m) {
	//return "get 요청 : " + m.getId() + ","+m.getUsername() + "," + m.getPassword();;
	
	//http://localhost:8080/http/post(insert)
	@PostMapping("/httml/post")
	public String postTest(@RequestBody String text) {
		return "post 요청 : " + text;
	}
	//@RequestBody로 JSON, TEXT 등 보낼 수 있음. 이건 BODY로 보내는거고 위에는 PARAM으로 보내는것
	//JSON으로 POST하고싶으면 (@RequestBody Member m) {
	//return "post 요청 : "," m.getId()...;
	//http://localhost:8080/http/put(update)
	@PutMapping("/http/put")
	public String putTest() {
		return "put 요청";
	}
	//http://localhost:8080/http/delete(delete)
	@DeleteMapping("/http/delete")
	public String deleteTest() {
		return "delete 요청";
	}
}
