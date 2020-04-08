$(document).ready(function(){
    $("#get").click(function(){
        var urlFizzBuzz = 'http://localhost:8080/fizzbuzz/testfizbuzz/'.concat(document.getElementById("number").value);
        $.get(urlFizzBuzz, function(data, status){
            console.log(data);
            document.getElementById("response").innerHTML = data;
        });
    });
});