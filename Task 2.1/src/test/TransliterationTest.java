import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TransliterationTest {

  String s = "Наше дело не так однозначно, как может показаться: сплочённость команды профессионалов требует от нас анализа новых принципов формирования материально-технической и кадровой базы. Также как новая модель организационной деятельности прекрасно подходит для реализации новых предложений. Сложно сказать, почему элементы политического процесса будут ассоциативно распределены по отраслям. Задача организации, в особенности же дальнейшее развитие различных форм деятельности, в своём классическом представлении, допускает внедрение экспериментов, поражающих по своей масштабности и грандиозности. Идейные соображения высшего порядка, а также убеждённость некоторых оппонентов говорит о возможностях благоприятных перспектив. Значимость этих проблем настолько очевидна, что понимание сути ресурсосберегающих технологий предполагает независимые способы реализации как самодостаточных, так и внешне зависимых концептуальных решений. С учётом сложившейся международной обстановки, граница обучения кадров выявляет срочную потребность дальнейших направлений развития. Лишь активно развивающиеся страны третьего мира, которые представляют собой яркий пример континентально-европейского типа политической культуры, будут указаны как претенденты на роль ключевых факторов. Есть над чем задуматься: активно развивающиеся страны третьего мира являются только методом политического участия и разоблачены. Картельные сговоры не допускают ситуации, при которой независимые государства, которые представляют собой яркий пример континентально-европейского типа политической культуры, будут разоблачены.";
  String s1 = "Юлия, съешь ещё этих мягких французских булок из Йошкар-Олы, да выпей алтайского чаю";
  String s2 = "Широкая электрификация южных губерний даст мощный толчок подъёму сельского хозяйства";

  String outS = "Nashe delo ne tak odnoznachno, kak mozhet pokazat`sya: splochyonnost` komandy` professionalov trebuet ot nas analiza novy`x principov formirovaniya material`no-texnicheskoj i kadrovoj bazy`. Takzhe kak novaya model` organizacionnoj deyatel`nosti prekrasno podxodit dlya realizacii novy`x predlozhenij. Slozhno skazat`, pochemu e`lementy` politicheskogo processa budut associativno raspredeleny` po otraslyam. Zadacha organizacii, v osobennosti zhe dal`nejshee razvitie razlichny`x form deyatel`nosti, v svoyom klassicheskom predstavlenii, dopuskaet vnedrenie e`ksperimentov, porazhayushhix po svoej masshtabnosti i grandioznosti. Idejny`e soobrazheniya vy`sshego poryadka, a takzhe ubezhdyonnost` nekotory`x opponentov govorit o vozmozhnostyax blagopriyatny`x perspektiv. Znachimost` e`tix problem nastol`ko ochevidna, chto ponimanie suti resursosberegayushhix texnologij predpolagaet nezavisimy`e sposoby` realizacii kak samodostatochny`x, tak i vneshne zavisimy`x konceptual`ny`x reshenij. S uchyotom slozhivshejsya mezhdunarodnoj obstanovki, granicza obucheniya kadrov vy`yavlyaet srochnuyu potrebnost` dal`nejshix napravlenij razvitiya. Lish` aktivno razvivayushhiesya strany` tret`ego mira, kotory`e predstavlyayut soboj yarkij primer kontinental`no-evropejskogo tipa politicheskoj kul`tury`, budut ukazany` kak pretendenty` na rol` klyuchevy`x faktorov. Est` nad chem zadumat`sya: aktivno razvivayushhiesya strany` tret`ego mira yavlyayutsya tol`ko metodom politicheskogo uchastiya i razoblacheny`. Kartel`ny`e sgovory` ne dopuskayut situacii, pri kotoroj nezavisimy`e gosudarstva, kotory`e predstavlyayut soboj yarkij primer kontinental`no-evropejskogo tipa politicheskoj kul`tury`, budut razoblacheny`.";
  String outS1 = "Yuliya, s``esh` eshhyo e`tix myagkix franczuzskix bulok iz Joshkar-Oly`, da vy`pej altajskogo chayu";
  String outS2 = "Shirokaya e`lektrifikaciya yuzhny`x gubernij dast moshhny`j tolchok pod``yomu sel`skogo xozyajstva";

  @Test
  void rusToLat() {
    assertEquals(outS, Transliteration.rusToLat(s));
    assertEquals(outS1, Transliteration.rusToLat(s1));
    assertEquals(outS2, Transliteration.rusToLat(s2));
  }

  @Test
  void latinToRus() {
    assertEquals(s, Transliteration.latinToRus(outS));
    assertEquals(s1, Transliteration.latinToRus(outS1));
    assertEquals(s2, Transliteration.latinToRus(outS2));
  }
}