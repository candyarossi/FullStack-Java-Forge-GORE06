window.onload = async () => {
  const params = new URLSearchParams(window.location.search);
  const id = params.get("id");
  cargarJuego(id);
};

async function cargarJuego(id) {
  let response = await fetch(
    "http://localhost:8080/detalle?id=" + id + "&fuente=db"
  );
  let juego = await response.json();

  console.log(juego);

  let response2 = await fetch("http://localhost:8080/generosyplataformas");
  let info = await response2.json();

  console.log(info);

  document.querySelector("#editar").innerHTML = `
      <input type="hidden" name="id" value="${juego.id}"/>
      
      <label for="nombre">Nombre:</label>
      <input type="text" name="nombre" value="${juego.nombre}"/>

      <label for="descripcion">Descripción:</label>
      <textarea name="descripcion">${juego.descripcion}</textarea>

      <label for="portada">Portada:</label>
      <input type="url" name="portada" value="${juego.portada}"/>

      <label for="fecha_lanzamiento">Fecha Lanzamiento:</label>
      <input type="date" name="fecha_lanzamiento" value="${
        juego.fecha_lanzamiento
      }"/>

      <label for="rating">Rating:</label>
      <input type="number" name="rating" step="0.5" value="${juego.rating}"/>

      <label for="generos">Géneros:</label>
      <select name="generos" id="generos" multiple>${info.generos.map(
        (element) =>
          juego.generos.find((e) => e.nombre == element.nombre)
            ? '<option value="' +
              element.id +
              '" selected>' +
              element.nombre +
              "</option>"
            : '<option value="' +
              element.id +
              '">' +
              element.nombre +
              "</option>"
      )}</select>

      <label for="plataformas">Plataformas:</label>
      <select name="plataformas" id="plataformas" multiple>${info.plataformas.map(
        (element) =>
          juego.plataformas.find((e) => e.nombre == element.nombre)
            ? '<option value="' +
              element.id +
              '" selected>' +
              element.nombre +
              "</option>"
            : '<option value="' +
              element.id +
              '">' +
              element.nombre +
              "</option>"
      )}</select>

      <input type="submit" value="Editar Juego" />`;
}

document.querySelector("#editar").onsubmit = async (e) => {
  e.preventDefault();

  let informacion = e.target.children;

  let generos = Array.from(informacion[12].selectedOptions).map((option) => ({
    id: option.value,
    nombre: option.innerText,
  }));

  let plataformas = Array.from(informacion[14].selectedOptions).map(
    (option) => ({
      id: option.value,
      nombre: option.innerText,
    })
  );

  let juego = {
    id: informacion[0].value,
    nombre: informacion[2].value,
    descripcion: informacion[4].value,
    portada: informacion[6].value,
    fecha_lanzamiento: informacion[8].value,
    rating: informacion[10].value,
    generos,
    plataformas,
  };

  let response = await fetch("http://localhost:8080/editar", {
    method: "PUT",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify(juego),
  });
  let rta = await response.json();

  if (rta) {
    window.location.href = "./videojuegos.html";
  }
};
