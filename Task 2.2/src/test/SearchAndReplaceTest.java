import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SearchAndReplaceTest {

  String str = "Наше дело не так однозначно, как может показаться: сплочённость команды профессионалов требует от нас " +
          "анализа новых принципов формирования материально-технической и кадровой базы. Также как новая модель " +
          "организационной деятельности прекрасно подходит для реализации новых предложений. Сложно сказать, почему " +
          "элементы политического процесса будут ассоциативно распределены по отраслям. Задача организации, в " +
          "особенности же дальнейшее развитие различных форм деятельности, в своём классическом представлении, " +
          "допускает внедрение экспериментов, поражающих по своей масштабности и грандиозности. Идейные соображения " +
          "высшего порядка, а также убеждённость некоторых оппонентов говорит о возможностях благоприятных перспектив. " +
          "Значимость этих проблем настолько очевидна, что понимание сути ресурсосберегающих технологий предполагает " +
          "независимые способы реализации как самодостаточных, так и внешне зависимых концептуальных решений. С учётом " +
          "сложившейся международной обстановки, граница обучения кадров выявляет срочную потребность дальнейших " +
          "направлений развития. Лишь активно развивающиеся страны третьего мира, которые представляют собой яркий " +
          "пример континентально-европейского типа политической культуры, будут указаны как претенденты на роль ключевых " +
          "факторов. Есть над чем задуматься: активно развивающиеся страны третьего мира являются только методом " +
          "политического участия и разоблачены. Картельные сговоры не допускают ситуации, при которой независимые " +
          "государства, которые представляют собой яркий пример континентально-европейского типа политической " +
          "культуры, будут разоблачены.";

  SearchAndReplace searchAndReplace = new SearchAndReplace(str);

  @Test
  void search() {
    assertEquals(0, searchAndReplace.Search("ъ").length);
    assertEquals(10, searchAndReplace.Search(".").length);
  }

  @Test
  void testSearch() {
    assertEquals(12, searchAndReplace.Search("Та", false).length);
    assertEquals(1, searchAndReplace.Search("Та", true).length);
  }

  @Test
  void replace() {
    assertEquals(12, searchAndReplace.Replace("Та", ""));
    assertEquals(10, searchAndReplace.Replace(".", ","));
    assertEquals(0, searchAndReplace.Replace(str, ","));
    searchAndReplace.setInputString(str);
    assertEquals(1, searchAndReplace.Replace(str, ","));
    System.out.println("Заменили весь текст на: " + searchAndReplace.getInputString());
  }

  @Test
  void testReplace() {
    assertEquals(1, searchAndReplace.Replace("Та", "", true));
    assertEquals(11, searchAndReplace.Replace("Та", "", false));
    assertEquals(2, searchAndReplace.Replace("С", "", true));
    assertEquals(72, searchAndReplace.Replace("с", "", false));

    searchAndReplace.setInputString(str);
    assertEquals(2, searchAndReplace.Replace("З", "з", true));
    assertEquals(25, searchAndReplace.Search("з").length);
    System.out.println(searchAndReplace.getInputString());
  }
}