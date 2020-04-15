
**PROJECT TITLE:** El Desafio De Potter (DP)

**VERSION or DATE:** 5/12/2019

**THIS PROJECT STARTED:** 12/11/2019

**AUTHORS:**
   - Pedro Miguel Carmona Broncano
   - Rubén Marín Lucas
   - Adrián Ruiz Parra
   
**USER INSTRUCTIONS**

    - You must rename the inputX.log file to input.log before run the project, You can find this
      file in 'files' folder
    - To run this project, you must run the main method of HogwartDemo class
    - The output of this emulation will be printed in terminal and in a output.log file in the 'files' folder.
    - We used Singlenton Pattern in Hogwarts class
    - We used Decorator Pattern in AbstractPotionExtra class
    - We used Strategy Pattern in AbstractWand class
    - We used JUnit integrated in BlueJ to make test classes


# 1.- Introducción
El objetivo del proyecto de la asignatura es construir un sistema que permita realizar una
simulación basada en la saga de novelas fantásticas “Harry Potter” 2 . En el caso de la asignatura,
hemos utilizado algunos nombres de personajes, varitas mágicas, pociones, etc. pero hemos
hecho una adaptación propia y hemos creado una situación ficticia para adaptarla a los contenidos
de POO impartidos en DP.

Así, el proyecto consiste en simular una competición de duelos entre las casas del castillo de
Hogwarts (inicialmente Gryffindor, Hufflepuff y Slytherin) en las que existirán personajes que
pertenecen a cada una de ellas y que irán compitiendo por turnos hasta que haya un vencedor o
se alcance un número máximo de turnos.

# 2.- Descripción de las entidades del proyecto “El Desafío de Potter (DP)”
### 2.1.- Hogwarts
Representa el castillo donde están los personajes y se establecen los duelos.
Su misión principal es almacenar información sobre las casas, los personajes, los duelos y su
resultado.
Para ello en cada turno irá solicitando a cada casa que le envíe a uno de sus personajes para que
