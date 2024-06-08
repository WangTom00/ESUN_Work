<template>
    <div>
      <h1>Product List</h1>
      <ul>
        <li v-for="product in products" :key="product.ProductID">
          {{ product.ProductName }} - {{ product.Price }} - Stock: {{ product.Quantity }}
          <button @click="addToCart(product)">Add to Cart</button>
        </li>
      </ul>
      <button @click="goToOrderSummary">Proceed to Order Summary</button>
    </div>
  </template>
  
  <script>
  import axios from 'axios';
  
  export default {
    data() {
      return {
        products: [],
        cart: []
      };
    },
    created() {
      this.fetchProducts();
    },
    methods: {
      fetchProducts() {
        axios.get('/api/products')
          .then(response => {
            this.products = response.data;
          })
          .catch(error => {
            console.error("There was an error fetching the products!", error);
          });
      },
      addToCart(product) {
        const item = this.cart.find(i => i.productId === product.ProductID);
        if (item) {
          if (item.quantity < product.Quantity) {
            item.quantity++;
          } else {
            alert('Insufficient stock');
          }
        } else {
          this.cart.push({ productId: product.ProductID, quantity: 1, price: product.Price });
        }
      },
      goToOrderSummary() {
        this.$router.push({ name: 'OrderSummary', params: { cart: this.cart } });
      }
    }
  };
  </script>
  