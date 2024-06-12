import { createApp } from 'vue'
import './assets/main.css'
import App from './App.vue'
import router from "./router";
import {createPinia} from "pinia";
import Vue3Toastify, {ToastContainerOptions} from "vue3-toastify";
import 'vue3-toastify/dist/index.css'

const app = createApp(App)
export const pinia = createPinia()
app.use(pinia).use(router)
app.use(Vue3Toastify, {
    autoClose: 3000,
} as ToastContainerOptions)
app.mount('#app')
