<template>
  <div class="hello">
    <h1>{{ msg }}</h1>
    <h2>To prove the app works, check following pages.</h2>
    <ul>
      <li><a href="hello.jsp">JSP page</a></li>
      <li><a href="test-servlet">Servlet</a></li>
      <li><a href="test-db-connection">DB connection</a></li>
      <li><a href="test-hibernate">Hibernate</a></li>
      <li><a href="test-json-response">JSON response</a></li>
    </ul>
  </div>
</template>

<script lang="ts">
import { Component, Prop, Vue } from 'vue-property-decorator'

@Component
export default class HelloWorld extends Vue {
  @Prop() private msg!: string;
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped lang="scss">
h3 {
  margin: 40px 0 0;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  // display: inline-block;
  margin: 0 10px;
}
a {
  color: #42b983;
}
</style>
