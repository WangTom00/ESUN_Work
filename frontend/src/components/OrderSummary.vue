<template>
    <div>
      <h1>Order Summary</h1>
      <ul>
        <li v-for="item in cart" :key="item.productId">
          Product ID: {{ item.productId }} - Quantity: {{ item.quantity }} - Subtotal: {{ item.quantity * item.price }}
        </li>
      </ul>
      <p>Total: {{ total }}</p>
      <button @click="createOrder">Create Order</button>
    </div>
  </template>
  
  <script>
  import axios from 'axios';
  
  export default {
    props: ['cart'],
    computed: {
      total() {
        return this.cart.reduce((sum, item) => sum + item.quantity * item.price, 0);
      }
    },
    methods: {
      createOrder() {
        const order = {
          OrderID: 'Ms' + Date.now(),  // 模擬訂單編號
          MemberID: Math.floor(Math.random() * 100000),  // 模擬會員編號
          Price: this.total,
          PayStatus: 0  // 初始設定為未付款
        };
        const orderDetails = this.cart.map(item => ({
          OrderID: order.OrderID,
          ProductID: item.productId,
          Quantity: item.quantity,
          StandPrice: item.price,
          ItemPrice: item.quantity * item.price
        }));
  
        axios.post('/api/orders', { order, orderDetails })
          .then(() => {
            alert('Order created!');
            this.$router.push({ name: 'ProductList' });
          })
          .catch(error => {
            console.error("There was an error creating the order!", error);
          });
      }
    }
  };
  </script>
  