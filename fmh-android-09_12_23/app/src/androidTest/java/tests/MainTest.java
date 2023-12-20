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
import screen.MainScreen;
import steps.AboutSteps;
import steps.AuthorizationSteps;
import steps.MainSteps;
import steps.NewsSteps;
import steps.QoutesSteps;

@RunWith(AllureAndroidJUnit4.class)
public class MainTest {
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
    @DisplayName("#: Разворачивание/сворачивание блока новости")
    public void expandAndRollUpNewsBlock() {
        MainSteps.waitForMainScreen();
        MainSteps.rollUpAllNews();
        MainSteps.expandAllNews();
    }

    @Test
    @DisplayName("#: Переход в блок Новости с главного экрана")
    public void goToNewsScreenFromMain(){
        MainSteps.goToScreen("News");
        NewsSteps.isNewsScreen();
    }

    @Test
    @DisplayName("#: Переход в блок О приложении через бургерное меню")
    public void goToAboutScreenFromMenu(){
        MainSteps.waitForMainScreen();
        MainSteps.goToScreen("About");
        AboutSteps.displayedAllElementsOfAboutScreen();
    }

    @Test
    @DisplayName("#: Переход в блок Цитаты")
    public void goToQoutesScreen(){
        MainSteps.waitForMainScreen();
        MainScreen.quotesButton.perform(click());
        QoutesSteps.displayedElementsOfQoutesScreen();
    }

    @Test
    @DisplayName("#: Выход из приложения")
    public void logOut(){
        MainSteps.waitForMainScreen();
        AuthorizationSteps.logOut();
    }
}
