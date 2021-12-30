$(function () {
    $("#getAssignmentsBtn").click(function () {
        $.ajax({
            type:"GET",
            url: "/assignments/getAll",
            contentType: "application/json; charset=utf-8",
            data: null,
            success: function (response) {
                console.log(response);
                var trHTML = '';
                $("tr:has(td)").remove();
                $.each(response, function (i, item) {
                    trHTML += '<tr><td>' + item.assignmentID +
                        '</td><td>' + item.dateOfAssign +
                        '</td><td>' + item.listOfDocumentsConnectedToAssignment +
                        '</td><td>' + item.whoAssigned.name +
                        '</td><td>' + item.whoClosedAssignment +
                        '</td><td>' + item.whoWasAssignee.name +
                        +'</td></tr>';
                });
                $('#assignmentTable').append(trHTML);

            },
            error: function (d) {
                console.log(d);
            }
        });
    });

});