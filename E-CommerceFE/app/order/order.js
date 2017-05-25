'use strict';

angular.module('ecommerce.order', ['ngRoute'])
    .config(['$routeProvider', function ($routeProvider) {
        $routeProvider.when('/app/order', {
            templateUrl: 'order/order.html',
            controller: 'OrderController'
        });
    }]);