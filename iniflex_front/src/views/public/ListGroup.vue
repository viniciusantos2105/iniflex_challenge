<script setup lang="ts">

import PageComponent from "@/components/PageComponent.vue";
import {employeeStore} from "@/views/public/store/EmployeeStore.ts";
import {onBeforeMount} from "vue";
import GenericButton from "@/components/GenericButton.vue";
import router from "@/router";

defineProps<{ msg: string }>()

onBeforeMount(
    async () => {
      await employeeStore().groupByRole();
      console.log(employeeStore().listGroupBy)
    },
)

</script>
<template>
  <PageComponent label="Iniflex - Listagem por grupo">
    <template v-slot:botaoCadastrar>
      <div class="mb-10">
        <GenericButton class="mt-4" label="Voltar para tela principal"
                       @click="router.push(`/`)"/>
      </div>
    </template>
    <!---------- Tabela ---------->
    <template v-slot:table>
      <div v-for="(group, role) in employeeStore().listGroupBy" :key="role">
        <h2>{{ role }}</h2>
        <table v-if="group" class="custom-table">
          <thead>
          <tr>
            <th>Nome</th>
            <th>Data de nascimento</th>
            <th>Salário</th>
            <th>Cargo</th>
          </tr>
          </thead>
          <tbody>
          <tr v-for="(employee, index) in group" :key="index">
            <td>{{ employee.personName }}</td>
            <td>{{ employee.personBirthDate }}</td>
            <td>{{ employee.employeeSalary }}</td>
            <td>{{ employee.employeeRole }}</td>
          </tr>
          </tbody>
        </table>
      </div>
    </template>
  </PageComponent>
</template>

<style scoped>

</style>
