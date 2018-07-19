package Lesson16.HW17.ValidateAddress;

public class Solution {

    //0.  Проверка на нал и на "" +
    //1.  Адрес должен начинаться с протокола https://  https://
    //2 www не обязательно
    //3. Доменная зона должна разделятся точкой, допустимые .com .org .net
    //4. Другие точки в названии адреса а также спецсимволы не допускаются

    //   http://www.test.com ---> http://test.com
    //   http://test.com   valid
    //   http://www.test@.com  valid
    //   http://wwwtest.com


    public boolean validate(String address) {

        if (address == null || address.isEmpty())
            return false;

        address = address.trim();

        if (!countpoint(address))
            return false;

        if (!testdomen(address))
            return false;

        if (!address.endsWith(".net") && !address.endsWith(".org") && !address.endsWith(".com")
                )
            return false;

        if (!address.startsWith("http://") && (!address.startsWith("https://")))
            return false;


        address = address.replaceAll("www.", "");

        //get body

        address = address.replaceAll(".com", "");
        address = address.replaceAll(".org", "");
        address = address.replaceAll(".net", "");
        address = address.replaceAll("http://", "");
        address = address.replaceAll("https://", "");

        return testadr(address);

    }

    private boolean testadr(String middle) {

        char[] chars = middle.toCharArray();

        for (char b : chars) {
            if (!Character.isLetterOrDigit(b))
                return false;
        }
        return true;
    }

    private boolean countpoint(String stroka) {
        char[] chars = stroka.toCharArray();
        int count = 0;
        for (char str : chars) {
            if (str == '.') {
                count++;
            }

        }
        return count > 2 ? false : true;
    }

    private boolean testdomen(String adres) {
        if ((adres.contains("com") && adres.contains("org")) ||
                (adres.contains("net") && adres.contains("org")) ||
                (adres.contains("com") && adres.contains("net"))) {
            return false;
        }
        return true;
    }
}
