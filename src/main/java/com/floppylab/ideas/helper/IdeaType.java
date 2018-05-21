package com.floppylab.ideas.helper;

public enum IdeaType {
	
	YELLOW("#f0dd27"),
	GREEN("#9bb909"),
	BLUE("#72cbc7"),
	RED("#e75335"),
	PINK("#db74a3"),
	GREY("#cfe5d9"),
	ORANGE("#fdad4c");
	
	String color;
	
	private IdeaType(String color) {
		this.color = color;
	}
	
	public String getColor() {
		return color;
	}
	
	public String getName() {
		return this.name();
	}
	
}
