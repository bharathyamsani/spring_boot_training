package com.example.springframework.game;

import org.springframework.stereotype.Component;

@Component
public class SuperContraGame implements GameConsole {
	
	public void up() {
		System.out.println("SuperContra up");
	}
	
	public void down() {
		System.out.println("SuperContra down");
	}
	
	public void left() {
		System.out.println("SuperContra left");
	}
	
	public void right() {
		System.out.println("SuperContra right");
	}

}