package com.example.springframework.game;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class PacmanGame implements GameConsole {
	
	public void up() {
		System.out.println("Pacman up");
	}
	
	public void down() {
		System.out.println("Pacman down");
	}
	
	public void left() {
		System.out.println("Pacman left");
	}
	
	public void right() {
		System.out.println("Pacman right");
	}

}