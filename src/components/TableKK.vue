<template>
    <div id="wrapper" class="toggled">
        <!-- Page Content -->
        <div id="page-content-wrapper">
            <div class="container-fluid">
                <h2> <strong>Homepage</strong> </h2>
                <div class="d-flex">
                  <div class="card mr-4" style="width: 13rem; height: 6rem">
                    <div class="card-body rounded" style="border: 1px solid aqua;">
                      <h6 class="card-title">Jumlah Kartu Keluarga</h6>
                      <h4 class="card-text"> <strong>{{kartuData.length}}</strong> </h4>
                    </div>
                  </div>

                  <div class="card" style="width: 13rem; height: 6rem">
                    <div class="card-body rounded" style="border: 1px solid aqua;">
                      <h6 class="card-title">Jumlah Seluruh Warga</h6>
                      <h4 class="card-text"> <strong>{{anggotaData.length}}</strong> </h4>
                    </div>
                  </div>
                </div>
                
                <div class="mt-5">
                  <h1 class="mb-3"> <center>Data Kartu Keluarga</center> </h1>
                  
                  <table class="table table-striped" >
                    <thead>
                      <tr class="text-center">
                        <th scope="col">No</th>
                        <th scope="col">Nomor KK</th>
                        <th scope="col">Alamat</th>
                        <th scope="col">Kota</th>
                        <th scope="col">Kode Pos</th>
                        <th scope="col">Action</th>
                      </tr>
                    </thead>
                    
                    <tbody v-if="kartuData.length">
                      <tr v-for="(item, index) in kartuData" :key="item.id" class="text-center">
                        <th> {{index + 1}} </th>
                        <td> {{item.nomor_kk}} </td>
                        <td>{{item.alamat}}</td>
                        <td> {{item.kabupaten_kota}} </td>
                        <td> {{item.kode_pos}} </td>
                        <td>
                          <router-link :to="{name: 'detailKK', params:{id: item.id} }" @click="$emit('detailTable',item)"
                            class="btn btn-primary">
                              <b-icon-eye></b-icon-eye> Detail
                          </router-link>
                          <button class="btn btn-danger ml-2" @click="deleteKK(item.id)">
                            <b-icon-trash></b-icon-trash> Delete
                          </button>
                        </td>
                      </tr>
                    </tbody>

                    <tbody v-else >
                      <tr class="text-center">
                        <td colspan="6">
                            <h5>Data tidak tersedia</h5>
                        </td>
                      </tr>
                    </tbody>
                  </table>
                </div>
            </div>
        </div>
        <!-- /#page-content-wrapper -->
    </div>
</template>

<script>
import kartuService from '../services/kartuService'
import anggotaService from '@/services/anggotaService'
import Swal from 'sweetalert2'

export default {
    name: "TableKKComponent",
    data(){
      return {
        kartuData: "",
        anggotaData: ""
      }
    },
    methods: {
        getKartu(){
            kartuService.getAll()
                .then(response => {
                    this.kartuData = response.data;
                    console.log(this.kartuData);
                })
                .catch(e => {
                    console.log(e);
                })
        },
        getAllAnggota() {
            anggotaService.getAll()
                .then(response => {
                    this.anggotaData = response.data;
                })
                .catch(e => {
                    console.log(e);
                })
        },
        deleteKK(id) {
            Swal.fire({
            title: 'Apakah anda akan menghapus data KK ini beserta anggotanya?',
            showDenyButton: true,
            showCancelButton: false,
            confirmButtonText: 'Delete',
            denyButtonText: `Cancel`,
            })
              .then((result) => {
            /* Read more about isConfirmed, isDenied below */
                if (result.isConfirmed) {
                    kartuService.deleteKK(id)
                      .then(response => {
                        anggotaService.deleteAllAnggota(id)
                          .then (response => {
                            console.log(response.data)
                          })
                          console.log(response.data)
                          Swal.fire('Sukses!', 'Data Berhasil Dihapus', 'success')
                          .then(() => {
                            location.reload()
                          })
                      })
                } else if (result.isDenied) {
                  Swal.fire('Hapus dibatalkan!', '', 'info')
                }
            })
        }
    },
    mounted(){
        this.getKartu();
        this.getAllAnggota();
    },
}
</script>

<style scoped>
body {
  overflow-x: hidden;
  
}
#wrapper {
  padding-left: 0;
  -webkit-transition: all 0.5s ease;
  -moz-transition: all 0.5s ease;
  -o-transition: all 0.5s ease;
  transition: all 0.5s ease;
}

#wrapper.toggled {
  padding-left: 250px;
}

#page-content-wrapper {
  width: 100%;
  position: absolute;
  padding: 15px;
}

#wrapper.toggled #page-content-wrapper {
  position: absolute;
  margin-right: -250px;
}
@media(min-width:768px) {
    #page-content-wrapper {
        padding: 20px;
        position: relative;
    }
    #wrapper.toggled #page-content-wrapper {
        position: relative;
        margin-right: 0;
    }
}
</style>