package com.htc.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonInclude;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@ApiModel(description = "Tous les détails concernant les todolist")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Todolist {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty(notes = "la base de donnee va generer le ID todolist")
	private Long id;
	@ApiModelProperty(notes = "la designation todolist")
	private String nom;
	@ApiModelProperty(notes = "le commentaire todolist")
	private String description;
	@ManyToOne
	@JoinColumn(name="utilisateur")
	@ApiModelProperty(notes = "l'etat du bon de travail")
	private User utilisateur;
	private Boolean completed=false;
	public Todolist() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Todolist(Long id, String nom, String description, User utilisateur, Boolean completed) {
		super();
		this.id = id;
		this.nom = nom;
		this.description = description;
		this.utilisateur = utilisateur;
		this.completed = completed;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public User getUtilisateur() {
		return utilisateur;
	}
	public void setUtilisateur(User utilisateur) {
		this.utilisateur = utilisateur;
	}
	public Boolean getCompleted() {
		return completed;
	}
	public void setCompleted(Boolean completed) {
		this.completed = completed;
	}

	
	
}
