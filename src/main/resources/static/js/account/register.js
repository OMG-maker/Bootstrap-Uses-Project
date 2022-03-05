$(function () {

});

let email = $("#exampleInputEmail");
let password = $("#exampleInputPassword");
let passwordCheck = $("#exampleRepeatPassword");
let fistName = $("#exampleFirstName");
let lastName = $("#exampleLastName");

function fRegister() {
    if (validate()) {
        $.ajax({
            url: "/joinProc",
            type: "POST",
            data: {
                email: email.val(),
                password: password.val(),
                userFirstName: fistName.val(),
                userSecondName: lastName.val()
            },
            success: function (result) {
                //alert('회원가입이 완료되었습니다.');
                location.href = "/login";
            }
            // ,
            // success: function (result) {
            //     if (result.data == null) {
            //         alert('등록 중 에러가 발생하였습니다.');
            //         return;
            //     } else {
            //         if (result.data == "d") {
            //             alert('이미 등록되어 있는 이메일입니다.');
            //             return;
            //         } else if (result.data == "e") {
            //             alert('등록 중 에러가 발생하였습니다.');
            //             return;
            //         } else if (result.data == "s") {
            //             alert('회원가입이 완료되었습니다.');
            //             location.href = "/login";
            //         }
            //     }
            // }
        });
    }
}
// let email = $("#exampleInputEmail");
// let password = $("#exampleInputPassword");
// let passwordCheck = $("#exampleRepeatPassword");
// let fistName = $("#exampleFirstName");
// let lastName = $("#exampleLastName");
//
// function fRegister() {
//     if (validate()) {
//         $.ajax({
//             url: "/account/register",
//             data: {
//                 userEmail: email.val(),
//                 userPassword: password.val(),
//                 firstName: fistName.val(),
//                 lastName: lastName.val()
//             },
//             success: function (result) {
//                 if (result.data == null) {
//                     alert('등록 중 에러가 발생하였습니다.');
//                     return;
//                 } else {
//                     if (result.data == "d") {
//                         alert('이미 등록되어 있는 이메일입니다.');
//                         return;
//                     } else if (result.data == "e") {
//                         alert('등록 중 에러가 발생하였습니다.');
//                         return;
//                     } else if (result.data == "s") {
//                         alert('회원가입이 완료되었습니다.');
//                         location.href = "/login";
//                     }
//                 }
//             }
//         });
//     }
//     return false;
// }
//

function validate() {
    var pwdCheck = /^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{8,25}$/;
    // var re2 = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
    var re2 = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/;
    // 이메일이 적합한지 검사할 정규식

    if (!pwdCheck.test(password.val())) {
        console.log(password.val());
        alert("비밀번호는 영문자+숫자+특수문자 조합으로 8~25자리 사용해야 합니다.");
        password.focus();
        return false;
    }
    ;

    if (password.val() != passwordCheck.val()) {
        alert("비밀번호가 다릅니다. 다시 확인해 주세요.");
        passwordCheck.focus();
        return false;
    }

    if (email.val() == "") {
        alert("이메일을 입력해 주세요");
        email.focus();
        return false;
    }

    if (!re2.test(email.val())) {
        alert("적합하지 않은 이메일 형식입니다.");
        email.focus();
        return false;
    }

    return true;
}

function check(re, what, message) {
    if (re.test(what)) {
        return true;
    } else {
        alert(message);
        what = "";
        what.focus();
    }
}

