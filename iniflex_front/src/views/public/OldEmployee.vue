<script setup lang="ts">

import PageComponent from "@/components/PageComponent.vue";
import {employeeStore} from "@/views/public/store/EmployeeStore.ts";
import {onBeforeMount} from "vue";
import GenericButton from "@/components/GenericButton.vue";
import router from "@/router";

defineProps<{ msg: string }>()

onBeforeMount(
    async () => {
      await employeeStore().getOldestEmployee();
    },
)

</script>

<template>
  <PageComponent label="Iniflex - Funcionario mais velho">
    <template v-slot:botaoCadastrar>
      <div class="mb-10">
        <GenericButton class="mt-4" label="Voltar para tela principal"
                       @click="router.push(`/`)"/>
      </div>
    </template>
    <!---------- Tabela ---------->
    <template v-slot:table>
      <table v-if="employeeStore().listEmployees" class="custom-table">
        <thead>
        <tr>
          <th>Nome</th>
          <th>Idade</th>
        </tr>
        </thead>
        <tbody>
        <tr >
          <td>{{ employeeStore().employeeOldestSelected.employeeName }}</td>
          <td>{{ employeeStore().employeeOldestSelected.employeeAge }}</td>
        </tr>
        </tbody>
      </table>
    </template>
  </PageComponent>
</template>

<style scoped>

</style>
