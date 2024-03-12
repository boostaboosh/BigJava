# Compile all Java files in the src folder. The compiled class files will be placed in the ../out/production/P7.10-VideoPokerSimulator/ directory.
javac -d "../out/production/P7.10-VideoPokerSimulator/" src/*.java

# After compilation, run the TwoPairsScoreTest class. The classpath is set to the directory containing the compiled class files.
# The output of the test is redirected to a file named twoPairsScoreTestOutput.txt.
java -cp "../out/production/P7.10-VideoPokerSimulator/" TwoPairsScoreTest > tests/twoPairsScoreTestOutput.txt

java -cp "../out/production/P7.10-VideoPokerSimulator/" FullHouseScoreTest > tests/fullHouseScoreTestOutput.txt

java -cp "../out/production/P7.10-VideoPokerSimulator/" StraightScoreTest > tests/straightScoreTestOutput.txt

java -cp "../out/production/P7.10-VideoPokerSimulator/" FlushScoreTest > tests/flushScoreTestOutput.txt
