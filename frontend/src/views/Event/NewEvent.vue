<template>
  <div id="f-event">
    <h1>イベントの作成</h1>
      <form id="form" v-on:submit.prevent="postEvent('/event/new', newEvent)">
        <!-- TODO: バリデーション追加 -->
        <p>title:<input type="text" v-model="newEvent.title"  name="title" value=""></p>
        <p>date:<input type="date" v-model="newEvent.date" name="date" value=""></p>
        <p>host:<select name="host" v-model="newEvent.host_id">
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
import axios from 'axios'

const BASE_URL = 'http://localhost:23450/webapp'

export default {
  data () {
    return {
      newEvent: {
        title: 'title',
        // TODO: 今日の日付（yyyy-MM-dd)
        date: '2020-09-06',
        host_id: 1,
      }
    }
  },
  // TODO: actionsで書く
  methods: {
    postEvent(param, newEvent) {
      return axios.post(BASE_URL + param, {
        event: newEvent,
      }, {
        headers: {
          'Content-Type': 'application/json'
        }
      })
      .then(() => {
        // レスポンスが200の時の処理
        console.log('送れたよ')
      })
      .catch(err => {
        if(err.response) {
          // レスポンスが200以外の時の処理
        console.log('NG')
        }
      });
    }
    // axiosでPOST通信
  }
}
</script>
