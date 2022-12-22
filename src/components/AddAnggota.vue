<template>
<div id="wrapper" class="toggled">
        <div id="page-content-wrapper">
            <div class="container-fluid">
                <h2> <strong>{{tittleValue}} Anggota Keluarga</strong> </h2>
                <div class="mt-5">
                    <router-link :to="{name: 'listAnggota'}" v-show="tittleValue == 'Detail'" class="btn mb-4" style="background-color: aqua;">
                        <b-icon-arrow-left></b-icon-arrow-left> Back
                    </router-link>
                    <button @click="btnBack" v-show="tittleValue != 'Detail'" class="btn mb-4" style="background-color: aqua;">
                        <b-icon-arrow-left></b-icon-arrow-left> Back
                    </button>
                    <button class="btn btn-success mb-4 ml-2" v-show="!btnUp && tittleValue != 'Tambah'" @click= "updateToggle" >
                        <b-icon-pencil></b-icon-pencil> Update Anggota
                    </button>
                    <div class="border p-4">
                        <form @submit.prevent="inputAnggota">
                            <div class="form-row w-100">
                                <div class="form-group col-md-6">
                                    <label>NIK</label>
                                    <input 
                                        type="text" 
                                        class="form-control"
                                        :class="{
                                        'is-invalid' : validasi && $v.anggotaData.nik.$error
                                        }" 
                                        placeholder="NIK"
                                        v-model="anggotaData.nik"
                                        :disabled="!bacadoang">
                                        <div 
                                        v-if="validasi && !$v.anggotaData.nik.required" 
                                        class="invalid-feedback">
                                        NIK tidak boleh kosong!
                                    </div>
                                </div>
                                <div class="form-group col-md-6">
                                    <label>Tanggal Lahir</label>
                                    <input 
                                        type="date" 
                                        class="form-control"
                                        :class="{
                                        'is-invalid' : validasi && $v.anggotaData.tanggal_lahir.$error
                                        }" 
                                        v-model="anggotaData.tanggal_lahir"
                                        :disabled="!bacadoang" >
                                        <div 
                                        v-if="validasi && !$v.anggotaData.tanggal_lahir.required" 
                                        class="invalid-feedback">
                                        Tanggal lahir tidak boleh kosong!
                                    </div>
                                </div>
                            </div>

                            <div class="form-row">
                                <div class="form-group col-md-6">
                                    <label>Nama</label>
                                    <input 
                                        type="text" 
                                        class="form-control" 
                                        :class="{
                                        'is-invalid' : validasi && $v.anggotaData.nama.$error
                                        }"
                                        placeholder="Nama Lengkap"
                                        v-model="anggotaData.nama"
                                        :disabled="!bacadoang">
                                        <div 
                                        v-if="validasi && !$v.anggotaData.nama.required" 
                                        class="invalid-feedback">
                                        Nama tidak boleh kosong!
                                    </div>
                                </div>
                                <div class="form-group col-md-6">
                                    <label>Agama</label>
                                    <input 
                                        type="text" 
                                        class="form-control" 
                                        :class="{
                                        'is-invalid' : validasi && $v.anggotaData.agama.$error
                                        }"
                                        placeholder="Agama"
                                        v-model="anggotaData.agama"
                                        :disabled="!bacadoang">
                                        <div 
                                        v-if="validasi && !$v.anggotaData.agama.required" 
                                        class="invalid-feedback">
                                        Agama tidak boleh kosong!
                                    </div>
                                </div>
                            </div>

                            <div class="form-row">
                                <div class="form-group col-md-6">
                                    <label>Jenis Kelamin</label>
                                    <select class="form-control" 
                                    :class="{
                                        'is-invalid' : validasi && $v.anggotaData.jenis_kelamin.$error
                                        }"
                                        v-model="anggotaData.jenis_kelamin"
                                        :disabled="!bacadoang">
                                        <option>Pria</option>
                                        <option>Wanita</option>
                                    </select>
                                    <div 
                                        v-if="validasi && !$v.anggotaData.jenis_kelamin.required" 
                                        class="invalid-feedback">
                                        Jenis kelamin tidak boleh kosong!
                                    </div>
                                </div>
                                <div class="form-group col-md-6">
                                    <label>Pendidikan</label>
                                    <input 
                                        type="text" 
                                        class="form-control"
                                        :class="{
                                        'is-invalid' : validasi && $v.anggotaData.pendidikan.$error
                                        }" 
                                        placeholder="Pendidikan"
                                        v-model="anggotaData.pendidikan"
                                        :disabled="!bacadoang">
                                        <div 
                                        v-if="validasi && !$v.anggotaData.pendidikan.required" 
                                        class="invalid-feedback">
                                        Pendidikan tidak boleh kosong!
                                    </div>
                                </div>
                            </div>

                            <div class="form-row">
                                <div class="form-group col-md-6">
                                    <label>Tempat Lahir</label>
                                    <input 
                                        type="text" 
                                        class="form-control" 
                                        :class="{
                                        'is-invalid' : validasi && $v.anggotaData.tempat_lahir.$error
                                        }" 
                                        placeholder="Nama Lahir"
                                        v-model="anggotaData.tempat_lahir"
                                        :disabled="!bacadoang">
                                        <div 
                                        v-if="validasi && !$v.anggotaData.tempat_lahir.required" 
                                        class="invalid-feedback">
                                        Tempat lahir tidak boleh kosong!
                                    </div>
                                </div>
                                <div class="form-group col-md-6">
                                    <label>Kepala Keluarga</label>
                                    <select class="form-control" 
                                    :class="{
                                        'is-invalid' : validasi && $v.anggotaData.kepala_keluarga.$error
                                        }"
                                        v-model="anggotaData.kepala_keluarga"
                                        :disabled="!bacadoang">
                                        <option>Yes</option>
                                        <option>No</option>
                                    </select>
                                    <div 
                                        v-if="validasi && !$v.anggotaData.kepala_keluarga.required" 
                                        class="invalid-feedback">
                                        Kepala keluarga tidak boleh kosong!
                                    </div>
                                </div>
                            </div>
                            <button v-show="btnUpdate" @click="btnCancel" type="button" class="btn btn-danger mr-2">
                                <b-icon-x></b-icon-x> Cancel
                            </button>
                            <button v-show="btnUpdate" type="submit" class="btn mr-2" style="background-color: aqua;">
                                <b-icon-check></b-icon-check> {{buttonValue}}
                            </button>
                            <button v-show="tittleValue == 'Tambah'" type="submit" class="btn" style="background-color: aqua;">
                                <b-icon-check></b-icon-check> {{buttonValue}}
                            </button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <!-- /#page-content-wrapper -->
    </div>
</template>

<script>
import anggotaService from '../services/anggotaService'
import Swal from 'sweetalert2'
import { required } from 'vuelidate/lib/validators'

export default {
    name: 'AddAnggotaComponent',
    data() {
        return {
            anggotaData: {
                "agama"             : '',
                "id_kk"             : this.$route.params.id,
                "jenis_kelamin"     : '',
                "kepala_keluarga"   : '',
                "nama"              : '',
                "nik"               : '',
                "pendidikan"        : '',
                "tanggal_lahir"     : '',
                "tempat_lahir"      : '',
            },
            buttonValue: "Submit",
            tittleValue: "Tambah",
            btnUpdate: false,
            bacadoang: false,
            validasi: false,
            btnUp: false
        }
    },
    validations: {
        anggotaData: {
                "agama"             : {required},
                "jenis_kelamin"     : {required},
                "kepala_keluarga"   : {required},
                "nama"              : {required},
                "nik"               : {required},
                "pendidikan"        : {required},
                "tanggal_lahir"     : {required},
                "tempat_lahir"      : {required},
            },
    },
    methods: {
        inputAnggota() {
            this.validasi = true;
            this.$v.$touch();
            if (this.$v.$invalid) {
                return;
            }

            let data = this.anggotaData;

            if(this.buttonValue === 'Submit') {

                anggotaService.insert(data)
                    .then(response => {
                        console.log(response.data);
                        Swal.fire(
                        'Sukses!',
                        'Data anggota berhasil ditambah!',
                        'success',
                        )
                        .then(() => {
                            location.reload();
                        });
                    })
                    .catch(e => {
                        console.log(e);
                        Swal.mixin({
                        toast: true,
                        position: "top",
                        iconColor: "white",
                        customClass: {
                            popup: "colored-toast",
                        },
                        showConfirmButton: false,
                        timer: 3500,
                        timerProgressBar: true,
                        }).fire({
                            icon: "error",
                            title: "NIK sudah terdaftar!",
                        });
                    })
            } else {
                anggotaService.updateAnggota(data.id, data)
                    .then(response => {
                        this.anggotaData = response.data;
                        console.log(this.anggotaData);
                        Swal.fire(
                        'Sukses!',
                        'Data anggota berhasil diupdate!',
                        'success',
                        )
                        .then(() => {
                            location.reload();
                        });
                    })
                    .catch(e => {
                        console.log(e);
                        Swal.mixin({
                        toast: true,
                        position: "top",
                        iconColor: "white",
                        customClass: {
                            popup: "colored-toast",
                        },
                        showConfirmButton: false,
                        timer: 3500,
                        timerProgressBar: true,
                        }).fire({
                            icon: "error",
                            title: "NIK sudah terdaftar!",
                        });
                    })
            }
        },
        getAnggotaId(id) {
            // let id = this.$route.params.id;

            anggotaService.getAnggotaId(id)
                .then(response => {
                    this.anggotaData = response.data;
                    console.log(this.anggotaData);
                })
                .catch(e => {
                    console.log(e);
                })
        },
        btnBack() {
            location.reload();
        },
        btnCancel() {
            location.reload();
        },
        updateToggle() {
            this.btnUpdate = true;
            this.bacadoang = true;
            this.btnUp = true;
        }
    },
    props: ['detailAnggotaProps'],
    watch: {
        'detailAnggotaProps'(newValue) {
            this.anggotaData = newValue;
        }
    },
    mounted() {
        if(this.$route.name == 'detailAnggota') {
            this.getAnggotaId(this.$route.params.ide);
            this.buttonValue = "Update";
            this.tittleValue = "Detail";
        } else {
            this.bacadoang = true;
        }
    }
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