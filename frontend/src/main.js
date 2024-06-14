import { createApp } from 'vue';
import App from './App.vue';
import router from './router';

// Import Bootstrap and BootstrapVue CSS files
import 'bootstrap/dist/css/bootstrap.css';
//import 'bootstrap-vue/dist/bootstrap-vue.css';
// Import Bootstrap and BootstrapVue CSS files (order is important)
import 'bootstrap-vue-3/dist/bootstrap-vue-3.css';

// Import BootstrapVue3
import { BootstrapVue3, IconsPlugin } from 'bootstrap-vue-3';

const app = createApp(App);

// Use BootstrapVue3
app.use(BootstrapVue3);
app.use(IconsPlugin);

// Use the router
app.use(router);

// Mount the app
app.mount('#app');
