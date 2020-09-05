<template>
  <div class="home">
    <HelloWorld msg="Welcome to Your Servlet + Vue.js App"/>
    <img alt="Tomcat logo" src="../assets/logo_tomcat.png">
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
<style lang='scss' scoped>
</style>
