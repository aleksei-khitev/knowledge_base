'use strict';

angular.
  module('statusReaderView').
  component('statusesList', {
    template:
        '<h1>Statuses</h1>' +
        '<ul>' +
          '<li ng-repeat="status in $ctrl.statuses">' +
            '<span>{{status.name}}</span>' +
            '<p>{{status.status}}</p>' +
          '</li>' +
        '</ul>',
    controller: function StatusesController() {
      this.statuses = [
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
    }
  });