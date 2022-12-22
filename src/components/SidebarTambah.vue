<template>
    <div id="wrapper" class="toggled">
        <!-- Sidebar -->
        <div id="sidebar-wrapper" class="rounded">
            <ul class="sidebar-nav">
                <li class="sidebar-brand">
                    <h3 class="mt-5">
                        <strong>
                          <img src="@/assets/ktp.png" width="40px">
                          E-KTP APP
                        </strong>
                    </h3>
                    <hr class="mx-5">
                </li>
                <li class="mt-3">
                    <router-link to="/home">
                      <b-icon-house-door></b-icon-house-door> Home
                    </router-link >
                </li>
                <li>
                    <router-link to="/addKK" style="color: black; background: white;">
                      <b-icon-file-earmark-plus></b-icon-file-earmark-plus> Tambah KK
                    </router-link>
                    <hr class="mx-5">
                </li>
                <li class="mt-4">
                    <a @click.prevent="logOut">
                      <b-icon-power></b-icon-power> Sign Out
                    </a>
                </li>
            </ul>
        </div>
        <!-- /#sidebar-wrapper -->
    </div>
</template>

<script>
export default {
    name: 'SidebarTambahComponent',
    methods: {
      logOut() {
        localStorage.clear();
        this.$router.push("/");
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

#sidebar-wrapper {
  z-index: 1000;
  position: fixed;
  left: 250px;
  width: 0;
  height: 100%;
  margin-left: -250px;
  overflow-y: auto;
  background: aqua;
  -webkit-transition: all 0.5s ease;
  -moz-transition: all 0.5s ease;
  -o-transition: all 0.5s ease;
  transition: all 0.5s ease;
}

#wrapper.toggled #sidebar-wrapper {
  width: 250px;
}
/* Sidebar Styles */

.sidebar-nav {
  position: absolute;
  top: 0;
  width: 250px;
  margin: 0;
  padding: 0;
  list-style: none;
}

.sidebar-nav li {
  text-indent: 20px;
  line-height: 40px;
}

.sidebar-nav li a {
  display: block;
  text-decoration: none;
  color: grey;
}

.sidebar-nav li a:hover {
  text-decoration: none;
  color: black;
  background: white;
}

.sidebar-nav li a:active, .sidebar-nav li a:focus {
  text-decoration: none;
}

.sidebar-nav>.sidebar-brand {
  height: 65px;
  font-size: 18px;
  line-height: 60px;
}

.sidebar-nav>.sidebar-brand a {
  color: #999999;
}

.sidebar-nav>.sidebar-brand a:hover {
  color: #fff;
  background: none;
}

@media(min-width:768px) {
  #wrapper {
    padding-left: 0;
  }
  #wrapper.toggled {
    padding-left: 250px;
  }
  #sidebar-wrapper {
    width: 0;
  }
  #wrapper.toggled #sidebar-wrapper {
    width: 250px;
  }
}
</style>