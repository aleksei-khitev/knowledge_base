'use strict';

// AngularJS E2E Testing Guide:
// https://docs.angularjs.org/guide/e2e-testing

describe('StatusReader Application', function() {

  describe('statusList', function() {

    beforeEach(function() {
      browser.get('');
    });

    it('should filter the status list as a user types into the search box', function() {
      var phoneList = element.all(by.repeater('status in $ctrl.statuses'));
      var query = element(by.model('$ctrl.query'));

      expect(phoneList.count()).toBe(3);

      query.sendKeys('Tomcat');
      expect(phoneList.count()).toBe(1);

      query.clear();
      query.sendKeys('Apache');
      expect(phoneList.count()).toBe(1);
    });

  });

});