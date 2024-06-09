<template>
    <div>
      <h2>Create Order</h2>
      <form @submit.prevent="createOrder">
        <div v-for="product in availableProducts" :key="product.productId">
          <label>
            <input type="checkbox" :value="product.productId" v-model="selectedProducts">
            {{ product.productName }} - {{ product.price }} - Stock: {{ product.quantity }}
          </label>
          <input type="number" v-model="productQuantities[product.productId]" :max="product.quantity" placeholder="Quantity">
        </div>
        <button type="submit">Create Order</button>
      </form>
      <div v-if="orderDetails.length > 0">
        <h3>Order Summary</h3>
        <ul>
          <li v-for="detail in orderDetails" :key="detail.productId">
            {{ detail.productName }} - {{ detail.quantity }} x {{ detail.standPrice }} = {{ detail.itemPrice }}
          </li>
        </ul>
        <p>Total Amount: {{ totalAmount }}</p>
        <button @click="submitOrder">Submit Order</button>
      </div>
    </div>
  </template>
  
  <script>
  export default {
    data() {
      return {
        availableProducts: [],
        selectedProducts: [],
        productQuantities: {},
        orderDetails: [],
        totalAmount: 0
      };
    },
    created() {
      this.fetchAvailableProducts();
    },
    methods: {
      async fetchAvailableProducts() {
        try {
          const response = await fetch('http://localhost:8081/api/products/available');
          if (response.ok) {
            this.availableProducts = await response.json();
          } else {
            console.error('Error fetching available products');
          }
        } catch (error) {
          console.error('Error fetching available products', error);
        }
      },
      createOrder() {
        this.orderDetails = [];
        this.totalAmount = 0;
        for (const productId of this.selectedProducts) {
          const product = this.availableProducts.find(p => p.productId === productId);
          const quantity = this.productQuantities[productId];
          if (quantity > 0 && quantity <= product.quantity) {
            const itemPrice = product.price * quantity;
            this.orderDetails.push({
              productId: product.productId,
              productName: product.productName,
              quantity: quantity,
              standPrice: product.price,
              itemPrice: itemPrice
            });
            this.totalAmount += itemPrice;
          }
        }
      },
      async submitOrder() {
        const order = {
          memberId: 1, // Replace with actual member ID
          payStatus: false,
          price: this.totalAmount
        };
        try {
          const response = await fetch('http://localhost:8081/api/orders', {
            method: 'POST',
            headers: {
              'Content-Type': 'application/json'
            },
            body: JSON.stringify({ order, orderDetails: this.orderDetails })
          });
          if (response.ok) {
            alert('Order created successfully!');
            this.fetchAvailableProducts(); // Refresh available products
          } else {
            alert('Error creating order');
          }
        } catch (error) {
          console.error('Error creating order', error);
        }
      }
    }
  };
  </script>
  