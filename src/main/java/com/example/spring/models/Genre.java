package com.example.spring.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "genre")
public class Genre {

	@Id
	private String id;

	private String filepath;



	public String getFilepath() {
		return filepath;
	}

	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}

	private String type;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Genre(String filepath, String type) {
		super();
		this.filepath = filepath;
		this.type = type;
	}

	@Override
	public String toString() {
		return "Genre [id=" + id + ", filepath=" + filepath + ", type=" + type + "]";
	}

}