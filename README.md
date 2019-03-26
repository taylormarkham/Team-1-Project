# Apocalypse Chess
 Group 1 – Tutorial 1:
Taylor Markham, 
James Liu, 
Leanard Valencia, 
Nasima Dahir, 
Serenity Wellman

Game Description:
Apocalypse Chess is a variant off of the regular chess game. It is played with two players on a 5x5 board, and the only pieces in use are pawns and knights. Pawns can only move in the forward direction by 1 space and only if that space is empty. They may move diagonally by 1 space only if their opponent has a piece on that spot. This is how a pawn can take one of its opponents pieces. If a pawn reaches the opposite side of the board, then it is changed to a knight. Knight move in an “L”-shape. That is, they can move forward or back 2 spaces followed by 1 space to the side, or they can move 2 spaces to the side and then forward or back by 1 space. In Apocalypse chess, the players make their moves at the same time without knowing where their opponent is going to move. If the two players land on the same spot and both pieces are the same, then the two pieces are removed from the board. If the player’s move to the same spot, but one of the pieces is a knight and the other a pawn then the knight takes the pawn. The game is over when one of the players have lost all of their pawns.
This game includes a textbased version as well as a GUI version. Both versions have the options to play human vs. human, or human vs. computer. In addition, the GUI version has the option to change the colour of the background.

To install and play the game:
-	If Java is not already installed on your computer, then go to https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html to download. Follow the link to download and setup Java 8 development kit for the appropriate system.
-	Once Java has been installed, download the zip file containing the game classes. Ensure that all of the files are in the same folder and you know it’s location on your computer.
-	Open the command prompt. Use the relevant commands to change the directory so that you are in the directory containing the game files. Type “javac  *.java” to compile all of the files.
-	To run the GUI version: type “java GameGUI” into the command prompt. A window will come up which runs the GUI version of Apocalypse. There will be a start screen where the user can choose their opponent and an options menu where they can change the colour of the background. To move the pieces in the GUI version, the user must click and hold the piece they want to move, drag it to the desired spot and release the mouse to drop the piece into position. 
-	To run the text-based version: type “java Game” into the command prompt. The game will now appear on the command prompt. Follow the instructions on screen to play.

Contributors:
James Liu – GameGUI, and Game classes
Taylor Markham – Move, GameConfig, Game, and HumanPlayer classes
Leanard Valencia – HumanPlayer class, class diagrams
Nasima Dahir – ComputerPlayer class
Serenity Wellman – GameConfig class
However, all members provided additional help and suggestions for other parts as needed.

References: 
These references were used for the duration of the time spent working on our project. 
1. Apocalypse (chess variant). (2018, November 02). Retrieved from https://en.wikipedia.org/ wiki/Apocalypse_(chess_variant)                                                                                              This reference was used to learn the game, and the specific rules. It helped us gain a basic and fundamental understanding of how the game is played. 
2. GeeksforGeeks. (2017, November 23). Difference between == and .equals() method in Java. Retrieved from https://www.geeksforgeeks.org/difference-equals-method-java/ 
3. Savitch, W. (2018). Java: An Introduction to Problem Solving and Programming(8th Edition). University of California, San Diego : Pearson. Retrieved from https:// www.pearson.com/us/higher-education/program/Savitch-Java-An-Introduction-to-ProblemSolving-and-Programming-Plus-My-Lab-Programming-with-Pearson-e-Text-Access-CardPackage-8th-Edition/PGM1743310.html      The textbook was used to learn the fundamentals of coding and how to structure the code.  
4. Evans, Elliot. (2017). Play Apocalypse Chess. Retrieved from http://apocalypsechess.online/ This is an online version of the game, which was used to play the game and also gain an       understanding of the game.  
5. Verwaal, Nathaly, (2019) Java and JavaFX. In 219: CPSC (Introduction to Computer Science for Multidisciplinary Studies II: WINTER 2019 [Lecture Notes]. Retrieved from https://d2l.ucalgary.ca/d2l/le/content/252622/Home 
