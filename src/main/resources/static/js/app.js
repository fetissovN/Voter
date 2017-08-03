// $('body').on('click', '#showAll', function(){
//     $.ajax({
//         type: 'GET',
//         url: '/get/all',
//         success: function(data){
//             alert("success")
//             alert(data);
//             // $('.loadedPostsPlaceholder'+page).append(data);
//         }
//     });
//
// });
$(document).ready(function () {
    $('#showAll').click(function (e) {

        // $.getJSON('/api/get/all', {}, function(json_data){
        //     alert(json_data);
        //     var table_obj = $('table');
        //     $.each(json_data, function(index, item){
        //         var table_row = $('<tr>', {id: item.id});
        //         var table_cell = $('<td>', {html: item.theme});
        //         table_row.append(table_cell);
        //         table_obj.append(table_row);
        //     })
        //
        // })
        $.ajax({
            type: 'GET',
            url: '/api/get/all',
            success: function (data) {
                $('#empTable').dataTable({
                    "ajax": data,
                    "columns": [
                        {"data": "Id"},
                        {"data": "Theme"},
                        {"data": "Started"},
                        {"data": "Closed"},
                        {"data": "Votes"}
                    ]
                });
            }
        });
    })

});