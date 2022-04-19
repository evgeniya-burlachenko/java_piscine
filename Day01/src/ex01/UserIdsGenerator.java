package ex01;
//https://javarush.ru/groups/posts/589-patternih-i-singleton--dlja-vsekh-kto-vpervihe-s-nimi-stolknulsja
public class UserIdsGenerator {
    private static int Identifier;
    private static UserIdsGenerator instance;//1

    private  UserIdsGenerator() {}//2
    public static UserIdsGenerator getInstance() { //3
        if (instance == null){
            instance = new UserIdsGenerator();
        }
        return instance;
    }
    public static int generateId() {
        return Identifier++;
    }
}
