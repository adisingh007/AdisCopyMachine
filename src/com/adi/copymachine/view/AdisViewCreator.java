package com.adi.copymachine.view;

import javafx.stage.Stage;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ColorPicker;
import javafx.scene.paint.Color;
import javafx.scene.image.ImageView;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.geometry.Pos;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;

import com.adi.copymachine.values.Adi;
import com.adi.copymachine.model.AdisTextBean;
import com.adi.copymachine.model.AdisCopyMachineModel;
import com.adi.copymachine.view.AdisCopyMachineApplication;

class AdisViewCreator {
	private Stage primaryStage;

	private Slider topGapSlider;
	private Slider lineGapSlider;
	private Slider leftGapSlider;
	private Slider rightGapSlider;
	private Slider letterGapSlider;
	private Slider fontSizeSlider;
	
	private ComboBox<String> fontsBox;
	private ComboBox<String> pagesBox;
	private ColorPicker fontColorPicker;
	private Button selectTextButton;
	private Button saveButton;
	
	private ImageView pageView;
	private VBox textBox;

	private AdisTextBean bean;

	AdisViewCreator(Stage primaryStage) {this.primaryStage = primaryStage;}

	BorderPane getRootPane() {
		BorderPane rootPane = new BorderPane();
		rootPane.setPadding(new Insets(Adi.dimens.root_pane_top, Adi.dimens.root_pane_right,
									   Adi.dimens.root_pane_bottom, Adi.dimens.root_pane_left));
		rootPane.setStyle(Adi.styles.root_pane_style);							   
		return rootPane;							   
	}
	
	GridPane getLeftPane() {
		Label topGapLabel  = new Label(Adi.strings.top_gap_text);
		Label lineGapLabel = new Label(Adi.strings.line_gap_text);
		GridPane.setHalignment(topGapLabel,  HPos.CENTER);
		GridPane.setHalignment(lineGapLabel, HPos.CENTER);
		GridPane.setValignment(topGapLabel,  VPos.CENTER);
		GridPane.setValignment(lineGapLabel, VPos.CENTER);
		
		topGapSlider = new Slider();
		topGapSlider.setMin(Adi.dimens.top_gap_min);
		topGapSlider.setMax(Adi.dimens.top_gap_max);
		topGapSlider.setValue(Adi.dimens.top_gap_max);
		GridPane.setHalignment(topGapSlider, HPos.CENTER);
		GridPane.setValignment(topGapSlider, VPos.CENTER);
		topGapSlider.setOrientation(Orientation.VERTICAL);
		
		lineGapSlider = new Slider();
		lineGapSlider.setMin(Adi.dimens.line_gap_min);
		lineGapSlider.setMax(Adi.dimens.line_gap_max);
		lineGapSlider.setValue(Adi.dimens.line_gap_max);
		GridPane.setHalignment(lineGapSlider, HPos.CENTER);
		GridPane.setValignment(lineGapSlider, VPos.CENTER);
		lineGapSlider.setOrientation(Orientation.VERTICAL);
		
		GridPane leftPane = new GridPane();
		leftPane.setHgap(Adi.dimens.left_pane_hgap);
		leftPane.setVgap(Adi.dimens.left_pane_vgap);
		leftPane.setAlignment(Pos.CENTER);
		leftPane.add(topGapLabel,   0, 0, 3, 1);
		leftPane.add(lineGapLabel,  3, 0, 3, 1);
		leftPane.add(topGapSlider,  1, 1, 1, 25);
		leftPane.add(lineGapSlider, 4, 1, 1, 25);
	
		return leftPane;
	}
	
	GridPane getBottomPane() {
		Label letterGapLabel = new Label(Adi.strings.letter_gap_text);
		Label leftGapLabel   = new Label(Adi.strings.left_gap_text);
		Label rightGapLabel   = new Label(Adi.strings.right_gap_text);
		Label fontSizeLabel   = new Label(Adi.strings.font_size_text);
		GridPane.setHalignment(letterGapLabel, HPos.CENTER);
		GridPane.setValignment(letterGapLabel, VPos.CENTER);
		GridPane.setHalignment(leftGapLabel, HPos.CENTER);
		GridPane.setValignment(leftGapLabel, VPos.CENTER);
		GridPane.setHalignment(rightGapLabel, HPos.CENTER);
		GridPane.setValignment(rightGapLabel, VPos.CENTER);
		GridPane.setHalignment(fontSizeLabel, HPos.CENTER);
		GridPane.setValignment(fontSizeLabel, VPos.CENTER);
		
		letterGapSlider = new Slider();
		letterGapSlider.setMin(Adi.dimens.letter_gap_min);
		letterGapSlider.setMax(Adi.dimens.letter_gap_max);
		GridPane.setHalignment(letterGapSlider, HPos.CENTER);
		GridPane.setValignment(letterGapSlider, VPos.CENTER);
		
		leftGapSlider = new Slider();
		leftGapSlider.setMin(Adi.dimens.left_gap_min);
		leftGapSlider.setMax(Adi.dimens.left_gap_max);
		GridPane.setHalignment(leftGapSlider, HPos.CENTER);
		GridPane.setValignment(leftGapSlider, VPos.CENTER);
		
		rightGapSlider = new Slider();
		rightGapSlider.setMin(Adi.dimens.right_gap_min);
		rightGapSlider.setMax(Adi.dimens.right_gap_max);
		rightGapSlider.setValue(Adi.dimens.right_gap_max);
		GridPane.setHalignment(rightGapSlider, HPos.CENTER);
		GridPane.setValignment(rightGapSlider, VPos.CENTER);
		
		fontSizeSlider = new Slider();
		fontSizeSlider.setMin(Adi.dimens.font_size_min);
		fontSizeSlider.setMax(Adi.dimens.font_size_max);
		GridPane.setHalignment(fontSizeSlider, HPos.CENTER);
		GridPane.setValignment(fontSizeSlider, VPos.CENTER);
		
		GridPane bottomPane = new GridPane();
		bottomPane.setHgap(Adi.dimens.bottom_pane_hgap);
		bottomPane.setVgap(Adi.dimens.bottom_pane_vgap);
		bottomPane.setAlignment(Pos.CENTER);
		bottomPane.add(letterGapLabel,  0, 0, 2, 1);
		bottomPane.add(leftGapLabel,    0, 1, 2, 1);
		bottomPane.add(rightGapLabel,   54, 1, 2, 1);
		bottomPane.add(fontSizeLabel,   0, 2, 2, 1);
		bottomPane.add(letterGapSlider, 2, 0, 25, 1);
		bottomPane.add(leftGapSlider,   2, 1, 25, 1);
		bottomPane.add(rightGapSlider,  28, 1, 25, 1);
		bottomPane.add(fontSizeSlider,  2, 2, 25, 1);
		
		return bottomPane;
	}
	
	GridPane getRightPane() {
		Label selectFontLabel      = new Label(Adi.strings.select_font);
		Label selectPageLabel      = new Label(Adi.strings.select_page);
		Label selectFontColorLabel = new Label(Adi.strings.select_font_color);
		
		fontsBox = new ComboBox<>();
		fontsBox.setItems(AdisCopyMachineModel.getFonts());
		fontsBox.setVisibleRowCount(Adi.vals.visible_row_count);
		fontsBox.getSelectionModel().selectFirst();
		
		pagesBox = new ComboBox<>();
		pagesBox.setItems(AdisCopyMachineModel.getPages());
		pagesBox.setVisibleRowCount(Adi.vals.visible_row_count);
		pagesBox.getSelectionModel().selectFirst();
	
		fontColorPicker = new ColorPicker();
		fontColorPicker.setValue(Color.BLACK);
	
		selectTextButton = new Button(Adi.strings.select_text);
		GridPane.setHalignment(selectTextButton, HPos.CENTER);
		GridPane.setValignment(selectTextButton, VPos.CENTER);

		saveButton = new Button(Adi.strings.save_text);
		GridPane.setHalignment(saveButton, HPos.CENTER);
		GridPane.setValignment(saveButton, VPos.CENTER);		
		
		GridPane rightPane = new GridPane();
		rightPane.setHgap(Adi.dimens.right_pane_hgap);
		rightPane.setVgap(Adi.dimens.right_pane_vgap);
		rightPane.setAlignment(Pos.CENTER);
		rightPane.add(selectFontLabel,      0, 0, 2, 1);
		rightPane.add(fontsBox,             0, 1, 2, 1);
		rightPane.add(selectPageLabel,      0, 2, 2, 1);
		rightPane.add(pagesBox,             0, 3, 2, 1);
		rightPane.add(selectFontColorLabel, 0, 4, 3, 1);
		rightPane.add(fontColorPicker,      0, 5, 3, 3);
		rightPane.add(selectTextButton,     1, 8, 2, 1);
		rightPane.add(saveButton,           1, 9, 2, 1);
		
		return rightPane;
	}
	
	StackPane getCenterPane() {
		pageView = new ImageView();
		pageView.setFitWidth(Adi.dimens.page_width);
		pageView.setFitHeight(Adi.dimens.page_height);
		pageView.setImage(AdisCopyMachineModel.getImage(pagesBox.getValue()));
		
		textBox = new VBox();
		textBox.setMaxWidth(Adi.dimens.page_width);
		textBox.setMaxHeight(Adi.dimens.page_height);
		
		StackPane centerPane = new StackPane();
		centerPane.setAlignment(Pos.CENTER);
		centerPane.getChildren().addAll(pageView, textBox);
		
		return centerPane;
	}
	
	void setListeners() {
		bean = new AdisTextBean();
		bean.setTopGap(topGapSlider.getMax() - topGapSlider.getValue());
		bean.setLineGap(lineGapSlider.getMax() - lineGapSlider.getValue());
		bean.setLetterGap(letterGapSlider.getValue());
		bean.setLeftGap(leftGapSlider.getValue());
		bean.setRightGap(rightGapSlider.getMax() - rightGapSlider.getValue());
		bean.setFontSize(fontSizeSlider.getValue());
		bean.setFontColor(fontColorPicker.getValue());
		bean.setFont(fontsBox.getValue());
		
		topGapSlider.valueChangingProperty().addListener((obs, wasChanging, isChanging) -> {
			if(!isChanging) {
				bean.setTopGap(Adi.dimens.top_gap_max - topGapSlider.getValue());
				showText();
			}	
		});
		lineGapSlider.valueChangingProperty().addListener((obs, wasChanging, isChanging) -> {
			if(!isChanging) {
				bean.setLineGap(Adi.dimens.line_gap_max - lineGapSlider.getValue());
				showText();
			}	
		});
		letterGapSlider.valueChangingProperty().addListener((obs, wasChanging, isChanging) -> {
			if(!isChanging) {
				bean.setLetterGap(letterGapSlider.getValue());
				showText();
			}
		});
		leftGapSlider.valueChangingProperty().addListener((obs, wasChanging, isChanging) -> {
			if(!isChanging) {
				bean.setLeftGap(leftGapSlider.getValue());
				showText();
			}
		});
		rightGapSlider.valueChangingProperty().addListener((obs, wasChanging, isChanging) -> {
			if(!isChanging) {
				bean.setRightGap(Adi.dimens.right_gap_max - rightGapSlider.getValue());
				showText();
			}
		});
		fontSizeSlider.valueChangingProperty().addListener((obs, wasChanging, isChanging) -> {
			if(!isChanging) {
				bean.setFontSize(fontSizeSlider.getValue());
				showText();
			}	
		});
		
		fontsBox.setOnAction(e -> {
			bean.setFont(fontsBox.getValue());
			showText();
		});
		
		pagesBox.setOnAction(e -> {
			pageView.setImage(AdisCopyMachineModel.getImage(pagesBox.getValue()));
			showText();
		});
		
		fontColorPicker.setOnAction(e -> {
			bean.setFontColor(fontColorPicker.getValue());
			showText();
		});
		
		selectTextButton.setOnAction(e -> {
			bean.setText(AdisCopyMachineModel.getText(primaryStage));
			showText();
		});
		
		saveButton.setOnAction(e -> {
			
		});
	}
	
	private void showText() {
		if(bean.isTextEmpty())
			return;	
		initTextBox();	
	}
	
	private void initTextBox() {
		if(bean.getFontSize() == 0 || bean.isTextEmpty())
			return;
	
		textBox.getChildren().clear();
		textBox.setSpacing(bean.getLineGap());
		textBox.setPadding(new Insets(bean.getTopGap(), bean.getRightGap(), 0, bean.getLeftGap()));
		
		int index = 0;
		int ind = 0;
		Character[][] chars = bean.getCharacters();		

		for(double i = bean.getTopGap(); i < textBox.getHeight() - bean.getFontSize(); 
										i += bean.getFontSize() + bean.getLineGap()) {						
			HBox singleLineBox = new HBox(letterGapSlider.getValue());
			singleLineBox.setMaxWidth(textBox.getWidth() - bean.getLeftGap() - bean.getRightGap());
			singleLineBox.setMaxHeight(bean.getFontSize());

			textBox.getChildren().add(singleLineBox);
			
			ind = setText(singleLineBox, chars[index], ind);
			if(ind == chars[index].length) {
				index++;
				ind = 0;
				if(index == chars.length)
					return;
			} else
				ind++;
		}
	}
	
	private int setText(HBox singleLineBox, Character[] line, int start) {
		double length = 0;
		int i = start;
		
		for(; i < line.length; i++) {
			if(line[i] == null)
				continue;
				
			Text txt = new Text(line[i]+"");
			txt.setFont(bean.getFont());
			txt.setFill(bean.getFontColor());
			
			singleLineBox.getChildren().add(txt);
			length += txt.getLayoutBounds().getWidth() + bean.getLetterGap();
			
			if(length >= Adi.dimens.page_width - bean.getLeftGap() - bean.getRightGap()) {
				break;
			}
		}
		return i;
	}
}
