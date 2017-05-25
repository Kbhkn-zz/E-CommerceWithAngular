angular.module('ecommerce.customer')
    .controller('CustomerController', function ($scope, $log, $timeout, CustomerService, NgTableParams) {
        $scope.customer = {id: 0, name: "", surname: "", email: ""};
        $scope.customers = [];

        $scope.allCustomers = function () {
            CustomerService.getAllCustomers()
                .then(function (resp) {
                    $scope.customers = resp.data;
                    $scope.tableParams = new NgTableParams({page: 1, total: 10}, { total: $scope.customers.length, dataset: resp.data});
                })
                .then(
                    $scope.customer = {id: 0, name: "", surname: "", email: ""}
                );
        };
        $scope.addCustomer = function () {
            CustomerService.addCustomer($scope.customer).then(init());
        };

        $scope.updateCustomer = function () {
            CustomerService.updateCustomer($scope.customer).then(init());
        };

        $scope.deleteCustomer = function (customer) {
            CustomerService.deleteCustomer(customer.id).then(init());
        };

        $scope.editUser = function (customer) {
            $scope.customer = angular.copy(customer);
        };

        var init = function () {
            $timeout(function () {
                $scope.allCustomers();
            }, 100);
        };

        init();
    });