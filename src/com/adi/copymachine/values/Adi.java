package com.adi.copymachine.values;

import javafx.stage.Screen;

public class Adi {
	public static class dimens {
		public static final int root_pane_top    = 10;
		public static final int root_pane_right  = 10;
		public static final int root_pane_bottom = 10;
		public static final int root_pane_left   = 10;
		
		public static final int screen_width  = (int)Screen.getPrimary().getVisualBounds().getWidth();
		public static final int screen_height = (int)Screen.getPrimary().getVisualBounds().getHeight();
		
		public static final int page_width  = screen_width / 2 - screen_width / 7;
		public static final int page_height = (screen_height / 2) + (screen_width / 6);
		
		public static final int top_gap_min    = 0;
		public static final int line_gap_min   = 0;
		public static final int letter_gap_min = 0;
		public static final int left_gap_min   = 0;
		public static final int right_gap_min  = 0;
		public static final int font_size_min  = 0;
		
		public static final int top_gap_max    = page_height;
		public static final int line_gap_max   = page_height; 
		public static final int letter_gap_max = page_width;
		public static final int left_gap_max   = page_width;
		public static final int right_gap_max  = page_width;
		public static final int font_size_max  = 50;
		
		public static final int left_pane_hgap = 20;
		public static final int left_pane_vgap = 20;
		public static final int bottom_pane_hgap = 10;
		public static final int bottom_pane_vgap = 10;
		public static final int right_pane_hgap = 10;
		public static final int right_pane_vgap = 10;
	}
	
	public static class vals {
		public static final int visible_row_count = 4;
	}
	
	public static class strings {
		public static final String app_title = "Adi's copy machine";
		public static final String file_chooser_title = "Select file";
		
		public static final String top_gap_text    = "Top Gap";
		public static final String line_gap_text   = "Line Gap";
		public static final String letter_gap_text = "Letter gap"; 
		public static final String left_gap_text   = "Left gap";
		public static final String right_gap_text   = "Right gap";
		public static final String font_size_text  = "Font size";
		
		public static final String select_text = "Select text";
		public static final String save_text   = "Save page";
		
		public static final String fonts_dir = "etc/fonts/";
		public static final String pages_dir = "etc/pages/";
		
		public static final String select_font      = "Select font";
		public static final String select_page      = "Select page";
		public static final String select_font_color = "Select font color";
		
		public static final String unwanted_file_name = ".";
	}
	
	public static class styles {
		public static final String root_pane_style = "-fx-background-color: #FFFF004F;";
	}
}