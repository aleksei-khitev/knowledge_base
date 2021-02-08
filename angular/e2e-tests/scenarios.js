'use strict';

// AngularJS E2E Testing Guide:
// https://docs.angularjs.org/guide/e2e-testing

describe('StatusReader Application', function() {

    describe('statusList', function() {

    beforeEach(function() {
        browser.get('index.html');
    });

    it('should filter the status list as a user types into the search box', function() {
        var phoneList = element.all(by.repeater('status in $ctrl.statuses'));
        var query = element(by.model('$ctrl.query'));
        var orderSelect = element(by.model('$ctrl.orderProp'));
        var nameOption = orderSelect.element(by.css('option[value="name"]'));
        var statusNameColumn = element.all(by.repeater('status in $ctrl.statuses').column('status.name'));

        function getNames() {
            return statusNameColumn.map(function(elem) {
                return elem.getText();
            });
        }

        query.sendKeys('Server');
        expect(phoneList.count()).toBe(2);
        expect(getNames()).toEqual([
            'Tomcat Server',
            'Apache Server'
        ]);

        nameOption.click();

        expect(getNames()).toEqual([
            'Apache Server',
            'Tomcat Server'
        ]);
    });

  });

});