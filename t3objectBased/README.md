# Programación Basada en Objetos


## Miembros de Instancia

[Miembros de Instancia](./u1instance.plantuml)

- app
    - LinkedListApp -> Principio de Unicidad!!
    - FractionApp -> Principio de Unicidad!!
    - TntervalApp -> Principio de Unicidad!!
    - TimeApp -> Principio de Unicidad!!
    - PrimitiveApp -> Principio de Unicidad!!
    - ... -> Principio de Unicidad!!
- util
    - collection
        - list
            - node ... -> Principio de Unicidad!!! 
            - iterator ... -> Principio de Unicidad!!!
            - StringLinkList -> Principio de Unicidad!!
            - IntegerLinkList -> Principio de Unicidad!!
            - FractionIntervalLinkedList -> Principio de Unicidad!!
            - FractionIntervalLinkedListLinkedList -> Principio de Unicidad!!
            - ... -> Principio de Unicidad!!! ... -> Principio de Unicidad!!! ... -> Principio de Unicidad!!!
    - values
        - Math
        - Fraction
        - Date
        - Time
        - DoubleInterval -> Principio de Unicidad!!
        - FractionInterval -> Principio de Unicidad!!
        - ... -> Principio de Unicidad!!!
    - view
        - dialog
            - collection
                - list
                    - StringLinkListDialog -> Principio de Unicidad!!
                    - IntegerLinkListDialog -> Principio de Unicidad!!
                    - FractionIntervalLinkedListDialog -> Principio de Unicidad!!
                    - FractionIntervalLinkedListLinkedListDialog -> Principio de Unicidad!!
                    - ...  -> Principio de Unicidad!!!
            - values
                - FractionDialog -> Principio de Unicidad!!
                - DateDialog -> Principio de Unicidad!!
                - TimeDialog -> Principio de Unicidad!!
                - FractionDialog -> Principio de Unicidad!!
                - DoubleIntervalDialog -> Principio de Unicidad!!
                - FractionIntervalDialog -> Principio de Unicidad!!
                - ...  -> Principio de Unicidad!!!
            - primitive
                - Console
                - IntDialgog -> Principio de Unicidad!!
                - DoubleDialog -> Principio de Unicidad!!
                - ... -> Principio de Unicidad!!!
## Atritutos
## Métodos
### Sentencia de Retorno
### Parámetros Variables
## Constructores
## Miembros Estáticos

[Miembros Estáticos](./u2static.plantuml)

- app
    - LinkedListApp -> Principio de Unicidad!! *
    - FractionApp -> Principio de Unicidad!! *
    - TntervalApp -> Principio de Unicidad!! *
    - TimeApp -> Principio de Unicidad!! *
    - PrimitiveApp -> Principio de Unicidad!! *
    - ... -> Principio de Unicidad!!
- util
    - collection
        - list
            - node ... -> Principio de Unicidad!!! 
            - iterator ... -> Principio de Unicidad!!!
            - StringLinkList -> Principio de Unicidad!! *
            - IntegerLinkList -> Principio de Unicidad!! *
            - FractionIntervalLinkedList -> Principio de Unicidad!! *
            - FractionIntervalLinkedListLinkedList -> Principio de Unicidad!! *
            - ... -> Principio de Unicidad!! ... -> Principio de Unicidad!!! ... -> Principio de Unicidad!!!
    - values
        - Math *
        - Fraction
        - Date *
        - Time *
        - DoubleInterval -> Principio de Unicidad!!
        - FractionInterval -> Principio de Unicidad!!
        - ... -> Principio de Unicidad!!!
    - view
        - dialog
            - collection
                - list
                    - StringLinkListDialog -> Principio de Unicidad!! *
                    - IntegerLinkListDialog -> Principio de Unicidad!! *
                    - FractionIntervalLinkedListDialog -> Principio de Unicidad!! *
                    - FractionIntervalLinkedListLinkedListDialog -> Principio de Unicidad!! *
                    - ...  -> Principio de Unicidad!!!
            - values
                - FractionDialog -> Principio de Unicidad!! *
                - DateDialog -> Principio de Unicidad!! *
                - TimeDialog -> Principio de Unicidad!! *
                - FractionDialog -> Principio de Unicidad!! *
                - DoubleIntervalDialog -> Principio de Unicidad!! *
                - FractionIntervalDialog -> Principio de Unicidad!! *
                - ...  -> Principio de Unicidad!!!
            - primitive
                - Console
                - IntDialgog -> Principio de Unicidad!! *
                - DoubleDialog -> Principio de Unicidad!! *
                - ... -> Principio de Unicidad!!!
### Métodos Estáticos
### Atributos Estáticos
### Código Estático
### Clases de Biblioteca
#### Clase de Matemáticas
#### Clases de Recubrimiento
#### Clases de Cadenas de Caracteres
#### Clase del Sistema
### Enumerados
### Registros
## Clases Genéricas

[Clases genéricas](./u3generic.plantuml)

- app
    - LinkedListApp -> Principio de Unicidad!!
    - FractionApp -> Principio de Unicidad!!
    - TntervalApp -> Principio de Unicidad!!
    - TimeApp -> Principio de Unicidad!!
    - PrimitiveApp -> Principio de Unicidad!!
    - ... -> Principio de Unicidad!!
- util
    - collection
        - list
            - LinkedList<T>  *
                - Node<T> *
                - Iterator<T> *
            - LinkedSet<T> *
    - values
        - Pair<K,V> *
        - Optional<T> *
        - Fraction *
        - Date
        - Time
        - Interval<T> *
        - DoubleInterval -> Principio de Unicidad! *
        - FractionInterval -> Principio de Unicidad! *
        - ... -> Principio de Unicidad!!
    - view
        - dialog
            - collection
                - list
                    - LinkedListDialog<T> *
                    - StringLinkedListDialog -> Principio de Unicidad! *
                    - IntegerLinkedListDialog -> Principio de Unicidad! *
                    - FractionIntervalLinkedListDialog -> Principio de Unicidad! *
                    - FractionIntervalLinkedListLinkedListDialog -> Principio de Unicidad! *
                    - ...  -> Principio de Unicidad!!
            - values
                - FractionDialog -> Principio de Unicidad *
                - DateDialog -> Principio de Unicidad *
                - TimeDialog -> Principio de Unicidad *
                - IntervalDialog<T> *
                - DoubleIntervalDialog -> Principio de Unicidad *
                - FractionIntervalDialog -> Principio de Unicidad *
                - ...  -> Principio de Unicidad!
            - primitive
                - Console
                - Dialog<T> *
                - IntDialgog -> Principio de Unicidad *
                - DoubleDialog -> Principio de Unicidad *
                - ... -> Principio de Unicidad!

- Result EJERCICIO!!!!
- Coordinate EJERCICIO!!!!
- Intervalo: Optional (infinto) EJERCICIO!!!!
- Map: composición EJERCICIO!!!! ---- hascode?!?!
- EJERCICIO!!!! Lista de doubles Coeficientes: getGradient(), ...

## Clases Anidadas
### Clases Internas
### Clases Locales

[Clases genéricas](./u4nested.plantuml)

- app
    - LinkedListApp -> Principio de Unicidad!!
    - FractionApp -> Principio de Unicidad!!
    - TntervalApp -> Principio de Unicidad!!
    - TimeApp -> Principio de Unicidad!!
    - PrimitiveApp -> Principio de Unicidad!! *
    - ... -> Principio de Unicidad!!
- util
    - collection
        - list
            - LinkedList<T>  *
                - Node<T> *
                - Iterator<T> *
            - LinkedSet<T> 
    - values
        - Pair<K,V> 
        - Optional<T> 
        - Fraction 
        - Date
        - Time
        - Interval<T> 
        - DoubleInterval -> Principio de Unicidad! 
        - FractionInterval -> Principio de Unicidad! 
        - ... -> Principio de Unicidad!!
    - view
        - dialog
            - collection
                - list
                    - LinkedListDialog<T> 
                    - StringLinkedListDialog -> Principio de Unicidad! 
                    - IntegerLinkedListDialog -> Principio de Unicidad! 
                    - FractionIntervalLinkedListDialog -> Principio de Unicidad! 
                    - FractionIntervalLinkedListLinkedListDialog -> Principio de Unicidad! 
                    - ...  -> Principio de Unicidad!!
            - values
                - FractionDialog -> Principio de Unicidad 
                - DateDialog -> Principio de Unicidad 
                - TimeDialog -> Principio de Unicidad 
                - IntervalDialog<T> 
                - DoubleIntervalDialog -> Principio de Unicidad 
                - FractionIntervalDialog -> Principio de Unicidad 
                - ...  -> Principio de Unicidad!
            - primitive
                - Console
                - Dialog<T> 
                - IntDialgog -> Principio de Unicidad 
                - DoubleDialog -> Principio de Unicidad 
                - ... -> Principio de Unicidad!

- Coordinate: Dimension
- Date: Month

