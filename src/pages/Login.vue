<template>
    <div>
        <LoginForm v-show="!viewForm" @daftarForm="daftarLogin" ></LoginForm>
        <RegisterForm v-show="viewForm" @regisForm="regisLogin" ></RegisterForm>
    </div>
</template>

<script>
import LoginForm from '@/components/LoginForm.vue'
import RegisterForm from '@/components/RegisterForm.vue'

export default {
    name: 'LoginPage',
    components: {
        LoginForm,
        RegisterForm
    },
    data(){
        return{
            viewForm: false,
            userData: null,
        }
    },
    methods:{
        daftarLogin(item) {
            this.userData = item;
            this.viewForm = true;
        },
        regisLogin(item) {
            this.userData = item;
            this.viewForm = false;
        }
    }
}
</script>

<style>

</style>