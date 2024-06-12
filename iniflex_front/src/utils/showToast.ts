import { toast } from 'vue3-toastify'

export function showToast(message: string, type: 'success' | 'warning' | 'error' = 'success') {
    switch (type) {
        case 'success':
            toast.success(message, {
                autoClose: 3000,
                theme: 'colored',
                transition: 'slide',
                delay: 20,
            })
            break
        case 'warning':
            toast.warning(message, {
                autoClose: 3000,
                theme: 'colored',
                transition: 'slide',
                delay: 20,
            })
            break
        case 'error':
            toast.error(message, {
                autoClose: 3000,
                theme: 'colored',
                transition: 'slide',
                delay: 20,
            })
            break
    }
}