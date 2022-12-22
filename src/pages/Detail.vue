<template>
    <div>
        <SidebarHome></SidebarHome>
        <div>
            <Add :detailKartuProps="kartuData"></Add>
            <TableKK v-show="none" @detailTable = "detailDetail" ></TableKK>
        </div>

    </div>
</template>

<script>
import Add from '@/components/Add.vue'
import SidebarHome from '@/components/SidebarHome.vue'
import TableKK from '@/components/TableKK.vue'
// import kartuService from '@/services/kartuService'

export default {
    name: 'DetailPage',
    components: {
        Add,
        SidebarHome,
        TableKK
    },
    data(){
        return {
            kartuData: null
        }
    },
    methods: {
        detailDetail(item) {
            this.kartuData = item;
        },
        // getId() {
        //     let id = this.$route.params.id;

        //     kartuService.updateId(id)
        //         .then(response => {
        //             this.kartuData = response.data;
        //             console.log(this.kartuData);
        //         })
        //         .catch(e => {
        //             console.log(e);
        //         })
        // }
    },
    // mounted() {
    //     this.getId();
    // }
}
</script>

<style>

</style>