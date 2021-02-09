describe('statusList', function() {

  // Load the module that contains the `statusList` component before each test
  beforeEach(module('statusList'));

  // Test the controller
  describe('StatusListController', function() {
    var $httpBackend, ctrl;

    beforeEach(inject(function($componentController, _$httpBackend_) {
        $httpBackend = _$httpBackend_;
        $httpBackend.expectGET('status-list/status-list.json')
            .respond([{name: 'Tomcat Server'}, {name: 'Apache Server'}]);

        ctrl = $componentController('statusList');
    }));



    it('should create a `statuses` property with 2 phones fetched with `$http`', function() {
        expect(ctrl.statuses).toBeUndefined();
        $httpBackend.flush();
        expect(ctrl.statuses).toEqual([{name: 'Tomcat Server'}, {name: 'Apache Server'}]);
    });

    it('should set a default value for the `orderProp` property', function() {
        expect(ctrl.orderProp).toBe('name');
    });

  });

});