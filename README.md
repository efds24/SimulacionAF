# Simulador de un autómata finito

A partir de la especificación de un archivo de definición de un autómata que tenga el siguiente formato:

```bash
#número total de estados estado1 estado2 … 
#número de estados finales estadoFinal1 estadoFinal2 …
#número total de símbolos del alfabeto simbolo1 simbolo2 … símbolo n 
--TABLA DE TRANSICIONES-- 
TANTAS FILAS COMO ESTADOS 
TANTAS COLUMNAS COMO SÍMBOLOS DEL ALFABETO + 1 (cadena vacía). 
Cada columna finaliza con el símbolo #
```
y una cadena de entrada indica el estado de salida.

## Ejecución
- Abrir archivo P2.jar
- Pulsar el botón ...
- Seleccionar el archivo con la descripción del autómata
- Pulsar el botón Seleccionar archivo
- Escribir la cadena
- Pulsar el botón Empezar

El archivo maquinaExpendedora.txt es un ejemplo de definición de un autómata que simula el funcionamiento de una máquina expendedora, un ejemplo de cadena de entrada para este autómata es "152ac22bd1c2c".
