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
        $('#makeQuizPlaceholder').hide();
        $('#loadedQuizPlaceholder').show();
        $('#loadedQuizPlaceholder').empty();
        $.ajax({
            type: 'GET',
            dataType: 'json',
            url: '/api/get/all',
            success: function (data) {
                $.each(data, function (index,article) {
                    var $quizTable=$('<table class="table" align="center"></table>');
                    var $container=$('<tr></tr>');
                    $.each(article,function (key,val) {
                        if (key == 'id'){
                            var $quizId=$('<tr><td id="key">' + key + ' ' + val + '<a href="/quiz/'+val+'"> link</a></td></tr>');
                            $quizTable.append($quizId)
                        }else if (key == 'theme') {
                            var $quizAttrTr = $('<tr><td colspan="2"><p>' + val + '<p></td></tr>');
                            $quizTable.append($quizAttrTr);
                        }else if (key == 'votes') {
                            var $quizVotes= $('<tr><td>Votes: ' + val + '</td></tr>');
                            $quizTable.append($quizVotes);
                        }else {
                            if (key == 'started' && val == '1'){
                                var $quizStarted=$('<td>Was started</td>');
                                $container.append($quizStarted)
                            }
                            if (key == 'started' && val == '0'){
                                var $quizStarted=$('<td>Was not started</td>');
                                $container.append($quizStarted)
                            }
                            if (key == 'closed' && val == '1'){
                                var $quizStarted=$('<td>Is closed</td>');
                                $container.append($quizStarted)
                            }
                            if (key == 'closed' && val == '0'){
                                var $quizStarted=$('<td>Is not Closed</td>');
                                $container.append($quizStarted)
                            }
                        }
                    });
                    $quizTable.append($container);
                    $('#loadedQuizPlaceholder').append($quizTable);
                });
            }
        });
    });

    $('#makeQuiz').click(function (e) {
        $('#loadedQuizPlaceholder').hide();
        $('#makeQuizPlaceholder').show();
    });
    $('#saveQuiz').click(function (e) {
        alert('asda');
        var theme = $('#theme').val();
        var json = '{"theme","' + theme + '"}';
        alert(json);
        if (theme.length < 20){
            $('#err').text('Too short theme!')
        }else {
            $.ajax({
                type: 'POST',
                dataType: 'json',
                data: theme,
                url: '/api/makeQuiz/',
                success: function (data) {
                    alert(data);
                }
            });
        }

    });



});