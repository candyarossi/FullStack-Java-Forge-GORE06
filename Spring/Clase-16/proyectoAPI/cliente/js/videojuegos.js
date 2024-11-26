window.onload = async () => {
  cargarJuegos(1);
};

async function cargarJuegos(page) {
  let response = await fetch("http://localhost:8080/todos?pagina=" + page);
  let juegos = await response.json();

  let vPlataforma = document.querySelector("#vPlataforma").children[1];
  let vComunidad = document.querySelector("#vComunidad").children[1];
  let paginador = document.querySelector("#paginador");

  vPlataforma.innerHTML = "";
  vComunidad.innerHTML = "";
  paginador.innerHTML = "";

  juegos.videojuegosComunidad.forEach((element) => {
    vComunidad.innerHTML += `<li>
                  <img src="${
                    element.portada
                      ? element.portada
                      : "https://t3.ftcdn.net/jpg/04/84/88/76/360_F_484887682_Mx57wpHG4lKrPAG0y7Q8Q7bJ952J3TTO.jpg"
                  }" />
                  <h3>${element.nombre}</h3>
                  <a href="./detalle.html?id=${
                    element.id
                  }&fuente=db">Detalles</a>
                  <a href="./editar.html?id=${element.id}">Editar</a>
                  <button onclick="eliminar(${element.id})">Eliminar</button>
              </li>`;
  });

  juegos.videojuegos.forEach((element) => {
    vPlataforma.innerHTML += `<li>
                  <img src="${element.portada}" />
                  <h3>${element.nombre}</h3>
                  <a href="./detalle.html?id=${element.id}&fuente=api">Detalles</a>
              </li>`;
  });

  for (let i = 1; i <= juegos.cantPaginas; i++) {
    paginador.innerHTML += `<button onclick="cargarJuegos(${i})">${i}</button>`;
  }
}

async function eliminar(id) {
  let response = await fetch("http://localhost:8080/eliminar?id=" + id, {
    method: "DELETE",
  });
  let rta = await response.json();

  if (rta) {
    window.location.href = "./videojuegos.html";
  }
}
