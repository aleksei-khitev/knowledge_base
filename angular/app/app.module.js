'use strict';

// Define the `statusReaderView` module
var statusReaderView = angular.module('statusReaderView',
    [
        // ...which depends on the `statusList` module
        'statusList'
    ]
);