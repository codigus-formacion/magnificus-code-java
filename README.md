# magnificus-code-java

## Programa

## [Programación Imperativa](./t2imperative/README.md)

## [Programación Basada en Objetos](./t3objectBased/README.md)

## [Programación Orientada a Objetos](./t4objectOriented/README.md)

## [Programación Modular](./t5modular/README.md)

- Evolución de Teoría
    - Reusabilidad: Principio de Modularidad
        - Composición: 
            - Programación Basada en Objetos
        - Herencia: 
            - Programación Orientada a Objetos
            - Programación Modular
        - Generics: 
            - Programación Basada en Objetos
            - Programación Orientada a Objetos
            - Programación Modular
    - Ocultación "anónima"
        - Modulos
        - Paquetes
        - Internas a Clases
        - Locales a Métodos
        - Clases Anónimas
        - Funciones Lambda
        - Método Referencia

- Evolución de Práctica
    - [Introducción](practica.plantuml)
    - Sin dominio practicar: 
        - con requisitos de teoría futura: colecciones y flujos
        - con el bien y el mal o alternativas
    - Con dominio: 
        - Ejemplo: Plataforma educativa
        - EJERCICIO: Gestor de Servicios con intervalos de horas y grado de satisfacción para distintos días o intervalos de días del año o periódicas por cada cliente: colisiones, informes, ...

CONCLUSIONES

- Programación
    - Aplicación: Colecciónes y flujos!!!
    - Mecanismos de Ocultación: modulo, paquete, clase, interna, local, anónima, función!! azucar sintáctico!!!
    - Mecanismos de Reusabilidad: comparativa
        - Genericidad/Parametrización
            - reusa estructura de código salpicado de variables de tipo abiertas a cualquier tipo concreto
                - estruturas de datos y 
                - algoritmos con jerarquía de estrcturas de control de flujo de ejecucuión
            - 5%, raro pero con una EFECTIVIDAD!!!
            - si se complica ... con código por composicion y herencia
        - Herencia/Clasificación 
            - reusa código "rigido/estático"
            - 20%, habitual pero muy sencilla 
            - si se complica ... por composición+herencia con código "flexible/dinámico"!
        - Compisición/Agregación/Jeraquía 
            - reusa código "flexible/dinámico"
            - 75% de modelo del dominio y por Patrón Adapter
            - ... no se complica, tritura y jerarquiza hasta encontrar el orden!!! Principios!!!

- Diseño
    - Principios de Diseño ... de Información!
        - Principio de Legibilidad: cada linea
            > Principio de Unificación
            > Principio de Uniformización
            > Principio de Minimización
        - Principio de Modularidad: cada modulo (aplicación/componente/paquete/clase/función)
                : interfaz/publico/caja negra
                    < Principio de Abstracción
                    < Principio de Autoprotección
                    < Principio de Ocultación
                : implementación/privado/caja blanca
                    < Principio de Cohesión
                    < Principio de Desacoplamiento
                    < Principio de Granularización
                : relaciones: jerarquía de composición(genericidad)
                    < Principio de Jerarquización
                    < Principio de Dominio
                    < Principio de Tecnología
        - Principio de Extensibilidad: jeraquía de clasificacion(genericidad)
                > Generalización
                > Especialización
                > Sustitución
    - Patrones de Diseño
        - Patrón Builder*
        - Patrón Composite
        - Patrón Singleton
        - Patrón Adapter
        - Patrón Bridge
        - Patrón Command
        - Patrón Iterator
        - Patrón Strategy
        - Patrón Template Method
        - ... 
    - Arquitectura del Software: Capas MVC con Jerarquía de Composición de Jerarquías de Clasificación de Clases Encarnables
        - Arquitectura Documento-Vista: "expuesta"
        - Arquitectura MVC: 
            - Modelo: entidades
                - Origen: Principio de Dominio
                - Acoplado: Modelos 
            - Vista: tecnologías
                - Origen: Principio de Tecnología
                - Acoplado: Controladores y/o Modelos
            - Controlador: intermediario entre Vista y Modelo
                - Origen:   
                    - Principio de Desacoplamiento: la vista está enfocada a tecnologías de entrada/salida y nada más!!!
                    - Principio de Unificación: varias vistas realizan las mismas consultas y actuliazaciónes de los modelos, recuperan y persisten, log, ...
                - Acoplado: 
                    - BackEnd(CRUD): 
                        - Controlador gestión de: 
                            - Persistencia (proxy/base acceso a SQL, NotSQL, ...)
                                - Principio de Extensibilidad
                            - Modelos y Colecciones 
                            - Auxiliares: permisos, logs, ... servicios
                        - Vistas: resources, controller?!?!?!?, ..., dispatcher, ... 
                        - ... DTO, Error, ... Mapper, ... ResultSet, ...
                    - FrontEnd (CRUD):
                        - Controlador gestión de: 
                            - Acceso a Backend (proxy/base acceso REST, GraphQL, ...)
                            agrupado por: 
                                - pantallas en el FrontEnd, donde el controlador atiende peticiones de la vista (interfaz gráfica de usuario, texto -CLI, menu, ...)
                            - Modelos y Colecciones, 
                            - ... Events, Layaouts, ...
                        - Vistas: Dialgos -> form, frame, ..., window, ... 
                        - ... xxx, ... yyy, ...
        - Estilos
            - MVP con Presentador: "expuesta"
            - MVP con Controlador Supervisor/Vista Pasiva: alternativas por Inversión de control (cliente->colaborador vs colaborador->client)
                    - Patrones Obeservador
                    - ...
        - Presencia
            - Modelo 
                - Modelo - Modelo
                    - Lista - Nodo - Entidad - Entidad, ...
            - Controlador 
                - Controlador - Modelo
                    - Controlador - DAO - Entidad, ...
                - Controlador - Controlador
                    - Controlador - Controlador - Mapper, ...
            - Vista 
                - Vista - Vista
                    - Menu - Opción - Dialogo - Dialogo, ...
                    - DIV - DIV - FORM - INPUT, ...
                    - CLI - Command - CLI - Command, ...
                - Vista - Controlador
                - Vista - Modelo
            - Tecnologías:
                - Spring: Entity + Controller + Service
                - Android: Entitiy++ Activity + Controler
                - Angular: HTML + CSS + Controller
                - React: Componente-JSX+CSS+Hook
                    - Jerárquico: componentes MVC - componente MVC, ...



- Funciones Lambda
    - Funciónal/Declarativa(Lógica) vs Imperativo?!?
        - Transparencia Referencial: 
            - Sin mutabilidad, sin variables, ... todo simbolos asociados a constantes
                - Java+Lambdas: objetos mutables?!?!
            - Sin tiempo, sin secuencia, sin alternativas, sin bucles, ... todo recursividad mediante el operador if, no sentencia!
                - Java+Lambdas: sentencia secuencial y más allá?!?!
    - Orientada a Funciones o a Objetos
    - Aplicación funciones Lambda (objeto-función)
        - Ámbito
            - Modelo ... con colecciones
            - Controladores para consultas!!!!!!!! 
            - Vistas ... con coleeciones
            - ... 30% de implementación (30% proyecto) => 9% proyecto!!!
        - Ventajas
            - Principio de Legibildad: se simplifica todo
                - Principio de Unicidad: se secuencializa!!!! todo
                - Principio de Uniformidad: programación declarativa!??!
                - Principio de Minimización: sin verbosidad se secuencializa!!!! todo
            - Principio de Modularidad: cosifición/acción/ ... partir más!
            - Principio de Extensibilidad: polimorfismo por implementacion de interfaces ... Patrón estrategia
        - Desventajas
            - Principio de Legibilidad?!?!?
                - Ejemplo ;})}))}
                - sin explicitar nombre?!?!
            - Principio de Unicidad?!?
                - repite código "a mansalva"?!?! de operativas comunes en distintos controladores sobre los mismos flujos?!?!?
                - paradigma?!?!?
                    - funcional e imperativo?!?
                        - cuando se complica el algoritmo se mezclan for y stream?!?!
                        - constantes efectivas de tipo primitivo pero no los objetos que cuelgan de referencias constantes efectivas: funcional??!
                    - objetos y procesos?!?
                        - parto en 4 el DAO/Dialogo(Input/Label, Lector/Escrito)?!!? 
                        - Había problema, por qué?!?!? 
                            - No pero Principio de Uniformidad al extremo ... 
                                - Vete a C o uno que te permita solo funciones libre ... 
                                - No, me quedo con clases y procesos! Más es más
                                - Por qué 2 organizaciones si con uno se hace todo? Menos es más!!!! Qué criterio para organizar en clase y o proceso?!?!
                                - ... silencio o ejemplos, no un criterio! Know-how 
                                    - arquitectrua hexagonal, clean, onion, ... en vez de pragmática de mvc 
                            - Si la entra y salida son tecnologías completamente dispares
                                - Ok, modulariza y cuando surjan objetos-función disfruta de su sintaxis!!!
        - Conclusion: 
            - Nombre y descripción muy muy confusas, ... falsas, marketing??!?
            - Está más o menos bien pero 
                - no arregla un proyecto ... 
                - la experiencia más bien es contraproducente ... 
                    - por el contexto (nivel cultural)
            - prudencia, ... equilibrio!!! 

