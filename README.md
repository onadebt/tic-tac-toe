# Assignment 1 - Tic-Tac-Toe

This application implements Tic-Tac-Toe as a hotseat multiplayer game for minimum of 2 players up to 26 players, with variable board width, height, and winning sequence length (minimum for all is 3). 

Each turn player can execute one of the following moves:
 - Single - place symbol of the player on the board
 - Swap N - swaps random N symbols on the board
 - Place N - places random N symbols on the board
 - Remove N - removes random N symbols from the board
 - Rollback N - rolls back last N turns (where N is <= (number of played turns) / 2)

The game setup and move execution is done on the standard input by entering numbers (according to the instructions on the standard ouput). Errors are displayed on the standard error output. 

 First player who reaches winning sequence length with symbols in horizontal, vertical, or diagonal way wins the game. If there is no remaining empty cell on the board, the game ends as draw.

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

- Filip Fabka (524835)
- Ivan Yatskiv (567817)
- Jakub Španger (524798)
- Vít Falta (524987)