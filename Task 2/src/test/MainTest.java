import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

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

  @Test
  void whatIsString() {

    String[] outputs = {"none", "телефон", "телефон", "телефон", "телефон",
            "ИНН", "ИНН", "none", "none", "none", "none", "username",
            "username", "none", "username", "none", "email", "email", "none"};

    for (int i = 0; i < strings.length; i++) {
      assertEquals(outputs[i], Main.whatIsString(strings[i]));
    }
  }
}