# **Chess Game Low-Level Design (LLD)**  

## **Problem Statement**  
The objective of this project is to implement a **Chess Game** using **Object-Oriented Programming (OOP)** principles in Java. This low-level design focuses on creating a modular, scalable, and maintainable architecture for the game, ensuring that key chess functionalities are encapsulated within well-defined classes and components.  

The chess game allows two players to take turns, moving pieces according to standard chess rules, and determines the game's status dynamically based on moves and win conditions.  

---

## **Scope**  
This project provides the low-level architecture required to build the core functionalities of a chess game. It focuses on:  
1. **Player Management**: Two players, Black and White, alternate turns.  
2. **Chessboard Representation**: The board is an 8x8 grid composed of cells, each holding a piece or remaining empty.  
3. **Piece Movement**: Movement rules for chess pieces, such as `Pawn`, `Rook`, `Knight`, `Bishop`, `Queen`, and `King`.  
4. **Game State Management**: Tracks the game's progress, including turn management and game-ending conditions like checkmate or stalemate.  
5. **Move Validation**: Ensures each move adheres to chess rules.  

---

## **Requirements**  

### **Functional Requirements**  
- **Player Management**: Supports two players, alternating turns.  
- **Move Validation**: Validates moves according to chess rules.  
- **Game State**: Tracks game progress (`ACTIVE`, `PAUSED`, `CHECKMATE`, etc.).  
- **Win Conditions**: Determines the winner or stalemate conditions dynamically.  

### **Non-Functional Requirements**  
- **Scalability**: Future-ready for AI-based opponents or online multiplayer.  
- **Performance**: Validates moves and updates the board in real-time.  
- **Maintainability**: Uses modular OOP principles for easy debugging and enhancements.  

---

## **Class Overview**  

| **Class Name**       | **Description**                                                                 |
|-----------------------|---------------------------------------------------------------------------------|
| **Chess**            | Main controller for the game. Manages the chessboard, players, and game status. |
| **ChessBoard**       | Represents the 8x8 chessboard as a grid of `Cell` objects.                      |
| **Cell**             | Represents a square on the chessboard. Holds the piece occupying the cell.      |
| **Player**           | Represents a player and tracks their color and account information.             |
| **Piece (Abstract)** | Parent class for all chess pieces. Subclasses define movement rules.             |
| **Move**             | Captures details of a move, including start and end positions and captured pieces. |
| **Enums**            | `Color` (Black, White) and `GameStatus` (Active, Checkmate, etc.).              |

---

## **Key Features**  

### **Chess Class**  
- **Responsibilities**:  
  - Manages game flow, including turn switching and move validation.  
  - Tracks game state (`ACTIVE`, `PAUSED`, `CHECKMATE`).  
- **Core Methods**:  
  - `playerMove(from, to, piece): boolean`  
  - `changeTurn(): void`  
  - `endGame(): boolean`  

### **ChessBoard Class**  
- **Responsibilities**:  
  - Maintains the state of the board (8x8 grid).  
  - Updates the board after each move.  
- **Core Methods**:  
  - `resetBoard(): void`  
  - `updateBoard(Move move): void`  

### **Piece Class (and Subclasses)**  
- **Responsibilities**:  
  - Implements movement rules for chess pieces.  
  - Subclasses like `Pawn`, `Rook`, and `King` define specific move validation.  
- **Core Method**:  
  - `validate(from, to): boolean`  

---

## **Code Snippets**  

### **1. Player Move Validation in Chess Class**
```java
public boolean playerMove(CellPosition from, CellPosition to, Piece piece) {
    if (piece.validate(from, to)) {
        chessBoard.updateBoard(new Move(currentPlayer, piece, from, to));
        changeTurn();
        return true;
    }
    return false;
}
