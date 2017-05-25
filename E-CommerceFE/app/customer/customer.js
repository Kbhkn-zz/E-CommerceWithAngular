'use strict';

angular.module('ecommerce.customer', ["ngRoute", "ngTable"])
    .config(['$routeProvider', function ($routeProvider) {
        $routeProvider.when('/app/customer', {
            templateUrl: 'customer/customer.html',
            controller: 'CustomerController'
        });
    }]);