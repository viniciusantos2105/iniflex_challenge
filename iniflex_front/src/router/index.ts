import { createRouter, createWebHistory } from 'vue-router'

const router = createRouter({
    history: createWebHistory(),
    routes: [
        {
            path: '/',
            name: 'menu',
            component: () => import('@/views/public/Menu.vue'),
        },
        {
            path: '/salarios',
            name: 'salarios',
            component: () => import('@/views/public/Salaries.vue'),
        },
        {
            path: '/funcionario-mais-velho',
            name: 'funcionario-mais-velho',
            component: () => import('@/views/public/OldEmployee.vue'),
        },
        {
            path: '/total-salarios',
            name: 'total-salarios',
            component: () => import('@/views/public/TotalSalaries.vue'),
        },
        {
            path: '/listar-grupo',
            name: 'listar-grupo',
            component: () => import('@/views/public/ListGroup.vue'),
        }
    ],
})

export default router
