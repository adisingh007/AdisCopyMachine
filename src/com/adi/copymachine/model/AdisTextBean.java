package com.adi.copymachine.model;

import javafx.scene.text.Font;
import javafx.scene.paint.Color;

import com.adi.copymachine.values.Adi;

public class AdisTextBean {
	private double topGap;
	private double lineGap;
	private double leftGap;
	private double rightGap;
	private double letterGap;
	private double fontSize;
	private Color fontColor;
	private Font font;
	private String text;
	private String[] lines;
	private Character[][] characters;
	
	private String fontName;

	public void setTopGap(double topGap) {this.topGap = topGap;}
	public void setLineGap(double lineGap) {this.lineGap = lineGap;}	
	public void setLeftGap(double leftGap) {this.leftGap = leftGap;}
	public void setRightGap(double rightGap) {this.rightGap = rightGap;}
	public void setLetterGap(double letterGap) {this.letterGap = letterGap;}
	public void setFontSize(double fontSize) {
		this.fontSize = fontSize;
		if(fontName != null)
			setFont(fontName);
	} 
	public void setFontColor(Color fontColor) {this.fontColor = fontColor;}
	public void setFont(String fontName) {
		this.fontName = fontName;
		font = Font.loadFont("file:"+Adi.strings.fonts_dir+fontName, fontSize);
	}
	public void setText(String text) {
		this.text = text;
		setLines(text);
	}
	public void setLines(String text) {
		this.lines = text.split("\r\n");
		int maxLength = 0;
		
		for(int i = 0; i < lines.length; i++)
			if(lines[i].length() > maxLength)
				maxLength = lines[i].length();
		
		setCharacters(lines, maxLength);
	}
	public void setCharacters(String[] lines, int maxLength) {
		characters = new Character[lines.length][maxLength];
		for(int i = 0; i < lines.length; i++) {
			for(int j = 0; j < lines[i].length(); j++) {
				characters[i][j] = lines[i].charAt(j);
			}
		}
	}
	
	
	public double getTopGap() {return topGap;}
	public double getLineGap() {return lineGap;}
	public double getLeftGap() {return leftGap;}
	public double getRightGap() {return rightGap;}
	public double getLetterGap() {return letterGap;}
	public double getFontSize() {return fontSize;}
	public Color getFontColor() {return fontColor;}
	public Font getFont() {return font;}
	public String getText() {return text;}
	public String[] getLines() {return lines;}
	public Character[][] getCharacters() {return characters;}
	
	@Override 
	public String toString() {
		return "[Top gap = "+topGap+", "+
			   "Line gap = "+lineGap+", "+
			   "Left gap = "+leftGap+", "+
			   "Letter gap = "+letterGap+", "+
			   "Font size = "+fontSize+", "+
			   "Font color = "+fontColor+", "+
			   "Font = "+font+"]";
	}
	
	public boolean isTextEmpty() {
		if(text == null || text.trim().length() == 0)
			return true;
		return false;	
	}
}