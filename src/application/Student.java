package application;

import javafx.beans.property.SimpleStringProperty;

public class Student {
	private SimpleStringProperty classStr;
	private SimpleStringProperty banStr;
	private SimpleStringProperty numStr;
	private SimpleStringProperty nameStr;
	private SimpleStringProperty rfStr;
	
	private Student(String classStr, String banStr, String numStr, String nameStr, String rfStr) {
		this.classStr = new SimpleStringProperty(classStr);
		this.banStr = new SimpleStringProperty(banStr);
		this.numStr = new SimpleStringProperty(numStr);
		this.nameStr = new SimpleStringProperty(nameStr);
		this.rfStr = new SimpleStringProperty(rfStr);
	}

	public SimpleStringProperty getClassStr() {
		return classStr;
	}

	public void setClassStr(SimpleStringProperty classStr) {
		this.classStr = classStr;
	}

	public SimpleStringProperty getBanStr() {
		return banStr;
	}

	public void setBanStr(SimpleStringProperty banStr) {
		this.banStr = banStr;
	}

	public SimpleStringProperty getNumStr() {
		return numStr;
	}

	public void setNumStr(SimpleStringProperty numStr) {
		this.numStr = numStr;
	}

	public SimpleStringProperty getNameStr() {
		return nameStr;
	}

	public void setNameStr(SimpleStringProperty nameStr) {
		this.nameStr = nameStr;
	}

	public SimpleStringProperty getRfStr() {
		return rfStr;
	}

	public void setRfStr(SimpleStringProperty rfStr) {
		this.rfStr = rfStr;
	}
}
