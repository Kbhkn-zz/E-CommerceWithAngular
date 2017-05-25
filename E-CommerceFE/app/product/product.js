'use strict';

angular.module('ecommerce.product', ['ngRoute'])
    .config(['$routeProvider', function ($routeProvider) {
        $routeProvider.when('/app/product', {
            templateUrl: 'product/product.html',
            controller: 'ProductController'
        });
    }]);