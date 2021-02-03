describe('StatusesController', function() {
  beforeEach(module('statusReaderView'));

  it('should create a `statuses` model with 3 statuses', inject(function($controller) {
    var scope = {};
    var ctrl = $controller('StatusesController', {$scope: scope});
    expect(scope.statuses.length).toBe(3);
  }));

});