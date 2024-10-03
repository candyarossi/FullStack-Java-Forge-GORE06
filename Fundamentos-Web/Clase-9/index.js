// DOM = Document Object Model

// document => <html>
// head y body

// document.head
// document.body
// document.body.ul.li

console.log(document);
console.log(document.head);
console.log(document.body);

console.dir(document.head);

// getElementById

let itemXid = document.getElementById("item2");
console.log(itemXid);

// getElementsByClassName

let enlacesXclass = document.getElementsByClassName("enlaces");
console.log(enlacesXclass);
console.log(enlacesXclass[1]);

for (const enlace of enlacesXclass) {
  console.log(enlace.innerText);
}

// getElementsByTagName

let itemsXtag = document.getElementsByTagName("li");
console.log(itemsXtag);

for (const item of itemsXtag) {
  console.log(item.innerText);
}

// innerText

itemXid.innerText = "Nuevo Item 2";

// innerHTML

itemXid.innerHTML =
  "<img src='https://upload.wikimedia.org/wikipedia/commons/4/41/Coding_Dojo.png' width='20%' />";
console.log(itemXid);

// className / id

let segundoEnlace = enlacesXclass[1];

segundoEnlace.className += " nuevaClase";
segundoEnlace.id = "enlace2";

console.log(segundoEnlace);
console.log(segundoEnlace.className);
console.log(segundoEnlace.id);

// Agregar un elemento al DOM

let lista = document.getElementById("lista");

// Opción 1:
lista.innerHTML += "<li>Item 4</li>";

// Opción 2:
let nuevoItem = document.createElement("li");
nuevoItem.innerText = "Item 4";
nuevoItem.id = "item4";
lista.append(nuevoItem);

// Quitar un elemento del DOM

let item4 = document.getElementById("item4");
item4.remove();

// querySelector()

let lista2 = document.querySelector("#lista");
console.log(lista2);

let enlace = document.querySelector(".enlaces");
console.log(enlace);

let li = document.querySelector("li");
console.log(li);

// querySelectorAll()

let enlaces = document.querySelectorAll(".enlaces");
console.log(enlaces);

// EVENTOS

// .addEventListener

let btn1 = document.getElementById("btn1");
btn1.addEventListener("click", respuestaClick);

function respuestaClick() {
  console.log("Click en btn1");
}

// .onclick

let btn2 = document.querySelector("#btn2");

btn2.onclick = () => {
  console.log("Click en btn2");
  btn2.innerText = "Nuevo boton 2";
};

// <li onclick="funcion()"></li>

function boton3(boton) {
  console.log("Click en btn3");

  // Opción 1:
  let btn3 = document.getElementById("btn3");
  btn3.style.display = "none";

  // Opción 2:
  console.dir(boton);
  boton.style.display = "none";
}

// Eventos del Mouse

// mousedown/mouseup
// mouseover/mouseout
// mousemove
// click

let input1 = document.querySelector("#texto1");

input1.onclick = () => {
  console.log("click");
};

input1.onmousemove = () => {
  console.log("move");
};

// Eventos del teclado

// keyDown
// keyUp

let input2 = document.getElementById("numero1");

input2.addEventListener("keydown", function () {
  console.log("keyDown");
});

// Evento input

let input3 = document.querySelector("#texto2");

input3.oninput = (event) => {
  console.log("input");
  console.log(event);
  console.log(event.target);
  console.log(event.target.value);
};

// Evento submit

let miForm = document.getElementById("formulario");
miForm.addEventListener("submit", validarFormulario);

function validarFormulario(event) {
  event.preventDefault();

  let formulario = event.target.children;
  console.dir(formulario);

  console.log(formulario[0].id, ":", formulario[0].value);
  console.log(formulario[1].id, ":", formulario[1].value);
  console.log(formulario[2].id, ":", formulario[2].value);
  console.log(formulario[3].id, ":", formulario[3].value);

  let reset = document.querySelector("#resetBtn");
  reset.click();

  alert("Formulario enviado");
}
