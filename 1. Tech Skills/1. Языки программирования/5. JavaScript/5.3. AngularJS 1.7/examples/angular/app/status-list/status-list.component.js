'use strict';

angular.
    module('statusList').
    component('statusList', {
        templateUrl: 'status-list/status-list.template.html',
        controller: function StatusListController($http) {
            var self = this;
            self.orderProp = 'name';
            $http.get('status-list/status-list.json').then(function(response) {
                self.statuses = response.data;
            });
        }
    });