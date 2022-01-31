$(function () {

});

let dash = $("#dash");
console.log(dash.text());

let session = sessionStorage.getItem("JSESSIONID");
console.log(session);

function checkMySession() {
    console.log(dash.text());
    dash.text('백신 접종 후 건강상태 현황');
}
checkMySession();