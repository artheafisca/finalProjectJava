import Login from './pages/Login'
import Home from './pages/Home'
import AddKK from './pages/AddKK'
import Detail from './pages/Detail'
import ListAnggota from './pages/ListAnggota'
import DetailAnggota from './pages/DetailAnggota'

export default [
    {
        path: "/",
        name: "login",
        component: Login
    },
    {
        path: "/home",
        name: "home",
        component: Home
    },
    {
        path: "/addKK",
        name: "addKK",
        component: AddKK
    },
    {
        path: "/detailKK/:id",
        name: "detailKK",
        component: Detail
    },
    {
        path: "/detailKK/:id/listAnggota",
        name: "listAnggota",
        component: ListAnggota
    },
    {
        path: "/detailKK/:id/listAnggota/detailAnggota/:ide",
        name: "detailAnggota",
        component: DetailAnggota
    }
]