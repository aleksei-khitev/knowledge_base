'use strict';

angular.
  module('statusList').
  component('statusList', {
    templateUrl: 'status-list/status-list.template.html',
    controller: function StatusListController() {
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