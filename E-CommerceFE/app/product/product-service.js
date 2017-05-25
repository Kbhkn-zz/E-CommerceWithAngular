angular.module('ecommerce.product')
    .factory('ProductService', function ($http, REST_URI) {
        var f = {};

        f.getAllProducts = function () {
            return $http.get(REST_URI + 'product/', {timeout: 10000})
        };
        f.addProduct = function (newProduct) {
            return $http.post(REST_URI + 'product/new', newProduct, {timeout: 10000})
        };
        f.updateProduct = function (product) {
            return $http.put(REST_URI + 'product/update', product, {timeout: 10000})
        };
        f.deleteProduct = function (productId) {
            return $http.delete(REST_URI + 'product/delete/' + productId, {timeout: 10000})
        };

        return f;
    });