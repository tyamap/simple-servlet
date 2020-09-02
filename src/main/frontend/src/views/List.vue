<template>
<div id="list">
    <h1>This is a List made by the API response</h1>
    <table>
      <tbody>
        <tr>
          <th>ID</th>
          <th>name</th>
          <th>department</th>
          <th>salary</th>
        </tr>
        <tr v-for="e in employees" :key="e.id">
          <td>{{ e.id }}</td>
          <td>{{ e.name }}</td>
          <td>{{ e.department }}</td>
          <td>{{ e.salary }}</td>
        </tr>
      </tbody>
    </table>
  </div>
</template>

<script>
import axios from 'axios'

export default {
  data: function () {
    return {
      employees: []
    }
  },
  mounted () {
    axios
      .get('/test-json-response.json')
      .then(response => (this.employees = response.data))
  }
}
</script>
<style scope>
  table {
    margin: 0 auto;
  }
</style>
