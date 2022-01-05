$(function () {

});

let dash = $("#dash");
console.log(dash.text());

let session = sessionStorage.getItem("sessionId");
console.log(session);

function checkMySession() {
    console.log(dash.text());
    dash.text('ㅁㄴㅇ');
}
checkMySession();