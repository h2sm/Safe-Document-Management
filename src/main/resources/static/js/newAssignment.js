$(function () {
    $("#sendAssignment").click(function () {
        var assigneeEmail = $(".emailAssignee").val();
        console.log(assigneeEmail)
        let doc = document.getElementById("file").files[0];
        $.ajax({
            type: "POST",
            url: "/assignments/new",
            contentType: "application/text; charset=utf-8",
            data: assigneeEmail,
            success: function (response) {
                alert("Поручение отпралено")
            },
            error: function (d) {
                console.log(d);
            }
        });
    });
});