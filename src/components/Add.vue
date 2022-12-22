<template>
    <div id="wrapper" class="toggled">
        <div id="page-content-wrapper">
            <div class="container-fluid">
                <h2> <strong>{{tittleValue}} Kartu Keluarga</strong> </h2>
                <div class="mt-5">
                    <router-link to="/home" class="btn mb-4" style="background-color: aqua;">
                      <b-icon-arrow-left></b-icon-arrow-left> Back
                    </router-link>
                    <button  class="btn btn-success mb-4 ml-2" v-show= "btnUpdate" @click= "updateToggle">
                        <b-icon-pencil></b-icon-pencil>  Update Kartu Keluarga
                    </button>
                    <router-link :to="{name: 'listAnggota' }" class="btn btn-primary mb-4 ml-2" v-show="tittleValue != 'Tambah'">
                        <b-icon-eye></b-icon-eye> Lihat Anggota Keluarga
                    </router-link>
                    <div class="border p-4">
                        <form @submit.prevent="inputKartu">
                            <div class="form-row w-100">
                                <div class="form-group col-md-6">
                                    <label>Nomor Kartu Keluarga</label>
                                    <input 
                                        type="text" 
                                        class="form-control"
                                        :class="{
                                        'is-invalid' : validasi && $v.kartuData.nomor_kk.$error
                                        }" 
                                        placeholder="Nomor Kartu Keluarga"
                                        v-model="kartuData.nomor_kk"
                                        :disabled= "!bacadoang" >
                                        <div 
                                        v-if="validasi && !$v.kartuData.nomor_kk.required" 
                                        class="invalid-feedback">
                                        Nomor KK tidak boleh kosong!
                                    </div>
                                </div>
                                <div class="form-group col-md-6">
                                    <label>Desa / Kelurahan</label>
                                    <input 
                                        type="text" 
                                        class="form-control" 
                                        :class="{
                                        'is-invalid' : validasi && $v.kartuData.desa_kelurahan.$error
                                        }" 
                                        placeholder="Desa / Kelurahan"
                                        v-model="kartuData.desa_kelurahan"
                                        :disabled= "!bacadoang" >
                                        <div 
                                        v-if="validasi && !$v.kartuData.desa_kelurahan.required" 
                                        class="invalid-feedback">
                                        Desa / kelurahan tidak boleh kosong!
                                    </div>
                                </div>
                            </div>

                            <div class="form-row">
                                <div class="form-group col-md-6">
                                    <label>Alamat</label>
                                    <textarea 
                                        class="form-control" 
                                        :class="{
                                        'is-invalid' : validasi && $v.kartuData.alamat.$error
                                        }"
                                        rows="5" 
                                        placeholder="Alamat"
                                        v-model="kartuData.alamat"
                                        :disabled= "!bacadoang"></textarea>
                                        <div 
                                        v-if="validasi && !$v.kartuData.alamat.required" 
                                        class="invalid-feedback">
                                        Alamat tidak boleh kosong!
                                    </div>
                                </div>
                                <div class="form-group col-md-6">
                                    <label>kecamatan</label>
                                    <input 
                                        type="text" 
                                        class="form-control"
                                        :class="{
                                        'is-invalid' : validasi && $v.kartuData.kecamatan.$error
                                        }" 
                                        placeholder="kecamatan"
                                        v-model="kartuData.kecamatan"
                                        :disabled= "!bacadoang">
                                        <div 
                                        v-if="validasi && !$v.kartuData.kecamatan.required" 
                                        class="invalid-feedback">
                                        Kecamatan tidak boleh kosong!
                                    </div>
                                
                                    <div class="mt-4">
                                        <label>Kabupaten / Kota</label>
                                        <input 
                                            type="text" 
                                            class="form-control" 
                                            :class="{
                                        'is-invalid' : validasi && $v.kartuData.kabupaten_kota.$error
                                        }"
                                            placeholder="Kabupaten / Kota"
                                            v-model= "kartuData.kabupaten_kota"
                                            :disabled= "!bacadoang">
                                            <div 
                                        v-if="validasi && !$v.kartuData.kabupaten_kota.required" 
                                        class="invalid-feedback">
                                        Kabupaten / kota tidak boleh kosong!
                                    </div>
                                    </div>
                                </div>
                            </div>

                            <div class="form-row">
                                <div class="form-group col-md-6">
                                    <label>RT</label>
                                    <input 
                                        type="text" 
                                        class="form-control" 
                                        :class="{
                                        'is-invalid' : validasi && $v.kartuData.rt.$error
                                        }"
                                        placeholder="RT"
                                        v-model="kartuData.rt"
                                        :disabled= "!bacadoang">
                                        <div 
                                        v-if="validasi && !$v.kartuData.rt.required" 
                                        class="invalid-feedback">
                                        RT tidak boleh kosong!
                                    </div>
                                </div>
                                <div class="form-group col-md-6">
                                    <label>Provinsi</label>
                                    <input 
                                        type="text" 
                                        class="form-control" 
                                        :class="{
                                        'is-invalid' : validasi && $v.kartuData.provinsi.$error
                                        }"
                                        placeholder="Provinsi"
                                        v-model="kartuData.provinsi"
                                        :disabled= "!bacadoang">
                                        <div 
                                            v-if="validasi && !$v.kartuData.provinsi.required" 
                                            class="invalid-feedback">
                                            Provinsi tidak boleh kosong!
                                        </div>
                                </div>
                            </div>

                            <div class="form-row">
                                <div class="form-group col-md-6">
                                    <label>RW</label>
                                    <input 
                                        type="text" 
                                        class="form-control"
                                        :class="{
                                        'is-invalid' : validasi && $v.kartuData.rw.$error
                                        }" 
                                        placeholder="RW"
                                        v-model="kartuData.rw"
                                        :disabled= "!bacadoang">
                                        <div 
                                            v-if="validasi && !$v.kartuData.rw.required" 
                                            class="invalid-feedback">
                                            RW tidak boleh kosong!
                                        </div>
                                </div>
                                <div class="form-group col-md-6">
                                    <label>Kode Pos</label>
                                    <input 
                                        type="text" 
                                        class="form-control" 
                                        :class="{
                                        'is-invalid' : validasi && $v.kartuData.kode_pos.$error
                                        }"
                                        placeholder="Kode Pos"
                                        v-model="kartuData.kode_pos"
                                        :disabled= "!bacadoang">
                                        <div 
                                            v-if="validasi && !$v.kartuData.kode_pos.required" 
                                            class="invalid-feedback">
                                            Kode pos tidak boleh kosong!
                                        </div>
                                </div>
                            </div>
                            <button  v-show="updateShow" @click="iniCancel" type="button" class="btn btn-danger mr-2">
                               <b-icon-x></b-icon-x> Cancel
                            </button>
                            <button v-show="updateShow" type="submit" class="btn" style="background-color: aqua;">
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
import kartuService from '../services/kartuService'
import Swal from 'sweetalert2'
import { required } from 'vuelidate/lib/validators'

export default {
    name: 'AddComponent',
    data() {
        return {
            kartuData: {
                "alamat"            : null,
                "desa_kelurahan"    : null,
                "kabupaten_kota"    : null,
                "kecamatan"         : null,
                "kode_pos"          : null,
                "nomor_kk"          : null,
                "provinsi"          : null,
                "rt"                : null,
                "rw"                : null
            },
            buttonValue: "Submit",
            tittleValue: "Tambah",
            btnUpdate: false,
            updateShow: false,
            bacadoang: false,
            validasi : false,
        }
    },
    validations: {
        kartuData: {
        alamat: { required },
        desa_kelurahan: { required },
        kabupaten_kota: { required },
        kecamatan: { required },
        kode_pos: { required },
        nomor_kk: { required },
        provinsi: { required },
        rt: { required },
        rw: { required },
        },
    },
    methods: {
        inputKartu(){
            this.validasi = true;
            this.$v.$touch();
            if (this.$v.$invalid) {
                return;
            }

            let data = this.kartuData;

            if(this.buttonValue === 'Submit') {

                kartuService.insert(data)
                    .then(response => {
                        console.log(response.data);
                        Swal.fire(
                        'Sukses!',
                        'Data Berhasil Ditambahkan',
                        'success',
                        )
                        .then(() => {
                            this.kartuData = {}
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
                            title: "Nomor KK sudah terdaftar!",
                        });
                    })
            }  else {
                    kartuService.updateKK(data.id, data)
                            .then(response => {
                                this.kartuData = response.data;
                                console.log(this.kartuData);
                                Swal.fire(
                                'Sukses!',
                                'Data KK berhasil diupdate!',
                                'success',
                                )
                                .then(() => {
                                    this.$router.push("/home")
                                })
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
                                    title: "Nomor KK sudah terdaftar!",
                                });
                            })  
            }  
        },
        updateToggle(){
            this.btnUpdate = false
            this.updateShow = true
            this.bacadoang = true
        },
        iniCancel() {
            location.reload()
        },
        getId() {
            let id = this.$route.params.id;

            kartuService.updateId(id)
                .then(response => {
                    this.kartuData = response.data;
                    console.log(this.kartuData)
                })
                .catch(e => {
                    console.log(e);
                })
        }
    },
    props: ['detailKartuProps'],
    watch: {
        'detailKartuProps'(newValue) {
            this.kartuData = newValue;
            console.log(this.kartuData);
        }
    },
    mounted(){
        if(this.$route.name == 'detailKK'){
            this.getId(this.$route.params.id)
            this.btnUpdate = true;
            this.tittleValue = "Detail";
            this.buttonValue = "Update";
        } 
        else {
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