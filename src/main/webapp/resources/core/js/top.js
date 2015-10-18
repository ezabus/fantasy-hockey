/**
 * Created by user on 18.10.2015.
 */

$(document).ready(function(){
    $.get("dtop",
        function(data){
            drawTable(data, $("#day-table"));
        });

    $.get("wtop",
        function(data){
            drawTable(data, $("#week-table"));
        });
});

function drawTable(data, table) {
    for (var i = 0; i < data.length; i++) {
        drawRow(data[i], i + 1, table);
    }
}

function drawRow(rowData, number, table) {
    //var row = $("<tr onClick = 'loadTeamInfo(this.id)'/>");
    var row = $("<tr class='rateTable'/>");
    row.attr("id",rowData.teamID);
    table.append(row); //this will append tr element to table... keep its reference for a while since we will add cels into it
    row.append($("<td>" + number + "</td>"));
    row.append($("<td>" + rowData.name + "</td>"));
    row.append($("<td>" + rowData.dailyPoints + "</td>"));
    row.append($("<td>" + rowData.pos + "</td>"));
}