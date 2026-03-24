# sudoku-solver
A Java Swing desktop app that solves any valid Sudoku puzzle using a recursive backtracking algorithm.

# Sudoku Solver

A Java desktop application that solves any valid Sudoku puzzle using a recursive backtracking algorithm, with an interactive GUI built using Java Swing.

---

## Preview

> Enter your puzzle into the 9×9 grid, click **Solve**, and watch it fill in instantly.

---

## Features

- Interactive 9×9 grid for entering puzzles
- Instant solving using a recursive backtracking algorithm
- Clean, minimal Swing-based GUI
- Alerts the user if no solution exists

---

## Getting Started

### Prerequisites

- Java JDK 8 or higher

### Running the App

1. **Clone the repository**
   ```bash
   git clone https://github.com/your-username/sudoku-solver.git
   cd sudoku-solver
   ```

2. **Compile the source file**
   ```bash
   javac Sudoku.java
   ```

3. **Run the application**
   ```bash
   java Sudoku
   ```

---

## How to Use

1. Launch the app — a 9×9 grid will appear.
2. Enter the known numbers from your puzzle into the corresponding cells. Leave unknown cells blank.
3. Click the **Solve** button.
4. The completed puzzle will fill in automatically.
5. If the puzzle has no valid solution, a dialog will notify you.

---

## How It Works

The solver uses a **backtracking algorithm** — a classic depth-first search approach:

1. Scan the board for the first empty cell.
2. Try placing digits 1–9 in that cell.
3. Check if the digit is valid (no conflicts in the row, column, or 3×3 box).
4. If valid, place the digit and recurse to the next empty cell.
5. If no digit works, backtrack to the previous cell and try the next option.
6. Repeat until the board is fully solved or all possibilities are exhausted.

---

## Project Structure

```
sudoku-solver/
└── Sudoku.java       # Main application file (GUI + solver logic)
```

---

## Built With

- **Java** — core language
- **Java Swing** — GUI framework
- **AWT** — layout management

---

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

---

## Acknowledgements

- Backtracking algorithm inspired by classic constraint satisfaction problem techniques
- Built as a portfolio/learning project to demonstrate algorithm implementation and GUI development in Java
