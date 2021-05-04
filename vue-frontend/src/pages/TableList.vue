<template>
    <div class="row">
      <section layout:fragment="f-content">
        <div class="container">
          <div class="d-title">
            <h2>농장 조회</h2>
          </div>
          <div class="d-content">
            <div class="row">
              <div class="table-responsive">
                <table class="table table-striped">
                  <thead>
                    <tr class="text-center">
                      <th width="10%">아이디</th>
                      <th width="35%">이름</th>
                      <th width="25%">농장 분류</th>
                      <th width="20%">가입일시</th>
                      <th width="10%">삭제여부</th>
                    </tr>
                  </thead>
                  <tbody>
                    <tr class="text-center" th:object="${store}" th:each="store: ${stores}" th:attr="data-href=@{/v/stores/__${store.id}__}">
                      <td th:text="*{ id }"></td>
                      <td th:text="*{ name }"></td>
                      <td th:text="*{ storeBusiness }"></td>
                      <td th:text="*{ createTimestamp }"></td>
                      <td th:text="*{ del ? 'Y' : 'N' }"></td>
                    </tr>
                  </tbody>
                </table>
              </div>
            </div>
          </div>
        </div>
      </section>
      <!-- <div class="col-12">
        <card :title="table1.title" :subTitle="table1.subTitle">
          <div slot="raw-content" class="table-responsive">
            <paper-table :data="table1.data" :columns="table1.columns">

            </paper-table>
          </div>
        </card>
      </div>

      <div class="col-12">
        <card class="card-plain">
          <div class="table-full-width table-responsive">
            <paper-table type="hover" :title="table2.title" :sub-title="table2.subTitle" :data="table2.data"
                         :columns="table2.columns">

            </paper-table>
          </div>
        </card>
      </div> -->

    </div>
</template>
<script>
import { PaperTable } from "@/components";
const tableColumns = ["Id", "Name", "Salary", "Country", "City"];
const tableData = [
  {
    id: 1,
    name: "Dakota Rice",
    salary: "$36.738",
    country: "Niger",
    city: "Oud-Turnhout"
  },
  {
    id: 2,
    name: "Minerva Hooper",
    salary: "$23,789",
    country: "Curaçao",
    city: "Sinaai-Waas"
  },
  {
    id: 3,
    name: "Sage Rodriguez",
    salary: "$56,142",
    country: "Netherlands",
    city: "Baileux"
  },
  {
    id: 4,
    name: "Philip Chaney",
    salary: "$38,735",
    country: "Korea, South",
    city: "Overland Park"
  },
  {
    id: 5,
    name: "Doris Greene",
    salary: "$63,542",
    country: "Malawi",
    city: "Feldkirchen in Kärnten"
  }
];

export default {
  components: {
    PaperTable
  },
  data() {
    return {
      table1: {
        title: "Stripped Table",
        subTitle: "Here is a subtitle for this table",
        columns: [...tableColumns],
        data: [...tableData]
      },
      table2: {
        title: "Table on Plain Background",
        subTitle: "Here is a subtitle for this table",
        columns: [...tableColumns],
        data: [...tableData]
      }
    };
  }
};
</script>
<style>
  @charset "UTF-8";

  body {
    color: #777777;
    font-size: 0.85rem;
    margin: 0 auto;
    font-family: 'Noto Sans KR', "Helvetica Neue", Roboto, Arial,
      "Droid Sans", sans-serif;
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

  header ul li .gsc-control-cse, header ul li table.gsc-search-box td.gsc-input {
    padding: 0;
  }

  header ul li form.gsc-search-box, header ul li table.gsc-search-box {
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
    width: 1em; height: 1em;	
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
    margin: 0 auto; width: 1140px;
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
      color: #6c757d!important;
  }

  footer {
    margin-bottom: 0;
    background-color: white;
    padding: 2rem 1rem;
    border-top: 1px solid #dadada;
    text-align: center;
  }
</style>
