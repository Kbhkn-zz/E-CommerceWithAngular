angular.module('ecommerce.customer')
    .factory('CustomerService', function ($http, REST_URI) {
        var f = {};

        f.getAllCustomers = function () {
            return $http.get(REST_URI + 'customer/', {timeout: 10000})
        };
        f.addCustomer = function (newCustomer) {
            return $http.post(REST_URI + 'customer/new', newCustomer, {timeout: 10000})
        };
        f.updateCustomer = function (customer) {
            return $http.put(REST_URI + 'customer/update', customer, {timeout: 10000})
        };
        f.deleteCustomer = function (customerId) {
            return $http.delete(REST_URI + 'customer/delete/' + customerId, {timeout: 10000})
        };

        return f;
    });