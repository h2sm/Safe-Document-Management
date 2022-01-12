$(function () {
    $("#delegateTask").click(function () {
        var id = $("#idAssignment").val();
        var newAssigneeEmail = $("#emailNewAssignee").val();
        $.ajax({
            type: "POST",
            url: "/assignments/delegate",
            contentType: "application/json; charset=utf-8",
            data: {email:newAssigneeEmail, assignmentId:id},
            success: function (response) {
                alert("Поручение передано")
            },
            error: function (d) {
                console.log(d);
            }
        });
    });
});