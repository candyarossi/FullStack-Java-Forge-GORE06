const climas = [
  {
    img: '<ion-icon name="rainy"></ion-icon>',
    temperatura: "3°C - 14°C",
    estado: "Tormentas",
  },
  {
    img: '<ion-icon name="cloudy"></ion-icon>',
    temperatura: "5°C - 12°C",
    estado: "Nublado",
  },
  {
    img: '<ion-icon name="partly-sunny"></ion-icon>',
    temperatura: "9°C - 18°C",
    estado: "Parcialmente Nublado",
  },
  {
    img: '<ion-icon name="sunny"></ion-icon>',
    temperatura: "15°C - 23°C",
    estado: "Soleado",
  },
];

alert("Cargando Reporte del Clima...");

document.getElementById("btnAceptar").addEventListener("click", aceptarCookies);

function aceptarCookies() {
  document.getElementById("cookies").style.display = "none";
}

function cargarClima(ciudad) {
  document.querySelector("#ciudad").innerText = ciudad.innerText;

  let cards = document.getElementsByClassName("card");

  for (const card of cards) {
    let nro = Math.floor(Math.random() * 4);
    let clima = climas[nro];

    card.children[0].innerHTML = clima.img;
    card.children[2].innerText = clima.estado;
    card.children[3].innerText = clima.temperatura;
  }

  document.getElementsByTagName("section")[0].style.display = "block";
}
