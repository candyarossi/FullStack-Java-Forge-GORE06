async function getGatitos(numero) {
  let response = await fetch(
    "https://api.thecatapi.com/v1/images/search?limit=" + numero
  );
  let gatitos = await response.json();
  return numero ? gatitos.splice(0, numero) : gatitos;
}

document.getElementById("form").onsubmit = async (event) => {
  event.preventDefault();
  let numero = event.target.children[1].value;

  let arrayGatos = await getGatitos(numero);

  let respuesta = document.getElementById("respuesta");
  respuesta.innerHTML = "";

  for (const gato of arrayGatos) {
    respuesta.innerHTML +=
      '<div class="card"><img src="' + gato.url + '"></div>';
  }
};
