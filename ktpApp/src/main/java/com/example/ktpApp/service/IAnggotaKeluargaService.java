package com.example.ktpApp.service;

import java.util.List;

import com.example.ktpApp.model.AnggotaKeluarga;

public interface IAnggotaKeluargaService {
	public AnggotaKeluarga insertAnggota(AnggotaKeluarga anggotaKeluarga);
	public List<AnggotaKeluarga> getAllAnggota();
	public AnggotaKeluarga updateAnggota(int id, AnggotaKeluarga anggotaKeluarga);
	public AnggotaKeluarga deleteAnggota(int id);
	public AnggotaKeluarga getAnggotaById(int id);
	public List<AnggotaKeluarga> getAnggotaIdKK (String id_kk);
	public List<AnggotaKeluarga> deleteAllAnggota(String id_kk);

}
