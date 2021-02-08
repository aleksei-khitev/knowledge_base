'use strict';

angular.
  module('statusList').
  component('statusList', {
    templateUrl: 'status-list/status-list.template.html',
    controller: function StatusListController() {
      this.statuses = [
        {
          name: 'Tomcat Server',
          status: 'Ok',
          value: 'Running'
        }, {
          name: 'Free Space',
          status: 'Ok',
          value: '800MB'
        }, {
          name: 'Apache Server',
          status: 'ERROR',
          value: 'Failed to runn'
        }
      ];
    }
  });