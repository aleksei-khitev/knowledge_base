describe('statusesList', function() {

  // Load the module that contains the `phoneList` component before each test
  beforeEach(module('statusReaderView'));

  // Test the controller
  describe('StatusesController', function() {

    it('should create a `phones` model with 3 phones', inject(function($componentController) {
      var ctrl = $componentController('statusesList');

      expect(ctrl.statuses.length).toBe(3);
    }));

  });

});