/**
 * Created by user on 19.10.2015.
 */
var chartTeamID

$(document).ready(function () {
    //$.getJSON('http://www.highcharts.com/samples/data/jsonp.php?filename=aapl-c.json&callback=?', function (data) {
    $("#chartButton").click(function () {
        if(chartTeamID != $("#teamID").text()) {
            chartTeamID = $("#teamID").text();
            drawChart();
            //$.getJSON('chart',
            //    {teamID: chartTeamID},
            //    function (data) {
            //        // Create the chart
            //        $('#chart-container').highcharts('StockChart', {
            //
            //            rangeSelector: {
            //                selected: 1
            //            },
            //
            //            title: {
            //                text: 'Изменение позиции в общем зачете'
            //            },
            //
            //            series: [{
            //                name: 'ОЗ',
            //                data: data,
            //                tooltip: {
            //                    valueDecimals: 2
            //                }
            //            }]
            //        });
            //    });
            }
        });
});

function drawChart()
{
    $.getJSON('chart',
        {teamID: $("#teamID").text()},
        function (data) {
            // Create the chart
            $('#chart-container').highcharts('StockChart', {

                rangeSelector: {
                    selected: 1
                },

                title: {
                    text: 'Изменение позиции в общем зачете'
                },

                yAxis:{
                    reversed: true
                },

                tooltip: {
                    pointFormat: '{series.name}: <b>{point.y:,.0f}</b><br/>'
                },

                series: [{
                    name: 'ОЗ',
                    data: data,
                    tooltip: {
                        valueDecimals: 2
                    }
                }]
            });
        });
}
