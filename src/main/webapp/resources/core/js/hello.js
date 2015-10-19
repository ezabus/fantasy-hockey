//$(document).ready(function(){
//    $("#achivSel").change(function() {
//        var firstRow = $("#achivTable :first-child :first-child").children()
//        //alert($("#achivSel :selected").attr("val"))
//        var selectedItemIndex = $("#achivSel :selected").attr("val");
//        if(selectedItemIndex == 1) {
//            $(firstRow[0]).text("Лидер")
//            $(firstRow[1]).text("Топ 10")
//            $(firstRow[2]).text("Топ 100")
//            $(firstRow[3]).text("Топ 500")
//        } else if(selectedItemIndex == 2) {
//            $(firstRow[0]).text("Чемпион")
//            $(firstRow[1]).text("Призёр")
//            $(firstRow[2]).text("Топ 10")
//            $(firstRow[3]).text("Топ 100")
//        } else if (selectedItemIndex == 3) {
//            $(firstRow[0]).text("Чемпион")
//            $(firstRow[1]).text("Призёр")
//            $(firstRow[2]).text("Топ 10")
//            $(firstRow[3]).text("Топ 100")
//        }
//    });
//});

//$(document).ready(function(){
//    $.get("dtop",
//        //{id : $("#searchBox").val()},
//        function(data){
//            drawTable(data, $("#day-table"));
//        });
//
//    $.get("wtop",
//        //{id : $("#searchBox").val()},
//        function(data){
//            drawTable(data, $("#week-table"));
//        });
//});
//
//function drawTable(data, table) {
//    for (var i = 0; i < data.length; i++) {
//        drawRow(data[i], i + 1, table);
//    }
//}
//
//function drawRow(rowData, number, table) {
//    //var row = $("<tr onClick = 'loadTeamInfo(this.id)'/>");
//    var row = $("<tr class='rateTable'/>");
//    row.attr("id",rowData.teamID);
//    table.append(row); //this will append tr element to table... keep its reference for a while since we will add cels into it
//    row.append($("<td>" + number + "</td>"));
//    row.append($("<td>" + rowData.name + "</td>"));
//    row.append($("<td>" + rowData.dailyPoints + "</td>"));
//    row.append($("<td>" + rowData.pos + "</td>"));
//}

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

//$(document).ready(function() {
//    $("#achivSel").change(function () {
//        var val = $("#achivSel :selected").attr("val");
//        switch (val) {
//            case "1": writeAchivs(achivs.season); break;
//            case "2": writeAchivs(achivs.weekly); break;
//            case "3": writeAchivs(achivs.daily); break;
//        }
//    });
//});
//
//var achivs;
//
//function getAchivs() {
//    achivs = new Object();
//    $.get("dayachivs",
//        {teamID: teamID},
//        function(data){
//            achivs.daily = data;
//            writeAchivs(data);
//        });
//    $.get("weekachivs",
//        {teamID: teamID},
//        function(data){
//            achivs.weekly = data;
//            writeAchivs(data);
//        });
//    $.get("seasonachivs",
//        {teamID: teamID},
//        function(data){
//            achivs.season = data;
//            writeAchivs(data);
//        });
//}
//
//
//function writeAchivs(achivs) {
//    var rows = $("#achivTable :first-child").children();
//    var row = $(rows[1]).children();
//    $(row[0]).text(achivs[0]);
//    $(row[1]).text(achivs[1]);
//    $(row[2]).text(achivs[2]);
//    $(row[3]).text(achivs[3]);
//}

$(document).on('click', '#day-table tr', function() {
    loadTeamInfo(this.id);
    loadSquad();
    loadHistory();
});

$(document).on('click', '#week-table tr', function() {
    loadTeamInfo(this.id);
    loadSquad();
    loadHistory();
});

//function loadSquad() {
//    $.get("squadload",
//        {teamID: teamID},
//        function(data) {
//            drawSquad(data);
//        });
//}

//function drawSquad(data) {
//    var players = data.players;
//    $('.squadRow').remove();
//    drawPlayersByAmplua(players, $("#forwards-table"), "3");
//    drawPlayersByAmplua(players, $("#deffs-table"), "2");
//    drawPlayersByAmplua(players, $("#goalkeepers-table"), "1");
//}
//
//function drawPlayersByAmplua(players, table, amp) {
//    for(i = 0; i < players.length; i++)
//    {
//        if(players[i].amplua == amp)
//        {
//            drawPlayer(players[i], table);
//        }
//    }
//}
//
//function drawPlayer(player, table) {
//    var row = $("<tr class='squadRow'/>");
//    table.append(row);
//    row.append($("<td class='col-md-4'>" + player.name + "</td>"));
//    row.append($("<td class='col-md-4'>" + player.club + "</td>"));
//    row.append($("<td class='col-md-2'>" + player.delta + "</td>"));
//    row.append($("<td class='col-md-2'>" + player.price + "</td>"));
//}

//function drawSquad(data) {
//    var players = data.players;
//    $('.squadRow').remove();
//    drawPlayersByAmplua(players, $("#forwardsTr"), "3");
//    drawPlayersByAmplua(players, $("#deffsTr"), "2");
//    drawPlayersByAmplua(players, $("#gksTr"), "1");
//}
//
//function drawPlayersByAmplua(players, startRow, amp) {
//    for(i = 0; i < players.length; i++)
//    {
//        if(players[i].amplua == amp)
//        {
//            startRow = drawPlayer(players[i], startRow);
//
//        }
//    }
//}
//
//function drawPlayer(player, startRow) {
//    var row = $("<tr class='squadRow'/>");
//    $(startRow).after(row);
//    row.append($("<td class='col-md-4'>" + player.name + "</td>"));
//    row.append($("<td class='col-md-4'>" + player.club + "</td>"));
//    row.append($("<td class='col-md-2'>" + player.delta + "</td>"));
//    row.append($("<td class='col-md-2'>" + player.price + "</td>"));
//    return row;
//}

$(document).ready(function() {
    $('#datetimepicker').datetimepicker(
        {
            lang: 'ru',
            dayOfWeekStart: 1,
            datepicker: true,
            timepicker: false,
            format: 'Y.m.d',
            value: new Date(),
            mask: true,
            onSelectDate: function(ct,$i) {
                loadTopByDate(ct.dateFormat('Y/m/d'))
            }
        });
})

function loadTopByDate(dateCode){
    $('.rateTable').remove();
    $.get("dtop",
        {dateCode : dateCode},
        function(data){
            drawTable(data, $("#day-table"));
        });

    $.get("wtop",
        {dateCode : dateCode},
        function(data){
            drawTable(data, $("#week-table"));
        });
}

$('.glyphicon-calendar').on('click', function () {
    $('#datetimepicker').focus()
});

$(".spoiler-trigger").click(function() {
    $(this).parent().next().collapse('toggle');
});


//$(document).on('click', "li a[href='#hist']", function() {
//    $.get("hist",
//        {teamID: teamID},
//        function(data) {
//            drawHist(data, $('#histTable'));
//        });
//});

//function loadHistory() {
//    $.get("hist",
//        {teamID: teamID, month: $("#hist select").val()},
//        function(data) {
//            drawHist(data, $('#histTable'));
//        });
//}
//
//$(document).ready(function() {
//    $("#monthSel").change(function () {
//        loadHistory();
//    })
//})
//
//function drawHist(data, table) {
//    $('.histTable').remove();
//    for (var i = data.length - 1; i >= 0 ; i--) {
//        drawHistRow(data[i], table);
//    }
//}
//
//function drawHistRow(rowData, table) {
//    //var row = $("<tr onClick = 'loadTeamInfo(this.id)'/>");
//    var row = $("<tr class='histTable'/>");
//    table.append(row); //this will append tr element to table... keep its reference for a while since we will add cels into it
//    row.append($("<td>" + rowData.dateCode + "</td>"));
//    row.append($("<td>" + rowData.dailyPoints + "</td>"));
//    row.append($("<td>" + rowData.dailyRank + "</td>"));
//    row.append($("<td>" + rowData.overalRank + "</td>"));
//}
//
//$(document).ready(function() {
//    var d = new Date();
//    //$("#monthSel select").val(d.getMonth() + 1);
//    $("#hist select").val("10");
//});
//
//$(document).ready(function() {
//    $("[name='dayWeekSwitch']").bootstrapSwitch();
//});
//
//$(document).ready(function() {
//    $("a [href='#hist']").bootstrapSwitch();
//    $("[name='dayWeekSwitch']").css("visibility: hidden");
//});
