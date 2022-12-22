<template>
    <div>
        <!-- <Sidebar></Sidebar> -->
        <SidebarHome></SidebarHome>
        <TableKK></TableKK>
    </div>
</template>

<script>
// import Sidebar from '@/components/Sidebar.vue'
import SidebarHome from '@/components/SidebarHome.vue'
import TableKK from '@/components/TableKK.vue'

export default {
    name: 'HomePage',
    components: { 
        SidebarHome,
        TableKK
    },

}
</script>

<style>

</style>