/**
 * Created by user on 19.10.2015.
 */
function loadHistory() {
    $.get("hist",
        {teamID: teamID, month: $("#hist select").val()},
        function(data) {
            drawHist(data, $('#histTable'));
        });
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
    row.append($("<td>" + rowData.dateCode + "</td>"));
    row.append($("<td>" + rowData.dailyPoints + "</td>"));
    row.append($("<td>" + rowData.dailyRank + "</td>"));
    row.append($("<td>" + rowData.overalRank + "</td>"));
}

$(document).ready(function() {
    var d = new Date();
    //$("#monthSel select").val(d.getMonth() + 1);
    $("#hist select").val("10");
});

$(document).ready(function() {
    $("[name='dayWeekSwitch']").bootstrapSwitch();
});

$(document).ready(function() {
    $("a [href='#hist']").bootstrapSwitch();
    $("[name='dayWeekSwitch']").css("visibility: hidden");
});