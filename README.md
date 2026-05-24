# Soccer Project

## Descripción
Aplicación de consola en Java para gestionar equipos y jugadores de fútbol.

## Arquitectura por capas
- presentation
- business
- persistence

## Funcionalidades
- Crear equipos
- Añadir y eliminar jugadores
- Simular partidos
- Persistencia en archivos CSV

## Tecnologías
- Java
- CSV
- Programación Orientada a Objetos (POO)
- Arquitectura por capas

## Estructura del proyecto

```text
soccer/
│
├── data/
│   ├── player.csv
│   └── team.csv
│
├── src/
│   │
│   ├── business/
│   │   ├── PlayerService.java
│   │   └── TeamService.java
│   │
│   ├── persistence/
│   │   ├── PlayerDAO.java
│   │   ├── TeamDAO.java
│   │   ├── PlayerCSV.java
│   │   ├── TeamCSV.java
│   │   ├── PlayerList.java
│   │   └── TeamList.java
│   │
│   ├── presentation/
│   │   ├── Controller.java
│   │   ├── MenuOption.java
│   │   └── UserInterface.java
│   │
│   ├── Player.java
│   ├── Team.java
│   └── Main.java
│
└── README.md
```