package com.example.ktpApp.service;

import java.util.List;

import com.example.ktpApp.model.KartuKeluarga;

public interface IKartuKeluargaService {
	public KartuKeluarga insertKartuKeluarga(KartuKeluarga kartuKeluarga);
	public List<KartuKeluarga> getAllKK();
	public KartuKeluarga updateKartuKeluarga(int id, KartuKeluarga kartuKeluarga);
	public KartuKeluarga deleKartuKeluarga(int id);
	public KartuKeluarga updateId(int id);
}
