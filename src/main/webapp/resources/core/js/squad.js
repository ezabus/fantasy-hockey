/**
 * Created by user on 18.10.2015.
 */
function loadSquad() {
    $.get("squadload",
        {teamID: $("#teamID").text()},
        function(data) {
            drawSquad(data);
        });
}

function drawSquad(data) {
    var players = data.players;
    $('.squadRow').remove();
    drawPlayersByAmplua(players, $("#forwardsTr"), "3");
    drawPlayersByAmplua(players, $("#deffsTr"), "2");
    drawPlayersByAmplua(players, $("#gksTr"), "1");
}

function drawPlayersByAmplua(players, startRow, amp) {
    for(i = 0; i < players.length; i++)
    {
        if(players[i].amplua == amp)
        {
            startRow = drawPlayer(players[i], startRow);

        }
    }
}

function drawPlayer(player, startRow) {
    var row = $("<tr class='squadRow'/>");
    $(startRow).after(row);
    row.append($("<td class='col-md-4'>" + player.name + "</td>"));
    row.append($("<td class='col-md-4'>" + player.club + "</td>"));
    row.append($("<td class='col-md-2'>" + player.delta + "</td>"));
    row.append($("<td class='col-md-2'>" + player.price + "</td>"));
    return row;
}

$(".spoiler-trigger").click(function() {
    $(this).parent().next().collapse('toggle');
});