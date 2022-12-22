<template>
    <section class="vh-100" style="background-color: aqua; ">
        <div class="container h-100">
            <div class="row d-flex justify-content-center align-items-center h-100">
            <div class="col-lg-12 col-xl-11" >
                <div class="card text-black" style="border-radius: 25px;">
                <div class="card-body p-md-5">
                    <div class="row justify-content-center">
                    <div class="col-md-10 col-lg-6 col-xl-5 order-2 order-lg-1">

                        <p class="text-center h1 fw-bold  mx-1 mx-md-4">Daftar</p>

                        <form class="mx-1 mx-md-4" @submit.prevent="inputUser" >

                        <div class="d-flex flex-row align-items-center mb-4">
                            <i class="fas fa-user fa-lg me-3 fa-fw"></i>
                            <div class="form-outline flex-fill mb-0">
                                <label class="form-label">Nama Lengkap</label>
                                <input 
                                    type="text" 
                                    class="form-control" 
                                    placeholder="Nama Lengkap"
                                    v-model="userData.nama" 
                                    :class="{
                                        'is-invalid' : validasi && $v.userData.nama.$error
                                    }" />
                                    <div 
                                        v-if="validasi && !$v.userData.nama.required" 
                                        class="invalid-feedback">
                                        Nama tidak boleh kosong!
                                    </div>
                            </div>
                        </div>

                        <div class="d-flex flex-row align-items-center mb-4">
                            <i class="fas fa-envelope fa-lg me-3 fa-fw"></i>
                            <div class="form-outline flex-fill mb-0">
                                <label class="form-label">Email</label>
                                <input
                                    v-model="userData.email"
                                    type="email"
                                    class="form-control"
                                    :class="{
                                        'is-invalid': validasi && $v.userData.email.$error,
                                    }"
                                    placeholder="Email"
                                    />
                                    <div
                                    v-if="validasi && $v.userData.email.$error"
                                    class="invalid-feedback"
                                    >
                                    <span v-if="!$v.userData.email.required"
                                        >Email tidak boleh kosong!</span
                                    >
                                    <span v-if="!$v.userData.email.email"
                                        >Format Email salah!</span
                                    >
                                </div>
                            </div>
                        </div>

                        <div class="d-flex flex-row align-items-center mb-4">
                            <i class="fas fa-lock fa-lg me-3 fa-fw"></i>
                            <div class="form-outline flex-fill mb-0">
                                <label class="form-label">Password</label>
                                <input 
                                    type="password" 
                                    class="form-control" 
                                    placeholder="Password"
                                    v-model="userData.password"
                                    :class="{
                                        'is-invalid': validasi && $v.userData.password.$error,
                                    }"
                                />
                                   <div
                                    v-if="validasi && $v.userData.password.$error"
                                    class="invalid-feedback"
                                    >
                                    <span v-if="!$v.userData.password.required"
                                        >Password tidak boleh kosong!</span
                                    >
                                    </div>
                            </div>
                        </div>

                        <div class="d-flex flex-row align-items-center mb-4">
                            <i class="fas fa-key fa-lg me-3 fa-fw"></i>
                            <div class="form-outline flex-fill mb-0">
                                <label class="form-label">Repassword</label>
                                <input 
                                    type="password" 
                                    class="form-control" 
                                    placeholder="Repassword"
                                    :class="{
                                        'is-invalid': validasi && $v.userData.repassword.$error,
                                    }"
                                    v-model="userData.repassword"/>
                                    <div
                                    v-if="validasi && $v.userData.repassword.$error"
                                    class="invalid-feedback"
                                    >
                                    <span v-if="!$v.userData.repassword.required"
                                        >Repassword tidak boleh kosong!</span
                                    >
                                    <span v-if="!$v.userData.repassword.sameAsPassword"
                                        >Password tidak sama!</span
                                    >
                                    </div>

                                    
                            </div>
                        </div>

                        <div class="d-flex justify-content-center mx-4 mb-3 mb-lg-4">
                            <button 
                                type="button" 
                                class="btn btn-danger btn-lg"
                                @click="gotoLogin" >Login</button>
                            <button 
                                type="submit" 
                                class="btn btn-primary btn-lg ml-3"
                                >Daftar</button>
                        </div>

                        </form>
                    </div>
                    <div class="col-md-10 col-lg-6 col-xl-7 d-flex align-items-center order-1 order-lg-2">

                        <img src="../assets/ktp.png"
                        class="img-fluid" alt="Sample image">

                    </div>
                    </div>
                </div>
                </div>
            </div>
            </div>
        </div>
    </section>
</template>

<script>
import userService from '../services/userService'
import Swal from 'sweetalert2'
import { required, email, sameAs } from 'vuelidate/lib/validators'


export default {
    name: 'RegisterFormComponent',
    data() {
        return {
            userData: {
                "nama"      : "",
                "email"     : "",
                "password"  : "",
                "repassword": ""
            },
            validasi: false,
        }
    },
    validations: {
         userData: {
                "nama"      : {required},
                "email"     : {required, email},
                "password"  : {required},
                "repassword": {required, sameAsPassword: sameAs("password")}
            },
    },
    methods: {
        clearData() {
            this.userData.nama = "";
            this.userData.email = "";
            this.userData.password = "";
            this.userData.repassword = "";
            this.validasi = false;
        },
        gotoLogin() {
            this.clearData();
            this.$emit('regisForm');
        },
        inputUser() {
            this.validasi = true;
            this.$v.$touch();
            if ( this.$v.$invalid ) {
                return;
            }

            let data = {
                nama    : this.userData.nama,
                email   : this.userData.email,
                password: this.userData.password
            }

            userService.insert(data)
                .then(Response => {
                    console.log(Response.data);
                    Swal.fire(
                    'Sukses!',
                    'Data Berhasil Terdaftar',
                    'success',
                    )
                    .then(() => {
                        this.$emit('regisForm');
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
                        title: "Email sudah terdaftar!",
                    });
                })
    
        }
    },
}
</script>

<style>
</style>