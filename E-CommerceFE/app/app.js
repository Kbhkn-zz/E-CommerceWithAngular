'use strict';

angular.module('ecommerce', ['ngRoute', 'ecommerce.customer', 'ecommerce.product', 'ecommerce.order'])
    .constant(
        'REST_URI', 'http://localhost:8080/api/service/'
    )
    .config(['$locationProvider', '$routeProvider', function ($locationProvider, $routeProvider) {
        $locationProvider.hashPrefix('!');
        $routeProvider.otherwise({redirectTo: '/app/customer'});
    }])
    .controller('MainController', function ($scope, $location) {
        $scope.isActive = function (viewLocation) {
            return (viewLocation === $location.path());
        };
    });
