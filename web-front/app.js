require('./stylesheets/main.css')
const Vue         = require('vue')
const VueResource = require('vue-resource')
const Search      = require('./components/home/search.vue')

Vue.use(VueResource)

new Vue({
    el: '#main',
    components: {
        search: Search,
    }
})
