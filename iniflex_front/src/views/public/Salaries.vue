<script setup lang="ts">

import PageComponent from "@/components/PageComponent.vue";
import {employeeStore} from "@/views/public/store/EmployeeStore.ts";
import {onBeforeMount} from "vue";
import GenericButton from "@/components/GenericButton.vue";
import router from "@/router";

defineProps<{ msg: string }>()

onBeforeMount(
    async () => {
      await employeeStore().listAllMinimumWages();
    },
)

</script>

<template>
  <PageComponent label="Iniflex - Salarios por pessoa">
    <template v-slot:botaoCadastrar>
      <div>
        <GenericButton label="Voltar para tela principal"
                       @click="router.push(`/`)"/>
      </div>
    </template>
    <!---------- Tabela ---------->
    <template v-slot:table>
      <table v-if="employeeStore().listEmployees" class="custom-table">
        <thead>
        <tr>
          <th>Nome</th>
          <th>Salários</th>
        </tr>
        </thead>
        <tbody>
        <tr v-for="(item) in employeeStore().listMinimumWages">
          <td>{{ item.employeeName }}</td>
          <td>{{ item.employeeSalary }}</td>
        </tr>
        </tbody>
      </table>
    </template>
  </PageComponent>
</template>

<style scoped>

</style>
