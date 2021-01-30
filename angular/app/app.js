'use strict';

// Define the `statusReaderView` module
var statusReaderView = angular.module('statusReaderView', []);

// Define the `StatusesController` controller on the `statusReaderView` module
statusReaderView.controller('StatusesController', function StatusesController($scope) {
  $scope.statuses = [
    {
      name: 'Tomcat',
      status: 'Ok'
    }, {
      name: 'Free Space',
      status: '800MB'
    }, {
      name: 'Apache',
      status: 'Ok'
    }
  ];
});