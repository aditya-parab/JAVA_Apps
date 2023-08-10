package com.neebalgurukul.utilities;

public class AreaUtlities {
	
	public int getAreaRectange(int length,int breadth) {
		return length*breadth;
	}
	
	public int getPerimeterRectange(int length,int breadth) {
		return 2*length+2*breadth;
	}
	
	public boolean isRectShape(int side1,int side2) {
		if(side1==side2) {
			return false;
		}
		else {
			return true;
		}
	}

}
