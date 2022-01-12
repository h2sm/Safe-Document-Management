$(function () {
    $("#getAssignmentsBtn").click(function () {
        $.ajax({
            type:"GET",
            url: "/assignments/getAss",
            contentType: "application/json; charset=utf-8",
            data: null,
            success: function (response) {
                console.log(response);
                var trHTML = '';
                $("tr:has(td)").remove();
                $.each(response, function (i, item) {
                    trHTML += '<tr><td>' + item.aid +
                        '</td><td>' + item.whoCreated.name + ' ' + item.whoCreated.surname +
                        '</td><td>' + item.whoAssignee.name +
                        '</td><td>' + item.status +
                        '</td><td>' + item.delegated +
                        +'</td></tr>';
                });
                $('#assignmentTable').append(trHTML);
                if (response.length ===0){
                    alert("Нет отданных Вами поручений")
                }

            },
            error: function (d) {
                console.log(d);
            }
        });
    });
    $("#getDelegatedAssignmentsBtn").click(function () {
        $.ajax({
            type:"GET",
            url: "/assignments/delegatedToMe",
            contentType: "application/json; charset=utf-8",
            data: null,
            success: function (response) {
                console.log(response);
                var trHTML = '';
                $("tr:has(td)").remove();
                $.each(response, function (i, item) {
                    trHTML += '<tr><td>' + item.id +
                        '</td><td>' + item.assignmentid.whoCreated + ' ' + item.whoCreated.surname +
                        '</td><td>' + item.whoAssignee.name +
                        '</td><td>' + item.status +
                        '</td><td>' + item.delegated +
                        +'</td></tr>';
                });
                $('#assignmentTable').append(trHTML);
                if (response.length ===0){
                    alert("Нет делегированных Вам поручений")
                }

            },
            error: function (d) {
                console.log(d);
            }
        });
    });
    $(function() {
        $.ajax({
            type: "GET",
            url: "/getMyName",
            contentType: "application/json",
            success: function (resp){
                console.log(resp);
                $('.username').html("Ваш логин: " + resp);
            }
        })
    });
});