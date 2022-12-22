package com.example.ktpApp.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.ktpApp.model.AnggotaKeluarga;
import com.example.ktpApp.repository.IAnggotaKeluargaRepository;

@Repository
public class AnggotaKeluargaRepository implements IAnggotaKeluargaRepository {
	@Autowired
	JdbcTemplate JdbcTemplate;

	@Override
	public AnggotaKeluarga insertAnggota(AnggotaKeluarga anggotaKeluarga) {
		// TODO Auto-generated method stub
		String query = "INSERT INTO tb_anggota_keluarga (agama, id_kk, jenis_kelamin, kepala_keluarga, nama, nik, pendidikan, tanggal_lahir, tempat_lahir) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
		JdbcTemplate.update(query, new Object[] {anggotaKeluarga.getAgama(), anggotaKeluarga.getId_kk(), anggotaKeluarga.getJenis_kelamin(), anggotaKeluarga.getKepala_keluarga(), anggotaKeluarga.getNama(), anggotaKeluarga.getNik(), anggotaKeluarga.getPendidikan(), anggotaKeluarga.getTanggal_lahir(), anggotaKeluarga.getTempat_lahir()});
		
		return anggotaKeluarga;
	}

	@Override
	public List<AnggotaKeluarga> getAllAnggota() {
		// TODO Auto-generated method stub
		String query = "SELECT * FROM tb_anggota_keluarga";
		
		return JdbcTemplate.query(query, new BeanPropertyRowMapper<>(AnggotaKeluarga.class));
	}

	@Override
	public AnggotaKeluarga updateAnggota(int id, AnggotaKeluarga anggotaKeluarga) {
		// TODO Auto-generated method stub
		String query = "UPDATE tb_anggota_keluarga SET agama = ?, id_kk = ?, jenis_kelamin = ?, kepala_keluarga = ?, nama = ?, nik = ?, pendidikan = ?, tanggal_lahir = ?, tempat_lahir = ? WHERE id = ?";
		JdbcTemplate.update(query, new Object[] {anggotaKeluarga.getAgama(), anggotaKeluarga.getId_kk(), anggotaKeluarga.getJenis_kelamin(), anggotaKeluarga.getKepala_keluarga(), anggotaKeluarga.getNama(), anggotaKeluarga.getNik(), anggotaKeluarga.getPendidikan(), anggotaKeluarga.getTanggal_lahir(), anggotaKeluarga.getTempat_lahir(), id});
		
		return anggotaKeluarga;
	}

	@Override
	public AnggotaKeluarga deleteAnggota(int id) {
		// TODO Auto-generated method stub
		String query = "SELECT * FROM tb_anggota_keluarga WHERE id = ?";
		var result = JdbcTemplate.queryForObject(query, new BeanPropertyRowMapper<>(AnggotaKeluarga.class), id);
		
		query = "DELETE FROM tb_anggota_keluarga WHERE id = ?";
		JdbcTemplate.update(query, id);
		
		return result;
	}

	@Override
	public AnggotaKeluarga getAnggotaId(int id) {
		// TODO Auto-generated method stub
		String query = "SELECT * FROM tb_anggota_keluarga WHERE id = ?";
		return JdbcTemplate.queryForObject(query, new BeanPropertyRowMapper<>(AnggotaKeluarga.class), id);
	}

	@Override
	public List<AnggotaKeluarga> getAnggotaIdKK(String id_kk) {
		// TODO Auto-generated method stub
		String query = "SELECT * FROM tb_anggota_keluarga WHERE id_kk = ?";
		
		return JdbcTemplate.query(query, new BeanPropertyRowMapper<>(AnggotaKeluarga.class), id_kk);
	}

	@Override
	public List<AnggotaKeluarga> deleteAllAnggota(String id_kk) {
		// TODO Auto-generated method stub
		String query = "SELECT * FROM tb_anggota_keluarga WHERE id_kk = ?";
		var result = JdbcTemplate.query(query, new BeanPropertyRowMapper<>(AnggotaKeluarga.class), id_kk);
		
		query = "DELETE FROM tb_anggota_keluarga WHERE id_kk = ?";
		JdbcTemplate.update(query, id_kk);
		
		return result;
	}

	
	

}
