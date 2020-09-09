<template>
  <div id="f-event">
    <h1>イベントの作成</h1>
      <form id="form" v-on:submit.prevent="postEvent('/event/new', newEvent)">
        <!-- TODO: バリデーション追加 -->
        <ul>
          <li>
            <label for="form-event-title">title:</label>
            <input type="text" v-model="newEvent.title" name="title" id="form-event-title">
          </li>
          <li>
            <label for="form-event-date">date:</label>
            <input type="date" v-model="newEvent.date" name="date" id="form-event-date">
          </li>
          <li>
            <label for="form-event-host">host:</label>
            <select name="host" v-model="newEvent.host_id">
              <!-- TODO: エンティティからホスト名を取得して選択 -->
              <option value="1">hoge</option>
              <option value="2">foo</option>
              <option value="3">bar</option>
            </select>
          </li>
          <li>
            <input type="submit" value="イベントを作成">
          </li>
        </ul>
      </form>
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
    postEvent(path, newEvent) {
      // サーバ側にformデータとして認識してもらう
      const params = new URLSearchParams();
      params.append('title', newEvent.title);
      params.append('date', newEvent.date);
      params.append('host_id', newEvent.host_id);
      return axios.post(BASE_URL + path, params)
      .then(() => {
        // レスポンスが200の時の処理
        console.log('OK')
      })
      .catch(err => {
        if(err.response) {
          // レスポンスが200以外の時の処理
        console.log('NG')
        }
      });
    }
  }
}
</script>
