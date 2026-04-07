# MTS TECH TASK - REST Сервис с маршрутизацией данных

## Описание

REST сервис на Spring Boot, который принимает POST запросы и распределяет данные между N базами данных PostgreSQL по алгоритму модуля (`type % N`).

## Технологии

- Java 21
- Spring Boot 3.4.4
- Spring JDBC (JdbcTemplate)
- PostgreSQL 16
- Docker / Docker Compose
- Swagger / OpenAPI (springdoc)
- Lombok


### Алгоритм маршрутизации
```
type % 3 = 0  →  db1
type % 3 = 1  →  db2
type % 3 = 2  →  db3
```



## Запуск через Docker (рекомендуется)

### 1. Требования

- Docker
- Docker Compose

### 2. Клонировать репозиторий
```bash
git clone https://github.com/sanyochek58/MTS_Task.git
cd MTS_Task
```

### 3. Создать `.env` файл в корне проекта
```bash
DB1_USERNAME=postgres1
DB1_PASSWORD=secret1

DB2_USERNAME=postgres2
DB2_PASSWORD=secret2

DB3_USERNAME=postgres3
DB3_PASSWORD=secret3
```

### 4. Запустить
```bash
docker-compose up --build
```

Сервис запустится на `http://localhost:8080`

## Запуск локально (без Docker)

### 1. Требования

- Java 21
- Maven
- PostgreSQL (3 экземпляра на портах 5432, 5433, 5434)

### 2. Создать `.env` файл
```bash
DB1_URL=jdbc:postgresql://localhost:5432/db1
DB1_USERNAME=postgres
DB1_PASSWORD=secret1

DB2_URL=jdbc:postgresql://localhost:5433/db2
DB2_USERNAME=postgres
DB2_PASSWORD=secret2

DB3_URL=jdbc:postgresql://localhost:5434/db3
DB3_USERNAME=postgres
DB3_PASSWORD=secret3
```

### 3. Создать таблицу в каждой БД
```sql
CREATE TABLE IF NOT EXISTS data_records (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    type INTEGER NOT NULL,
    random_text VARCHAR(255) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
```

### 4. Запустить
```bash
./mvnw spring-boot:run
```

## API

### POST /api/data

Сохраняет запись в одну из БД в зависимости от значения `type`.

**Request:**
```json
{
  "type": 1,
  "randomText": "example text"
}
```

**Responses:**

| Статус | Описание |
|--------|----------|
| 201 | Запись успешно сохранена |
| 400 | Невалидные данные |
| 500 | Внутренняя ошибка сервера |

## Swagger UI

После запуска документация доступна по адресу:
```
http://localhost:8080/swagger-ui
```

## Тесты
```
./mvnw test
```