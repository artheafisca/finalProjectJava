<template>
    <section class="vh-100" style="background-color: aqua;">
        <div class="container-fluid h-custom">
            <div class="row d-flex justify-content-center align-items-center h-100">
                <div class="col-md-9 col-lg-6 col-xl-5">
                    <img src="../assets/ktp.png"
                    class="img-fluid"
                    style="width: 80vw">
                </div>
                <div class="col-md-8 col-lg-6 col-xl-4 offset-xl-1">
                    <form @submit.prevent="loginUser">
                        <div class="d-flex flex-row align-items-center justify-content-center justify-content-lg-start mb-3">
                            <h1>Selamat Datang!</h1>
                        </div>

                        <!-- Email input -->
                        <div class="form-outline mb-4">
                            <input type="email" class="form-control form-control-lg"
                            placeholder="Email" v-model="loginData.email" />
                        </div>

                        <!-- Password input -->
                        <div class="form-outline mb-3">
                            <input type="password" class="form-control form-control-lg"
                            placeholder="Password" v-model="loginData.password" />
                        </div>

                        <div class="text-center text-lg-start mt-4 pt-2">
                            <button type="submit" class="btn btn-primary btn-lg mb-2"
                            style="padding-left: 2.5rem; padding-right: 2.5rem;">Login</button>
                            <!-- <div> -->
                                <!-- <p v-show="validasi" class="text-center text-danger">Email atau password salah!</p> -->
                            <!-- </div> -->
                            <hr>
                            <p class="small fw-bold mt-2 pt-1 mb-0">Tidak memiliki akun? 
                                <a 
                                class="link-danger"
                                @click="$emit('daftarForm')">
                                daftar disini</a>
                            </p>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </section>
</template>

<script>
import userService from '@/services/userService'
import Swal from 'sweetalert2'

export default {
    name: 'LoginFormComponent',
    data() {
        return {
            loginData: {
                "email"     : null,
                "password"  : null
            },
            validasi: false
        }
    },
    methods: {
        loginUser() {
            let data = this.loginData;

            userService.login(data)
                .then(response => {
                    console.log(response.data)
                    localStorage.user_login = JSON.stringify(response.data)
                    this.$router.push("/home")
                })
                .catch(e => {
                    console.log(e)
                    this.validasi = true
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
                        title: "Email / Password Salah!",
                    });
                })
        }
    }
}
</script>

<style>
/* .divider:after,
.divider:before {
content: "";
flex: 1;
height: 1px;
background: rgb(50, 79, 143);
}
.h-custom {
height: calc(100% - 73px);
}
@media (max-width: 450px) {
.h-custom {
height: 100%;
}
} */

.colored-toast.swal2-icon-success {
  background-color: #a5dc86 !important;
}

.colored-toast.swal2-icon-error {
  background-color: #f27474 !important;
}

.colored-toast.swal2-icon-warning {
  background-color: #f8bb86 !important;
}

.colored-toast.swal2-icon-info {
  background-color: #3fc3ee !important;
}

.colored-toast.swal2-icon-question {
  background-color: #87adbd !important;
}

.colored-toast .swal2-title {
  color: white;
}


</style>