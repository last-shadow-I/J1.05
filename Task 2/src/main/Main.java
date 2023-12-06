public class Main {

  public static String whatIsString(String str){
    str = str.trim();
    if(str.matches("[a-zA-Z0-9._-]+@[a-zA-Z._-]+\\.[a-zA-Z_-]+")){
      return "email";
    } else if(str.matches("\\+7-?\\(?\\d\\d\\d\\)?-?\\(?\\d\\d\\d\\)?-?\\d\\d-?\\d\\d")){
      return "телефон";
    } else if(str.matches("\\b[0-9]{10}\\b|\\b[0-9]{12}\\b")){
      return "ИНН";
    } else if(str.matches("[a-zA-Z][a-zA-Z0-9._$]{7,}")){
      return "username";
    }
    return "none";
  }

  public static void main(String[] args) {

    String[] strings = {"$asdfghjk",
            "+7(123)456-78-90    ",
            "+7-(123)-456-78-90",
            "+7-123-456-78-90",
            " +71234567890",
            "000000000000",
            "1234567890",
            "4abc",
            "71234567890",
            "7777-8888-9999",
            "@example.com",
            "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz.$1234_",
            "       aaaa1111",
            "qwerty 456",
            "user.name.example.com",
            "user.name@example",
            "user.name@example.com",
            "user_name1@some.example.com",
            "    "};

    for (String str: strings) {
      System.out.println(whatIsString(str)); // str + ": " +
    }
  }
}