$(document).ready(function(){
    $("#get").click(function(){
        var host = window.origin;
        var urlFizzBuzz = host.concat('/fizzbuzz/testfizbuzz/').concat(document.getElementById("number").value);
        $.get(urlFizzBuzz, function(data, status){
            console.log(data);
            document.getElementById("response").innerHTML = data;
        });
    });
});