let positionOfThisUser = null;
$(function () {
    $("#getAssignmentsBtn").click(function () {//все создданные мной
        $.ajax({
            type: "GET",
            url: "/assignments/getAss",
            contentType: "application/json; charset=utf-8",
            data: null,
            success: function (response) {
                console.log(response);
                var trHTML = '';
                $("tr:has(td)").remove();
                $.each(response, function (i, item) {
                    var aid = item.aid;
                    var position = item.whoCreated.position;
                    trHTML += '<tr><td id="' + aid + '">' + item.aid +
                        '</td><td>' + item.whoCreated.name + ' ' + item.whoCreated.surname +
                        '</td><td>' + item.whoAssignee.name + ' ' + item.whoAssignee.surname +
                        '</td><td>' + item.status +
                        '</td><td>' + item.delegated +
                        '</td><td>' + '<input type="button" onclick="deleteAssignment('+aid+')" value="Удалить" />\n' +
                        '<input type="button" onclick="cancelAssignment('+aid+')" value="Отменить" />\n' +
                        '<input type="button" onclick="sign('+aid+')" value="Подписать как '+position+'" />\n';
                    if (position === positionOfThisUser){
                        trHTML+= '<input type="button" onclick="improve('+aid+')" value="На доработку" />\n';
                    }
                        trHTML+='</td><td>' + '<input type="button" onclick="location.href=\'/assignments/del/' + aid + '\';" value="Скачать документ" />\n'
                        + '</td></tr>';
                });
                $('#assignmentTable').append(trHTML);
                if (response.length === 0) {
                    alert("Нет отданных Вами поручений")
                }

            },
            error: function (d) {
                console.log(d);
            }
        });
    });
    $("#getDelegatedAssignmentsBtn").click(function () {//делегированные мне
        $.ajax({
            type: "GET",
            url: "/assignments/delegatedToMe",
            contentType: "application/json; charset=utf-8",
            data: null,
            success: function (response) {
                console.log(response);
                var trHTML = '';
                $("tr:has(td)").remove();
                $.each(response, function (i, item) {
                    var delegatedID = item.id;
                    trHTML += '<tr><td>' + item.assignment.aid +
                        '</td><td>' + item.assignment.whoCreated.name + ' ' + item.assignment.whoCreated.surname +
                        '</td><td>' + item.assignment.whoAssignee.name + ' ' + item.assignment.whoAssignee.surname +
                        '</td><td>' + item.assignment.status +
                        '</td><td>' + item.assignment.delegated + '<input type="button" onclick="deleteDelegation(' + delegatedID + ')" value="Отказаться" />\n' +
                        '</td><td>' + item.newAssignee.name + ' ' + item.newAssignee.surname
                        + '</td></tr>';
                });
                $('#delegatedAssignmentsToMe').append(trHTML);
                if (response.length === 0) {
                    alert("Нет делегированных Вам поручений")
                }

            },
            error: function (d) {
                console.log(d);
            }
        });
    });
    $("#getGivenAssignmentsBtn").click(function () {//назначенные мне
        $.ajax({
            type: "GET",
            url: "/assignments/getGivenToMe ",
            contentType: "application/json; charset=utf-8",
            data: null,
            success: function (response) {
                console.log(response);
                var trHTML = '';
                $("tr:has(td)").remove();
                $.each(response, function (i, item) {
                    trHTML += '<tr><td>' + item.aid +
                        '</td><td>' + item.whoCreated.name + ' ' + item.whoCreated.surname +
                        '</td><td>' + item.whoAssignee.name + ' ' + item.whoAssignee.surname +
                        '</td><td>' + item.status +
                        '</td><td>' + item.delegated +
                        '</td><td>' +
                        '</td></tr>';
                });
                $('#givenAssignments').append(trHTML);
                if (response.length === 0) {
                    alert("Нет назначенных Вам поручений")
                }

            },
            error: function (d) {
                console.log(d);
            }
        });
    });
    $(function () {
        $.ajax({
            type: "GET",
            url: "/getMyName",
            contentType: "application/json",
            success: function (resp) {
                console.log(resp);
                $('.username').html("Здравстуйте, " + resp.name + ' ' + resp.surname);
                positionOfThisUser = resp.position;
                if (resp.position === "DepartmentWorker") {
                    $('#emailAssignee').remove();
                    $('#file').remove();
                    $('#sendAssignment').remove();
                    $('#assignmentTable').remove();
                }

            }
        })
    });
});

function deleteDelegation(dID) {
    $.ajax({
        type: "POST",
        url: "/assignments/delegate/delete",
        data: {id: dID},
        success: function (resp) {
            console.log(resp);
            alert("Удалено");
        }
    });
}

function setInWork(dID) {
    $.ajax({
        type: "POST",
        url: "/assignments/delete",
        data: {id: dID},
        success: function (resp) {
            console.log(resp);
            alert("Удалено");
        }
    });
}
function sign(assId){
    var signs = null;
    $.ajax({
        type:"GET",
        url:""
    })
}
function deleteAssignment(id){
    console.log(id)
    $.ajax({
        type: "POST",
        url: "/assignments/delete",
        data: {id:id},
        success: function (response) {
            alert("Удалено")
        },
        error: function (d) {
            console.log(d);
        }
    });
}
function cancelAssignment(id){
    console.log(id)
    $.ajax({
        type: "POST",
        url: "/assignments/cancel",
        data: {id:id},
        success: function (response) {
            alert("Отменено")
        },
        error: function (d) {
            console.log(d);
        }
    });
}
function improve(aid){
    console.log(aid);
}
