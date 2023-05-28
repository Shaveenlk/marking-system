import java.util.Scanner;



public class Main {
    private static  int[] arr ={0,20,40,60,80,100,120};
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.println("Student version for 1 or staff version 2");
            try {
                int option = input.nextInt();
                switch (option) {
                    case 1:
                        studentversion();
                        break;
                    case 2:
                        staffversion();
                        break;
                    default:
                        System.out.println("Enter the valid option");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Enter the valid option");
                input.nextLine();
            }
        }
    }

    private static void staffversion() {
        int pass_credit = 0;
        int defer_credit = 0;
        int fail_credit = 0;
        String user = "y";
        int progress =0;
        int Exclude =0;
        int trailer =0;
        int retriever =0;

        Scanner input = new Scanner(System.in);
        while (!user.equals("q")) {
            while (true) {
                try {
                    System.out.println("Please enter your credits at pass :");
                    pass_credit = input.nextInt();
                    if (creditsrangechecker(pass_credit) == true) {
                        break;
                    }
                } catch (Exception e) {
                    System.out.println("wrong input");
                    input.nextLine();
                }
            }

            while (true) {
                try {
                    System.out.println("Please enter your credits at defer :");
                    defer_credit = input.nextInt();
                    if (creditsrangechecker(defer_credit) == true) {
                        break;
                    }
                } catch (Exception e) {
                    System.out.println("wrong input");
                    input.nextLine();
                }
            }

            while (true) {
                try {
                    System.out.println("Please enter your credits at fail :");
                    fail_credit = input.nextInt();
                    if (creditsrangechecker(fail_credit) == true) {
                        break;
                    }
                } catch (Exception e) {
                    System.out.println("wrong input");
                    input.nextLine();
                }
            }

            int total = pass_credit + defer_credit + fail_credit;
            if (total != 120) {
                System.out.println("total incorrect");
                continue;
            } else if (pass_credit == 120) {
                System.out.println("Progress");
                System.out.println();
                progress =progress+1;
            } else if ((fail_credit == 100) || (fail_credit == 80) || (fail_credit == 120)) {
                System.out.println("Exclude");
                System.out.println();
                Exclude =Exclude +1;
            } else if (pass_credit == 100) {
                System.out.println("Progress (module trailer)");
                System.out.println();
                trailer =trailer+1;
            } else {
                System.out.println("Module retriever");
                System.out.println();
                retriever =retriever +1;
            }

            while (true) {
                System.out.println("Would you like to enter another set of data?\nEnter 'y' for yes or 'q' to quit and view results:");
                user = input.next();
                if ((user.equals("y") || user.equals("q"))){
                    System.out.println();
                    break;
                }else {
                    System.out.println("wrong input");
                    System.out.println();
                }
            }
        }
        int totaloutcomes = progress + trailer + retriever + Exclude;

        System.out.println("-------------------------------------------------------");
        System.out.println("Histogram");

        printHistogram("Progress", progress);
        printHistogram("Trailer", trailer);
        printHistogram("Retriever", retriever);
        printHistogram("Excluded", Exclude);

        System.out.println();
        System.out.println(totaloutcomes + " outcomes in total.");
        System.out.println("--------------------------------------------------------");
    }


    private static boolean creditsrangechecker ( int Credit){
        for (int element : arr) {
            if (element == Credit) {
                return true;
            }
        }
        System.out.println("wrong range");
        return false;
    }

    public static void printHistogram(String category, int count) {
        String histogram = category + " " + count + "\t: ";
        histogram += "*".repeat(count);
        System.out.println(histogram);
    }
    private static void studentversion () {
    }

}


