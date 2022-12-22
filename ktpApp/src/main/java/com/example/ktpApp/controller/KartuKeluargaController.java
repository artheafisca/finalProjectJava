package com.example.ktpApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ktpApp.model.KartuKeluarga;
import com.example.ktpApp.service.IKartuKeluargaService;

@RestController
@CrossOrigin(origins = "http://localhost:8080/")
@RequestMapping("/api/kartukeluarga")
public class KartuKeluargaController {
	@Autowired
	IKartuKeluargaService kartuKeluargaService;
	
	@PostMapping("/insert")
	public KartuKeluarga insertKartuKeluarga(@RequestBody KartuKeluarga kartuKeluarga) {
		return kartuKeluargaService.insertKartuKeluarga(kartuKeluarga);
	}
	
	@GetMapping("/getAll")
	public List<KartuKeluarga> getAllKK() {
		return kartuKeluargaService.getAllKK();
	}
	
	@PutMapping("/update/{id}")
	public KartuKeluarga updateKK(@PathVariable int id, @RequestBody KartuKeluarga kartuKeluarga) {
		return kartuKeluargaService.updateKartuKeluarga(id, kartuKeluarga);
	}
	
	@DeleteMapping("/delete/{id}")
	public KartuKeluarga deleteKK(@PathVariable int id) {
		return kartuKeluargaService.deleKartuKeluarga(id);
	}
	
	@GetMapping("/updateId/{id}")
	public KartuKeluarga updateId(@PathVariable int id) {
		return kartuKeluargaService.updateId(id);
	}

}
