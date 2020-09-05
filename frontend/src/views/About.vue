<template>
  <div class="about">
    <h1>This is an about page</h1>
    <h2>To prove the app works, check following pages.</h2>
    <ul>
      <li><router-link to="/events">Events list</router-link></li>
      <li><router-link to="/employees">Employees list</router-link></li>
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
