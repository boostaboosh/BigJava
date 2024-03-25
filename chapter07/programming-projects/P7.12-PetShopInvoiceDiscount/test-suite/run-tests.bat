# compile java source files and translate into class file, i.e., java bytecode
javac --release 11 -d "../out/production/P7.12-PetShopInvoiceDiscount" ../src/*

# run tests using input files and output to output files
java -cp "../out/production/P7.12-PetShopInvoiceDiscount" InvoiceDiscountTester < getDiscountTestInput.txt > getDiscountTestOutput.txt
