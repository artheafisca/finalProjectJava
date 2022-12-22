<template>
    <div>
        <SidebarHome></SidebarHome>
        <!-- <TableKK></TableKK> -->
        <div>
            <TableAnggota v-show="!viewForm" @tambahTable="tambahList" ></TableAnggota>
            <AddAnggota v-show="viewForm"></AddAnggota>
        </div>
    </div>
</template>

<script>
import SidebarHome from '@/components/SidebarHome.vue'
// import TableKK from '@/components/TableKK.vue'
import TableAnggota from '@/components/TableAnggota.vue'
import AddAnggota from '@/components/AddAnggota.vue'

export default {
    name: 'TableAnggotaPage',
    components: { SidebarHome,  TableAnggota, AddAnggota },
    methods: {
        tambahList(item) {
            this.anggotaData = item;
            this.viewForm = true;
        }
    },
    data() {
        return {
            anggotaData: null,
            viewForm: false
        }
    }

}
</script>

<style>

</style>