package com.example.ktpApp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ktpApp.model.AnggotaKeluarga;
import com.example.ktpApp.repository.IAnggotaKeluargaRepository;
import com.example.ktpApp.service.IAnggotaKeluargaService;

@Service
public class AnggotaKeluargaService implements IAnggotaKeluargaService {
	@Autowired
	IAnggotaKeluargaRepository AnggotaKeluargaRepository;

	@Override
	public AnggotaKeluarga insertAnggota(AnggotaKeluarga anggotaKeluarga) {
		// TODO Auto-generated method stub
		return AnggotaKeluargaRepository.insertAnggota(anggotaKeluarga);
	}

	@Override
	public List<AnggotaKeluarga> getAllAnggota() {
		// TODO Auto-generated method stub
		return AnggotaKeluargaRepository.getAllAnggota();
	}

	@Override
	public AnggotaKeluarga updateAnggota(int id, AnggotaKeluarga anggotaKeluarga) {
		// TODO Auto-generated method stub
		return AnggotaKeluargaRepository.updateAnggota(id, anggotaKeluarga);
	}

	@Override
	public AnggotaKeluarga deleteAnggota(int id) {
		// TODO Auto-generated method stub
		return AnggotaKeluargaRepository.deleteAnggota(id);
	}

	@Override
	public AnggotaKeluarga getAnggotaById(int id) {
		// TODO Auto-generated method stub
		return AnggotaKeluargaRepository.getAnggotaId(id);
	}

	@Override
	public List<AnggotaKeluarga> getAnggotaIdKK(String id_kk) {
		// TODO Auto-generated method stub
		return AnggotaKeluargaRepository.getAnggotaIdKK(id_kk);
	}

	@Override
	public List<AnggotaKeluarga> deleteAllAnggota(String id_kk) {
		// TODO Auto-generated method stub
		return AnggotaKeluargaRepository.deleteAllAnggota(id_kk);
	}

}
