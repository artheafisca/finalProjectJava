package com.example.ktpApp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ktpApp.model.KartuKeluarga;
import com.example.ktpApp.repository.IKartuKeluargaRepository;
import com.example.ktpApp.service.IKartuKeluargaService;

@Service
public class KartuKeluargaService implements IKartuKeluargaService {
	@Autowired
	IKartuKeluargaRepository KartuKeluargaRepository;

	@Override
	public KartuKeluarga insertKartuKeluarga(KartuKeluarga kartuKeluarga) {
		// TODO Auto-generated method stub
		return KartuKeluargaRepository.insertKartuKeluarga(kartuKeluarga);
	}

	@Override
	public List<KartuKeluarga> getAllKK() {
		// TODO Auto-generated method stub
		return KartuKeluargaRepository.getAllKK();
	}

	@Override
	public KartuKeluarga updateKartuKeluarga(int id, KartuKeluarga kartuKeluarga) {
		// TODO Auto-generated method stub
		return KartuKeluargaRepository.updateKK(id, kartuKeluarga);
	}

	@Override
	public KartuKeluarga deleKartuKeluarga(int id) {
		// TODO Auto-generated method stub
		return KartuKeluargaRepository.deleteKK(id);
	}

	@Override
	public KartuKeluarga updateId(int id) {
		// TODO Auto-generated method stub
		return KartuKeluargaRepository.updateId(id);
	}

}
