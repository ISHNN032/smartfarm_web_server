<template>
  <div class="row">
    <a class="col-md-12">
      <album-card></album-card>
      <members-card> </members-card>
    </a>
  </div>
</template>
<script>
import AlbumCard from "./Album/AlbumCard.vue";
import MembersCard from "./UserProfile/MembersCard.vue";
export default {
  components: {
    AlbumCard,
    MembersCard,
  },
};
</script>
<style>
</style>
