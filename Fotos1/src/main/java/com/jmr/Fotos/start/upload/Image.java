package com.jmr.Fotos.start.upload;
import jakarta.persistence.*;

@Entity
@Table(name = "foto_tb")
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String contentType;

    @Lob
    private byte[] data;

	public Long getId() {return id;}

	public void setId(Long id) {this.id = id;}

	public String getName() {return name;}

	public void setName(String name) {this.name = name;}

	public String getContentType() {return contentType;}

	public void setContentType(String contentType) {this.contentType = contentType;}

	public byte[] getData() {return data;}

	public void setData(byte[] data) {this.data = data;}
    
    
}