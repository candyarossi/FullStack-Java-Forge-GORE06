window.onload = async () => {
  const params = new URLSearchParams(window.location.search);
  const id = params.get("id");
  const fuente = params.get("fuente");
  cargarDetalle(id, fuente);
};

async function cargarDetalle(id, fuente) {
  let response = await fetch(
    "http://localhost:8080/detalle?id=" + id + "&fuente=" + fuente
  );
  let juego = await response.json();

  document.querySelector("#detalle").innerHTML = `<div>
	    <img src="${juego.portada}"/>
	<div>
	<h1>${juego.nombre}</h1>
	<ul>
		<li>Rating: &#160;&#160;<b>${juego.rating}</b> <span>&#9733;</span></li>
		<li>Fecha Lanzamiento: &#160;&#160;<b>${juego.fecha_lanzamiento}</b></li>
		<li>Géneros: 
			<ol>
                ${juego.generos
                  .map(
                    (genero) =>
                      `<li class="gen ${genero.nombre}">${genero.nombre}</li>`
                  )
                  .join("")}
			</ol>
		</li>
		<li>Plataformas: 
			<ol>
                ${juego.plataformas
                  .map(
                    (plataforma) =>
                      `<li class="plat ${plataforma.nombre}">${plataforma.nombre}</li>`
                  )
                  .join("")}
			</ol>
		</li>
	</ul>
	</div>
	</div>
	<p>${juego.descripcion}</p>

	<a href="./videojuegos.html">Volver</a>`;
}
