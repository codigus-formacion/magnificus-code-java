# Programación Orientada a Objetos

## Herencia por Extensión
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
            - LinkedList<T>  
                - Node<T> 
                - Iterator<T> 
            - LinkedSet<T> 
    - values
        - Pair<K,V> 
        - Optional<T> 
        - Fraction 
        - Date
        - Time
        - Interval<T> *
        - DoubleInterval -> Principio de Unicidad *
        - FractionInterval -> Principio de Unicidad *
        - ... -> Principio de Unicidad!
    - view
        - dialog
            - collection
                - list
                    - LinkedListDialog<T> *
                    - StringLinkedListDialog *
                    - IntegerLinkedListDialog *
                    - FractionIntervalLinkedListDialog *
                    - FractionIntervalLinkedListLinkedListDialog *
                    - ... 
            - values
                - FractionDialog *
                - DateDialog *
                - TimeDialog *
                - IntervalDialog<T> *
                - DoubleIntervalDialog *
                - FractionIntervalDialog *
                - ...  
            - primitive
                - Console
                - Dialog<T> *
                - SecuenceDialog<T>
                - IntDialgog *
                - DoubleDialog *
                - ... 

- sustituye composicion por herencia en dialogos e intervalos
- Lista: centinela EJERCICIO!!!!!

## Polimorfismo

- Menú: Option<T>
- Intervalo: Optional (abierto/cerrado) EJERCICIO

## Herencia por Implementación

- Colección: polimorfismo en app
- Fraction: Comparable
## Clases Genéricas y Herencia

- Intervalo: T extends Comparable 2
- Menú: Option<T extends Option>
## Clases Anidadas y Herencia
### Clases Anónimas

- Menú: derivadas anónimas y locales
- LinkedList: mapper, confusion, ...
### Funciones Lambda


- Menú: derivadas flecha
- LinkedList: mapper, confusion, ...


