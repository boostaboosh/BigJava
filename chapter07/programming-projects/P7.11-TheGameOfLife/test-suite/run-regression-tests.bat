# To be run from inside the run-regression-tests.bat directory
# in order to prevent compiled java class files being generated
# in new and unintended directories outside 
# of the project directory.

# Compile all java files in the src directory 
# and place compiled java class files in 
# the "../out/production/P7.11-TheGameOfLife/" directory.
# And ensure the compiled class files are compatible with JDK 11, 
# both in terms of language features and available APIs.
javac --release 11 -d "../out/production/P7.11-TheGameOfLife/" ../src/*.java

# After compilation run tests using input and output files
# by running the class files for each test.

# has alive edge cells tests
java -cp "../out/production/P7.11-TheGameOfLife/" HasAliveEdgeCellsTester < hasAliveEdgeCellsFalseTestInput.txt > hasAliveEdgeCellsFalseTestOutput.txt
java -cp "../out/production/P7.11-TheGameOfLife/" HasAliveEdgeCellsTester < hasAliveEdgeCellsTrueTestInput.txt > hasAliveEdgeCellsTrueTestOutput.txt

# get next generations tests
java -cp "../out/production/P7.11-TheGameOfLife/" GetNextGenerationTester < getNextGenerationNoEdgeCellsGameTestInput.txt > getNextGenerationNoEdgeCellsGameTestOutput.txt
java -cp "../out/production/P7.11-TheGameOfLife/" GetNextGenerationTester < getNextGenerationStaticAliveEdgeCellsGameTestInput.txt > getNextGenerationStaticAliveEdgeCellsGameTestOutput.txt
java -cp "../out/production/P7.11-TheGameOfLife/" GetNextGenerationTester < getNextGenerationDynamicAliveEdgeCellsGameTestInput.txt > getNextGenerationDynamicAliveEdgeCellsGameTestOutput.txt

# glider gun game expected output test
java -cp "../out/production/P7.11-TheGameOfLife" GetNextGenerationTester < getNextGenerationGliderGunTestInput.txt > getNextGenerationGliderGunTestOutput.txt
