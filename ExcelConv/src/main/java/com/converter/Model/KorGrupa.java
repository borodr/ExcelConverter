package com.converter.Model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name="korgrupa")
@NamedQuery(name="KorGrupa.findAll", query="SELECT k FROM KorGrupa k")
public class KorGrupa implements Serializable{

	
	@Id
	@Column(name="id")
	private int id;
	
	
	@Column(name="sifra")
	private int sifra;
	
	@Column(name="opis")
	private String opis;
	
	@Column(name="nivo")
	private int novi;

	
	public KorGrupa() {}
	
	public KorGrupa(int id, int sifra, String opis, int novi) {
		super();
		this.id = id;
		this.sifra = sifra;
		this.opis = opis;
		this.novi = novi;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSifra() {
		return sifra;
	}

	public void setSifra(int sifra) {
		this.sifra = sifra;
	}

	public String getOpis() {
		return opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	public int getNovi() {
		return novi;
	}

	public void setNovi(int novi) {
		this.novi = novi;
	}
	
	
	
}
