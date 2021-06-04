<template>
  <div class="row">
    <a class="col-md-12">
      <div class="gallery">
        <div class="gallery-item">
          <img class="gallery-image" :src="imagepool[0]" />
        </div>

        <div class="gallery-item">
          <img class="gallery-image" :src="imagepool[1]" />
        </div>

        <div class="gallery-item">
          <img class="gallery-image" :src="imagepool[2]" />
        </div>

        <div class="gallery-item">
          <img class="gallery-image" :src="imagepool[3]" />
        </div>

        <div class="gallery-item">
          <img class="gallery-image" :src="imagepool[4]" />
        </div>

        <div class="gallery-item">
          <img class="gallery-image" :src="imagepool[5]" />
        </div>
      </div>
    </a>
  </div>
</template>
<script>
export default {
  data() {
    return {
      imagepool: [],
      img_0: ""
    };
  },
  methods: {
    importAll(r) {
      r.keys().forEach(key =>
        this.imagepool.push(r(key))
      );
      window.console.log(this.imagepool);
      // this.imagepool.forEach(img => {
      //   this.img_0 = img.pathLong;
      //   this.$set(this.imagepool, 1, img.pathLong);
      //   window.console.log("index: " + img.pathLong);
      // });
    }
  },
  mounted() {
    this.importAll(require.context("../assets/img/screenshots/", true, /\.jpg$/));
  }
};
</script>
<style>
:root {
  font-size: 10px;
}

*,
*::before,
*::after {
  box-sizing: border-box;
}

body {
  min-height: 100vh;
  background-color: #fafafa;
}

.container {
  max-width: 100rem;
  margin: 0 auto;
  padding: 0 2rem 2rem;
}

.heading {
  font-family: "Montserrat", Arial, sans-serif;
  font-size: 4rem;
  font-weight: 500;
  line-height: 1.5;
  text-align: center;
  padding: 3.5rem 0;
  color: #1a1a1a;
}

.heading span {
  display: block;
}

.gallery {
  display: flex;
  flex-wrap: wrap;
  /* Compensate for excess margin on outer gallery flex items */
  margin: -1rem -1rem;
}

.gallery-item {
  /* Minimum width of 24rem and grow to fit available space */
  flex: 1 0 24rem;
  /* Margin value should be half of grid-gap value as margins on flex items don't collapse */
  margin: 1rem;
  box-shadow: 0.3rem 0.4rem 0.4rem rgba(0, 0, 0, 0.4);
  overflow: hidden;
}

.gallery-image {
  display: block;
  width: 100%;
  height: 100%;
  object-fit: cover;
  transition: transform 400ms ease-out;
}

.gallery-image:hover {
  transform: scale(1.15);
}

@supports (display: grid) {
  .gallery {
    display: grid;
    grid-template-columns: repeat(auto-fit, minmax(24rem, 1fr));
    grid-gap: 2rem;
  }

  .gallery,
  .gallery-item {
    margin: 0;
  }
}
</style>
