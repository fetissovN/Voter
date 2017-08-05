$(document).ready(function () {
    $.ajax({
        type: 'GET',
        dataType: 'json',
        url: '/api/get/all',
        success: function (data) {
        }
    });
    $('#vote').click(function (e) {
        var started= $('#vote').attr('class').split('.')[1];
        var closed= $('#vote').attr('class').split('.')[2];
        var id= $('#vote').attr('class').split('.')[0];
        if (localStorage.getItem('voted') != id){
            if(closed == 0 && started == 1){
                $.ajax({
                    type: 'GET',
                    dataType: 'json',
                    url: '/api/quiz/assert/'+id,
                    success: function (data) {
                        localStorage.setItem('voted',id);
                        // alert(data.status);
                        location.reload();
                    }
                });
            }else {
                alert('is closed');
            }
        }
    });
    $('#toStart').click(function (e) {
        var id= $('#toStart').attr('name');
            $.getJSON('/api/start/'+id,function (data) {
                alert(data.status);
                location.reload();
            });
    });
    $('#toClose').click(function (e) {
        var id= $('#toClose').attr('name');
        $.getJSON('/api/close/'+id,function (data) {
            alert(data.status);
            location.reload();
        });
    });


});