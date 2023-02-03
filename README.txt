README

I am using java as programming language in this project.

Please compile and execute programs as follows,

Part-1:

MiniMaxOpening:

Please give input in file MiniMaxOpening-Input.txt. And your output will be shown on console and also will be stored in file MiniMaxOpening-Output.txt.
Please give the depth as command line argument while executing the program.

Compile:
javac MiniMaxOpening.java

Execution:(java programName inputFileName outputFileName depth)
java MiniMaxOpening MiniMaxOpening-Input.txt MiniMaxOpening-Output 5


MiniMaxGame:

Please give input in file MiniMAX_MidEndGame_Input.txt. And your output will be shown on console and also will be stored in file MiniMAX_MidEndGame_Output.txt.
Please give the depth as command line argument while executing the program.

Compile:
javac MiniMaxGame.java

Execution:
java MiniMaxGame MiniMAX_MidEndGame_Input.txt MiniMAX_MidEndGame_Output.txt 5



Part-2:

ABOpening:

Please give input in file AB_Opening_Input.txt. And your output will be shown on console and also will be stored in file AB_Opening_Output.txt.
Please give the depth as command line argument while executing the program.

Compile:
javac ABOpening.java

Execution:
java ABOpening AB_Opening_Input.txt AB_Opening_Output.txt 5


ABGame:

Please give input in file AB_MidEndGame_Input.txt. And your output will be shown on console and also will be stored in file AB_MidEndGame_Output.txt.
Please give the depth as command line argument while executing the program.

Compile:
javac ABGame.java

Execution:
java ABGame AB_MidEndGame_Input.txt AB_MidEndGame_Output.txt 5



Part-3:

MiniMaxOpeningBlack:

Please give input in file MiniMaxOpening-Black-Input.txt. And your output will be shown on console and also will be stored in file MiniMaxOpening-Black-Output.txt.
Please give the depth as command line argument while executing the program.

Compile:
javac MiniMaxOpeningBlack.java

Execution:
java MiniMaxOpeningBlack MiniMaxOpening-Black-Input.txt MiniMaxOpening-Black-Output.txt 5


MiniMaxGameBlack:
Please give input in file MiniMaxMidEnd-Black-Input.txt. And your output will be shown on console and also will be stored in file MiniMaxMidEnd-Black-Output.txt.
Please give the depth as command line argument while executing the program.


Compile:
javac MiniMaxGameBlack.java

Execution:
java MiniMaxGameBlack MiniMaxMidEnd-Black-Input.txt MiniMaxMidEnd-Black-Output.txt 5



Part-4:

MiniMaxOpeningImproved:

Please give input in file MiniMaxOpeningImproved-Input.txt. And your output will be shown on console and also will be stored in file MiniMaxOpeningImproved-Output.txt.
Please give the depth as command line argument while executing the program.

Compile:
javac MiniMaxOpeningImproved.java 

Execution:
java MiniMaxOpeningImproved MiniMaxOpeningImproved-Input.txt MiniMaxOpeningImproved-Output.txt 5


MiniMaxGameImproved:

Please give input in file MiniMaxGameImproved-Input.txt. And your output will be shown on console and also will be stored in file MiniMaxGameImproved-Output.txt.
Please give the depth as command line argument while executing the program.

Compilation:
javac MiniMaxGameImproved.java 

Execution:
java MiniMaxGameImproved MiniMaxGameImproved-Input.txt MiniMaxGameImproved-Output.txt 5

Improvement logic used:
In part-4 to improve our program I added number of possible mills possible for each position for our static estimation function Thus our program will select the path that has more number of possible mills. I think this would improve our program as prioritizing paths with more number of mills will raise our chances of winning.



NOTE: Input files should just have board position like below. Please note to use small x not Capital X. For while and black positions please use capital W and capital B.

xWxxxWxxBxxxxxBxxx


Results:

Please check Results excel attached to see results for different inputs and cases where alpha-beta performed better than minimax. And cases where our Improved program returned improved results 



















