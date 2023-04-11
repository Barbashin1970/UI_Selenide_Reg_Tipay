import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class ContactTest {

    public String EMAIL = RandomStringUtils.randomAlphabetic(8).toLowerCase() + "@gmail.com" ;
    public String NAME = "Виталий Мартемьянович " + RandomStringUtils.randomAlphabetic(5);
    public String MESSAGE = "Hello, dear GaiMP, we are interested in cooperation with our best Game - "
            + RandomStringUtils.randomAlphabetic(1).toUpperCase()
            + RandomStringUtils.randomAlphabetic(8).toLowerCase() + " Strategy";
    @Test
    public void checkMessageFromPMainPage() throws InterruptedException {
        open("https://gaimp.ru/");
        // Нажимаем кнопку регистрации на главной странице
        $(byText("Наши контакты")).shouldBe(enabled);
        $(byText("Наши контакты")).click();
        // Вводим информацию о компании
        $(byName("Email")).shouldBe(enabled);
        $(byName("Email")).setValue(EMAIL);
        $(byName("Name")).shouldBe(enabled);
        $(byName("Name")).setValue(NAME);
        $(byName("Textarea")).shouldBe(enabled);
        $(byName("Textarea")).setValue(MESSAGE);
        $(byText("Отправить")).shouldBe(enabled);
        $(byText("Отправить")).click();
            Thread.sleep(5000);
    }


}
