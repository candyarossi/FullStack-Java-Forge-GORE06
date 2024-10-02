// FUNCIONES

function suma(numero1, numero2) {
  let numero1 = 3;
  let numero2 = 7;
  let suma = numero1 + numero2;
  console.log("El resultado es: ", suma);
  return suma;
}

suma(6, 3);
suma(2, 8);
console.log("Hola!");
suma(8, 7);
suma(8, 1);

//  resultado = 3 * 9;
let resultado = 3 * suma(6, 3);
console.log(resultado);

// SCOPE

// let k = 9;
// while(condicion){
//     let j = 5;
//     if(condicion){
//         console.log(j);
//     }
// }
// console.log(j);

// FUNCIONES ANÓNIMAS Y FUNCIONES FLECHA
// Calcular área de un rectangulo

let largo = 5;
let ancho = 3;

let calcularArea = function (largoRectangulo, anchoRectangulo) {
  return largoRectangulo * anchoRectangulo;
};

console.log(calcularArea(largo, ancho));

// Calcular perímetro de un rectangulo

let calcularPerimetro = (largoRectangulo, anchoRectangulo) =>
  2 * (largoRectangulo + anchoRectangulo);

console.log(calcularPerimetro(largo, ancho));

// OBJETOS

let persona = {
  nombre: "Rocco",
  apellido: "Alcayaga",
  id: 9854,
};

// JSON = JavaScript Object Notation

// let persona = {
//     "nombre": "Rocco",
//     "apellido": "Alcayaga",
//     "id": 9854
// };

// Acceder a propiedades

console.log(persona.nombre);
console.log(persona["apellido"]);

// Agregar propiedades

persona.colorFav = "Naranja";
console.log(persona);

// Modificar propiedades

persona.colorFav = "Violeta";
console.log(persona);

persona["id"] = 456;
persona.id = 456;
console.log(persona);

// Copiar propiedades

let persona2 = {
  nombre: persona.nombre,
  apellido: persona.apellido,
};

// OBJETOS CON FUNCIONES

let persona = {
  nombre: "Rocco",
  apellido: "Alcayaga",
  id: 9854,
  nombreCompleto: function () {
    return this.nombre + " " + this.apellido;
  },
  verThis: function () {
    return this;
  },
};

console.log(persona.nombreCompleto());
console.log(persona.verThis());

// Objetos globales

console.log(this);
console.log(global);

// Operador 'in'

console.log("dni" in persona);
console.log("nombre" in persona);

if ("nombre" in persona) {
  console.log(persona.nombre);
} else {
  persona.nombre = "";
  console.log("Persona sin nombre");
}

// For .. in
for (let prop in persona) {
  console.log(prop + ": " + persona[prop]);
  console.log(persona[prop]);
}

// Arreglo de objetos

let user1 = { nombre: "User 1", mail: "user1@gmail.com", id: 1234 };
let user2 = { nombre: "User 2", mail: "user2@gmail.com", id: 5678 };
let user3 = { nombre: "User 3", mail: "user3@gmail.com", id: 9012 };

let users = [user1, user2, user3];
console.log(users);

// let user4 = { nombre: "User 4", mail: "user4@gmail.com", id: 7676 };
// users.push(user4);
users.push({ nombre: "User 4", mail: "user4@gmail.com", id: 7676 });

console.log(users);

// For .. of

for (let user of users) {
  console.log(user.id);
}
