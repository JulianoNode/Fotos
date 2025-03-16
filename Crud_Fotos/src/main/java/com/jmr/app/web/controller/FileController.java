package com.jmr.app.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jmr.app.domain.File;
import com.jmr.app.service.FileService;

@Controller
@RequestMapping("files")
public class FileController {
	@Autowired
	private FileService service;

	@GetMapping({ "", "/" })
	public String abrir(File file) {
		return "file/fileCad";
	}

	@GetMapping("/datatables/server")
	public ResponseEntity<?> getFiles(HttpServletRequest request) {
		return ResponseEntity.ok(service.buscarFiles(request));
	}

	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("file", service.buscarPorId(id));
		return "file/fileCad";
	}

	@GetMapping("/excluir/{id}")
	public String abrir(@PathVariable("id") Long id, RedirectAttributes attr) {
		service.remover(id);
		attr.addFlashAttribute("sucesso", "Operação realizada com sucesso.");
		return "redirect:/files";
	}

	@PostMapping("/salvar")
	public String salvar(@ModelAttribute File file, @RequestParam("fileImage") MultipartFile fileImage,
			RedirectAttributes attr) {
		try {
			service.salvar(file, fileImage);
			attr.addFlashAttribute("sucesso", "Operação realizada com sucesso!");
		} catch (Exception e) {
			attr.addFlashAttribute("aviso", "Erro ao salvar arquivo!");
		}
		return "redirect:/files";
	}

	@GetMapping("/image/{id}")
	public ResponseEntity<byte[]> exibirImagem(@PathVariable Long id) {
		byte[] image = service.buscarImagem(id);
		if (image != null) {
			return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(image);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
}