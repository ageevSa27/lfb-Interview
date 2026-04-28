# Deal REST API Service

## API Endpoints

### POST `/api/deals` - Создание сделки

**Request DTO:**

```json
{
  "title": "string (required, not blank)",
  "description": "string",
  "amount": "number",
  "customerName": "string",
  "customerEmail": "string (email format)",
  "status": "string (NEW, CLOSED)"
}
```

**Response DTO (201 Created):**

```json
{
  "id": "long",
  "title": "string",
  "description": "string",
  "amount": "double",
  "status": "string",
  "customerName": "string",
  "customerEmail": "string",
  "createdAt": "datetime",
  "updatedAt": "datetime"
}
```

### GET `/api/deals` - Получение всех сделок

**Response DTO (200 OK):**

```json
[
  {
    "id": "long",
    "title": "string",
    "description": "string",
    "amount": "double",
    "status": "string",
    "customerName": "string",
    "customerEmail": "string",
    "createdAt": "datetime",
    "updatedAt": "datetime"
  }
]
```