package com.example.springframework.game;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GameRunner {
	
	@Autowired
	private GameConsole gc;
	
	public GameRunner(GameConsole gc){
		this.gc=gc;
	}
	
	public void run() {
		gc.up();
		gc.down();
		gc.left();
		gc.right();
	}

}
