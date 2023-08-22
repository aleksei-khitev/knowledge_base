'use strict';

angular.
    module('statusReader').
    config(['$routeProvider',
        function config($routeProvider) {
            $routeProvider.
            when('/statuses', {
                template: '<status-list></status-list>'
            }).
            when('/statuses/:id', {
                template: '<status-detail></status-detail>'
            }).
            otherwise('/statuses');
        }
    ]);