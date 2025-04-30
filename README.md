# Assignment 1 - Tic-Tac-Toe

This application implements Tic-Tac-Toe as a hotseat multiplayer game for minimum of 2 players up to 26 players, with
variable board width, height, and winning sequence length (minimum for all is 3).

Each turn player can execute one of the following moves:

- Single - place symbol of the player on the board
- Swap N - swaps random N symbols on the board
- Place N - places random N symbols on the board
- Remove N - removes random N symbols from the board
- Rollback N - rolls back last N turns (where N is <= (number of played turns) / 2)

The game setup and move execution is done on the standard input by entering numbers (according to the instructions on
the standard ouput). Errors are displayed on the standard error output.

First player who reaches winning sequence length with symbols in horizontal, vertical, or diagonal way wins the game. If
there is no remaining empty cell on the board, the game ends as draw.

## Required Software

- JDK 21

Quick start
-------------------

To run the TicTacToe game run the following command:

```shell
./gradlew run -q --console=plain
```

Run tests
-------------------

To run the provided test suite use the following command:

```shell
./gradlew test
```

## Repository structure

```
.
├── config                  # Static analysis configuration
├── gradle                  # Gradle Wrapper script
├── gradlew                 # Gradle Wrapper script (Windows)
├── gradlew.bat             # Batch script to run Gradle
└── src
    ├── main                # Source files
    └── test                # Unit and E2E tests
```

## Team members (Team 4)

- Filip Fabka
- Ivan Yatskiv
- Jakub Španger
- Vít Falta

## User Guide – CLI Tic-Tac-Toe

### 1  Starting the program

From the project root run:

```bash
./gradlew run -q --console=plain
```

> The first launch may download Gradle dependencies; subsequent runs start instantly.

---

### 2  Setting-up a new game

Immediately after launch the CLI asks four questions; press **Enter** to accept the default in brackets.

| Prompt                                 | Meaning                                          | Allowed values (inclusive) |
|----------------------------------------|--------------------------------------------------|----------------------------|
| **How many players [2]**               | Number of participants                           | 2 – 25                     |
| **Width of the board [3]**             | Horizontal size                                  | 3 – 30                     |
| **Height of the board [3]**            | Vertical size                                    | 3 – 30                     |
| **Length of the winning sequence [3]** | Symbols in a row/column/diagonal required to win | 3 – min(width, height)     |

Invalid input is rejected with a clear one-line explanation and the same prompt is shown again; e.g.

*`There have to be at least 2 players`* or  
*`Minimum width of the board is 3`*

Just type a valid number and press **Enter** to continue.

---

### 3  Taking a turn

The game cycles through the players in order (1 → 2 → … → N → 1).  
On your turn:

1. **Choose a strategy** – a numbered menu appears.  
   *`1 – Single Move`*, `2 – Swap N`, `3 – Place N`, `4 – Remove N`, `5 – Rollback N`.  
   Type the desired number and press **Enter**.
2. **Answer follow-up questions** if the strategy needs parameters (e.g. *Enter row*, *Enter column*, or *How many
   symbols?*).
3. **Board refreshes** immediately so everyone sees the new state.

The built-in validation prevents illegal moves:

| Situation                                  | Error message                                              | What to do                                |
|--------------------------------------------|------------------------------------------------------------|-------------------------------------------|
| Position already occupied                  | *`This cell is already taken. Please choose another one.`* | Enter different row/column numbers        |
| Rollback exceeds limit                     | *`You can only roll back up to ⌊turns/2⌋.`*                | Use a smaller N                           |
| Not enough symbols for *Swap N / Remove N* | *`Not enough symbols on the board for that action.`*       | Pick a lower N or choose another strategy |

---

### 4  Winning, drawing & quitting

* A player wins as soon as they create the configured winning sequence.
* If every cell is full and nobody has a sequence, the game declares a draw.
* Press **Ctrl +C** at any prompt to abandon the current match.

---

### 5  Hints for smooth play

* **Keep numbers small** at first (e.g. 2 players, 3×3 board) to learn the interface.
* **Use advanced moves sparingly**; they can radically change the board and may lengthen the game.
* **Pipe predefined answers** from a file when scripting or running the CI test suite; the program reads from standard
  input exactly the same way it reads from the keyboard.
* **Rollback** can save you from mistakes if you act quickly.
* **Swap**, **Remove**, and **Place** can drastically change the board - use them wisely!
* Focus not only on creating your sequence but also on blocking opponents!

Enjoy experimenting with bigger boards, more players, and the advanced strategies!

### 6. Example play through (3x3 board, 2 players)

Below is an example of a game played by two players on a 3x3 board. The first player uses the symbol 'a' and the second
player uses the symbol 'b'. The winning sequence length is set to 3.

```
Welcome to Tic Tac Toe!
? How many players [default: 2]: 2
? Width of the board [default: 3]: 3
? Height of the board [default: 3]: 3
? Length of the winning sequence [default: 3]: 3

================================

Player 1 turn

? Choose strategy:
1 - Single Move
2 - Rollback
3 - Swap N Move
4 - Remove N
5 - Place N
: 1
   1   2   3
1    |   |  
  ---+---+---
2    |   |  
  ---+---+---
3    |   |  

? Enter row: 1
? Enter column: 1
   1   2   3
1  a |   |  
  ---+---+---
2    |   |  
  ---+---+---
3    |   |  

Player 2 turn

? Choose strategy:
1 - Single Move
2 - Rollback
3 - Swap N Move
4 - Remove N
5 - Place N
: 1
   1   2   3
1  a |   |  
  ---+---+---
2    |   |  
  ---+---+---
3    |   |  

? Enter row: 1
? Enter column: 2
   1   2   3
1  a | b |  
  ---+---+---
2    |   |  
  ---+---+---
3    |   |  

Player 1 turn

? Choose strategy:
1 - Single Move
2 - Rollback
3 - Swap N Move
4 - Remove N
5 - Place N
: 1
   1   2   3
1  a | b |  
  ---+---+---
2    |   |  
  ---+---+---
3    |   |  

? Enter row: 2
? Enter column: 1
   1   2   3
1  a | b |  
  ---+---+---
2  a |   |  
  ---+---+---
3    |   |  

Player 2 turn

? Choose strategy:
1 - Single Move
2 - Rollback
3 - Swap N Move
4 - Remove N
5 - Place N
: 1
   1   2   3
1  a | b |  
  ---+---+---
2  a |   |  
  ---+---+---
3    |   |  

? Enter row: 1
? Enter column: 3
   1   2   3
1  a | b | b
  ---+---+---
2  a |   |  
  ---+---+---
3    |   |  

Player 1 turn

? Choose strategy:
1 - Single Move
2 - Rollback
3 - Swap N Move
4 - Remove N
5 - Place N
: 1
   1   2   3
1  a | b | b
  ---+---+---
2  a |   |  
  ---+---+---
3    |   |  

? Enter row: 3
? Enter column: 1
   1   2   3
1  a | b | b
  ---+---+---
2  a |   |  
  ---+---+---
3  a |   |  

================================

Game over! WINNER: a
```
