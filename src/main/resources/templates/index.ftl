<html>
<head>
    <!-- DataTables CSS -->
    <link rel="stylesheet" type="text/css" href="http://ajax.aspnetcdn.com/ajax/jquery.dataTables/1.9.4/css/jquery.dataTables.css">

    <!-- jQuery -->
    <script type="text/javascript" charset="utf8" src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.8.2.min.js"></script>

    <!-- DataTables -->
    <script type="text/javascript" charset="utf8" src="http://ajax.aspnetcdn.com/ajax/jquery.dataTables/1.9.4/jquery.dataTables.min.js"></script>
    <#--<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/2.0.3/jquery.min.js"></script>-->
    <link rel="stylesheet" type="text/css" href="/css/foundation.min.css">
    <link rel="stylesheet" type="text/css" href="/css/app.css">
    <#--<link rel="stylesheet" type="text/css" href="/media/css/jquery.dataTables.css">-->
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
        <div id="loadedQuizPlaceholder">

        </div>
        <div id="makeQuizPlaceholder" style="display: none">
            <textarea id="theme"></textarea>
            <span id="err" style="color: red"></span><br>
            <button id="saveQuiz" class="button">Save</button>
        </div>

    </div>
    <div class="large-3 column"></div>
</div>
</body>
</html>
