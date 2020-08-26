package lesson_4;

import java.util.Scanner;

public class lesson_4 {
    public static void main(String[] args) {
        PlayTicTacToe();
    }
    static void PlayTicTacToe() {
        char[][] field = GetField();
        char PlayerSign = 'X';
        char ComputerSign = '0';
        boolean isWin = true;
        Boolean IsWant = true;
        char CurrentPlayerSign = PlayerSign;
        String CurrentPlayerName = "Игрок";
        WelcomingAndRules(field);
        do {
            MovePlayer(field, PlayerSign);
            DrawField(field);
            isWin = CheckWin(field, CurrentPlayerSign, CurrentPlayerName);
            if (CheckDraw(field)) {
                break;
            }
            MoveSmartComputer(field, ComputerSign, PlayerSign);
            DrawField(field);
            if (CheckWin(field, CurrentPlayerSign, CurrentPlayerName)) {
                break;
            }
            if (!isWin) {
                CurrentPlayerSign = CurrentPlayerSign == PlayerSign ? ComputerSign : PlayerSign;
                CurrentPlayerName = CurrentPlayerSign == PlayerSign ? "игрок" : "компьютер";
            }
            isWin = CheckWin(field, CurrentPlayerSign, CurrentPlayerName);


        } while (!isWin);
    }

    static boolean CheckDraw(char[][] field) {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field.length; j++) {
                if (field[i][j] == '-') {
                    return false;
                }
            }
        }
        System.out.println("Ничья");
        return true;
    }


    static boolean CheckWin(char[][] field, char CurrentPlayerSign, String CurrentPlayerName) {
        if (CheckWinVertical(field, CurrentPlayerSign, CurrentPlayerName)) {
            return true;
        } else if (CheckWinHorizontal(field, CurrentPlayerSign, CurrentPlayerName)) {
            return true;
        } else if (CheckWinDiagonal(field, CurrentPlayerSign, CurrentPlayerName)) {
            return true;
        }
        return false;
    }

    static boolean CheckWinDiagonal(char[][] field, char CurrentPlayerSign, String CurrentPlayerName) {
        if (field[0][0] == CurrentPlayerSign && field[1][1] == CurrentPlayerSign && field[2][2] == CurrentPlayerSign) {
            System.out.println(String.format("Победил %s", CurrentPlayerName));
            return true;
        } else if (field[2][0] == CurrentPlayerSign && field[1][1] == CurrentPlayerSign && field[0][2] == CurrentPlayerSign) {
            System.out.println(String.format("Победил %s", CurrentPlayerName));
            return true;
        }
        return false;
    }

    static boolean CheckWinVertical(char[][] field, char CurrentPlayerSign, String CurrentPlayerName) {
        for (int j = 0; j < field.length; j++) {
            if (field[0][j] == CurrentPlayerSign && field[1][j] == CurrentPlayerSign && field[2][j] == CurrentPlayerSign) {
                System.out.println(String.format("Победил %s", CurrentPlayerName));
                return true;
            }
        }
        return false;
    }

    static boolean CheckWinHorizontal(char[][] field, char CurrentPlayerSign, String CurrentPlayerName) {
        for (int i = 0; i < field.length; i++) {
            if (field[i][0] == CurrentPlayerSign && field[i][1] == CurrentPlayerSign && field[i][2] == CurrentPlayerSign) {
                System.out.println(String.format("Победил %s", CurrentPlayerName));
                return true;
            }
        }
        return false;
    }

    static void WelcomingAndRules(char[][] field) {
        System.out.println("Привет! Предлагаю тебе сыграть в крестики и нолики.Это будет схватка века!");
        DrawField(field);
        System.out.println("Поле игры имеет свои координаты соответствующие x и y.\nx - вертикаль.\ny - горизонталь.");
        System.out.println("Отсчет ведется:\nx : сверху вниз\ny : слева направо ");
    }

    static void MovePlayer(char[][] field, char PlayerSign) {
        Scanner scanner = new Scanner(System.in);
        int x;
        int y;
        do {
            do {
                System.out.print("Твой ход!\nВведи координату x [1, 2, 3]:");
                x = scanner.nextInt() - 1;
                System.out.print("Введи координату y [1, 2, 3]:");
                y = scanner.nextInt() - 1;
                if (!checkCoordinates(x, y)) {
                    System.out.println(String.format("Ячейка с координатами [%s, %s] находится вне игрового поля", x + 1, y + 1));
                }
            } while (!checkCoordinates(x, y));
            if (!IsOccupiedCoordinate(field, x, y)) {
                System.out.println(String.format("Ячейка с координатами [%s, %s] уже занята", x + 1, y + 1));
            }
        } while (!IsOccupiedCoordinate(field, x, y));
        field[x][y] = PlayerSign;
    }

    static boolean checkCoordinates(int x, int y) {
        return (x >= 0 && x <= 2) && (y >= 0 && y <= 2);
    }

    static boolean IsOccupiedCoordinate(char[][] field, int x, int y) {
        return field[x][y] == '-';
    }


    static void DrawField(char[][] field) {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field.length; j++) {
                System.out.print(field[i][j] + " ");
            }
            System.out.println();
        }
    }

    static char[][] GetField() {
        return new char[][]{
                {'-', '-', '-'},
                {'-', '-', '-'},
                {'-', '-', '-'}
        };
    }

    // *** Доработать искусственный интеллект, чтобы он мог блокировать ходы игрока.
    static void MoveSmartComputer(char[][] field, char ComputerSign, char PlayerSign) {
        int WinCombinationVertical = 0;
        int WinCombinationHorizontal = 0;
        int WinCombinationMainDiagonal = 0;
        int WinCombinationDiagonal = 0;
        int DoesItExistVertical = 0;
        int DoesItExistHorizontal = 0;
        int DoesItExistDiagonal = 0;
        for (int n = 0; n < field.length; n++) {
            WinCombinationVertical = 0;
            for (int i = 0; i < field.length; i++) {
                if (field[i][n] == PlayerSign) {
                    WinCombinationVertical++;
                    if (WinCombinationVertical == 2) {
                        for (int j = 0; j < field.length; j++) {
                            if (field[j][n] == '-') {
                                field[j][n] = ComputerSign;
                                DoesItExistVertical++;
                                System.out.println("Ход компьтера...");
                                System.out.println(String.format("Компьютер выбрал координаты: [%s ; %s]", i + 1, j + 1));
                                break;
                            }
                        }
                        if (DoesItExistVertical == 1) {
                            break;
                        }
                    }
                }
            }
            if (DoesItExistVertical == 1) {
                break;
            }
        }
        if (DoesItExistVertical != 1) {
            for (int i = 0; i < field.length; i++) {
                WinCombinationHorizontal = 0;
                for (int n = 0; n < field.length; n++) {
                    if (field[i][n] == PlayerSign) {
                        WinCombinationHorizontal++;
                        if (WinCombinationHorizontal == 2) {
                            for (int j = 0; j < field.length; j++) {
                                if (field[i][j] == '-') {
                                    field[i][j] = ComputerSign;
                                    DoesItExistHorizontal++;
                                    System.out.println("Ход компьютера...");
                                    System.out.println(String.format("Компьютер выбрал координаты: [%s ; %s]", i + 1, j + 1));
                                    break;
                                }
                            }
                            if (DoesItExistHorizontal == 1) {
                                break;
                            }
                        }

                    }
                }
                if (DoesItExistHorizontal == 1) {
                    break;
                }
            }
            if (DoesItExistHorizontal != 1) {
                WinCombinationMainDiagonal = 0;
                for (int i = 0; i < field.length; i++) {
                    if (field[i][i] == PlayerSign) ;
                    WinCombinationDiagonal++;
                }
                if (WinCombinationMainDiagonal == 2) {
                    for (int i = 0; i < field.length; i++) {
                        if (field[i][i] == '-') {
                            field[i][i] = ComputerSign;
                            System.out.println("Ход компьютера...");
                            System.out.println(String.format("Компьютер выбрал координаты: [%s ; %s]", i + 1, i + 1));
                        }
                    }
                }
            }
            if (WinCombinationMainDiagonal != 1) {
                WinCombinationDiagonal = 0;
                for (int i = 0; i < field.length; i++) {
                    if (field[2 - i][i] == PlayerSign) {
                        WinCombinationDiagonal++;
                    }
                }
                if (WinCombinationDiagonal == 2) {
                    for (int i = 0; i < field.length; i++) {
                        if (field[2 - i][i] == '-') {
                            field[2 - i][i] = ComputerSign;
                            DoesItExistDiagonal++;
                            System.out.println("Ход компьютера...");
                            System.out.println(String.format("Компьютер выбрал координаты: [%s ; %s]", 2 - i + 1, i + 1));
                        }
                    }
                }
            }
            if (DoesItExistDiagonal != 1 && DoesItExistHorizontal != 1 && DoesItExistVertical != 1) {
                int x;
                int y;
                System.out.println("Ход компьютера...");
                do {
                    x = (int) (Math.random() * 3);
                    y = (int) (Math.random() * 3);
                } while (!IsOccupiedCoordinate(field, x, y));
                field[x][y] = ComputerSign;
                System.out.println(String.format("Компьютер выбрал координаты: [%s ; %s]", x + 1, y + 1));
            }
        }
    }
}

