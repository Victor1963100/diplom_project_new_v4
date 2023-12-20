package tests;

import static androidx.test.espresso.action.ViewActions.click;

import android.os.SystemClock;

import androidx.test.espresso.NoMatchingViewException;
import androidx.test.rule.ActivityTestRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.junit4.DisplayName;
import ru.iteco.fmhandroid.ui.AppActivity;
import screen.NewsScreen;
import steps.AuthorizationSteps;
import steps.MainSteps;
import steps.NewsSteps;

@RunWith(AllureAndroidJUnit4.class)
public class NewsTest {
    @Rule
    public ActivityTestRule<AppActivity> activityTestRule =
            new ActivityTestRule<>(AppActivity.class);

    @Before
    public void login() {
        SystemClock.sleep(7000);
        try {
            AuthorizationSteps.isAuthorizationScreen();
        } catch (NoMatchingViewException e) {
            return;
        }
        AuthorizationSteps.clickLoginField("login2");
        AuthorizationSteps.clickPasswordField("password2");
        AuthorizationSteps.clickSignIn();
    }

    @Test
    @DisplayName("#: Переход на экран Панель управления Новостей (Позитивный)")
    public void goToControlPanel() {
        MainSteps.goToScreen("News");
        NewsSteps.isNewsScreen();
        NewsSteps.openControlPanelOfNews();
        NewsSteps.isControlPanelNews();
    }

    @Test
    @DisplayName("#: Сортировка новостей (Позитивный)")
    public void sortingNewsControlPanel() {
        MainSteps.clickAllNewsButton();
        NewsSteps.openControlPanelOfNews();
        NewsSteps.clickAddNewsFromControlPanel();
        NewsSteps.chooseCategory();
        NewsSteps.enterNewsTitle("Объявление");
        NewsSteps.enterDateOfNewsPublication("17.12.2023");
        NewsScreen.saveButton.perform(click());
        NewsSteps.findDisplayedNews("Объявление");
        NewsSteps.enterNewsTitle("Объявление");
        NewsSteps.enterDateOfNewsPublication("17.12.2023");
    }

    @Test
    @DisplayName("#: Удаление активной новости во вкладке Панель управления (Позитивный)")
    public void deletingActiveNews() {
        MainSteps.clickAllNewsButton();
        NewsSteps.openControlPanelOfNews();
        NewsSteps.findDisplayedNews("Объявление");
        NewsScreen.clickButtonDeleteNews();
        NewsScreen.clickOkButton();
    }

    @Test
    @DisplayName("#: Редактирование новости во вкладке Панель управления (Позитивный)")
    public void editNewsControlPanel() {
        MainSteps.clickAllNewsButton();
        NewsSteps.openControlPanelOfNews();
        NewsSteps.findDisplayedNews("Объявление");
        NewsScreen.titleTextInput.perform();
        NewsScreen.clickSaveButton();
    }

    @Test
    @DisplayName("#: Смена статуса новости, находящейся в статусе АКТИВНА на статус НЕ АКТИВНА, во вкладке Панель управления (Позитивный)")
    public void statusChangeNews() {
        MainSteps.clickAllNewsButton();
        NewsSteps.openControlPanelOfNews();
        NewsSteps.findDisplayedNews("Объявление");
        NewsScreen.activeCheckBox();
        NewsScreen.notActiveCheckBox();
        NewsScreen.clickSaveButton();
    }

    @Test
    @DisplayName("#: Фильтрация новостей по критерию Активна (Позитивный)")
    public void filterNewsByCriterionActive() {
        MainSteps.clickAllNewsButton();
        NewsSteps.openControlPanelOfNews();
        NewsSteps.findDisplayedNews("Active");
    }

    @Test
    @DisplayName("#: Фильтрация новостей по критерию Не активна (Позитивный)")
    public void filterNewsByCriterionNotActive() {
        MainSteps.clickAllNewsButton();
        NewsSteps.openControlPanelOfNews();
        NewsSteps.findDisplayedNews("Not active");
    }

    @Test
    @DisplayName("#: Создание новости во вкладке Панель управления (Позитивный)")
    public void addNewsFromControlPanel () {
        MainSteps.clickAllNewsButton();
        NewsSteps.openControlPanelOfNews();
        NewsSteps.clickAddNewsFromControlPanel();
        NewsSteps.chooseCategory();
        NewsSteps.enterNewsTitle("Новостная сводка");
        NewsSteps.enterDateOfNewsPublication("18.12.2023");
        NewsSteps.enterTimeOfNewsPublication("17:00");
        NewsSteps.enterNewsDescription("Все новости на сегодня");
        NewsScreen.saveButton.perform(click());
        NewsSteps.findDisplayedNews("Новостная сводка");
    }

    @Test
    @DisplayName("#: Поле Категория пустое, при создании новости, во вкладке Панель управления (Негативный)")
    public void fieldCategoryEmptyCreationNewsInControlPanel() {
        MainSteps.clickAllNewsButton();
        NewsSteps.openControlPanelOfNews();
        NewsSteps.clickAddNewsFromControlPanel();
        NewsSteps.enterNewsTitle("Собрание");
        NewsSteps.enterDateOfNewsPublication("19.12.2023");
        NewsSteps.enterTimeOfNewsPublication("14:00");
        NewsSteps.enterNewsDescription("Обсуждение");
        NewsScreen.saveButton.perform(click());
        NewsSteps.findDisplayedNews("Собрание");
    }

    @Test
    @DisplayName("#: Поле Заголовок пустое при создании новости во вкладке Панель управления (Негативный)")
    public void fieldTitleEmptyCreationNewsInControlPanel() {
        MainSteps.clickAllNewsButton();
        NewsSteps.openControlPanelOfNews();
        NewsSteps.clickAddNewsFromControlPanel();
        NewsSteps.enterNewsTitle("");
        NewsSteps.enterDateOfNewsPublication("19.12.2023");
        NewsSteps.enterTimeOfNewsPublication("15:00");
        NewsSteps.enterNewsDescription("Обсуждение");
        NewsScreen.saveButton.perform(click());
        NewsSteps.findDisplayedNews("");
    }

    @Test
    @DisplayName("#: Поле Дата публикации пустое, при создании новости во вкладке Панель управления (Негативный)")
    public void fieldDateEmptyCreationNewsInControlPanel() {
        MainSteps.clickAllNewsButton();
        NewsSteps.openControlPanelOfNews();
        NewsSteps.clickAddNewsFromControlPanel();
        NewsSteps.chooseCategory();
        NewsSteps.enterNewsTitle("Новостная сводка");
        NewsSteps.enterDateOfNewsPublication("");
        NewsSteps.enterTimeOfNewsPublication("17:00");
        NewsSteps.enterNewsDescription("Все новости на сегодня");
        NewsScreen.saveButton.perform(click());
        NewsSteps.findDisplayedNews("");
    }

    @Test
    @DisplayName("#: Поле Время пустое при создании новости во вкладке Панель управления (Негативный)")
    public void fieldTimeEmptyCreationNewsInControlPanel() {
        MainSteps.clickAllNewsButton();
        NewsSteps.openControlPanelOfNews();
        NewsSteps.clickAddNewsFromControlPanel();
        NewsSteps.chooseCategory();
        NewsSteps.enterNewsTitle("Новостная сводка");
        NewsSteps.enterDateOfNewsPublication("18.12.2023");
        NewsSteps.enterTimeOfNewsPublication("");
        NewsSteps.enterNewsDescription("Все новости на сегодня");
        NewsScreen.saveButton.perform(click());
        NewsSteps.findDisplayedNews("");
    }

    @Test
    @DisplayName("#: Поле Описание пустое при создании новости во вкладке Панель управления (Негативный)")
    public void fieldDescriptionEmptyCreationNewsInControlPanel() {
        MainSteps.clickAllNewsButton();
        NewsSteps.openControlPanelOfNews();
        NewsSteps.clickAddNewsFromControlPanel();
        NewsSteps.chooseCategory();
        NewsSteps.enterNewsTitle("Новостная сводка");
        NewsSteps.enterDateOfNewsPublication("18.12.2023");
        NewsSteps.enterTimeOfNewsPublication("17:00");
        NewsSteps.enterNewsDescription("");
        NewsScreen.saveButton.perform(click());
        NewsSteps.findDisplayedNews("");
    }

    @Test
    @DisplayName("#: Ввод в поле Категория собственного названия категории при создании новости во вкладке Панель управления (Негативный)")
    public void customCategoryName() {
        MainSteps.clickAllNewsButton();
        NewsSteps.openControlPanelOfNews();
        NewsSteps.clickAddNewsFromControlPanel();
        NewsScreen.categoryOfNews("Приглашение на обед");
        NewsSteps.enterNewsTitle("Собрание");
        NewsSteps.enterDateOfNewsPublication("18.12.2023");
        NewsSteps.enterTimeOfNewsPublication("17:00");
        NewsSteps.enterNewsDescription("Все новости на сегодня");
        NewsScreen.saveButton.perform(click());
        NewsSteps.findDisplayedNews("Приглашение на обед");
    }

    @Test
    @DisplayName("#: Поле Категория состоит из цифр при создании новости во вкладке Панель управления (Негативный)")
    public void fieldCategoryConsistsOfNumbers() {
        MainSteps.clickAllNewsButton();
        NewsSteps.openControlPanelOfNews();
        NewsSteps.clickAddNewsFromControlPanel();
        NewsScreen.categoryOfNews("1234567890");
        NewsSteps.enterNewsTitle("Собрание");
        NewsSteps.enterDateOfNewsPublication("18.12.2023");
        NewsSteps.enterTimeOfNewsPublication("17:00");
        NewsSteps.enterNewsDescription("Все новости на сегодня");
        NewsScreen.saveButton.perform(click());
        NewsSteps.findDisplayedNews("1234567890");
    }

    @Test
    @DisplayName("#: Поле Категория состоит из спецсимволов при создании новости во вкладке Панель управления (Негативный)")
    public void fieldCategoryConsistsOfSpecialCharacters() {
        MainSteps.clickAllNewsButton();
        NewsSteps.openControlPanelOfNews();
        NewsSteps.clickAddNewsFromControlPanel();
        NewsScreen.categoryOfNews("@#$^&**");
        NewsSteps.enterNewsTitle("Собрание");
        NewsSteps.enterDateOfNewsPublication("18.12.2023");
        NewsSteps.enterTimeOfNewsPublication("17:00");
        NewsSteps.enterNewsDescription("Все новости на сегодня");
        NewsScreen.saveButton.perform(click());
        NewsSteps.findDisplayedNews("@#$^&**");
    }

    @Test
    @DisplayName("#: Поле Дата публикации состоит из даты будущего года при создании новости во вкладке Панель управления (Позитивный)")
    public void fieldDateConsistsOfNextYearCreatingNews() {
        MainSteps.clickAllNewsButton();
        NewsSteps.openControlPanelOfNews();
        NewsSteps.clickAddNewsFromControlPanel();
        NewsSteps.chooseCategory();
        NewsSteps.enterNewsTitle("Новостная сводка");
        NewsSteps.enterDateOfNewsPublication("19.12.2024");
        NewsSteps.enterTimeOfNewsPublication("17:00");
        NewsSteps.enterNewsDescription("Все новости на сегодня");
        NewsScreen.saveButton.perform(click());
        NewsSteps.findDisplayedNews("19.12.2024");
    }

    @Test
    @DisplayName("#: Просмотр новостей во вкладке Новости (Позитивный)")
    public void viewingNews() {
        MainSteps.clickAllNewsButton();
        NewsSteps.openControlPanelOfNews();
        NewsScreen.editNewsItemButton();
    }

    @Test
    @DisplayName("#: Фильтрация новостей без указания категории во вкладке Новости (Позитивный)")
    public void filteringNewsNoCategoryPositive() {
        MainSteps.clickAllNewsButton();
        NewsSteps.openControlPanelOfNews();
        NewsScreen.filterNewsButton();
    }

    @Test
    @DisplayName("#: Фильтрация новостей, без указания категории, в определенный период времени (Позитивный)")
    public void filteringNewsCertainPeriodTime() {
        MainSteps.clickAllNewsButton();
        NewsSteps.openControlPanelOfNews();
        NewsScreen.dateStartPeriod("13.12.2023");
        NewsScreen.dateEndPeriod("19.12.2023");
    }
}
