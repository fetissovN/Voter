$(document).ready(function () {
    var text = $('#field-function_purpose').text()
    $.ajax({
        type: 'GET',
        dataType: 'json',
        url: '/api/get/all',
        success: function (data) {
        }
    });

});