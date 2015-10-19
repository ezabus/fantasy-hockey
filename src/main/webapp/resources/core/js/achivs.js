$(document).ready(function(){
    $("#achivSel").change(function() {
        var firstRow = $("#achivTable :first-child :first-child").children()
        //alert($("#achivSel :selected").attr("val"))
        var selectedItemIndex = $("#achivSel :selected").attr("val");
        if(selectedItemIndex == 1) {
            $(firstRow[0]).text("�����")
            $(firstRow[1]).text("��� 10")
            $(firstRow[2]).text("��� 100")
            $(firstRow[3]).text("��� 500")
        } else if(selectedItemIndex == 2) {
            $(firstRow[0]).text("�������")
            $(firstRow[1]).text("�����")
            $(firstRow[2]).text("��� 10")
            $(firstRow[3]).text("��� 100")
        } else if (selectedItemIndex == 3) {
            $(firstRow[0]).text("�������")
            $(firstRow[1]).text("�����")
            $(firstRow[2]).text("��� 10")
            $(firstRow[3]).text("��� 100")
        }
    });
});

var achivs;

$(document).ready(function() {
    $("#achivSel").change(function () {
        var val = $("#achivSel :selected").attr("val");
        switch (val) {
            case "1": writeAchivs(achivs.season); break;
            case "2": writeAchivs(achivs.weekly); break;
            case "3": writeAchivs(achivs.daily); break;
        }
    });
});

function getAchivs() {
    achivs = new Object();
    teamID = $("#teamID").text();
    alert($("#teamID").text());
    $.get("dayachivs",
        {teamID: teamID},
        function(data){
            achivs.daily = data;
            writeAchivs(data);
        });
    $.get("weekachivs",
        {teamID: teamID},
        function(data){
            achivs.weekly = data;
            writeAchivs(data);
        });
    $.get("seasonachivs",
        {teamID: teamID},
        function(data){
            achivs.season = data;
            writeAchivs(data);
        });
}


function writeAchivs(achivs) {
    var rows = $("#achivTable :first-child").children();
    var row = $(rows[1]).children();
    $(row[0]).text(achivs[0]);
    $(row[1]).text(achivs[1]);
    $(row[2]).text(achivs[2]);
    $(row[3]).text(achivs[3]);
}