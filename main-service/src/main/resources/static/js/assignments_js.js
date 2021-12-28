$(function () {
    $("#getAssignmentsBtn").click(function () {
        $.ajax({
            type:"GET",
            url: "/assignments/getAll",
            contentType: "application/json; charset=utf-8",
            data: null,
            success: function (data) {
                console.log(data);
                var $response = $("#response");
                data.forEach(a => {
                    $response.html(data);
                })
                //$response.empty().text(data);
            },
            error: function (d) {
                console.log(d);
            }
        });
    });

});