# preparacion_ssr

Repositorio de práctica para preparación SSR. Cada semana agrego una carpeta
nueva (`sN_<topico>`) enfocada en un tema distinto, dentro de un mismo proyecto
Spring Boot.

## Índice de semanas

| Semana | Tópico | Carpeta |
|--------|--------|---------|
| S1 | Streams y lambdas (API de tenis) | [`s1_streams_tenis`](src/main/java/com/ezequiel/preparacion_ssr/s1_streams_tenis) |

## Estructura

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

## Stack

- Java + Spring Boot (Maven)
- MapStruct para el mapeo DTO ↔ entidad

## Cómo correr

```bash
./mvnw spring-boot:run
```

> Nota: al convivir varias semanas en el mismo proyecto, para levantar una
> semana puntual revisá su configuración/`application.properties` y posibles
> conflictos de beans entre paquetes.
