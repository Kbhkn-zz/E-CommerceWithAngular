angular.module('ecommerce.product')
    .controller('ProductController', function ($scope, $log, $timeout, ProductService) {
        $scope.product = {id: 0, name: "", description: "", price: ""};
        $scope.products = [];

        $scope.allProducts = function () {
            ProductService.getAllProducts()
                .then(function (resp) {
                    $scope.products = resp.data;
                })
                .then(
                    $scope.product = {id: 0, name: "", description: "", price: ""}
                );
        };
        $scope.addProduct = function () {
            ProductService.addProduct($scope.product).then(init());
        };

        $scope.updateProduct = function () {
            ProductService.updateProduct($scope.product).then(init());
        };

        $scope.deleteProduct = function (product) {
            ProductService.deleteProduct(product.id).then(init());
        };

        $scope.editProduct = function (product) {
            $scope.product = angular.copy(product);
        };

        var init = function () {
            $timeout(function () {
                $scope.allProducts();
            }, 100);
        };

        init();
    });