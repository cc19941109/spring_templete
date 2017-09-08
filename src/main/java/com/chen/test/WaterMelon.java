package com.chen.test;

public class WaterMelon {

	private String name;
	private int id;
	private double cost;

	public WaterMelon(String name, int id, double cost) {
		super();
		this.name = name;
		this.id = id;
		this.cost = cost;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	@Override
	public String toString() {
		return "WaterMelon [name=" + name + ", id=" + id + ", cost=" + cost + "]";
	}

}
