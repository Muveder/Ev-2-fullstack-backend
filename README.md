# Backend RedNorte - Microservicios
Estructura del Proyecto
- `citas-bff`: Orquestador de servicios (Puerto 8085).
- `pacientes-ms`: Gestión de pacientes (Puerto 8081).
- `medicos-ms`: Gestión de médicos (Puerto 8082).
- `citas-ms`: Gestión de citas (Puerto 8083).
- `frontend`: Interfaz de usuario (Puerto 5173).

 Instalación y Ejecución
1. Clonar el repositorio.
  
2. Compilar los microservicios:
bash:  ./mvnw clean package -DskipTests

3.Levantar la infraestructura completa con Docker:
Bash: docker-compose up --build
