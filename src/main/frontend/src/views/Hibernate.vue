<template>
<div id="list">
    <h1>This is a List made by the Hibernate response</h1>
    <table>
      <tbody>
        <tr>
          <th>ID</th>
          <th>title</th>
          <th>date</th>
        </tr>
        <tr v-for="e in events" :key="e.id">
          <td>{{ e.id }}</td>
          <td>{{ e.title }}</td>
          <td>{{ e.date }}</td>
        </tr>
      </tbody>
    </table>
  </div>
</template>

<script>
// TODO: TypeScriptで記述する
import axios from 'axios'

export default {
  data: function () {
    return {
      events: []
    }
  },
  mounted () {
    axios
      .get('/test-hibernate.json')
      .then(response => (this.events = response.data))
  }
}
</script>
<style lang='scss' scoped>
  table {
    margin: 0 auto;
  }
</style>
