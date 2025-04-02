package com.example.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Proyect {
	@Id
	private long id;
	private String description;
	private String languaje;
	private boolean open;
	
	public Proyect(Long id, String description, String language, boolean open) {
		this.id = id;
        this.description = description;
        this.languaje = language;
        this.open = open;

	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getLanguaje() {
		return languaje;
	}
	public void setLanguaje(String languaje) {
		this.languaje = languaje;
	}
	public boolean isOpen() {
		return open;
	}
	public void setOpen(boolean open) {
		this.open = open;
	}

	
	
}
