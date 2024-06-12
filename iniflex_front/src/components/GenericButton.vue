<script lang="ts" setup>
defineProps({
    label: {
        type: String,
        required: true,
    },
    disabled: {
        type: Boolean,
        default: false,
    },
})
</script>

<template>
    <button :disabled="disabled" type="button" v-text="label" />
</template>

<style scoped>
button {
    margin-top: 20px;
    margin-left: 10px;
    width: fit-content;
    height: fit-content;
    padding: 8px 40px;
    border-radius: 10px;
    border: 0;
    background-color: #009879;
    letter-spacing: 1.5px;
    font-size: 15px;
    transition: all 0.3s ease;
    box-shadow: rgb(0, 125, 101) 0 10px 0 0;
    color: hsl(0, 0%, 100%);
    cursor: pointer;
}

button:hover {
  box-shadow: rgb(0, 125, 101) 0 7px 0 0;
}

button:disabled {
    background-color: rgb(241, 241, 241);
    box-shadow: rgb(231, 231, 231) 0 0 0 0;
    transform: translateY(5px);
    transition: 200ms;
}

button:active {
    background-color: rgb(241, 241, 241);
    box-shadow: rgb(231, 231, 231) 0 0 0 0;
    transform: translateY(5px);
    transition: 200ms;
}
</style>