package com.jmr.app.domain;

import javax.persistence.*;

@SuppressWarnings("serial")
@Entity
@Table(name = "files", indexes = { @Index(name = "idx_file_file", columnList = "file") })
public class File extends AbstractEntity {
	@Column(name = "file", unique = true, nullable = false, length = 50)
	private String titulo;
	@Column(name = "descricao", columnDefinition = "TEXT")
	private String descricao;
	@Lob
	@Column(name = "image", columnDefinition = "LONGBLOB")
	private byte[] image;

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}
}
