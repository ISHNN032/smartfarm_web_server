<template>
  <div>
    <div class="row">
      <div class="col-md-12">
        <card>
          <template slot="header">
            <h4 class="card-title">기상 정보</h4>
            <p>기상 정보가 없습니다.</p>
          </template>
        </card>
      </div>
    </div>

    <div class="row">
      <div class="col-md-12">
        <card>
          <template slot="header">
            <h4 class="card-title">제어기 상황</h4>
            <p class="card-category">
              마지막 연결: <a target="_self" href="#/icons">방금 전</a>
            </p>

            <!--Stats cards-->
            <div class="row">
              <div
                class="col-md-6 col-xl-3"
                v-for="stats in statsCards"
                :key="stats.title"
              >
                <stats-card>
                  <div
                    class="icon-big text-center"
                    :class="`icon-${stats.type}`"
                    slot="header"
                  >
                    <i :class="stats.icon"></i>
                  </div>
                  <div class="numbers" slot="content">
                    <p>{{ stats.title }}</p>
                    {{ stats.value }}
                  </div>
                  <div class="stats" slot="footer">
                    <i :class="stats.footerIcon"></i> {{ stats.footerText }}
                  </div>
                </stats-card>
              </div>
            </div>
          </template>
          <div class="content all-icons">
            <div class="icon-section">
              <h3></h3>
            </div>
          </div>
        </card>
      </div>
    </div>

    <!--Charts-->
    <div class="row">
      <div class="col-12">
        <chart-card
          title="세다 딸기 농원"
          sub-title="1년 기준"
          :chart-data="usersChart.data"
          :chart-options="usersChart.options"
        >
          <span slot="footer"> <i class="ti-reload"></i> 3분 전</span>
          <div slot="legend">
            <i class="fa fa-circle text-info"></i> 40%이하
            <i class="fa fa-circle text-danger"></i> 80%
            <i class="fa fa-circle text-warning"></i> 수확가능
          </div>
        </chart-card>
      </div>

      <!-- <div class="col-md-6 col-12">
        <chart-card
          title="Email Statistics"
          sub-title="Last campaign performance"
          :chart-data="preferencesChart.data"
          chart-type="Pie"
        >
          <span slot="footer">
            <i class="ti-timer"></i> Campaign set 2 days ago</span
          >
          <div slot="legend">
            <i class="fa fa-circle text-info"></i> Open
            <i class="fa fa-circle text-danger"></i> Bounce
            <i class="fa fa-circle text-warning"></i> Unsubscribe
          </div>
        </chart-card>
      </div>

      <div class="col-md-6 col-12">
        <chart-card
          title="2015 Sales"
          sub-title="All products including Taxes"
          :chart-data="activityChart.data"
          :chart-options="activityChart.options"
        >
          <span slot="footer">
            <i class="ti-check"></i> Data information certified
          </span>
          <div slot="legend">
            <i class="fa fa-circle text-info"></i> Tesla Model S
            <i class="fa fa-circle text-warning"></i> BMW 5 Series
          </div>
        </chart-card>
      </div> -->
    </div>
  </div>
</template>
<script>
import { StatsCard, ChartCard } from "@/components/index";
import Chartist from "chartist";
import axios from 'axios';
import SensorTable from "../components/SensorTable.vue";
export default {
  components: {
    StatsCard,
    ChartCard,
    SensorTable,
  },
  /**
   * Chart data used to render stats, charts. Should be replaced with server data
   */
  data() {
    return {
      statsCards: [
        {
          type: "warning",
          icon: "ti-check",
          title: "외부온도",
          value: "0°C",
          footerText: "방금 전",
          footerIcon: "ti-reload",
        },
        {
          type: "info",
          icon: "ti-check",
          title: "외부습도",
          value: "0%",
          footerText: "방금 전",
          footerIcon: "ti-timer",
        },
        {
          type: "success",
          icon: "ti-check",
          title: "풍속",
          value: "0.0m/s",
          footerText: "방금 전",
          footerIcon: "ti-reload",
        },
        {
          type: "success",
          icon: "ti-check",
          title: "풍향",
          value: "+0°",
          footerText: "방금 전",
          footerIcon: "ti-reload",
        },
        {
          type: "danger",
          icon: "ti-check",
          title: "지온",
          value: "0°C",
          footerText: "방금 전",
          footerIcon: "ti-calendar",
        },
        {
          type: "info",
          icon: "ti-check",
          title: "지습",
          value: "0%",
          footerText: "방금 전",
          footerIcon: "ti-calendar",
        },
      ],
      usersChart: {
        data: {
          labels: [
            "8월",
            "9월",
            "10월",
            "11월",
            "2020년 12월",
            "1월",
            "2월",
            "3월",
            "4월",
          ],
          series: [
            [0, 0, 490, 562, 594, 626, 698, 895, 952],
            [67, 152, 193, 240, 387, 435, 535, 642, 744],
            [23, 113, 67, 108, 190, 239, 307, 410, 410],
          ],
        },
        options: {
          low: 0,
          high: 1000,
          showArea: true,
          height: "245px",
          axisX: {
            showGrid: false,
          },
          lineSmooth: Chartist.Interpolation.simple({
            divisor: 3,
          }),
          showLine: true,
          showPoint: false,
        },
      }
    };
  },

  methods: {
    getDatas: function(){
      axios.get("http://localhost:8080/smartfarm-1.0.0/api/temp")
        .then(response => {this.patch('temp', response.data)})
        .catch(error => window.console.log(error));
      axios.get("http://localhost:8080/smartfarm-1.0.0/api/humi")
        .then(response => this.patch('humi', response.data))
        .catch(error => window.console.log(error));
      axios.get("http://localhost:8080/smartfarm-1.0.0/api/winds")
        .then(response => this.patch('winds', response.data))
        .catch(error => window.console.log(error));
      axios.get("http://localhost:8080/smartfarm-1.0.0/api/windd")
        .then(response => this.patch('windd', response.data))
        .catch(error => window.console.log(error));
      axios.get("http://localhost:8080/smartfarm-1.0.0/api/soilt")
        .then(response => this.patch('soilt', response.data))
        .catch(error => window.console.log(error));
      axios.get("http://localhost:8080/smartfarm-1.0.0/api/soilh")
        .then(response => this.patch('soilh', response.data))
        .catch(error => window.console.log(error));
    },
    patch: function(table, data){
      switch (table) {
        case 'temp':
          this.statsCards[0].value = data[0].value + "°C"; break;
        case 'humi':
          this.statsCards[1].value = data[0].value + "%"; break;
        case 'winds':
          this.statsCards[2].value = data[0].value + "m/s"; break;
        case 'windd':
          this.statsCards[3].value = data[0].value + "°"; break;
        case 'soilt':
          this.statsCards[4].value = data[0].value + "°C"; break;
        case 'soilh':
          this.statsCards[5].value = data[0].value + "%"; break;
      }
    }
  },
  mounted: function () {
    this.getDatas();
    this.pollInterval = setInterval(function () {
      this.getDatas();
    }.bind(this), 5000)
  },

  beforeDestroy: function () {
    clearInterval(this.pollInterval);
  }
};
</script>
<style>
</style>
