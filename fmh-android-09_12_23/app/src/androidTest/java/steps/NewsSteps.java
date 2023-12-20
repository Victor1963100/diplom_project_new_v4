package steps;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

import androidx.test.espresso.ViewInteraction;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.R;
import screen.NewsScreen;

public class NewsSteps {

    public static void isNewsScreen(){
        Allure.step("Проверка, что это экран блока Новости");
        NewsScreen.newsScreenTitle.check(matches(allOf(withText("News"), isDisplayed())));
        NewsScreen.sortNewsButton.check(matches(isDisplayed()));
    }

    public static void openControlPanelOfNews(){
        Allure.step("Открыть панель управления блока Новости");
        NewsScreen.controlPanelButton.perform(click());
    }

    public static void isControlPanelNews(){
        Allure.step("Проверка, что это экран Панель Управления Новостей");
        NewsScreen.addNewsButton.check(matches(isDisplayed()));
    }

    public static void clickAddNewsFromControlPanel(){
        Allure.step("Нажать добавить новость из блока Панель управления");
        NewsScreen.addNewsButton.perform(click());
    }

    public static void isCreateNewsScreen(){
        Allure.step("Проверка, что это экран создания новости");
        NewsScreen.titleOfCreatingWindow.check(matches(allOf(withText("Creating"), isDisplayed())));
    }

    public static void chooseCategory(){
        Allure.step("Выбрать категорию новости");
        NewsScreen.categoryOfNews.perform(click());
        NewsScreen.titleTextInput.perform(click());
    }

    public static void enterNewsTitle(String text) {
        Allure.step("Ввести заголовок");
        NewsScreen.titleTextInput.perform(replaceText(text), closeSoftKeyboard());
    }

    public static void enterDateOfNewsPublication(String text) {
        Allure.step("Ввести дату публикации");
        NewsScreen.dateField.perform(replaceText(text));
    }

    public static void enterTimeOfNewsPublication(String text) {
        Allure.step("Ввести время");
        NewsScreen.timeField.perform(replaceText(text));
    }

    public static void enterNewsDescription(String text) {
        Allure.step("Ввести описание");
        NewsScreen.descriptionOfNews.perform(replaceText(text), closeSoftKeyboard());
    }

    public static void findDisplayedNews(String text) {
        Allure.step("Найти элемент");
        onView(allOf(withId(R.id.news_item_title_text_view), withText(text)));
    }

    public static void deleteNewsButton() {
        Allure.step("Удалить новость");
        ViewInteraction perform = NewsScreen.deleteNewsButton.perform(click());
    }
}
