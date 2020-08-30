function forUpdate(price,count,unit,id,idGood){
    var priceUp = document.getElementById("priceUps");
    priceUp.value = price;
    var countUp = document.getElementById("countUps");
    countUp.value = count;
    var unitUp = document.getElementById("unitUps");
    unitUp.value = unit;
    var idUp = document.getElementById("idUps");
    idUp.value = id;

    var HandGood = document.getElementById("idHandGood");
    HandGood.value = idGood;
}


function setIdForDelete(idSold , idGood){
    var elem1 = document.getElementById("idSale");
    elem1.value=idSold;
    var elem2 = document.getElementById("idGood");
    elem2.value = idGood;
}