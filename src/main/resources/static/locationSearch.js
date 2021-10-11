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
    axios.get(`https://directed-post-326819.uc.r.appspot.com/places?lat=${latitutdeVal}&lon=${longtitudeVal}`)
        .then(values => {
                const places = values.data 
                const data = places.map(place => { 
                    return [place.name, place.rating]
                })
                new gridjs.Grid({ 
                    columns: ['Name', 'Rating'],
                    data: data
                }).render(document.getElementById('table'));
            }
        )
        .catch(err => console.log(err))
    mymap.setView([latitutdeVal + 0.00, longtitudeVal + 0.00], radiusVal + 0.00);
    marker = L.marker([latitutdeVal + 0.00, longtitudeVal + 0.00], L.Icon.Default).addTo(mymap);
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