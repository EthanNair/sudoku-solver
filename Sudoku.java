import javax.swing.*;
import java.awt.*;

public class Sudoku extends JFrame {
    private static final int SIZE = 9;
    private JTextField[][] cells = new JTextField[SIZE][SIZE];

    public Sudoku() {
        setTitle("Sudoku Solver");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel gridPanel = new JPanel(new GridLayout(SIZE, SIZE));
        Font font = new Font("SansSerif", Font.BOLD, 20);

        // Create 9x9 grid
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                cells[row][col] = new JTextField();
                cells[row][col].setHorizontalAlignment(JTextField.CENTER);
                cells[row][col].setFont(font);
                gridPanel.add(cells[row][col]);
            }
        }

        JButton solveButton = new JButton("Solve");
        solveButton.addActionListener(e -> {
            int[][] board = new int[SIZE][SIZE];
            for (int row = 0; row < SIZE; row++) {
                for (int col = 0; col < SIZE; col++) {
                    String text = cells[row][col].getText();
                    board[row][col] = text.isEmpty() ? 0 : Integer.parseInt(text);
                }
            }

            if (solveSudoku(board)) {
                updateBoard(board);
            } else {
                JOptionPane.showMessageDialog(this, "no solution");
            }
        });

        add(gridPanel, BorderLayout.CENTER);
        add(solveButton, BorderLayout.SOUTH);
        setSize(500, 500);
        setVisible(true);
    }

    private void updateBoard(int[][] board) {
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                cells[row][col].setText(Integer.toString(board[row][col]));
            }
        }
    }

    // Sudoku solving logic
    private boolean solveSudoku(int[][] board) {
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                if (board[row][col] == 0) {
                    for (int num = 1; num <= SIZE; num++) {
                        if (isSafe(board, row, col, num)) {
                            board[row][col] = num;
                            if (solveSudoku(board)) return true;
                            board[row][col] = 0; // Backtrack
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isSafe(int[][] board, int row, int col, int num) {
        for (int i = 0; i < SIZE; i++) {
            if (board[row][i] == num || board[i][col] == num)
                return false;
        }
        int boxRowStart = row - row % 3;
        int boxColStart = col - col % 3;
        for (int i = boxRowStart; i < boxRowStart + 3; i++) {
            for (int j = boxColStart; j < boxColStart + 3; j++) {
                if (board[i][j] == num)
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Sudoku::new);
    }
}