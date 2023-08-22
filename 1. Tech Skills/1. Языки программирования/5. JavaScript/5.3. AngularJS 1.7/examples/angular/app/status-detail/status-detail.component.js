'use strict';

// Register `statusDetail` component, along with its associated controller and template
angular.
  module('statusDetail').
  component('statusDetail', {
    template: 'Status Detail view for <span>{{$ctrl.id}}</span>',
    controller: ['$routeParams',
      function statusDetailController($routeParams) {
        this.id = $routeParams.id;
      }
    ]
  });