import http from '../http-common'

class anggotaService {
    insert(data) {
        return http.post("/anggotakeluarga/insert", data);
    }

    getAll() {
        return http.get("/anggotakeluarga/getAll");
    }

    deleteAnggota(id) {
        return http.delete(`/anggotakeluarga/delete/${id}`);
    }

    updateAnggota(id, data) {
        return http.put(`/anggotakeluarga/update/${id}`, data);
    }

    getAnggotaId(id) {
        return http.get(`/anggotakeluarga/getAnggotaId/${id}`);
    }

    getAnggotaIdKK(id_kk) {
        return http.get(`/anggotakeluarga/getAnggotaIdKK/${id_kk}`);
    }

    deleteAllAnggota(id_kk) {
        return http.delete(`/anggotakeluarga/deleteAllAnggota/${id_kk}`);
    }
}

export default new anggotaService();