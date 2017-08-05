$(document).ready(function () {
    var text = $('#field-function_purpose').text()
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

        if(closed == 0 && started == 1){
            $.ajax({
                type: 'GET',
                dataType: 'json',
                url: '/api/quiz/assert/'+id,
                success: function (data) {
                    alert(data);
                }
            });
        }else {
            alert('is closed');
        }


    });
    $('#toStart').click(function (e) {
        var id= $('#toStart').attr('name');
            $.getJSON('/api/start/'+id,function (data) {
                alert(data)
                alert(data["status"])
            });
            // $.ajax({
            //     type: 'GET',
            //     dataType: 'json',
            //     url: '/api/start/'+id,
            //     success: function (data) {
            //      alert(data.status);
            //     }
            // });

    });
    $('#toClose').click(function (e) {
        var id= $('#toClose').attr('name');
        $.ajax({
            type: 'GET',
            dataType: 'json',
            url: '/api/close/'+id,
            success: function (data) {
                alert(data)
                var obj = JSON.parse(data);
                alert( obj[0] );
                // $.each(data, function (index,obj) {
                //     alert(obj);
                // })
            }
        });

    })



});