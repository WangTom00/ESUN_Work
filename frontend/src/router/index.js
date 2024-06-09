import { createRouter, createWebHistory } from 'vue-router';
import ProductList from '../components/ProductList.vue';
import AddProduct from '../components/AddProduct.vue';
import CreateOrder from '../components/CreateOrder.vue';

const routes = [
  { path: '/products', component: ProductList },
  { path: '/add-product', component: AddProduct },
  { path: '/create-order', component: CreateOrder }
];

const router = createRouter({
  history: createWebHistory(),
  routes
});

export default router;
