package Lesson16.HW17.ValidateAddress;

/**
 * Created by slash22 on 19.04.2018.
 */

//   http://www.test.com --->http://test.com
//   http://test.com   valid
//   http://www.test@.com  valid
//   http://wwwtest.com

public class Demo {
    public static void main(String[] args) {
    Solution solution = new Solution();
    //System.out.println(solution.validate(""));
   // System.out.println(solution.validate(null));

    System.out.println(solution.validate("http://test com.org"));
    System.out.println(solution.validate("http://www.test com"));
    System.out.println(solution.validate("http://www.test_com"));
    System.out.println(solution.validate("http://www.test/com"));
    System.out.println(solution.validate("http://www.test.com"));
    System.out.println(solution.validate("http://www.test.com.org"));
    System.out.println(solution.validate("http://test.com"));
    System.out.println(solution.validate("http://www.test@%.com.net"));
    System.out.println(solution.validate("http://wwwtest.com"));
    System.out.println(solution.validate("https://test1.com"));
    }
}
