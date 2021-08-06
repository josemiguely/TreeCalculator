# Scrabble

![http://creativecommons.org/licenses/by/4.0/](https://i.creativecommons.org/l/by/4.0/88x31.png)

Interactive graphic programming language heavily inspired by 
[Scratch](https://scratch.mit.edu).
This work is licensed under a
[Creative Commons Attribution 4.0 International License](http://creativecommons.org/licenses/by/4.0/), 
and aims purely to be used with the purpose of teaching in the context of the course 
_CC3002 Metodologías de Diseño y programación_ of the 
[_Computer Sciences Department (DCC)_](https://www.dcc.uchile.cl) of the 
_University of Chile_.

---

**The rest of the documentation is left for the users of this template to complete**

## Introduccion:

-La logica del programa es que hay 5 tipos. SBinary (binarios),SBool(booleanos),SFloat(double),SInt(enteros),SString(strings)
que pueden interactuar entre ellos a partir de operaciones comunes en sus contrapartes primitivas

Se asumieron las siguientes cosas 

-Dos Sbinaries son iguales si su transformacion a entero es la misma.

-El arbolAst (Clase ArbolFactory), asume que el usuario va a crear correctamente el arbol. En la gui, atrapa las excepciones y la despliega como errores de sintaxis

Para ejecutar los tests basta con correr la carpeta de Test.

# **GUI:**

Para hacer correr la gui basta con correr la clase en el paquete MVC (Modelo-Vista-Controlador)

_Instrucciones:_

Esta aplicación añade nodos en orden de nivel de izquierda a derecha

Todas las operaciones y elementos que se pueden ingresar deben escribirse tal cual como escritas a continuación

Operaciones que se pueden ingresar
Operaciones Binarias disponibles: Add,Sub,Div,Mult,Add,Or
Operaciones Unarias disponibles: Negacion,ToInt,ToString,ToBool,ToFloat,ToBinary

Elementos que se pueden ingresar:
Numeros enteros: Cualquier digito valido sin puntos
Numeros decimales: Cualquier digito valido con punto
Numeros binarios: Cualquier digito de 0 y 1 que empiece con bx. Ejemplo: bx1011
Strings: Cualquier secuencia de caracteres que empieze con " y termine con ". Ejemplo: "Nancy es lo mejor que existe 1234"
Booleanos: Dos opciones. booltrue o boolfalse

Si alguna operacion es incorrecta, usted debera borrar todo y intentarlo nuevamente"+'\n'+
Para las operaciones Unarias o Elementos que no tengan hijos, debe ingresar cualquier cosa en los espacios vacios el numero de veces correspondiente hasta llegar al nodo deseado


**_Para desplegar esta informacion en la aplicacion puede apretar la letra i._**