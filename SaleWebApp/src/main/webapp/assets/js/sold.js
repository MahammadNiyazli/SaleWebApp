function forUpdatesold(price,count,unit,id,idGood){
    var priceUp = document.getElementById("priceUpsold");
    priceUp.value = price;
    var countUp = document.getElementById("countUpsold");
    countUp.value = count;
    var unitUp = document.getElementById("unitUpsold");
    unitUp.value = unit;
    var idUp = document.getElementById("idUpsold");
    idUp.value = id;

    var HandGood = document.getElementById("idHandGoodsold");
    HandGood.value = idGood;
}


function setIdForDeletesold(idSold , idGood){
    var elem1 = document.getElementById("idSalesold");
    elem1.value=idSold;
    var elem2 = document.getElementById("idGoodsold");
    elem2.value = idGood;
}