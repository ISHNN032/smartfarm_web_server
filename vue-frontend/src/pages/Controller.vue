<template>
  <div>
    <img id="motionjpeg" src="http://192.168.0.63:8080/video" />
    <img
      class="src"
      id="srcjpg"
      :src="img_0"
      @mousedown="changeImageWhen(0, 'down')"
      @mouseup="changeImageWhen(0, 'up')"
    />
    <img
      class="src"
      id="srcjpg"
      :src="img_1"
      @mousedown="changeImageWhen(1, 'down')"
      @mouseup="changeImageWhen(1, 'up')"
    />
  </div>
</template>
<script>
export default {
  data() {
    return {
      img_0: "http://192.168.0.63:8080/shot.jpg",
      img_1: "http://192.168.0.63:8080/shot.jpg",
      images: {
        up: "http://192.168.0.63:8080/shot.jpg",
        down: "https://via.placeholder.com/300x300/ddd"
      }
    };
  },
  methods: {
    changeImageWhen: function(num, state) {
      if (num == 0) {
        this.img_0 = this.images[state];
      } else if (num == 1) {
        this.img_1 = this.images[state];
      }
    }
  }
};
</script>
<style>
img {
  width: 100%;
  object-fit: cover;
}
.src {
  width: 50%;
  height: 200px;
  object-fit: cover;
}
</style>
