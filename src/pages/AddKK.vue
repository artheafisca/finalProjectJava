<template>
  <div>
    <!-- <AddForm></AddForm> -->
    <SidebarTambah></SidebarTambah>
    <Add></Add>

  </div>
</template>

<script>
// import AddForm from '../components/AddForm.vue'
import SidebarTambah from '@/components/SidebarTambah.vue'
import Add from '@/components/Add.vue'

export default {
    name: 'AddKKPage',
    components: {
        SidebarTambah,
        Add
    }
}
</script>

<style>

</style>