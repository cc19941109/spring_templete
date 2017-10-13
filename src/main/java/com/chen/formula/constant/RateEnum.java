package com.chen.formula.constant;


public enum RateEnum {

	City(0), SubStation(1), PoliceStation(2);

	Integer id;

	
	 RateEnum(int  id) {
		this.id = id;
		
	}

	public int  getId() {
		return id;
	}
	
}
