
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


# :one: - Introducción
El objetivo del proyecto de la asignatura es construir un sistema que permita realizar una
simulación basada en la saga de novelas fantásticas *“Harry Potter”* . En el caso de la asignatura,
hemos utilizado algunos nombres de personajes, varitas mágicas, pociones, etc. pero hemos
hecho una adaptación propia y hemos creado una situación ficticia para adaptarla a los contenidos
de POO impartidos en DP.

Así, el proyecto consiste en simular una competición de duelos entre las casas del castillo de
Hogwarts (inicialmente *Gryffindor, Hufflepuff y Slytherin*) en las que existirán personajes que
pertenecen a cada una de ellas y que irán compitiendo por turnos hasta que haya un vencedor o
se alcance un número máximo de turnos.

# :two: - Descripción de las entidades del proyecto “El Desafío de Potter (DP)”
### :two:.:one: - Hogwarts
Representa el castillo donde están los personajes y se establecen los duelos.
Su misión principal es almacenar información sobre las casas, los personajes, los duelos y su
resultado.

Para ello en cada turno irá solicitando a cada casa que le envíe a uno de sus personajes para que
mantenga un duelo con los personajes de cada una de las otras casas.

Una vez llegue cada personajes de cada casa a *Hogwarts*, se producirá un duelo, en el que el
personaje con **menos energía** (ver clase *Character*) será el primero en enfrentarse al resto de
personajes uno a uno. Así, el personaje con menos energía realizará la acción de atacar (*fight*)
uno a uno a los demás personajes. Una vez termine el primero, el segundo atacará también a
todos los rivales y así sucesivamente hasta que todos hayan atacado una vez al resto de
personajes. Hay que tener en cuenta que solo se producirá el duelo si ambos personajes
(*“atacante” y “atacado”*) tienen aún energía (es decir, un valor mayor que cero).

Al terminar todos los ataques, solo aquellos personajes que todavía tengan energía serán
enviados a sus respectivas casas.

Los que no tengan energía se enviarán a un calabozo que hay en el castillo (llamado *dungeon*)
por orden de llegada.

Los turnos de duelos se repetirán hasta que haya un vencedor o se alcance un número máximo
de turnos. Los detalles concretos sobre esta situación final están explicados a continuación en los
requisitos detallados.

Además, al final de la simulación, la aplicación mostrará la información que resuma las acciones
que han tenido lugar así como información estadística de los personajes que han participado.

**Requisitos** detallados de *Hogwarts*:
- Existirá una **única instancia** de la clase Hogwarts en la simulación.
- La clase Hogwarts almacenará la siguiente información mínima:
   - Una colección que almacene las distintas casas de la simulación. Esta estructura
   permitirá el acceso de forma eficiente a cada casa utilizando su nombre (con
   valores definidos de forma única) como clave.
   - Los personajes enviados por cada casa para participar en el duelo se almacenarán
   en una colección lineal en la que se ordenarán los personajes siguiendo el criterio
   de **menor a mayor** energía, en caso de empate en la energía, los personajes se
   ordenarán alfabéticamente por su nombre en orden creciente.
   - Hogwarts almacenará una colección de varitas mágicas *“nuevas”*. Estas varitas
   pueden ser de cualquiera de los tipos especificados en el apartado *“Varitas*
   *Mágicas (Wand)”* y se almacenarán en una estructura que permita mantenerlas en
   orden ascendente por el nombre específico que se le asigne a cada varita (no
   confundir con su tipo), además, no podrá haber dos varitas con el mismo nombre.
   Estas varitas son almacenadas para repartirlas (mientras existan varitas) a cada
   personaje después de su turno de duelos, solo en caso de que aún le quede
   energía, para que la utilice en el siguiente turno de duelos. En caso de agotarse las
   varitas mágicas el personaje seguirá durante el resto de los duelos con la última
   varita que utilizó.
   - Además, aquellos personajes que se van quedando sin energía en los duelos no
   volverán a sus casa y se almacenarán en el “calabozo” (*dungeon*), que será una
   colección lineal en la que se ordenarán por orden de llegada.


La **funcionalidad** de *Hogwarts* será la siguiente:
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
        Hogwarts les asigna a cada uno de ellos una de las *“nuevas”* varitas en el
        orden en que están almacenadas, es decir, alfabéticamente por su nombre.
      - Mostrar los resultados solicitados de los duelos por la simulación.
      

- **La situación final de la simulación sucede cuando solo queda una casa con
  **personajes con energía o se han completado 10 turnos**. Cuando se alcance esta
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

### :two:.:two: - Casa (House) :house:
Representa als casas donde se agrupan los distintos personajes de manera que cada personaje debe pertenecer a una y solo una de las casas. Su labor principal es mantener el grupo de sus personajes y enviar en cada turno uno de ellos al duelo en *Hogwarts*. 

**Requisitos** detallados de la *Casa*:
   - Cada objeto de este tipo almacenará, como mínimo, los distintos personajes que pertenecen a ella. Esta estructura permitirá la ordenación **inicial** de los personajes según los criterios explicados en la parte de funcionalidad. 
   
La **funcionalidad** de cada casa será la siguiente: 

- **Antes de comenzar el primer turno de duelos**, cada casa ordenará sus personajes. Este orden **inicial** establecido será:
   - Casa *Gryffindor*: ordenará sus personajes de menos a más puntos defensivos.
   - Casa *Hufflepuff*: ordenará sus personajes de menos a más puntos ofensivos.
   - Casa *Slytherin*: ordenará sus personajes de más a menos puntos ofensivos.
- En caso de empate en este orden inicial, los personajes se ordenarán
alfabéticamente por su nombre en orden creciente.
- Cuando *Hogwarts* le solicite un personaje a una casa, ésta enviará el personaje situado en
la primera posición para el enfrentamiento.
- Los personajes enviados al enfrentamiento que retornen del duelo serán insertados en la
última posición de la colección de personajes.

### :two:.:three: - Personaje (Character)

En esta clase se definen las características comunes de los personajes que existen en la
simulación. Los personajes tienen unas características comunes explicadas a continuación.
**Requisitos** detallados de la clase Character:
- Cada objeto de la clase Character almacenará como información mínima:
   - *Nombre (name)*
   - *Puntos de energía (energy)* (por defecto 20.0)
   - *Puntos ofensivos (offensive)* (por defecto 20.0)
   - *Puntos defensivos (defensive)* (por defecto 20.0)
   - *Varita mágica (wand):*
   
      - Cualquier personaje puede usar cualquier varita mágica.
      - Los personajes deben poder cambiar de varita mágica.
      
 - Además, los personajes se clasifican en los siguientes tipos:
   - *Defensivos:* se caracterizan porque inicialmente tienen 5.0 puntos defensivos
   extras.
   - *Ofensivos:* se caracterizan porque inicialmente tienen 5.0 puntos ofensivos extras.
   
   
La **funcionalidad** de los personajes será la siguiente:
- Cada personaje ofrece los siguientes métodos (como mínimo):
   - método ataque (*fight*), que utilizará durante el combate. Este método comprobará
   los puntos para el ataque (*attack points*) devueltos por la varita mágica para el
   personaje que la está usando de forma ofensiva y los puntos de resistencia
   (*resistance points*) devueltos por su oponente:  
   
      - Si los puntos del ataque del personaje son mayores que los puntos de
      resistencia del oponente (*attack points > resistance points*), la energía
      resultante del oponente tras el ataque (*energy*) será el resultado de restar a
      dicha energía antes del ataque (energy) la diferencia entre los puntos para
      el ataque (*attack points*) y los puntos de resistencia (resistance points).
      
      -  Si los puntos del ataque del personaje son menores o iguales que los
      puntos de resistencia del oponente (*attack points <= resistance points*), la
      energía del oponente permanecerá inalterada.
      
   - método resistencia (*resistance*), que utiliza un personaje para contrarrestar el
   ataque recibido. Este método devolverá los puntos de resistencia (*resistance*
   *points*) devueltos por la varita mágica para el personaje que la está usando de
   forma defensiva.
   - *Cambiar varita*. Cada vez que un personaje finalice el duelo, antes de ser devuelto
   a su casa, cambiará su varita a la que le asigne Hogwarts siempre que queden
   “nuevas varitas” sin asignar.
      - Es decir, si por ejemplo un personaje ha combatido un turno con la varita de
      madera de Acebo Defensivo (*HollyDefensive Wand*) podría tener que
      cambiar en el siguiente turno a una varita de madera de Espino Ofensivo
      (*HawthornOffensive Wand*) si se la asigna Hogwarts.
   -  Además, cada personaje ofrecerá los métodos necesarios para llevar a cabo la
   funcionalidad requerida en la simulación (*métodos “gets”, “sets”, etc.*).


### :two:.:four: - Varítas Mágicas (Wand)

Cada personaje usa una varita mágica durante el duelo tanto para generar sus puntos de ataque
(*attack points*) como para generar sus puntos de resistencia (*resistance points*). La diferencia
entre cada varita mágica viene marcada por el tipo de madera utilizada que hace que generen los
puntos de forma distinta cuando son usadas de forma ofensiva o de forma defensiva.

**Requisitos** de las varitas (*Wand*):
- Una varita es usada durante los duelos por los personajes tanto de forma ofensiva,
devolviendo *attack points* ,como de forma defensiva, devolviendo *resistance points*.


La **funcionalidad** de las varitas (*Wand*) dependerá del tipo de madera de cada una:
- Inicialmente tendremos los siguientes tipos de varitas con el siguiente comportamiento
asociado:

   - Espino Ofensivo (*OffensiveHawthorn*): se caracteriza por ser una varita orientada al
   ataque, de manera que, cuando un personaje utiliza esta varita:
   
      - cuando es utilizada de forma ofensiva, los puntos de ataque devueltos
      (attack points) por esta varita serán: 0.6 veces sus puntos de energía
      (*energy*) más 1.4 veces sus puntos ofensivos (*offensive*);
      
      - cuando es utilizada de forma defensiva, los puntos de resistencia devueltos
      (resistance points) por esta varita serán: 0.8 veces sus puntos de energía
      (*energy*) más 0.2 veces sus puntos defensivos (*defensive*);

   - Acebo Defensivo (*HollyDefensive*): se caracteriza por ser una varita orientada a la
   defensa, de manera que, cuando un personaje utiliza esta varita:
   
      - cuando es utilizada de forma ofensiva, los puntos de ataque devueltos
      (attack points) por esta varita serán: 0.7 veces sus puntos de energía
      (*energy*) más 0.3 veces sus puntos ofensivos (*offensive*);
      
      - cuando es utilizada de forma defensiva, los puntos de resistencia devueltos
      (resistance points) por esta varita serán: 0.9 veces sus puntos de energía
      (*energy*) más 1.1 veces sus puntos defensivos (*defensive*);


### :two:.:five: - Pociones Extras (Extra potions)

Cualquiera de los personajes pueden usar en algún momento **pociones extras**. Estas pociones
extras se caracterizan porque bien potencian sus puntos ofensivos y/o sus puntos defensivos. Un
personaje puede llegar a no usar nunca una de estas pociones, una de ellas, dos o usar todas las
que existan a la vez.

Así, inicialmente tendremos estos tipos de pociones extra:

- *InvigorationPotion:* se caracteriza por ser una poción defensiva de manera que el
personaje que la usa aumenta sus puntos defensivos (*defensive*) en 1.4 veces.
- *FelixFelicisPotion:* se caracteriza por ser una poción ofensiva de manera que el personaje
que la usa aumenta sus puntos ofensivos (*offensive*) en 1.3 veces.
