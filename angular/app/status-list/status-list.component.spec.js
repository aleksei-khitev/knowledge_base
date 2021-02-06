describe('statusList', function() {

  // Load the module that contains the `statusList` component before each test
  beforeEach(module('statusList'));

  // Test the controller
  describe('StatusListController', function() {

    it('should create a `phones` model with 3 phones', inject(function($componentController) {
      var ctrl = $componentController('statusList');

      expect(ctrl.statuses.length).toBe(3);
    }));

  });

});