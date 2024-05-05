# compile source class files and put in directory d
javac --release 11 -d "../out/production/E8.4" ../src/*.java

# compile test class and put in directory d, 
# I need to specify where the class files of the classes used by the class I am compiling are, 
# that's what the -classpath option is for
javac -classpath "../out/production/E8.4:/Users/loz/.m2/repository/junit/junit/4.13.1/junit-4.13.1.jar:/Users/loz/.m2/repository/org/hamcrest/hamcrest-core/1.3/hamcrest-core-1.3.jar" --release 11 -d "../out/test/E8.4" ./*.java

# run compiled test files, i.e., the class files we compiled
# redirect input from test input.txt
# ReaderTest is a JUnit test class, not a Java application with a main method,
# so to run it I need to use a JUnit test runner command instead of the java command.
# The org.junit.runner.JUnitCore command is the correct approad for running tests that do not have a main method.
java -classpath "../out/test/E8.4:../out/production/E8.4:/Users/loz/.m2/repository/junit/junit/4.13.1/junit-4.13.1.jar:/Users/loz/.m2/repository/org/hamcrest/hamcrest-core/1.3/hamcrest-core-1.3.jar"  org.junit.runner.JUnitCore ReaderTest < ReaderTestInput.txt > ReaderTestOutput.txt
