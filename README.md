# Submersible Probe Control System

This project is a RESTful API designed to control a submersible probe on a 2D ocean grid. The system supports directional movement, obstacle detection, and maintains a log of visited coordinates.

---

## 🧰 Tech Stack

- **Java 17+**
- **Spring Boot**
- **JUnit 5**
- **Maven**
- **RESTful APIs**

---

## 🚀 Features

- Navigate a grid using movement commands: `F` (forward), `B` (backward), `L` (left), `R` (right)
- Detect and avoid obstacles
- Record all visited coordinates
- Validate boundaries based on max X and Y limits
- Fully tested with JUnit

---

## 📦 API Endpoints

### `POST /api/probe/commands`

**Description:** Process movement commands and return final position and path.

**Request Body:**
```json
{
  "startX": 0,
  "startY": 0,
  "startDirection": "NORTH",
  "maxX": 5,
  "maxY": 5,
  "commands": "FFRFFLBB",
  "obstacles": ["1,2", "3,3"]
}
```

**Response**
```json
{
  "finalX": 2,
  "finalY": 1,
  "finalDirection": "NORTH",
  "visitedCoordinates": [
    "(0,0)", "(0,1)", "(0,2)", "(1,2)", "(2,2)", "(2,1)"
  ]
}
```

📝 Author
Vishwa Shah
