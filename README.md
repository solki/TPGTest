# TPGTest
## Q1
* There is only one class file, `IPValidationRegex.class`, being compiled from its source file, `IPValidationRegex.java`.
* `InputIPs.txt` is the sample input file with a list of IP addresses. Put input file in the same directory where `IPValidationRegex.class` is.
* Run the test program in the format `java IPValidationRegex [file name]`. Let the name of input file be the only command line argument. For example `java IPValidationRegex InputIPs.txt`.

## Q2
* There are two class files,`Student.class` and `Student$1.class`, being compiled from their source file, `Student.java`.
* `InputStudents.txt` is the sample input file with a list of students' information. Put input file in the same directory where `Student.class` is.
* Run the test program in the format `java Student [file name]`. Let the name of input file be the only command line argument. For example `java Student InputStudents.txt`.

## Q3
* There is only one class file, `MethodTimer.class`, being compiled from its source file, `MethodTimer.java`.
* Run the test program without command `java MethodTimer`.
* There is a small snip of code in the main method for simulating executing an independent method.
* Usage of the class  
    MethodTimer timer = new MethodTimer();  
    timer.start();  
    
    // Method();  
    
    timer.stop();  
    if (timer.getProcessTime() < 0L) {  
      System.out.println("Timer is not working properly");  
    } else {  
      System.out.println("The time consumed for this method is " + timer.getProcessTime() + " milliseconds.");  
    }  
