/*
Palabras Reservadas: 

break, case, catch, continue, default, let, delete, do, else, finally, for, 
function, if, in, instanceof, new, return, switch, this, throw, try, typeof, 
var, void, while, with, y varias más...
*/

//Tipos de variables

var numero1;
let numero2;
const numero3 = 0;

// Tipos de datos básicos

let nro = 1;
let nombre = "Simon";
let bool = false;
let nulo = null;
let indefinido;

const constanteNula = null;
console.log(indefinido);

// Operadores básicos

let nro1 = 3;
let nro2 = 6;

let suma = nro1 + nro2;
console.log("Suma: ", suma);

let resta = nro1 - nro2;
console.log("Resta: ", resta);

let mult = nro1 * nro2;
console.log("Mult: ", mult);

let div = nro2 / nro1;
console.log("Div: ", div);

//

let str1 = "Coding";
let str2 = "Dojo";

let str3 = str1 + str2;
let str4 = str1 - 1;
let str5 = "12" - 3;
let str6 = str1 - str2;
let str7 = "3" - "1";

console.log("String nueva: ", str7); // Coerción de Datos

// Condicionales

let booleana = false;

// true = 1
// false = 0

/*
Operadores de comparación:

==                Ej: "1" == 1 -> true
===               Ej: "1" === 1 -> false
!=                
!==
<, <=, >, >=
*/

let numero = 6;

if (numero > 6) {
  console.log("Hola Mundo!");
} else if (numero < 6) {
  console.log("Chau Mundo!");
} else {
  console.log("El nro es 6");
}

/*
Operadores lógicos 

and (y) -> &&
or (o) -> ||
not (negación) -> !
*/

console.log("AND: ");

console.log("- true AND true: ", true && true);
console.log("- true AND false: ", true && false);
console.log("- false AND true: ", false && true);
console.log("- false AND false: ", false && false);

console.log("OR: ");

console.log("- true OR true: ", true || true);
console.log("- true OR false: ", true || false);
console.log("- false OR true: ", false || true);
console.log("- false OR false: ", false || false);

console.log("NOT: ");

console.log("- NOT true: ", !true);
console.log("- NOT false: ", !false);

// Ejemplos

let nombre1 = "";
let num6 = 6;
let esMenorA10 = num6 < 10; // true

//    false   &&    true  &&     true    =>
//   (false   &&    true) &&     true    =>
//          false         &&     true    =>   FALSE
if (nombre1 && esMenorA10 && num6 == 6) {
  console.log("Hola Mundo 1!");
}

//    false   ||    true  ||    true    =>
//   (false   ||    true) ||    true    =>
//           true         ||    true    =>    TRUE
if (nombre1 || esMenorA10 || num6 == 6) {
  console.log("Hola Mundo 2!");
}

//   false  || ( true      &&     true )   =>
//   false  || ( true      &&     true )   =>
//   false  ||            true             =>    TRUE
if (nombre1 || (esMenorA10 && num6 == 6)) {
  console.log("Hola Mundo 3!");
}

// Ciclos / Bucles / Iteraciones

// factorial => 4! = 4*3*2*1

let num1 = 4;
let factorial1 = 1;

for (let i = 1; i <= num1; i++) {
  factorial1 = factorial1 * i;
}

console.log(factorial1);

/*
Iteraciones:

num = 4
i = 1
i <= num -> true
factorial = 1 * 1; fact = 1;
i++ = i = 2

num = 4
i = 2
i <= num -> true
factorial = 1 * 2; fact = 2;
i++ = i = 3

num = 4
i = 3
i <= num -> true
factorial = 2 * 3; fact = 6;
i++ = i = 4

num = 4
i = 4
i <= num -> true
factorial = 6 * 4; fact = 24;
i++ = i = 5

num = 4
i = 5
i <= num -> false
fact = 24;
*/

let num2 = 4;
let factorial2 = 1;
let i = 1;

while (i <= num2) {
  factorial2 = factorial2 * i;
  i++;
}

console.log(factorial2);

// ARRAYS o ARREGLOS

//  índices =     0          1         2         3         4         5        6
let alumnos = [
  "Julian",
  "Daniela",
  "Jose",
  "Cristian",
  "Matias",
  "Tomas",
  "Juan",
];

console.log(alumnos[2]);
console.log(alumnos[0]);
console.log(alumnos[10]);

console.log(alumnos.length);
console.log(alumnos[alumnos.length - 1]);

for (let i = 0; i < alumnos.length; i++) {
  console.log(alumnos[i]);
}

alumnos.push("Catalina"); // Agrega al final
console.log(alumnos);

alumnos.unshift("Camila"); // Agrega al inicio
console.log(alumnos);

let fin = alumnos.pop(); // Quita del final
console.log(fin);
console.log(alumnos);

let inicio = alumnos.shift(); // Quita del inicio
console.log(inicio);
console.log(alumnos);
