<template>
  <div class="home">
    <HelloWorld msg="Welcome to Your Servlet + Vue.js App"/>
    <img alt="Tomcat logo" src="../assets/logo_tomcat.gif">
    <img alt="Vue logo" src="../assets/logo_vue.png">
  </div>
</template>

<script lang="ts">
import { Component, Vue } from 'vue-property-decorator'
import HelloWorld from '@/components/HelloWorld.vue' // @ is an alias to /src

@Component({
  components: {
    HelloWorld
  }
})
export default class Home extends Vue {}
</script>
<style scope>
img {
  width: 10%;
}
</style>
