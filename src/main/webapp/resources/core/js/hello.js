$("#teamSumbit").click(function(){
    loadTeamInfo(urlToTeamID($("#srch-term").val()));
    loadSquad();
});

function loadTeamInfo(id) {
    teamID = id;
    $('#teamID').text(id);
    $.get("playerinfo",
        {teamID : teamID},
        function(data){
            $("#srch-term").val("");
            writeTeamInfo(data);
        });
    $.get("pointsrank",
        {teamID : teamID},
        function(data){
            $("#srch-term").val("");
            writePointsAndRank(data);
        });
    getAchivs();
}

function urlToTeamID(teamURL) {
    return teamURL.substring(teamURL.lastIndexOf('/') + 1, teamURL.lastIndexOf('.'));
}

var teamID;

function writePointsAndRank(data) {
    $("#dailyRank").text(data.dailyRank);
    $("#weeklyRank").text(data.weeklyRank);
    $("#overalRank").text(data.overalRank);
    $("#dailyPoints").text(data.dailyPoints);
    $("#weeklyPoints").text(data.weeklyPoints);
    $("#overalPoints").text(data.points);
}

function writeTeamInfo(data) {
    $("#userName").text(data.name);
    teamID = data.teamID;
}


$(document).on('click', '#day-table tr, #week-table tr', function() {
    loadTeamInfo(this.id);
    loadSquad();
    loadHistory();
    drawChart();
});

//$(document).on('click', '#week-table tr', function() {
//    loadTeamInfo(this.id);
//    loadSquad();
//    loadHistory();
//    drawChart();
//});

