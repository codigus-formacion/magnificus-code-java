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
        - del mal al bien y/o alternativas
    - Con dominio: 
        - Ejemplo: Plataforma educativa
        - EJERCIICO: Marcador de Tenis por comandos/menu
        - EJERCICIO: Gestor de Servicios con intervalos de horas y grado de satisfacción para distintos días o intervalos de días del año o periódicas por cada cliente: colisiones, informes, ...

CONCLUSIONES

- Programación
    - Mecanismos de Reusabilidad: comparativa
        - Genericidad/Parametrización
            - reusa estructura de código salpicado de variables de tipo abiertas a cualquier tipo concreto
                - estruturas de datos y 
                - algoritmos con jerarquía de estrcturas de control de flujo de ejecucuión
            - 5%, raro pero con una EFECTIVIDAD!!! vs 50% por cada Interfaz Funcional
            - si se complica ... con código por composicion y herencia
        - Herencia/Clasificación 
            - reusa código "rigido/estático"
            - 20%, habitual pero muy sencilla 
            - si se complica ... por composición+herencia con código "flexible/dinámico"!
        - Compisición/Agregación/Jeraquía 
            - reusa código "flexible/dinámico"
            - 75% de modelo del dominio y por Patrón Adapter
            - ... no se complica, tritura y jerarquiza hasta encontrar el orden!!! Principios!!!
    - Mecanismos de Ocultación: modulo, paquete, clase, interna, local, anónima, función!! reglas de ámbito con azucar sintáctico!!!
    - Jerarquía (expresiones, sentencias, clases por composición/herencia en paquetes) de Vistas (Menu, Formularios, Dialogos) "paralela" a Jerarquía de Colecciónes/Flujos de Entidades/Valores!!!

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
                : relaciones: jerarquía de colaboración(composición, asociación genericidad)
                    < Principio de Jerarquización
                    < Principio de Dominio
                    < Principio de la Tecnología
        - Principio de Extensibilidad: jeraquía de clasificacion(genericidad)
                > Generalización
                > Especialización
                > Sustitución
    - Patrones de Diseño
        - Patrón Facade (Console)
        - Patrón Singleton (Console)
        - Patrón Bridge (jerarquía de vistas y modelos)
        - Patrón Template Method (100 casos en dialogo, interval, collections, ...)
        - Patrón Iterator (cada colección)
        - Patrón Decorator (especialización por colaboración, Dialogo delegado)
        - Patrón Composite (Opción y Menú)
        - Patrón Command (Opción)
        - Patrón Strategy (Cada Predicado, Consumer, ...)
        - ... 
    - Arquitectura del Software: Capas MVC con Jerarquía de Composición de Jerarquías de Clasificación de Clases Encarnables
        - Arquitectura Documento-Vista: "expuesta"
        - Arquitectura MVC: 
            - Modelo: entidades
                - Origen: Principio de Dominio
                - Acoplado: Modelos 
            - Vista: tecnologías
                - Origen: Principio de Tecnología (interfaz de usuario menu/cli texto/gráfico)
                - Responsabilidad: enviar peticiones correctas del cliente al controlador
                - Acoplado: Controladores y Modelos devueltos opcionalmente
            - Controlador: 
                - Origen:   
                    - Principio de Desacoplamiento: 
                        - vista está enfocada a tecnologías de entrada/salida del cliente!!!
                        - controlador está enfocado a tecnologías de entrada/salidad de los servicios!!!
                    - Principio de Unificación: varias vistas realizan las mismas consultas y actuliazaciónes de los modelos, recuperan y persisten, logs, ...
                - Responsabilidad: reglas del negocio: CRUD de modelos del dominio como intermediario entre Vistas y Modelos colaborando con otros servicios => Facade
                - Acoplado: 
                    - FrontEnd:
                        - Vistas: Menu, Dialgos, ..., DIV, FORM, ..., frame, window, ... 
                            - Acceso al Usuario: grafico, texto, gadgets, ...
                            - Auxiliares: Math, Colorator, Events, Layaouts, ...
                        - Controlador: 
                            - Agrupado por pantallas/modelos
                            - Acceso al Backend (proxy de TCP/IP, HTTP, ...)
                            - Auxiliares: DAO, File, ...
                        - Modelos y Colecciones, Values, Error, ... 
                    - BackEnd:                         
                        - Vistas: resources, controller?!?!?!?, dispatcher, ...  
                            - Acceso del Backend: HTTP, TCP/IP, ...
                            - Auxiliares: ... DTO, ... Mapper, ... 
                        - Controlador: services, ...
                            - Acceso a Persistencia/... (proxy a SQL, NotSQL, files, ...)
                            - Auxiliares: DAO, ResultSet, ..., permisos, logs, ... 
                                - Principio de Extensibilidad!!! 
                        - Modelos y Colecciones, Entity, Value, Error, ...
                    - Monolito
                        - Vistas: del Front sin "proxy" (controlador del frontend)
                        - Controlador: del Backend sin "adapter" (vista del backend)
                        - Modelos
            - Jerarquía en capas MVC
                - Modelo 
                    - Modelo - Modelo
                        - Lista - Nodo - Entidad - Valor, ...
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
                - Android: Entitiy + Activity + Controler
                - Angular: HTML + CSS + Controller
                - React: Componente + JSX + CSS+Hook
                    - Jerárquico: componentes MVC - componente MVC, ...
            - Estilos
                - MVP con Presentador: "expuesta"
                - MVP con Controlador Supervisor/Vista Pasiva: alternativas por Inversión de control (cliente->colaborador vs colaborador->client)
                        - Patrones Obeservador
                        - ...

- Funciones Lambda
    - Dónde? Ámbito de aplicación:
        - Modelo ... con colecciones
        - Controladores para consultas!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! 
        - Vistas ... con colecciones
    - Cuánto? aprox-aprox 30% de esfuerzo de implementación (30% proyecto) => 9% proyecto!!!
    - Qué? 
        - Programación Funciónal/Declarativa(Lógica) vs Imperativa?!? 
            - Transparencia Referencial vs Opacidad Referencial
                - Funcional: Sin mutabilidad, sin variables, ... todo simbolos asociados a constantes
                - Java+Lambdas: objetos mutables, locales mutables, ...?!?!
            - Expresiones vs Sentencias
                - Funcional: Sin tiempo, sin secuencia, sin alternativas, sin bucles, ... todo recursividad mediante el operador if, no sentencia!
                - Java+Lambdas: sentencia secuencial y más allá?!?!
        - Orientada a Funciones o a Objetos inmutables con métodos "return ? " recursivos!!!!!!!
    - Ventajas
        - Principio de Legibildad: se simplifica todo
            - Principio de Unicidad: se secuencializa!!!! todo
            - Principio de Uniformidad: programación declarativa!!!!?
            - Principio de Minimización: sin verbosidad se secuencializa!!!! todo
        - Principio de Modularidad: cosifición/acción/ ... partir más! Patrón Visitor!!!
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
    - Conclusion: 
        - Nombre y descripción muy muy confusas, ... falsas, marketing??!?
        - Está más o menos bien pero 
            - no arregla un proyecto ... 
            - la experiencia más bien es contraproducente ... muy dependiente del nivel cultural
        - prudencia, ... equilibrio!!! me dejaría arrastrar!!!

