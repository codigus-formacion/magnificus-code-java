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
- Jerarquías de clasificación de Dialog

- sustituye composicion por herencia en dialogos e intervalos EJERCICIO!!!!!
- Lista: centinela EJERCICIO!!!!!
- Lista: ordenada EJERCICIO!!!!!

## Polimorfismo

- app
    - collection
        - LinkedListApp -> Principio de Unicidad!!
        - FractionApp -> Principio de Unicidad!!
        - TntervalApp -> Principio de Unicidad!!
        - TimeApp -> Principio de Unicidad!!
        - PrimitiveApp -> Principio de Unicidad!!
        - ... -> Principio de Unicidad!!
    - service
        - Service *
        - ServiceDialog *
        - ServiceApp *
        - ServiceMenu *
- util
    - collection
        - list
            - LinkedList<T>  
                - Node<T> 
                - Iterator<T> 
        - set
            - LinkedSet<T> 
        - map
            - LinkedMap<K,V>
    - values
        - Pair<K,V> 
        - Optional<T> 
        - Fraction 
        - Date
        - Time
        - Interval<T> 
        - DoubleInterval -> Principio de Unicidad 
        - FractionInterval -> Principio de Unicidad 
        - ... -> Principio de Unicidad!
    - view
        - dialog
            - collection
                - list
                    - LinkedListDialog<T> 
                    - StringLinkedListDialog 
                    - IntegerLinkedListDialog 
                    - FractionIntervalLinkedListDialog 
                    - FractionIntervalLinkedListLinkedListDialog 
                    - ... 
            - values
                - FractionDialog 
                - DateDialog 
                - TimeDialog 
                - IntervalDialog<T> 
                - DoubleIntervalDialog 
                - FractionIntervalDialog 
                - ...  
            - primitive
                - Console
                - Dialog<T> 
                - SecuenceDialog<T>
                - IntDialgog 
                - DoubleDialog 
                - ... 
        - menu
            - Menu<T> *
            - QuitMenu<T> *
            - IterativeMenu<T> *
            - DynamicMenu<T> *
            - Option<T> *
            - QuitOption<T> *


- Menú: con alternativo, escape, iterativo y dinámico con Option<T>

- Form: con menu iterativo con opción por campo (editar) mediante dialog / y con algún campo enumerado para no escribir, solo escoger(menú alternativo) EJERCICIO!!!!!
- Intervalo: Optional (abierto/cerrado) EJERCICIO!!!

## Herencia por Implementación

- app
    - collection
        - LinkedListApp -> Principio de Unicidad!! *
        - FractionApp -> Principio de Unicidad!!
        - TntervalApp -> Principio de Unicidad!!
        - TimeApp -> Principio de Unicidad!!
        - PrimitiveApp -> Principio de Unicidad!!
        - ... -> Principio de Unicidad!!
    - service
        - Service *
        - ServiceDialog *
        - ServiceApp 
        - ServiceMenu *
- util
    - collection
        - list
            - LinkedList<T> *
        - set
            - LinkedSet<T> *
        - map
            - LinkedMap<K,V>
        - Colection<T> *
        - Node<T> *
        - Iterator<T> *
    - values
        - Pair<K,V> 
        - Optional<T> 
        - Fraction 
        - Date
        - Time
        - Interval<T> 
        - DoubleInterval -> Principio de Unicidad 
        - FractionInterval -> Principio de Unicidad 
        - ... -> Principio de Unicidad!
    - view
        - dialog
            - collection
                - list
                    - LinkedListDialog<T> 
                    - StringLinkedListDialog 
                    - IntegerLinkedListDialog 
                    - FractionIntervalLinkedListDialog 
                    - FractionIntervalLinkedListLinkedListDialog 
                    - ... 
            - values
                - FractionDialog 
                - DateDialog 
                - TimeDialog 
                - IntervalDialog<T> 
                - DoubleIntervalDialog 
                - FractionIntervalDialog 
                - ...  
            - primitive
                - Console
                - Dialog<T> 
                - SecuenceDialog<T>
                - IntDialgog 
                - DoubleDialog 
                - ... 
        - menu
            - Menu<T> *
            - QuitMenu<T> *
            - IterativeMenu<T> *
            - DynamicMenu<T> *
            - Option *
            - QuitOption *

- Menú y options por composición con polimorfismo por implementación!!!!
- Collection con filter Predicate: Conjunto y Lista

- Lista: array en clase con interfaz EJERCICIO!!!!!
- Dialog: checker EJERCICIO!!!!!

## Clases Genéricas y Herencia

- app
    - collection
        - LinkedListApp -> Principio de Unicidad!! 
        - FractionApp -> Principio de Unicidad!!
        - TntervalApp -> Principio de Unicidad!!
        - TimeApp -> Principio de Unicidad!!
        - PrimitiveApp -> Principio de Unicidad!!
        - ... -> Principio de Unicidad!!
    - service
        - Service 
        - ServiceDialog 
        - ServiceApp 
        - ServiceMenu 
- util
    - collection
        - list
            - LinkedList<T> *
        - set
            - LinkedSet<T> *
        - map
            - LinkedMap<K,V>
        - Colection<T> *
        - Node<T> 
        - Iterator<T> 
    - values
        - Pair<K,V> 
        - Optional<T> 
        - Fraction 
        - Date
        - Time
        - Interval<T extends Comparable<T>> *
        - DoubleInterval *
        - FractionInterval *
        - ... 
    - view
        - dialog
            - collection
                - list
                    - LinkedListDialog<T> 
                    - StringLinkedListDialog 
                    - IntegerLinkedListDialog 
                    - FractionIntervalLinkedListDialog 
                    - FractionIntervalLinkedListLinkedListDialog 
                    - ... 
            - values
                - FractionDialog 
                - DateDialog 
                - TimeDialog 
                - IntervalDialog<T> 
                - DoubleIntervalDialog 
                - FractionIntervalDialog 
                - ...  
            - primitive
                - Console
                - Dialog<T> 
                - SecuenceDialog<T>
                - IntDialgog 
                - DoubleDialog 
                - ... 
        - menu
            - Menu<T> 
            - QuitMenu<T> 
            - IterativeMenu<T> 
            - DynamicMenu<T> 
            - Option 
            - QuitOption 

- Intervalo: Interval<T extends Comparable>

- Distribuidor: <T extends Pesable> ... EJERCICIO!!!!!


## Clases Anidadas y Herencia
### Clases Anónimas

- Menú: derivadas anónimas y locales
- LinkedList: mapper, confusion, ...
### Funciones Lambda


- Menú: derivadas flecha
- LinkedList: mapper, confusion, ...


