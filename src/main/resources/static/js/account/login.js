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
                    alert('사용할 수 없는 회사명입니다.');
                    return;
                } else {
                    // alert('성공');
                    location.href = "/index";
                }
            }
        });
    }
}
function fRegister() {

    if (validate()) {
        $.ajax({
            url: "/account/register",
            data: {
                userEmail: email.val(),
                userPassword: password.val(),
                firstName: fistName.val(),
                lastName: lastName.val()
            },
            success: function (result) {
                if (result.data == null) {
                    alert('등록 중 에러가 발생하였습니다.');
                    return;
                } else {
                    if (result.data == "d") {
                        alert('이미 등록되어 있는 회사명입니다.');
                        return;
                    } else if (result.data == "e") {
                        alert('등록 중 에러가 발생하였습니다.');
                        return;
                    } else if (result.data == "s") {
                        alert('서비스 이용 신청이 완료되었습니다.');
                        location.href = "/login";
                    }
                }
            }
        });
    }
    return false;
}