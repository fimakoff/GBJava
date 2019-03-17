package lesson_5;

public class Main {
    public static void main(String[] args) {

        Person[] persArray = new Person[5];
        persArray[0] = new Person("Ivanov Ivan", "Engineer", "ivivan@mailbox.com", "892312312", 30000, 30);
        persArray[1] = new Person("Lychkin Valera", "Arcitect", "allBuilder@mailbox.com", "8923archi77", 35000, 36);
        persArray[2] = new Person("Yarcefolaev Ignat", "Team Leader", "schneller_Sklaven@mailbox.com", "892312312", 50000, 43);
        persArray[3] = new Person("Pyatochkin Matvey", "Project manager", "zeliboba15@mailbox.com", "8923amn0amn", 10000, 32);
        persArray[4] = new Person("Knutov Emmanuil", "SEO", "navalyashka1972@mailbox.com", "892311knut4u", 60000, 47);

        for (int i = 0; i < persArray.length; i++) {
            if (persArray[i].getAge()>=40){
                persArray[i].printInfo();
            }
        }
    }

}
