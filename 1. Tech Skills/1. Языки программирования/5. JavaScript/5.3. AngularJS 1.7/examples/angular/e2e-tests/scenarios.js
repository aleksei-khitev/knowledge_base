'use strict';

// AngularJS E2E Testing Guide:
// https://docs.angularjs.org/guide/e2e-testing

describe('StatusReader Application', function() {

    it('should redirect `index.html` to `index.html#!/statuses', function() {
        browser.get('index.html');
        expect(browser.getCurrentUrl()).toContain('index.html#!/statuses');
    });


    describe('View: Status List', function() {

        beforeEach(function() {
            browser.get('index.html#!/statuses');
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
                'Apache Server',
                'Tomcat Server'
            ]);

            nameOption.click();

            expect(getNames()).toEqual([
                'Apache Server',
                'Tomcat Server'
            ]);
        });

  });

    describe('View: Status detail', function() {

        beforeEach(function() {
            browser.get('index.html#!/statuses/2');
        });

        it('should display placeholder page with `phoneId`', function() {
            expect(element(by.binding('$ctrl.id')).getText()).toBe('2');
        });

    });

});