/**
 * Created by user on 19.10.2015.
 */
var weekTeamID;
var dayTeamID;

$(document).ready(function() {
    $("#dayHistButton").click(function() {
        if(dayTeamID !=  $("#teamID").text()) {
            loadHistory();
        }
    })
});

$(document).ready(function() {
    $("#weekHistButton").click(function() {
        if(weekTeamID !=  $("#teamID").text()) {
            loadWeekHistory();
        }
    })
});

function loadHistory() {
    dayTeamID = $("#teamID").text();
    $.get("hist",
        {teamID: dayTeamID, month: $("#hist select").val()},
        function(data) {
            drawHist(data, $('#histTable'));
        });
}

function loadWeekHistory() {
    weekTeamID = $("#teamID").text();
    $.get("weekhist",
        {teamID: weekTeamID},
        function(data) {
            drawWeeklyHist(data, $('#histTableWeek'));
        });
}

function drawWeeklyHist(data, table) {
    $('.weekHistTable').remove();
    for (var i = data.length - 1; i >= 0 ; i--) {
        drawWeekHistRow(data[i], table);
    }
}

function drawWeekHistRow(rowData, table) {
    //var row = $("<tr onClick = 'loadTeamInfo(this.id)'/>");
    var row = $("<tr class='weekHistTable'/>");
    table.append(row); //this will append tr element to table... keep its reference for a while since we will add cels into it
    row.append($("<td>" + rowData.dateCode + "</td>"));
    row.append($("<td>" + rowData.weeklyPoints + "</td>"));
    row.append($("<td>" + rowData.weeklyRank + "</td>"));
    row.append($("<td>" + rowData.overalRank + "</td>"));
}

function getWeekRange(dateCode)
{
    var curMonday = new Date(dateCode)
    var lastMonday = new Date(dateCode);
    lastMonday.setDate(lastMonday.getDate() - 6);
    return lastMonday.getMonth() + "." + lastMonday.getDate() + "-" + curMonday.getMonth() + "." + curMonday.getDate();
}

$(document).ready(function() {
    $("#monthSel").change(function () {
        loadHistory();
    })
})

function drawHist(data, table) {
    $('.histTable').remove();
    for (var i = data.length - 1; i >= 0 ; i--) {
        drawHistRow(data[i], table);
    }
}

function drawHistRow(rowData, table) {
    //var row = $("<tr onClick = 'loadTeamInfo(this.id)'/>");
    var row = $("<tr class='histTable'/>");
    table.append(row); //this will append tr element to table... keep its reference for a while since we will add cels into it
    row.append($("<td>" + transformDateCode(rowData.dateCode) + "</td>"));
    row.append($("<td>" + rowData.dailyPoints + "</td>"));
    row.append($("<td>" + rowData.dailyRank + "</td>"));
    row.append($("<td>" + rowData.overalRank + "</td>"));
}

$(document).ready(function() {
    var d = new Date();
    //$("#monthSel select").val(d.getMonth() + 1);
    $("#hist select").val("10");
});

function transformDateCode(dateCode) {
    var d = new Date(dateCode)
    return d.getDate();
}