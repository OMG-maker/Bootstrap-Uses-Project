$(function () {


});

// let email = $("#exampleInputEmail");
let name = $("#exampleInputEmail");
let password = $("#exampleInputPassword");

function fLogin() {
    $.ajax({
        // url: "/account/login",
        url: "/loginProc",
        type: "POST",
        data: {
            // userEmail: email.val(),
            username: name.val(),
            // userPassword: password.val()
            password: password.val()
        },
        success: function (result) {
            location.href = "/index";
        }
    });
}

function submit() {
    document.getElementById('userform').submit();
    return false;
}