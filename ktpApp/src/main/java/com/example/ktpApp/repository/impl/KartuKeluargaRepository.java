package com.example.ktpApp.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.ktpApp.model.KartuKeluarga;
import com.example.ktpApp.repository.IKartuKeluargaRepository;

@Repository
public class KartuKeluargaRepository implements IKartuKeluargaRepository {
	@Autowired
	JdbcTemplate JdbcTemplate;

	@Override
	public KartuKeluarga insertKartuKeluarga(KartuKeluarga kartuKeluarga) {
		// TODO Auto-generated method stub
		String query = "INSERT INTO tb_kartu_keluarga (alamat, desa_kelurahan, kabupaten_kota, kecamatan, kode_pos, nomor_kk, provinsi, rt, rw) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
		JdbcTemplate.update(query, new Object[] {kartuKeluarga.getAlamat(), kartuKeluarga.getDesa_kelurahan(), kartuKeluarga.getKabupaten_kota(), kartuKeluarga.getKecamatan(), kartuKeluarga.getKode_pos(), kartuKeluarga.getNomor_kk(), kartuKeluarga.getProvinsi(), kartuKeluarga.getRt(), kartuKeluarga.getRw() } );
		
		return kartuKeluarga;
	}

	@Override
	public List<KartuKeluarga> getAllKK() {
		// TODO Auto-generated method stub
		String query = "SELECT * FROM tb_kartu_keluarga";
		
		return JdbcTemplate.query(query, new BeanPropertyRowMapper<>(KartuKeluarga.class));
	}

	@Override
	public KartuKeluarga updateKK(int id, KartuKeluarga kartuKeluarga) {
		// TODO Auto-generated method stub
		String query = "UPDATE tb_kartu_keluarga SET alamat = ?, desa_kelurahan = ?, kabupaten_kota = ?, kecamatan = ?, kode_pos = ?, nomor_kk = ?, provinsi = ?, rt = ?, rw = ? WHERE id = ?";
		JdbcTemplate.update(query, new Object[] {kartuKeluarga.getAlamat(), kartuKeluarga.getDesa_kelurahan(), kartuKeluarga.getKabupaten_kota(), kartuKeluarga.getKecamatan(), kartuKeluarga.getKode_pos(), kartuKeluarga.getNomor_kk(), kartuKeluarga.getProvinsi(), kartuKeluarga.getRt(), kartuKeluarga.getRw(), id});
		
		return kartuKeluarga;
	}

	@Override
	public KartuKeluarga deleteKK(int id) {
		// TODO Auto-generated method stub
		String query = "SELECT * FROM tb_kartu_keluarga WHERE id = ?";
		var result = JdbcTemplate.queryForObject(query, new BeanPropertyRowMapper<>(KartuKeluarga.class), id);
		
		query = "DELETE FROM tb_kartu_keluarga WHERE id = ?";
		JdbcTemplate.update(query, id);
		
		return result;
	}

	@Override
	public KartuKeluarga updateId(int id) {
		// TODO Auto-generated method stub
		String query = "SELECT * FROM tb_kartu_keluarga WHERE id = ?";
		var result = JdbcTemplate.queryForObject(query, new BeanPropertyRowMapper<>(KartuKeluarga.class), id);
		
		return result;
	}

}
