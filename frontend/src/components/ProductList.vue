<template>
    <div>
      <h2>Product List</h2>
      <ul>
        <li v-for="product in products" :key="product.productId">
          {{ product.productName }} - {{ product.price }} - Stock: {{ product.quantity }}
        </li>
      </ul>
    </div>
  </template>
  
  <script>
  export default {
    data() {
      return {
        products: []
      };
    },
    created() {
      this.fetchProducts();
    },
    methods: {
      async fetchProducts() {
        try {
          const response = await fetch('http://localhost:8081/api/products');
          if (response.ok) {
            this.products = await response.json();
          } else {
            console.error('Error fetching products');
          }
        } catch (error) {
          console.error('Error fetching products', error);
        }
      }
    }
  };
  </script>
  