<script lang="ts" setup>

const props = defineProps({
    label: {
        type: String,
    },
    linkTitulo: {
        type: String,
        required: false,
    },
})
</script>

<template>
    <div>
        <div >
            <slot v-if="linkTitulo" name="titulo" />
            <h1 v-else>{{ label }}</h1>
            <slot name="botaoCadastrar" />
        </div>
        <div>
            <div>
                <slot name="filtro" />
            </div>
        </div>
        <div>
            <slot name="table" />
        </div>
    </div>
</template>

<style scoped>
::-webkit-scrollbar {
    width: 4px;
}

::-webkit-scrollbar-track {
    box-shadow: inset 0 0 5px #c0c0c0;
    border-radius: 10px;
}

::-webkit-scrollbar-thumb {
    background: #c0c0c0;
    border-radius: 10px;
}

::-webkit-scrollbar-thumb:hover {
    background: rgb(159, 159, 159);
}
</style>