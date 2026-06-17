# DotComBust Game

A classic, text-based battleship-style terminal game written in Java. Players attempt to sink three virtual "Dot Com" companies hidden on a grid by guessing their locations in the fewest moves possible.

---

## 🎮 Game Rules & Mechanics

The game initializes three Dot Com targets, each occupying three sequential or unique grid cells:
* **Pets.com**
* **eToys.com**
* **Go2.com**

Every turn, you will be prompted to enter a guess representing a cell location. 
* **Hit:** You successfully hit a part of a living Dot Com.
* **Miss:** Your guess did not match any remaining active Dot Com locations.
* **Kill:** You successfully hit the final remaining location of a Dot Com, sinking it completely.

The game concludes when all three Dot Coms have been destroyed. Your final score is determined by the total number of guesses taken.

---

## 🛠️ Tech Stack & Architecture

* **Language:** Java (JDK 8 or higher recommended)
* **Input Handling:** `java.util.Scanner`
* **Data Structures:** `java.util.ArrayList` (utilized for dynamic array scaling and effortless target removal upon a "kill")

### Component Breakdown

### 1. `DotCom.java`
Represents an individual target company. It maintains state metadata including the company name and an `ArrayList<String>` of its assigned grid cells. It contains the core logic (`checkYourself`) to determine if a user's guess results in a hit, miss, or kill.

### 2. `DotComBust.java`
Acts as the main game controller. It handles game setup, maintains the master list of active targets, manages user input via a command-line loop, tracks overall statistics (guess count), and processes state changes when a company is completely sunk.

---

## 🚀 How to Run

### Prerequisites
Ensure you have the Java Development Kit (JDK) installed on your machine. You can verify this by running:
```bash
java -version
