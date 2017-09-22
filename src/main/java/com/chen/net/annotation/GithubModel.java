package com.chen.net.annotation;

public class GithubModel {

	private String name;

	private String author;

	private String readme;

	public GithubModel() {
		super();
	}

	public GithubModel(String name, String author, String readme) {
		super();
		this.name = name;
		this.author = author;
		this.readme = readme;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getReadme() {
		return readme;
	}

	public void setReadme(String readme) {
		this.readme = readme;
	}

	@Override
	public String toString() {
		return "GithubModel [name=" + name + ", author=" + author + ", readme=" + readme + "]";
	}

}
