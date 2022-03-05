$(function () {


});

let name = $("#exampleInputEmail");
let password = $("#exampleInputPassword");

function fLogin() {
    $.ajax({
        // url: "/account/login",
        url: "/loginProc",
        type: "POST",
        data: {
            // username: name.val(),
            userEmail: name.val(),
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
//
// function goToLoginPage(){
//     location.href="/login"
// }