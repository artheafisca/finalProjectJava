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

import com.example.ktpApp.model.AnggotaKeluarga;
import com.example.ktpApp.service.IAnggotaKeluargaService;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/api/anggotakeluarga")
public class AnggotaKeluargaController {
	@Autowired
	IAnggotaKeluargaService anggotaKeluargaService;
	
	@PostMapping("/insert")
	public AnggotaKeluarga insertAKeluarga(@RequestBody AnggotaKeluarga anggotaKeluarga) {
		return anggotaKeluargaService.insertAnggota(anggotaKeluarga);
	}
	
	@GetMapping("/getAll")
	public List<AnggotaKeluarga> getAllAnggota() {
		return anggotaKeluargaService.getAllAnggota();
	}
	
	@PutMapping("/update/{id}")
	public AnggotaKeluarga updateAnggota(@PathVariable int id, @RequestBody AnggotaKeluarga anggotaKeluarga) {
		return anggotaKeluargaService.updateAnggota(id, anggotaKeluarga);
	}
	
	@DeleteMapping("/delete/{id}")
	public AnggotaKeluarga deleteAnggota(@PathVariable int id) {
		return anggotaKeluargaService.deleteAnggota(id);
	}
	
	@GetMapping("/getAnggotaId/{id}")
	public AnggotaKeluarga getAnggotaId(@PathVariable int id) {
		return anggotaKeluargaService.getAnggotaById(id);
	}
	
	@GetMapping("/getAnggotaIdKK/{id_kk}")
	public List<AnggotaKeluarga> getAnggotaIdKK(@PathVariable String id_kk) {
		return anggotaKeluargaService.getAnggotaIdKK(id_kk);
	}
	
	@DeleteMapping("/deleteAllAnggota/{id_kk}")
	public List<AnggotaKeluarga> deleteAllAnggota(@PathVariable String id_kk) {
		return anggotaKeluargaService.deleteAllAnggota(id_kk);
	}
 
}
