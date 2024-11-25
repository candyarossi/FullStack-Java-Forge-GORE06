window.onload = async () => {
  cargarInfo();
};

async function cargarInfo() {
  let response = await fetch("http://localhost:8080/generosyplataformas");
  let info = await response.json();

  let plataformas = document.querySelector("#plataformas");
  let generos = document.querySelector("#generos");

  info.plataformas.forEach((element) => {
    plataformas.innerHTML +=
      '<option value="' + element.id + '">' + element.nombre + "</option>";
  });

  info.generos.forEach((element) => {
    generos.innerHTML +=
      '<option value="' + element.id + '">' + element.nombre + "</option>";
  });
}

document.querySelector("#agregar").onsubmit = async (e) => {
  e.preventDefault();

  let informacion = e.target.children;

  let generos = Array.from(informacion[11].selectedOptions).map((option) => ({
    id: option.value,
    nombre: option.innerText,
  }));

  let plataformas = Array.from(informacion[13].selectedOptions).map(
    (option) => ({
      id: option.value,
      nombre: option.innerText,
    })
  );

  let juego = {
    nombre: informacion[1].value,
    descripcion: informacion[3].value,
    portada: informacion[5].value,
    fecha_lanzamiento: informacion[7].value,
    rating: informacion[9].value,
    generos,
    plataformas,
  };

  let response = await fetch("http://localhost:8080/guardar", {
    method: "POST",
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
