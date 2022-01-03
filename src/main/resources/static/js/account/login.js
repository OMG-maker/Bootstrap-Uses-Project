$(function () {

    
});

let email = $("#exampleInputEmail");
let password = $("#exampleInputPassword");

function fLogin() {
    if (validate()) {
        $.ajax({
            url: "/account/login",
            data: {
                userEmail: email.val(),
                userPassword : password.val()
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
}