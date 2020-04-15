
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
mantenga un duelo con los personajes de cada una de las otras casas.

Una vez llegue cada personajes de cada casa a Hogwarts, se producirá un duelo, en el que el
personaje con menos energía (ver clase Character) será el primero en enfrentarse al resto de
personajes uno a uno. Así, el personaje con menos energía realizará la acción de atacar (fight)
uno a uno a los demás personajes. Una vez termine el primero, el segundo atacará también a
todos los rivales y así sucesivamente hasta que todos hayan atacado una vez al resto de
personajes. Hay que tener en cuenta que solo se producirá el duelo si ambos personajes
(“atacante” y “atacado”) tienen aún energía (es decir, un valor mayor que cero).

Al terminar todos los ataques, solo aquellos personajes que todavía tengan energía serán
enviados a sus respectivas casas.

Los que no tengan energía se enviarán a un calabozo que hay en el castillo (llamado dungeon)
por orden de llegada.

Los turnos de duelos se repetirán hasta que haya un vencedor o se alcance un número máximo
de turnos. Los detalles concretos sobre esta situación final están explicados a continuación en los
requisitos detallados.

Además, al final de la simulación, la aplicación mostrará la información que resuma las acciones
que han tenido lugar así como información estadística de los personajes que han participado.

Requisitos detallados de Hogwarts:
- Existirá una única instancia de la clase Hogwarts en la simulación.
- La clase Hogwarts almacenará la siguiente información mínima:
   - Una colección que almacene las distintas casas de la simulación. Esta estructura
   permitirá el acceso de forma eficiente a cada casa utilizando su nombre (con
   valores definidos de forma única) como clave.
   - Los personajes enviados por cada casa para participar en el duelo se almacenarán
   en una colección lineal en la que se ordenarán los personajes siguiendo el criterio
   de menor a mayor energía, en caso de empate en la energía, los personajes se
   ordenarán alfabéticamente por su nombre en orden creciente.
   - Hogwarts almacenará una colección de varitas mágicas “nuevas”. Estas varitas
   pueden ser de cualquiera de los tipos especificados en el apartado “Varitas
   Mágicas (Wand)” y se almacenarán en una estructura que permita mantenerlas en
   orden ascendente por el nombre específico que se le asigne a cada varita (no
   confundir con su tipo), además, no podrá haber dos varitas con el mismo nombre.
   Estas varitas son almacenadas para repartirlas (mientras existan varitas) a cada
   personaje después de su turno de duelos, solo en caso de que aún le quede
   energía, para que la utilice en el siguiente turno de duelos. En caso de agotarse las
   varitas mágicas el personaje seguirá durante el resto de los duelos con la última
   varita que utilizó.
   - Además, aquellos personajes que se van quedando sin energía en los duelos no
   volverán a sus casa y se almacenarán en el “calabozo” (dungeon), que será una
   colección lineal en la que se ordenarán por orden de llegada.


La funcionalidad de Hogwarts será la siguiente:
- En cada turno, mientras no se haya llegado a la situación final:
   - Solicitar a cada casa un personaje.
   - Ordenarlos de menor a mayor de acuerdo a su energía.
   - Realizar los duelos:
      - Comenzando por el personaje con menos energía para que éste ataque uno
         a uno a los demás.
      - Continuar con el resto de personajes para que ataquen uno a uno a los
        demás siempre que ambos tengan energía hasta que todos los que tengan
        energía hayan usado su turno de ataque.

   - Al finalizar el turno de duelos:
      - Enviar a los personajes que tengan aún energía a sus casas y enviar a
        aquellos que no tengan ya energía al calabozo.
      - A la vez que envía los personajes que aún tienen energía a sus casas,
        Hogwarts les asigna a cada uno de ellos una de las “nuevas” varitas en el
        orden en que están almacenadas, es decir, alfabéticamente por su nombre.
      - Mostrar los resultados solicitados de los duelos por la simulación.
      

- La situación final de la simulación sucede cuando solo queda una casa con
  personajes con energía o se han completado 10 turnos. Cuando se alcance esta
  situación:
  - Mostrar los resultados finales.
    - En caso de que el final se produzca porque se han alcanzado los 10 turnos
      y hayan sobrevivido personajes de más de una casa:
      - Gana la casa con más personajes
         - En caso de empate en el número de personajes
           supervivientes, gana la casa cuya suma de los puntos finales
           de energía de sus personajes sea mayor
           - En caso de empate en el total de los puntos de
             energía finales de los personajes supervivientes, gana
             la casa cuya suma de puntos defensivos más los
             puntos ofensivos sea menor.
