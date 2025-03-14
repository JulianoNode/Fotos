package com.jmr.Fotos.start.upload;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class ImageService {

	private final ImageRepository imageRepository;

	public ImageService(ImageRepository imageRepository) {
		this.imageRepository = imageRepository;
	}

	public List<Image> getAllImages() {
		return imageRepository.findAll();
	}

	public Optional<Image> getImageById(Long id) {
		return imageRepository.findById(id);
	}

	public Image saveImage(MultipartFile file) throws IOException {
		Image image = new Image();
		image.setName(file.getOriginalFilename());
		image.setData(file.getBytes());
		image.setContentType(file.getContentType());
		return imageRepository.save(image);
	}

	public void deleteImage(Long id) {
		imageRepository.deleteById(id);
	}
}