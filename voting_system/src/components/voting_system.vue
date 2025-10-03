<template>
  <div>
    <h1>最受歡迎Idol排行榜</h1>
    <div class="container mt-4" style="max-width: 300px;">
      <h2>新增 Idol</h2>
        <input v-model="idolName" placeholder="輸入Idol名字" class="form-control"/>
        <button @click="addIdol" class="btn btn-outline-primary add">新增</button>
    </div>
    <div class="container mt-4" style="max-width: 300px;">
      <h2 class="mb-3">Idol 名單</h2>
      <h4>
        <div class="list-group mb-3">
          <li v-for="idol in idols" :key="idol.id" class="list-group-item d-flex justify-content-between align-items-center">
            <div class="form-check">
              <input class="form-check-input" type="checkbox" :value="idol.id" v-model="selectedIdols" :id="'idol'+idol.id" />
              <label class="form-check-label fw-semibold text-dark small" :for="'idol'+idol.id">
                <span class="badge bg-primary me-1">#{{ idol.id }}</span>
                {{ idol.idol_name }}
                <span class="badge bg-success ms-2">{{ idol.vote_count }} 票</span>
              </label>
            </div>
          </li>
        </div>
      </h4>

      <div class="mb-3">
        <label for="voterName" class="form-label">投票者名字：</label>
        <input type="text" class="form-control" id="voterName" placeholder="輸入投票人名字" v-model="voterName" />
      </div>
    <button @click="submitSelection" class="btn btn-outline-primary submit">送出投票</button>
    <button @click="submitDelection" class="btn btn-outline-secondary delete">刪除投票選項</button>
    </div>
    
  </div>
</template>

<script>
import axios from "axios";

export default {
  data() {
    return {
      idolName: "",
      voterName: "",
      idols: [] , // 儲存查詢結果
      selectedIdols: []   // 存放被勾選的 idol id
    };
  },
  methods: {
    addIdol() {
      if (!this.idolName) {
        alert("請輸入名字！");
        return;
      }
      const idolData = {
        idolName: this.idolName
      };
      axios.post("http://localhost:8081/api/idol/addidol",idolData, {
        headers: { "Content-Type": "application/json" }
      })
      .then(res => {
        alert(res.data);
        this.idolName = "";
        this.getAllIdols();
      })
      .catch(err => {
        console.error(err);
        alert(err);
      });
    },
    getAllIdols() {
      axios.get("http://localhost:8081/api/idol/all")
        .then(res => {
          this.idols = res.data;
        })
        .catch(err => {
          console.error(err);
          alert(err);
        });
    },
    submitSelection() {
      if (!this.voterName) {
        alert("請輸入投票者名字！");
        return;
      }
      if (this.selectedIdols.length === 0) {
        alert("請至少選擇一位偶像！");
        return;
      }
      
      const voteData = {
        voterName: this.voterName,
        options: this.selectedIdols
      };
      axios.post("http://localhost:8081/api/idol/vote", voteData, {
        headers: { "Content-Type": "application/json" }
      })
      .then(res => {
        this.voterName = "";
        this.selectedIdols = []; // 清空選擇
        alert(res.data);
        this.getAllIdols(); // 投票後自動刷新列表
      })
      .catch(err => {
        console.error(err);
        alert(err);
      });
    },
    submitDelection() {
      if (this.selectedIdols.length === 0) {
        alert("請至少選擇一位偶像！");
        return;
      }
      
      const deleteData = {
        options: this.selectedIdols
      };
      axios.post("http://localhost:8081/api/idol/delete", deleteData, {
        headers: { "Content-Type": "application/json" }
      })
      .then(res => {
        this.selectedIdols = []; // 清空選擇
        alert(res.data);
        this.getAllIdols(); 
      })
      .catch(err => {
        console.error(err);
        alert(err);
      });
    }
  },
  mounted() {
    this.getAllIdols();
  }
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.delete{
  margin-left: 10px;
}
.add{
  margin-top: 5px;
}
</style>
