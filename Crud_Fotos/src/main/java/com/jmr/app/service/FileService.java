package com.jmr.app.service;

import java.io.IOException;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.jmr.app.datatables.Datatables;
import com.jmr.app.datatables.DatatablesColunas;
import com.jmr.app.domain.File;
import com.jmr.app.repository.FileRepository;

@Service
public class FileService {
	@Autowired
	private FileRepository repository;
	@Autowired
	private Datatables datatables;

	@Transactional(readOnly = false)
	public void salvar(File file) {
		repository.save(file);
	}

	@Transactional(readOnly = true)
	public Map<String, Object> buscarFiles(HttpServletRequest request) {
		datatables.setRequest(request);
		datatables.setColunas(DatatablesColunas.FILES);
		Page<?> page = datatables.getSearch().isEmpty() ? repository.findAll(datatables.getPageable())
				: repository.findAllByTitulo(datatables.getSearch(), datatables.getPageable());
		return datatables.getResponse(page);
	}

	@Transactional(readOnly = true)
	public File buscarPorId(Long id) {
		return repository.findById(id).get();
	}

	@Transactional(readOnly = false)
	public void remover(Long id) {
		repository.deleteById(id);
	}

	@Transactional(readOnly = false)
	public void salvar(File file, MultipartFile fileImage) throws IOException {
		if (!fileImage.isEmpty()) {
			file.setImage(fileImage.getBytes());
		}
		repository.save(file);
	}

	@Transactional(readOnly = true)
	public byte[] buscarImagem(Long id) {
		return repository.findById(id).map(File::getImage).orElse(null);
	}
}