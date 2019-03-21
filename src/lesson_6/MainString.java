package lesson_6;

public class MainString {
    public static void main(String[] args) {
        String s = "Предложение  один     Теперь предложение    два   Предложение   три";
        System.out.println(s);
        String s1 = s.replaceAll(" +", " ");
        StringBuilder s2 = new StringBuilder(s1);

        for (int i = 1; i < s1.length(); i++) {

            if(s2.charAt(i) >= 'А' && s2.charAt(i) <= 'Я') {
                s2.setCharAt(i-1, '.');
            }

        }

        for (int i =1; i<s2.length();i++){

            if (s2.charAt(i)=='.'){
                s2.insert(i+1," ");
            }
        }

        s2.append('.');
        System.out.println(s2.toString());


    }
}
