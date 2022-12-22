<template>
    <div>
        <SidebarHome></SidebarHome>
        <div>
            <AddAnggota :detailAnggotaProps="anggotaData" ></AddAnggota>
            <TableAnggota v-show="none" @detailTable="detailDetail" ></TableAnggota>
        </div>
    </div>
</template>

<script>
import SidebarHome from '@/components/SidebarHome.vue'
import TableAnggota from '@/components/TableAnggota.vue'
import AddAnggota from '@/components/AddAnggota.vue'

export default {
    name: 'DetailAnggotaPage',
    components: {
        SidebarHome,
        TableAnggota,
        AddAnggota
    },
    data() {
        return {
            anggotaData: null
        }
    },
    methods: {
        detailDetail(item) {
            this.anggotaData = item;
        }
    }
}
</script>

<style>

</style>