$(function () {
    $("#getAssignmentsBtn").click(function () {
        $.ajax({
            url: "/assignments/getAll",
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            data: null,
            success: function (data) {
                console.log(data);
                var $response = $("#response");
                $response.empty().text(data);
            },
            error: function (d) {
                console.log(d);
            }
        });
    });

});