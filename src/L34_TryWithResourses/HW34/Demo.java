package L34_TryWithResourses.HW34;

public class Demo {
    public static void main(String[] args) throws Exception {
        // Solution.transferFileContent("C:/Users/slash22/Desktop/test1.txt",
        //  "C:/Users/slash22/Desktop/test225.txt");
       // TransSentences.transferSentences("C:/Users/slash22/Desktop/test1.txt",
               // "C:/Users/slash22/Desktop/test225.txt","Proverka");

        CopyFileCont.copyFileContent("C:/Users/slash22/Desktop/test.txt",
                "C:/Users/slash22/Desktop/test1.txt");
      CopyFileCont.copyFileContentApacheIO("C:/Users/slash22/Desktop/apa1.txt",
               "C:/Users/slash22/Desktop/apa2.txt");
    }
}
