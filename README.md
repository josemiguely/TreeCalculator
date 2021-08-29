<h1>Tree Calculator</h1>

This Java program evaluates an operation between Integers, Floats, Strings, Booleans, Binaries through a tree, displaying its result on a tree structure on the screen using the library JavaFX.

The operations this program can evaluate are the following: Addition, Multiplication, Subtraction, Division, And, Or, Transformation (example: From Binary to Integer), Logical Negation.

Maven is used to manage the program dependencies. 

This program was an assignment for the course "Metodologías de Diseño y Programación" in Universidad de Chile for educational purpouses.

An example of the program is the following:



![image](https://user-images.githubusercontent.com/81194170/131036413-a1ff18ae-21a0-4b20-b0f5-5e0ec27df674.png)









An explanation of the program, its considerations, and the design patterns used are given in Spanish. A translation will be soon available


## Introducción:

-La lógica del programa es que hay 5 tipos. SBinary (binarios),SBool(booleanos),SFloat(double),SInt(enteros),SString(strings)
que pueden interactuar entre ellos a partir de operaciones comunes en sus contrapartes primitivas.

Se asumieron las siguientes cosas:

-Dos SBinaries son iguales si su transformación a entero es la misma

-El arbolAst (Clase ArbolFactory), asume que el usuario va a crear correctamente el árbol. En la gui, se atrapan las excepciones y se despliegan como errores de sintaxis

Para ejecutar los tests basta con correr la carpeta de Test.

# **GUI:**

Para hacer correr la gui basta con correr la clase App en el paquete MVC (Modelo-Vista-Controlador)

_Instrucciones:_

Esta aplicación añade nodos en orden de nivel de izquierda a derecha

Todas las operaciones y elementos que se pueden ingresar deben escribirse tal cual como escritas a continuación

### `Operaciones que se pueden ingresar`

Operaciones Binarias disponibles: Add,Sub,Div,Mult,Add,Or

Operaciones Unarias disponibles: Negacion,ToInt,ToString,ToBool,ToFloat,ToBinary

### _**`Elementos que se pueden ingresar:`**_

Números enteros: Cualquier dígito válido sin punto

Números decimales: Cualquier dígito válido con punto

Números binarios: Cualquier dígito de 0 y 1 que empiece con bx. Ejemplo: bx1011

Strings: Cualquier secuencia de caracteres que empiece con " y termine con ". Ejemplo: "Nancy es lo mejor que existe 1234"

Booleanos: Dos opciones. booltrue o boolfalse

Si alguna operación es incorrecta, usted deberá borrar todo y intentarlo nuevamente

Para las operaciones Unarias o Elementos que no tengan hijos, debe ingresar cualquier cosa en los espacios vacíos el número de veces correspondiente hasta llegar al nodo deseado


**_Para desplegar esta información en la aplicación puede apretar la letra i._**
