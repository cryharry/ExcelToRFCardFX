package application;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import com.extentech.ExtenXLS.WorkBookHandle;
import com.extentech.ExtenXLS.WorkSheetHandle;
import com.extentech.formats.XLS.CellNotFoundException;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class ExcelController implements Initializable {
	@FXML
	private Stage primaryStage;
	@FXML
	private FileChooser fc;
	@FXML
	private File file;
	@FXML
	private String classStr, banStr, numStr, nameStr, rfStr, excelFile, selSheet = "";
	@FXML
	private TextField excelField;
	@FXML
	private String[] cellValue, replaceValue, splitStr;
	@FXML
	private int getRow, getCol;
	@FXML
	private ComboBox<String> sheetCombo;
	@FXML
	private WorkBookHandle work;
	@FXML
	private WorkSheetHandle sheet;
	@FXML
	private Button excelBtn, execBtn;
	
	public void excuteMerit() {
		for(int j=1;j < getRow;j++) {
				splitStr = replaceValue[j-1].split(",");
				for(int i=0; i<splitStr.length; i++) {
					
				}
		}
	}
	
	
	public ObservableList<String> getSheetsName() {
		ObservableList<String> comboList = FXCollections.observableArrayList();
		WorkSheetHandle[] workSheets = work.getWorkSheets();
		for(int i=0;i<workSheets.length;i++) {
			comboList.add(workSheets[i].getSheetName());
		}
		return comboList;
	}
	
	@FXML
	public void handleOpenExcel() {
		fc = new FileChooser();
		fc.setTitle("엑셀 파일 선택 - xls");
		FileChooser.ExtensionFilter xlsFilter = new FileChooser.ExtensionFilter("xls file(*.xls)", "*.xls");
		fc.getExtensionFilters().add(xlsFilter);
		file =  fc.showOpenDialog(primaryStage);
		if(file == null) {
			handleOpenExcel();
		}
		this.excelFile = file.getPath().replace("\\", "/");
		excelField.setText(excelFile);
		work = new WorkBookHandle(file);
		ObservableList<String> sheetName = getSheetsName();
		sheetCombo.setItems(sheetName);
		sheetCombo.valueProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				selSheet = newValue;
				try {
					sheet = work.getWorkSheet(selSheet);
				} catch (Exception e) {	}
				getRow = sheet.getLastRow();
				getCol = sheet.getLastCol();
				cellValue = new String[getRow];
				replaceValue = new String[getRow];
				ObservableList<Student> studentData = FXCollections.observableArrayList();
				
				for(int j=0;j < getRow; j++) {
					for(int i=0;i < getCol; i++) {
						try {
							switch(i) {
							case 0:
								classStr = sheet.getCell(j,i).getVal().toString();
								break;
							case 1:
								banStr = sheet.getCell(j,i).getVal().toString();
								break;
							case 2:
								numStr = sheet.getCell(j,i).getVal().toString();
								break;
							case 3:
								nameStr = sheet.getCell(j,i).getVal().toString();
								break;
							case 4:
								rfStr = String.valueOf(sheet.getCell(j,i).getVal());
								break;
							default:
								break;
							}
							//cellValue[j-1] += sheet.getCell(j,i).getVal() + ",";
						} catch (CellNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					System.out.println("학년:"+classStr+" 반:"+banStr+" 번호:"+numStr+" 이름:"+nameStr+" RF:"+rfStr);
					//replaceValue[j-1] = cellValue[j-1].replaceAll("null", "");
				}
			}
		});
	}
	
	public static boolean isStringCheck(String s) {
		try {
			Double.parseDouble(s);
			return true;
		} catch(NumberFormatException e) {
			return false;
		}
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	}
}
