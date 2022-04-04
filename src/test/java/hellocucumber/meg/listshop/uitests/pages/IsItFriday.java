package hellocucumber.meg.listshop.uitests.pages;


public class IsItFriday {
    public static String isItFriday(String today) {

        return today.equals("Friday") ? "TGIF": "Nope";
    }
}


