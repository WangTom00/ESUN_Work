<template>
  <div id="app">
    <h1>E-commerce Platform</h1>
    <nav>
      <router-link to="/products">Product List</router-link>
      <router-link to="/add-product">Add Product</router-link>
      <router-link to="/create-order">Create Order</router-link>
    </nav>
    <router-view></router-view>
  </div>
</template>

<script>
export default {
  name: 'App'
};
</script>

<style>
nav {
  margin-bottom: 20px;
}
nav a {
  margin-right: 10px;
}
</style>
