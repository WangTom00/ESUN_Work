<template>
  <div id="app">
    <b-container>
      <b-navbar toggleable="lg" type="dark" variant="info">
        <b-navbar-brand href="#">E-commerce Platform</b-navbar-brand>
        <b-navbar-nav class="ml-auto">
          <b-nav-item to="/products" exact>Product List</b-nav-item>
          <b-nav-item to="/add-product">Add Product</b-nav-item>
          <b-nav-item to="/create-order">Create Order</b-nav-item>
        </b-navbar-nav>
      </b-navbar>
      <b-container class="mt-4">
        <router-view></router-view>
      </b-container>
    </b-container>
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
