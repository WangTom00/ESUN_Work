import { createRouter, createWebHistory } from 'vue-router';
import ProductList from '../components/ProductList.vue';
import OrderSummary from '../components/OrderSummary.vue';

const routes = [
  {
    path: '/',
    name: 'ProductList',
    component: ProductList
  },
  {
    path: '/order-summary',
    name: 'OrderSummary',
    component: OrderSummary,
    props: true
  }
];

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
});

export default router;
