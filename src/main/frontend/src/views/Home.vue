<template>
  <div class="home">
    <img alt="Tomcat logo" src="../assets/logo_tomcat.gif">
    <img alt="Vue logo" src="../assets/logo_vue.png">
    <HelloWorld msg="Welcome to Your Servlet + Vue.js App"/>
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
