angular.module('ecommerce.order')
    .factory('OrderService', function ($http, REST_URI) {
        var f = {};

        f.getAllOrders = function () {
            return $http.get(REST_URI + '/order/', {timeout: 10000})
        };
        f.addOrder = function (newOrder) {
            return $http.post(REST_URI + '/order/new', newOrder, {timeout: 10000})
        };
        f.updateOrder = function (order) {
            return $http.put(REST_URI + '/order/update', order, {timeout: 10000})
        };
        f.deleteOrder = function (orderId) {
            return $http.delete(REST_URI + '/order/delete/' + orderId, {timeout: 10000})
        };

        return f;
    });