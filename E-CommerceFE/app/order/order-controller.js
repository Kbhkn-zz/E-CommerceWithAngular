angular.module('ecommerce.order')
    .controller('OrderController', function ($scope, $log, $timeout, OrderService, CustomerService, ProductService) {
        $scope.order = {id:0};

        $scope.allOrders = function () {
            OrderService.getAllOrders()
                .then(function (resp) {
                    $scope.orders = resp.data;
                })
                .then(
                    $scope.order = {id:0}
                );
        };
        $scope.addOrder = function () {
            OrderService.addOrder($scope.order).then(init());
        };

        $scope.updateOrder = function () {
            OrderService.updateOrder($scope.order).then(init());
        };

        $scope.deleteOrder = function (order) {
            OrderService.deleteOrder(order.id).then(init());
        };

        $scope.editUser = function (order) {
            $scope.order = angular.copy(order);
        };

        var init = function () {
            $timeout(function () {
                $scope.allOrders();
                CustomerService.getAllCustomers().then(function (resp) {
                    $scope.customers = resp.data;
                });
                ProductService.getAllProducts().then(function (resp) {
                    $scope.products = resp.data;
                });
            }, 100);
        };

        init();
    });