<template>
    <div>
      <h2>Add Product</h2>
      <form @submit.prevent="addProduct">
        <div>
          <label for="productId">Product ID</label>
          <input type="text" v-model="productId" required>
        </div>
        <div>
          <label for="productName">Product Name</label>
          <input type="text" v-model="productName" required>
        </div>
        <div>
          <label for="price">Price</label>
          <input type="number" v-model="price" required>
        </div>
        <div>
          <label for="quantity">Quantity</label>
          <input type="number" v-model="quantity" required>
        </div>
        <button type="submit">Add Product</button>
      </form>
    </div>
  </template>
  
  <script>
  export default {
    data() {
      return {
        productId: '',
        productName: '',
        price: 0,
        quantity: 0
      };
    },
    methods: {
      async addProduct() {
        const product = {
          productId: this.productId,
          productName: this.productName,
          price: this.price,
          quantity: this.quantity
        };
        try {
          const response = await fetch('http://localhost:8081/api/products', {
            method: 'POST',
            headers: {
              'Content-Type': 'application/json'
            },
            body: JSON.stringify(product)
          });
          if (response.ok) {
            alert('Product added successfully!');
          } else {
            alert('Error adding product');
          }
        } catch (error) {
          console.error('Error adding product', error);
        }
      }
    }
  };
  </script>
  