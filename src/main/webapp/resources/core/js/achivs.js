///**
// * Created by user on 28.09.2015.
// */
//var overalAchivs;
//var weeklyAchivs;
//var dailyAchivs;
//
//$(document).ready(function() {
//    $("#achivSel").change(function () {
//        var val = $("#achivSel :selected").attr("val");
//        switch (val) {
//            case "1":
//                if(overalAchivs == null)
//                {
//                    $.get("seasonachivs",
//                        {period : "season"},
//                        function(data){
//                            writeAchivs(data);
//                            overalAchivs = data;
//                        });
//                } else {
//                    writeAchivs(overalAchivs);
//                }
//                break;
//            case "2":
//                if(weeklyAchivs == null)
//                {
//                    $.get("weekachivs",
//                        {period : "week"},
//                        function(data){
//                            writeAchivs(data);
//                            weeklyAchivs = data;
//                        });
//                } else {
//                    writeAchivs(weeklyAchivs);
//                }
//                break;
//            case "3":
//                if(weeklyAchivs == null)
//                {
//                    $.get("dayachivs",
//                        {teamID: $("#userID").text()},
//                        function(data){
//                            writeAchivs(data);
//                            dailyAchivs = data;
//                        });
//                } else {
//                    writeAchivs(dailyAchivs);
//                }
//                break;
//        }
//    });
//});
//
//function writeAchivs(achivs) {
//    var rows = $("#achivTable :first-child").children();
//    var row = $(rows[1]).children();
//    $(row[0]).text(achivs.first);
//    $(row[1]).text(achivs.second);
//    $(row[2]).text(achivs.third);
//    $(row[3]).text(achivs.fourth);
//}