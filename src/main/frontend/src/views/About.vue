<template>
  <div class="about">
    <h1>This is an about page</h1>
    <h2>To prove the app works, check following pages.</h2>
    <ul>
      <li><a href="hello.jsp">JSP page</a></li>
      <li><a href="test-servlet">Servlet</a></li>
      <li><a href="test-db-connection">DB connection</a></li>
      <hr>
      <li><router-link to="/list">API communicate</router-link></li>
      <li><router-link to="/hibernate">Hibernate</router-link></li>
    </ul>
  </div>
</template>
<style lang='scss' scoped>
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
hr {
  width: 20em;
}
</style>
