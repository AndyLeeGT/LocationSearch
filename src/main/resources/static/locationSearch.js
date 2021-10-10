//do it once the database is implemented\
                                //latitutde and longtitude


var mymap = L.map('mapid').setView([33.772163578,-84.390165106], 10.00);
L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
    attribution: '&copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors'
}).addTo(mymap);
const marker = L.marker([33.772163578, -84.390165106], L.Icon.Default).addTo(mymap);


function optionalSearch(){
var latitutdeVal = parseFloat(document.getElementById('latitude').value);
var longtitudeVal = parseFloat(document.getElementById('longitude').value);
var radiusVal = parseFloat(document.getElementById('searchRadius').value);

mymap.setView([latitutdeVal + 0.00, longtitudeVal + 0.00], radiusVal + 0.00);
marker = L.marker([latitutdeVal + 0.00, longtitudeVal + 0.00], L.Icon.Default).addTo(mymap);
}

