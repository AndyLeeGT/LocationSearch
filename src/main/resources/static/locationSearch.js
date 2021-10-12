//do it once the database is implemented\
                                //latitutde and longtitude

                                

var mymap = L.map('mapid').setView([33.772163578,-84.390165106], 10.00);
L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
    attribution: '&copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors'
}).addTo(mymap);

var markerGroup = L.layerGroup()
markerGroup.addTo(mymap)

var grid = new gridjs.Grid({ 
    columns: ['Name', 'Rating'],
    data: []
}).render(document.getElementById('table'));

function optionalSearch(){
    var latitutdeVal = parseFloat(document.getElementById('latitude').value);
    var longtitudeVal = parseFloat(document.getElementById('longitude').value);
    var radiusVal = parseFloat(document.getElementById('searchRadius').value);
    axios.get(`http://localhost:8080/places?lat=${latitutdeVal}&lon=${longtitudeVal}&radius=${radiusVal}`, { crossDomain: true })
        .then(values => {
                const places = values.data 
                const data = places.map(place => { 
                    return [place.name, place.rating]
                })
                markerGroup.clearLayers()
                const markers = places.forEach(place => { 
                    L.marker([place.geometry.location.lat, place.geometry.location.lng]).addTo(markerGroup)
                })
                grid.updateConfig({
                    data: data
                }).forceRender(document.getElementById('table'));
            }
        )
        .catch(err => console.log(err))
    mymap.setView([latitutdeVal, longtitudeVal], 10);;
}   



// new gridjs.Grid({
//     columns: ["Name", "Email", "Phone Number"],
//     data: [
//       ["John", "john@example.com", "(353) 01 222 3333"],
//       ["Mark", "mark@gmail.com", "(01) 22 888 4444"],
//       ["Eoin", "eoin@gmail.com", "0097 22 654 00033"],
//       ["Sarah", "sarahcdd@gmail.com", "+322 876 1233"],
//       ["Afshin", "afshin@mail.com", "(353) 22 87 8356"]
//     ]
//   }).render(document.getElementById("table"));