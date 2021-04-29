<template>
  <card class="card-album">
    <div class="image">
      <img
        src="https://baedagol.com/wp-content/uploads/2017/06/Cap-2017-11-12-13-50-42-112.jpg"
        alt="..."
      />
    </div>
      <hr />
      <ul>
        <li>
          <div class="row" v-for="member in members" :key="member.name">
            <div class="wtf">
              <div class="vvv">
                <img :src="member.image" alt="Circle Image" class="rounded img-fluid">
              </div>
            </div>
          </div>
        </li>
      </ul>
  </card>
</template>

<script>
export default {
  data() {
    return {
      members: [
        {
          image: require("@/assets/img/faces/face-0.jpg"),
          name: "Dj Khaled",
          status: "Offline"
        },
        {
          image: require("@/assets/img/faces/face-1.jpg"),
          name: "Creative Tim",
          status: "Available"
        },
        {
          image: require("@/assets/img/faces/face-1.jpg"),
          name: "Flume",
          status: "Busy"
        }
      ]
    };
  },
};
</script>

<style></style>