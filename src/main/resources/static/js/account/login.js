$(function () {


});

// let email = $("#exampleInputEmail");
let name = $("#exampleInputEmail");
let password = $("#exampleInputPassword");

function fLogin() {
    $.ajax({
        // url: "/account/login",
        url: "/loginProc",
        data: {
            // userEmail: email.val(),
            username: name.val(),
            // userPassword: password.val()
            password: password.val()
        },
        success: function (result) {
            if (result.data == null) {
                alert('계정정보가 일치하지 않습니다.');
                return;
            } else {
                // alert('성공');
                location.href = "/index";
            }
        }
    });

}