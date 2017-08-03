<html>
<head>
    <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/2.0.3/jquery.min.js"></script>
    <link rel="stylesheet" type="text/css" href="/css/foundation.min.css">
    <link rel="stylesheet" type="text/css" href="/css/app.css">
    <link rel="stylesheet" type="text/css" href="/media/css/jquery.dataTables.css">
    <script type="text/javascript" src="/js/foundation.min.js"></script>
    <script type="text/javascript" src="/js/app.js"></script>
</head>
<body>
<div class="row">
    <h1 align="center">Voter</h1>
    <div class="large-3 column">
        <button id="showAll" class="button">Show all</button><br>
        <button id="makeQuiz" class="button">Make Quiz</button>
    </div>
    <div class="large-6 large-centered column">
        <div class="loadedQuizPlaceholder">
            <table id="empTable" class="display" width="100%" cellspacing="0">
                <thead>
                <tr>
                    <th>Id</th>
                    <th>Theme</th>
                    <th>Started</th>
                    <th>Closed</th>
                    <th>Votes</th>
                </tr>
                </thead>

                <tfoot>
                <tr>
                    <th>id</th>
                    <th>theme</th>
                    <th>started</th>
                    <th>closed</th>
                    <th>votes</th>
                </tr>
                </tfoot>
            </table>
        </div>

    </div>
    <div class="large-3 column"></div>
</div>
</body>
</html>
