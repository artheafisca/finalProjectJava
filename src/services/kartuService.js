import http from '../http-common'

class kartuService {
    insert(data) {
        return http.post("/kartukeluarga/insert", data);
    }

    getAll() {
        return http.get("/kartukeluarga/getAll");
    }

    deleteKK(id) {
        return http.delete(`/kartukeluarga/delete/${id}`);
    }

    updateKK(id, data) {
        return http.put(`/kartukeluarga/update/${id}`, data);
    }

    updateId(id) {
        return http.get(`/kartukeluarga/updateId/${id}`);
    }
}

export default new kartuService();