package com.example.sampleboard;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BoardController {

	private List<String> messages = new ArrayList<>();// 本当はDBから引っ張ってくる

	// getメソッドのこと。引数入れられる。デフォルトだとこれ("/")
	@GetMapping
	public String show(Model model) {
		model.addAttribute("messages", messages);
		return "board";// 文字列のhelloではなくhello.htmlのこと。board.htmlならboard
	}

	@PostMapping
	public String post(@RequestParam String message) {
		messages.add(message);
		return "redirect:/";// Getに任せる
	}
}
