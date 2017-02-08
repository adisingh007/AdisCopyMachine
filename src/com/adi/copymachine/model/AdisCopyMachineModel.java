package com.adi.copymachine.model;

import java.io.File;
import java.io.FileInputStream;
import java.util.Scanner;
import java.util.LinkedList;

import javafx.stage.Stage;
import javafx.stage.FileChooser;
import javafx.scene.image.Image;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import com.adi.copymachine.values.Adi;
import com.adi.copymachine.view.AdisCopyMachineApplication;

public class AdisCopyMachineModel {
	public static ObservableList<String> getFonts() {
		ObservableList<String> fontsList = FXCollections.observableList(new LinkedList<String>());
		File fontsDir = new File(Adi.strings.fonts_dir);
		File[] fonts  = fontsDir.listFiles();
		
		for(int i = 0; i < fonts.length; i++) {
			if(!fonts[i].getName().startsWith(Adi.strings.unwanted_file_name)) {	
				fontsList.add(fonts[i].getName());
			}	
		}
		return fontsList;
	}
	
	public static ObservableList<String> getPages() {
		ObservableList<String> pagesList = FXCollections.observableList(new LinkedList<String>());
		File pagesDir = new File(Adi.strings.pages_dir);
		File[] pages  = pagesDir.listFiles();
		
		for(int i = 0; i < pages.length; i++) {
			if(!pages[i].getName().startsWith(Adi.strings.unwanted_file_name)) {	
				pagesList.add(pages[i].getName());
			}	
		}
		return pagesList;
	}
	
	public static Image getImage(String imageName) {
		Image image = null;
		try(FileInputStream fis = new FileInputStream(Adi.strings.pages_dir+imageName)) {
			image = new Image(fis);
		} catch(Exception e) {e.printStackTrace();}
		return image;
	}
	
	public static String getText(Stage primaryStage) {
		FileChooser chooser = new FileChooser();
		chooser.setTitle(Adi.strings.file_chooser_title);
		File file = chooser.showOpenDialog(primaryStage);
		
		String text = "";
		try(Scanner sc = new Scanner(file)) {
			while(sc.hasNextLine()) {
				String line = sc.nextLine();
				text += line + "\r\n";
			}
		} catch(NullPointerException npe) {
			text = "";
		} catch(Exception e) {
			e.printStackTrace();
		}
		return text;
	}
}
