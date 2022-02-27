$(function () {

});

let dash = $("#dash");
console.log(dash.text());

let session = sessionStorage.getItem("JSESSIONID");
console.log(session);

function checkMySession() {
    console.log(dash.text());
    dash.text('Bootstrap Project');
}
checkMySession();