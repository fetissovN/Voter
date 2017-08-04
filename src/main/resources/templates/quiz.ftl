<html>
<head>
    <script type="text/javascript" charset="utf8" src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.8.2.min.js"></script>

    <link rel="stylesheet" type="text/css" href="/css/foundation.min.css">
    <link rel="stylesheet" type="text/css" href="/css/app.css">
    <script type="text/javascript" src="/js/foundation.min.js"></script>
    <script type="text/javascript" src="/js/app.js"></script>
</head>
<body>
<div class="row">
    <h1 align="center">Voter</h1>
    <div class="large-3 column">
        <button id="showAll" class="button">Show all</button><br>
        <#--<button id="makeQuiz" class="button">Make Quiz</button>-->
    </div>
    <div class="large-6 large-centered column">
        <article class="article-row">
            <div class="article-row-content">
                <p class="article-row-content-header">Id ${quiz.id}</p>
                <p class="article-row-content-description">${quiz.theme}</p>
                <#--<p class="article-row-content-description">${quiz.started}</p>-->
                <#--<p class="article-row-content-description">${quiz.closed}</p>-->
                <p id="voteTag" class="article-row-content-author">
                    Votes: ${quiz.votes}
                    <a id="vote" href="/post/like/">Click to vote!</a>
                </p>
            </div>
        </article>
        <#if quiz.started == 0>
            <button id="toStart" class="button">Start!</button>
        <#elseif quiz.closed == 0>
            <button id="toClose" class="button">Close!</button>
        </#if>
    </div>
    <div class="large-3 column"></div>
</div>
</body>
</html>
