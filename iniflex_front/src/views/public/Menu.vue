<script setup lang="ts">

import PageComponent from "@/components/PageComponent.vue";
import {employeeStore} from "@/views/public/store/EmployeeStore.ts";
import {onBeforeMount} from "vue";
import GenericButton from "@/components/GenericButton.vue";
import router from "@/router";

defineProps<{ msg: string }>()

onBeforeMount(
    async () => {
      await employeeStore().listAll();
    },
)

</script>

<template>
  <PageComponent label="Iniflex - Funcionarios">
    <template v-slot:botaoCadastrar>
      <div>
        <GenericButton  label="Listar em ordem alfabetica"
                       @click="employeeStore().listEmployeesAlphabetically()"/>
        <GenericButton label="Selecionar aniversariantes"
                       @click="employeeStore().listEmployeesBornIn()"/>
        <GenericButton  label="Aumentar salario"
                       @click="employeeStore().increaseSalary()"/>
        <GenericButton label="Salarios por pessoa"
                       @click="router.push(`/salarios`)"/>
        <GenericButton label="Total de salarios"
                       @click="router.push(`/total-salarios`)"/>
        <GenericButton label="Funcionario mais velho"
                       @click="router.push(`/funcionario-mais-velho`)"/>
        <GenericButton label="Listagem por grupos"
                       @click="router.push(`/listar-grupo`)"/>
        <GenericButton  label="Remover João"
                       @click="employeeStore().removeEmployee()"/>
      </div>
    </template>
    <!---------- Tabela ---------->
    <template v-slot:table>
      <table v-if="employeeStore().listEmployees" class="custom-table">
        <thead>
        <tr>
          <th>Nome</th>
          <th>Data de nascimento</th>
          <th>Salário</th>
          <th>Cargo</th>
        </tr>
        </thead>
        <tbody>
        <tr v-for="(item) in employeeStore().listEmployees" :key="item.personId">
          <td>{{ item.personName }}</td>
          <td>{{ item.personBirthDate }}</td>
          <td>{{ item.employeeSalary }}</td>
          <td>{{ item.employeeRole }}</td>
        </tr>
        </tbody>
      </table>
    </template>
  </PageComponent>
</template>

<style scoped>

</style>
