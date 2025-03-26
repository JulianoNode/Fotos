package com.jmr.app.domain;

import javax.persistence.*;

@SuppressWarnings("serial")
@Entity
@Table(name = "files", indexes = { @Index(name = "idx_file_file", columnList = "file") })
public class File extends AbstractEntity {
	@Column(name = "file", unique = true, nullable = false, length = 50)
	private String nome;
	@Column(name = "contentType", columnDefinition = "TEXT")
	private String contentType;
	@Lob
	@Column(name = "image", columnDefinition = "LONGBLOB")
	private byte[] image;
	
	//______ Get e Set _____
	public String getnome() {return nome;}
	public void setnome(String nome) {this.nome = nome;}
	public String getContentType() {return contentType;}
	public void setContentType(String contentType) {this.contentType = contentType;}
	public byte[] getImage() {return image;}
	public void setImage(byte[] image) {this.image = image;}
}
