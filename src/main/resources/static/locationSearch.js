//do it once the database is implemented\
                                //latitutde and longtitude

var x = 51.505;
var y = -0.09;
var z = 13;

function optionalSearch(){
var latitutdeVal = parseFloat(document.getElementById('latitude').value);
var longtitudeVal = parseFloat(document.getElementById('longitude').value);
var radiusVal = parseFloat(document.getElementById('searchRadius').value);

var mymap = L.map('mapid').setView([latitutdeVal, longtitudeVal], radiusVal);
L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
    attribution: '&copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors'
}).addTo(mymap);

}

