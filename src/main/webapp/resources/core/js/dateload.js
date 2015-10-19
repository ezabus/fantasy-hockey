/**
 * Created by user on 19.10.2015.
 */

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
