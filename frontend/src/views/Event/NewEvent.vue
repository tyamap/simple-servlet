<template>
  <div id="f-event">
    <h1>イベントの作成</h1>
      <form id="form">
        <!-- それぞれに作ったvaidatorに通す -->
        <p>title:<input type="text" v-model="newEvent.title"  name='title' value=''></p>
        <p>date:<input type="date" v-model="newEvent.date" name='date' value=''></p>
        <p>host:<select name="host" v-model="newEvent.host">
                  <option value="1">hoge</option>
                  <option value="2">foo</option>
                  <option value="3">bar</option>
                </select>
        </p>
        <input type="submit" value="イベントを作成">
      </form>
      {{newEvent.title}}
      {{newEvent.date}}
      {{newEvent.host}}
  </div>
</template>

<script>
// import axios from 'axios'

// var BASE_URL = 'http://localhost:23450/webapp/'

export default {
  data () {
    return {
      newEvent: {
        title: 'タイトル',
        date: '2020-09-06',
        host: 1,
      }
    }
  },
  actions: {
    // axiosでPOST通信
  }
}
</script>
