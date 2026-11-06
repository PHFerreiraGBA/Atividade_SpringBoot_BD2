# postgisSpringBootAPI

Projeto exemplo, com uso de postgis, para a disciplina de banco de dados II.

---

## Integrantes do Projeto

- **François de Araújo Amaro**
- **Pedro Henrique Ferreira da Costa**

---

## Visão Geral

Extensão do projeto base para implementação e validação de consultas espaciais avançadas com Spring Boot 3, Hibernate Spatial e PostGIS, manipulando geometrias reais de aeroportos, rodovias e ferrovias.

## Endpoints das 5 Consultas Espaciais

### 1. Rodovias próximas a um aeroporto específico
- **Rota:** `GET /api/rodovias/proximas-aeroporto/{aeroportoId}`
- **Parâmetros:**
  - `aeroportoId` (path): Identificador do aeroporto (ex: `1`)
  - `distanciaMetros` (query): Raio de busca em metros (ex: `50000`)
- **Operação Espacial:** `ST_DWithin` com projeção métrica EPSG:3857

### 2. Ferrovias próximas a um aeroporto específico
- **Rota:** `GET /api/ferrovias/proximas-aeroporto/{aeroportoId}`
- **Parâmetros:**
  - `aeroportoId` (path): Identificador do aeroporto (ex: `1`)
  - `distanciaMetros` (query): Raio de busca em metros (ex: `100000`)
- **Operação Espacial:** `ST_DWithin` com projeção métrica EPSG:3857

### 3. Rodovias que cruzam com ferrovias
- **Rota:** `GET /api/rodovias/cruzam-ferrovias`
- **Operação Espacial:** `ST_Intersects` identificando intersecção física entre malhas lineares

### 4. Ferrovias próximas a rodovias
- **Rota:** `GET /api/ferrovias/proximas-rodovias`
- **Parâmetros:**
  - `distanciaMetros` (query): Distância métrica limite (ex: `5000`)
- **Operação Espacial:** `ST_DWithin` entre entidades lineares

### 5. Rodovia mais próxima de um aeroporto específico
- **Rota:** `GET /api/rodovias/mais-proxima-aeroporto/{aeroportoId}`
- **Parâmetros:**
  - `aeroportoId` (path): Identificador do aeroporto (ex: `1`)
- **Operação Espacial:** `ST_Distance` com ordenação ascendente e limite de 1 registro

## Como Executar e Testar

1. Iniciar a aplicação via terminal:
   ```zsh
   mvn spring-boot:run

http://localhost:8080/swagger-ui/index.html