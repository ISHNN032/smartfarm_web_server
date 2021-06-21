<template>
  <div class="row">
    <div class="col-12">
      <card :title="table0.title" :subTitle="table0.subTitle">
        <div class="table-responsive">
          <paper-table :data="table0.data" :columns="table0.columns">
          </paper-table>
        </div>
      </card>

      <card :title="table1.title" :subTitle="table1.subTitle">
        <div slot="raw-content" class="table-responsive">
          <paper-table :data="table1.data" :columns="table1.columns">
          </paper-table>
        </div>
      </card>

      <card :title="table2.title" :subTitle="table2.subTitle">
        <div slot="raw-content" class="table-responsive">
          <paper-table :data="table2.data" :columns="table2.columns">
          </paper-table>
        </div>
      </card>

      <card :title="table3.title" :subTitle="table3.subTitle">
        <div slot="raw-content" class="table-responsive">
          <paper-table :data="table3.data" :columns="table3.columns">
          </paper-table>
        </div>
      </card>

      <card :title="table4.title" :subTitle="table4.subTitle">
        <div slot="raw-content" class="table-responsive">
          <paper-table :data="table4.data" :columns="table4.columns">
          </paper-table>
        </div>
      </card>

      <card :title="table5.title" :subTitle="table5.subTitle">
        <div slot="raw-content" class="table-responsive">
          <paper-table :data="table5.data" :columns="table5.columns">
          </paper-table>
        </div>
      </card>
    </div>
    <!-- <div class="col-12">
      <card class="card-plain">
        <div class="table-full-width table-responsive">
          <paper-table
            type="hover"
            :title="table2.title"
            :sub-title="table2.subTitle"
            :data="table2.data"
            :columns="table2.columns"
          >
          </paper-table>
        </div>
      </card>
    </div> -->
  </div>
</template>
<script>
import { PaperTable } from "@/components";
import axios from "axios";
import Button from "../components/Button.vue";
const tableColumns = [
  "id",
  "createtimestamp",
  "state",
  "value"
];
const tableData = [];

export default {
  components: {
    PaperTable,
    Button
  },
  data() {
    return {
      pollInterval: null,
      table0: {
        title: "inji000_temp",
        subTitle: "마지막 업데이트: 방금 전",
        columns: [...tableColumns],
        data: [...tableData]
      },
      table1: {
        title: "inji001_humi",
        subTitle: "마지막 업데이트: 방금 전",
        columns: [...tableColumns],
        data: [...tableData]
      },
      table2: {
        title: "inji002_wind_direction",
        subTitle: "마지막 업데이트: 방금 전",
        columns: [...tableColumns],
        data: [...tableData]
      },
      table3: {
        title: "inji003_wind_speed",
        subTitle: "마지막 업데이트: 방금 전",
        columns: [...tableColumns],
        data: [...tableData]
      },
      table4: {
        title: "inji004_soilt",
        subTitle: "마지막 업데이트: 방금 전",
        columns: [...tableColumns],
        data: [...tableData]
      },
      table5: {
        title: "inji005_soilh",
        subTitle: "마지막 업데이트: 방금 전",
        columns: [...tableColumns],
        data: [...tableData]
      }
    };
  },
  methods: {
    getDatas: function() {
      axios
        .get("http://localhost:8080/smartfarm-1.0.0/api/temp")
        .then(response =>{
          var vv = JSON.stringify(response.data).replace(/"([^"]+)":/g,function($0,$1){return ('"'+$1.toLowerCase()+'":');});
          this.patch("temp", JSON.parse(vv));
        })
        .catch(error => window.console.log(error));

      axios
        .get("http://localhost:8080/smartfarm-1.0.0/api/humi")
        .then(response => {
          var vv = JSON.stringify(response.data).replace(/"([^"]+)":/g,function($0,$1){return ('"'+$1.toLowerCase()+'":');});
          this.patch("humi", JSON.parse(vv));
        })
        .catch(error => window.console.log(error));

      axios
        .get("http://localhost:8080/smartfarm-1.0.0/api/windd")
        .then(response => {
          var vv = JSON.stringify(response.data).replace(/"([^"]+)":/g,function($0,$1){return ('"'+$1.toLowerCase()+'":');});
          this.patch("windd", JSON.parse(vv));
        })
        .catch(error => window.console.log(error));

      axios
        .get("http://localhost:8080/smartfarm-1.0.0/api/winds")
        .then(response => {
          var vv = JSON.stringify(response.data).replace(/"([^"]+)":/g,function($0,$1){return ('"'+$1.toLowerCase()+'":');});
          this.patch("winds", JSON.parse(vv));
        })
        .catch(error => window.console.log(error));

      axios
        .get("http://localhost:8080/smartfarm-1.0.0/api/soilt")
        .then(response => {
          var vv = JSON.stringify(response.data).replace(/"([^"]+)":/g,function($0,$1){return ('"'+$1.toLowerCase()+'":');});
          this.patch("soilt", JSON.parse(vv));
        })
        .catch(error => window.console.log(error));

      axios
        .get("http://localhost:8080/smartfarm-1.0.0/api/soilh")
        .then(response => {
          var vv = JSON.stringify(response.data).replace(/"([^"]+)":/g,function($0,$1){return ('"'+$1.toLowerCase()+'":');});
          this.patch("soilh", JSON.parse(vv));
        })
        .catch(error => window.console.log(error));
    },
    patch: function(table, data) {
      switch (table) {
        case "temp":
          this.table0.data = data;
          break;
        case "humi":
          this.table1.data = data;
          break;
        case "windd":
          this.table2.data = data;
          break;
        case "winds":
          this.table3.data = data;
          break;
        case "soilt":
          this.table4.data = data;
          break;
        case "soilh":
          this.table5.data = data;
          break;
      }
    }
  },
  // mounted() {
  //   this.getDatas()
  //   //check if the status is completed, if not fetch data every 10minutes
  //   this.pollInterval = setInterval(this.getDatas(), 1000) //save reference to the interval
  //   setTimeout(() => {clearInterval(this.pollInterval)}, 36000000) //stop polling after an hour
  // }
  mounted: function() {
    this.getDatas();

    this.pollInterval = setInterval(
      function() {
        this.getDatas();
      }.bind(this),
      5000
    );
  },

  beforeDestroy: function() {
    clearInterval(this.pollInterval);
  }
};
</script>
<style>
@charset "UTF-8";

body {
  color: #777777;
  font-size: 0.85rem;
  margin: 0 auto;
  font-family: "Noto Sans KR", "Helvetica Neue", Roboto, Arial, "Droid Sans",
    sans-serif;
}

a {
  color: #777777;
  text-decoration: none;
}

header {
  padding: 20px 10px;
  text-align: center;
  max-height: 90px;
}

header ul {
  list-style: none;
  font-size: 0.8rem;
  position: absolute;
  top: 20px;
  right: 20px;
}

header ul li {
  display: inline-block;
  padding-right: 5px;
  max-width: 300px;
  vertical-align: middle;
}

header ul li .gsc-control-cse,
header ul li table.gsc-search-box td.gsc-input {
  padding: 0;
}

header ul li form.gsc-search-box,
header ul li table.gsc-search-box {
  margin-bottom: 0;
}

header ul li .gsc-search-box input {
  font-size: 13px;
}

nav#nav_area {
  background-color: white;
  border-bottom: 1px solid #dadada;
  padding: 0rem 1rem;
}

nav#nav_area > button {
  margin: 3px;
}

nav#nav_area > button span {
  width: 1em;
  height: 1em;
}

nav .navbar-nav li {
  padding: 1rem 1.02rem;
  box-sizing: border-box;
  -moz-box-sizing: border-box;
  -webkit-box-sizing: border-box;
  border-bottom: 3px solid transparent;
  font-weight: 500;
}

nav #nav_menu {
  margin: 0 auto;
  width: 1140px;
}

nav #nav_menu li.nav-item.active {
  color: #24a9f6;
  border-bottom: 3px solid #24a9f6;
}

nav #nav_menu li.nav-item:hover {
  color: #24a9f6;
  border-bottom: 3px solid #dadada;
}

section {
  background-color: #f2f4f7;
  padding: 20px;
  border-top: 1px solid #ebedef;
  border-bottom: 1px solid #ebedef;
}

section .container {
  width: 100%;
  min-height: 580px;
  margin: 0 auto;
  padding: 30px 45px;
  border: 1px solid #ebedef;
  background-color: #ffffff;
}

section .container .d-title {
  padding: 1px 5px 6px;
  margin-bottom: 10px;
}

section .container .d-title h2 {
  font-size: 22px;
}

section #d-spin {
  position: fixed;
  top: calc(50% - 1rem);
  left: calc(50% - 1rem);
  color: #6c757d !important;
}

footer {
  margin-bottom: 0;
  background-color: white;
  padding: 2rem 1rem;
  border-top: 1px solid #dadada;
  text-align: center;
}
</style>
