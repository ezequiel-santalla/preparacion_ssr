# preparacion_ssr

Repositorio de práctica para la preparación de la evaluación **SSR Java**. Cada
semana se agrega una carpeta `sN_<topico>` enfocada en un tema, dentro de un
mismo proyecto Spring Boot. Cada proyecto es pequeño pero apunta a ejercitar en
profundidad una skill concreta.

## Objetivo

El plan está organizado alrededor de los ejes técnicos que suele cubrir una
evaluación de seniority para Java Developer Junior/Semisenior:

- **Skills de especialidad** — núcleo técnico de Java (el de mayor peso).
- **Skills técnicas comunes** — habilidades transversales (testing, SQL,
  patrones, CI/CD, cloud, etc.).
- **Skills generales** — soft skills y management (no se practican con código; se
  trabajan en el simulacro y en el día a día).

La meta es cubrir, con un proyecto demostrable por tema, **todas las skills
técnicas relevantes**.

## Itinerario

Ordenado para ir de fundamentos del lenguaje → calidad → concurrencia y Java
moderno → Spring y persistencia → DevOps → simulacro.

### Bloque 1 — Fundamentos del lenguaje

| # | Tema | Proyecto | Skills cubiertas | Estado |
|---|------|----------|---------------------|--------|
| S1 | Streams & Lambda | 🎾 Ranking de tenis | Java 8+ / Lambda (Stream API) | ✅ |
| S2 | OOP + SOLID | 🚗 Concesionaria | Java OO capabilities, OOP, Clean Code | ⬜ |
| S3 | Design Patterns | 🍕 Pizzería | Design Patterns | ⬜ |
| S4 | Collections (profundo) | 🏆 Torneo deportivo | Collections | ⬜ |
| S5 | Core Classes + IO/NIO | 📁 Gestor de archivos | Core Classes, IO | ⬜ |
| S6 | Recursión & algoritmos | 🧩 Laberinto / parser | Recursive algorithms | ⬜ |

### Bloque 2 — Calidad

| # | Tema | Proyecto | Skills cubiertas | Estado |
|---|------|----------|---------------------|--------|
| S7 | Unit Testing + TDD/ATDD | 🏦 Transferencias bancarias | Unit Testing, TDD-ATDD | ⬜ |

### Bloque 3 — Concurrencia & Java moderno

| # | Tema | Proyecto | Skills cubiertas | Estado |
|---|------|----------|---------------------|--------|
| S8 | Concurrencia | 🏪 Caja de supermercado | Concurrent programming | ⬜ |
| S9 | Java 17 / 21 | 📦 Seguimiento de envíos | Java 17 / Java 21 | ⬜ |

### Bloque 4 — Spring & persistencia

| # | Tema | Proyecto | Skills cubiertas | Estado |
|---|------|----------|---------------------|--------|
| S10 | AOP + Logging | 📋 Clínica con auditoría | AOP, Logging | ⬜ |
| S11 | JPA/ORM + SQL profundo | 🛒 Órdenes de compra | JDBC/JPA/ORM, SQL | ⬜ |
| S12 | NoSQL | 🗃️ Catálogo + caché | No SQL (Redis / Mongo) | ⬜ |
| S13 | Spring Batch | 📊 Procesamiento de facturas | Batch application development | ⬜ |
| S14 | JMS / Kafka | 📨 Sistema de notificaciones | JMS | ⬜ |

### Bloque 5 — DevOps & cierre

| # | Tema | Proyecto | Skills cubiertas | Estado |
|---|------|----------|---------------------|--------|
| S15 | CI/CD + Docker + Cloud | ☁️ Deploy de un proyecto previo | CI/CD, Cloud, Code Repository | ⬜ |
| S16 | Simulacro de entrevista | 🎯 Entrevista simulada + UML | General Skills, UML, repaso integral | ⬜ |

## Skills transversales

Algunas skills no tienen semana propia porque se ejercitan en **todos** los
proyectos:

- **Java - Spring** (Core, DI, Boot, MVC, Data, REST/Swagger) — toda la práctica
  es una app Spring Boot REST.
- **Web application framework (MVC)** — presente en cada API.
- **Code Repository (Git)** — flujo de commits/push en este repo.
- **Clean Code (SOLID, DRY, KISS, YAGNI)** — se aplica en cada semana; se
  profundiza en S2.
- **Language Fundamentals** (tipos, operadores, autoboxing) — base de todo.
- **UML** — documentar con diagramas a medida que crecen los proyectos; foco en
  S16.

## Detalle por semana (checklist)

Lo que conviene dominar al cerrar cada semana.

### S1 — Streams & Lambda 🎾 ✅
- [x] `filter`, `map`, `sorted`, `limit`, method references
- [x] `mapToLong`/`average`, `findFirst`, `max`/`min` con `Comparator`
- [x] `groupingBy` + downstream (`counting`, `summingLong`, `mapping`)
- [x] `allMatch` / `noneMatch`, grouping anidado
- [ ] Pendiente de práctica: `partitioningBy`, `flatMap`, `teeing`,
      `summarizingLong` / `DoubleSummaryStatistics`, `Collectors.joining`

### S2 — OOP + SOLID 🚗
- [ ] Encapsulamiento, herencia, polimorfismo, abstracción
- [ ] Clases abstractas vs interfaces, clases internas/anónimas, `final`
- [ ] Overloading vs overriding, `super`, casting
- [ ] Los 5 principios SOLID aplicados (no solo nombrados)
- [ ] Refactor de "code smells" hacia un diseño limpio

### S3 — Design Patterns 🍕
- [ ] Creacionales: Factory, Builder, Singleton
- [ ] Estructurales: Adapter, Decorator
- [ ] De comportamiento: Strategy, Observer
- [ ] Reconocer anti-patrones y justificar cuándo aplicar cada patrón

### S4 — Collections (profundo) 🏆
- [ ] `List` (ArrayList vs LinkedList), `Set` (HashSet/TreeSet/LinkedHashSet)
- [ ] `Map` (HashMap/TreeMap/LinkedHashMap)
- [ ] `Comparable` vs `Comparator`, `equals`/`hashCode`
- [ ] Complejidad (Big-O) de cada estructura y cuándo elegir cada una
- [ ] Colecciones inmutables y `Collections` utils

### S5 — Core Classes + IO/NIO 📁
- [ ] `String`, `StringBuilder`/`StringBuffer`, wrappers, parsing de números
- [ ] Fechas (`LocalDate`/`LocalDateTime`), formateo
- [ ] IO clásico: streams de bytes y de caracteres, buffers, serialización
- [ ] NIO: `Path`/`Files`, lectura/escritura, glob patterns
- [ ] Manejo y liberación de recursos (`try-with-resources`)

### S6 — Recursión & algoritmos 🧩
- [ ] Caso base y caso recursivo; recursión vs iteración
- [ ] Recursión de cola (tail recursion) y límites de stack
- [ ] Divide & conquer, recursión binaria, recorrido de árboles
- [ ] Ejemplos: recorrido de un laberinto, parser de expresiones, fractales

### S7 — Unit Testing + TDD/ATDD 🏦
- [ ] JUnit 5: ciclo de vida, asserts, parametrizados
- [ ] Mockito: mocks, stubs, `verify`, argument captors
- [ ] Ciclo TDD red-green-refactor
- [ ] ATDD: leer una user story y derivar criterios de aceptación
- [ ] Cobertura y test de casos límite / excepciones
- [ ] Volver a S1 y agregarle tests retroactivos

### S8 — Concurrencia 🏪
- [ ] Ciclo de vida de `Thread`, daemon threads
- [ ] `ExecutorService` / thread pools, `Future`/`CompletableFuture`
- [ ] Colecciones concurrentes
- [ ] Sincronización: `synchronized`, locks, `volatile`, variables atómicas
- [ ] `CountDownLatch`, `join`/`wait`/`notify`, condiciones de carrera

### S9 — Java 17 / 21 📦
- [ ] Pattern matching (`instanceof`, `switch`)
- [ ] Sealed classes, records, text blocks
- [ ] Virtual threads (Java 21) y comparación con threads de plataforma
- [ ] Scoped values, novedades de la API

### S10 — AOP + Logging 📋
- [ ] `@Aspect`, advices (`@Before`, `@After`, `@Around`), pointcuts, weaving
- [ ] Aspecto de auditoría que registra accesos/cambios
- [ ] Logback: niveles por paquete, appenders a consola y archivo
- [ ] MDC con `correlationId`/`userId` por request
- [ ] Logs estructurados en JSON (pensando en ELK) y qué NO loguear

### S11 — JPA/ORM + SQL profundo 🛒
- [ ] Mapeo de entidades y relaciones (1:1, 1:N, N:M)
- [ ] Fetching (lazy/eager), estados de entidad, transacciones
- [ ] JPQL/HQL y queries nativas
- [ ] SQL a mano: joins, subqueries, índices, stored procedures, `EXPLAIN`
- [ ] Caching y batch executions; observar el SQL generado (`show-sql`)

### S12 — NoSQL 🗃️
- [ ] Concepto SQL vs NoSQL y cuándo usar cada uno
- [ ] Redis: caché, expiración, pub/sub
- [ ] (Opcional) MongoDB: documentos, queries, Spring Data Mongo

### S13 — Spring Batch 📊
- [ ] Principios batch (bulk, no interactivo, long running)
- [ ] Jobs, steps, `ItemReader`/`ItemProcessor`/`ItemWriter`
- [ ] Job repository, chunk processing, reinicio y monitoreo

### S14 — JMS / Kafka 📨
- [ ] Conceptos: colas vs topics, productores/consumidores
- [ ] Connection factories, filtrado en topics
- [ ] Apache Kafka: topics, particiones, grupos de consumidores

### S15 — CI/CD + Docker + Cloud ☁️
- [ ] GitHub Actions: workflow que corre `mvn test` en cada push
- [ ] Pipeline build → test → empaquetado
- [ ] Dockerfile y `docker compose` para levantar la app + DB
- [ ] Deploy de un proyecto a un free tier (Render / Railway / Fly.io)

### S16 — Simulacro de entrevista 🎯
- [ ] Diagramas UML (clases, secuencia) de un proyecto previo
- [ ] Repaso integral y preguntas tipo entrevista por skill
- [ ] Practicar la comunicación de decisiones técnicas (General Skills)

## Estructura de cada semana

Cada carpeta `sN_<topico>` sigue una organización por capas:

```
sN_<topico>/
├── controller/      # Interfaces de controllers + impl/
├── service/         # Interfaces de services + impl/
├── repository/
├── model/
├── mapper/          # MapStruct
├── dto/
│   ├── request/
│   └── response/
└── enums/
```

> No todas las semanas usan todas las capas (p. ej. recursión o concurrencia
> pueden ser más algorítmicas). Se adapta según el tema.

## Stack

- Java + Spring Boot (Maven)
- MapStruct para el mapeo DTO ↔ entidad
- H2 (en memoria) para las semanas que requieren persistencia simple

## Cómo correr

```bash
./mvnw spring-boot:run
```

> Nota: al convivir varias semanas en el mismo proyecto, para levantar una
> semana puntual revisá su `application.properties` y posibles conflictos de
> beans entre paquetes.
