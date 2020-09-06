<template>
<div id="list">
    <h1>This is a Events List</h1>
    <table>
      <tbody>
        <tr>
          <th>ID</th>
          <th>title</th>
          <th>date</th>
          <th>host</th>
        </tr>
        <tr v-for="e in events" :key="e.id">
          <td>{{ e.id }}</td>
          <td>{{ e.title }}</td>
          <td>{{ e.date }}</td>
          <td>{{ e.employee.name }}</td>
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
      .get('http://localhost:23450/webapp/events.json')
      .then(response => (this.events = response.data))
  }
}
</script>
<style lang='scss' scoped>

</style>
