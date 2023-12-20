package tests;

import android.os.SystemClock;

import androidx.test.rule.ActivityTestRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.junit4.DisplayName;
import ru.iteco.fmhandroid.ui.AppActivity;
import steps.AuthorizationSteps;
import steps.MainSteps;

@RunWith(AllureAndroidJUnit4.class)

public class AuthorizationTest {

    @Rule
    public ActivityTestRule<AppActivity> activityTestRule =
            new ActivityTestRule<>(AppActivity.class);

    @Before
    public void logout() {
        SystemClock.sleep(5000);
        try {
            AuthorizationSteps.isAuthorizationScreen();
        } catch (androidx.test.espresso.NoMatchingViewException e) {
            AuthorizationSteps.logOut();
        }
    }

    @Test
    @DisplayName("#1: Авторизация в мобильном приложении Мобильный хоспис (Позитивный)")
    public void signInSucces() {

        AuthorizationSteps.isAuthorizationScreen();
        AuthorizationSteps.clickLoginField("login2");
        AuthorizationSteps.clickPasswordField("password2");
        AuthorizationSteps.clickSignIn();

        MainSteps.waitForMainScreen();
        MainSteps.isMainScreen();

        AuthorizationSteps.logOut();
    }
    @Test
    @DisplayName("#2: Авторизация с пустым полем Login (Негативный)")
    public void loginFieldIsEmpty() {
        AuthorizationSteps.isAuthorizationScreen();
        AuthorizationSteps.clickLoginField("");
        AuthorizationSteps.clickPasswordField("password2");
        AuthorizationSteps.clickSignIn();
        AuthorizationSteps.popUpErrorWrongLoginOrPassword();
    }

    @Test
    @DisplayName("#3: Авторизация с полем Login, заполненным данными незарегистрированного пользователя (Негативный)")
    public void signInWithWrongLogin(){
        AuthorizationSteps.isAuthorizationScreen();
        AuthorizationSteps.clickLoginField("login123");
        AuthorizationSteps.clickPasswordField("password2");
        AuthorizationSteps.clickSignIn();
        AuthorizationSteps.popUpErrorWrongLoginOrPassword();
    }

    @Test
    @DisplayName("#4: Авторизация при заполнении поля Login символами (Негативный)")
    public void loginFieldWithSpecialCharacters() {
        AuthorizationSteps.isAuthorizationScreen();
        AuthorizationSteps.clickLoginField("@#$^&**");
        AuthorizationSteps.clickPasswordField("password2");
        AuthorizationSteps.clickSignIn();
        AuthorizationSteps.popUpErrorWrongLoginOrPassword();
    }

    @Test
    @DisplayName("#5: Поле Логин состоит из одного символа (Негативный)")
    public void loginFieldOneLetter() {
        AuthorizationSteps.isAuthorizationScreen();
        AuthorizationSteps.clickLoginField("l");
        AuthorizationSteps.clickPasswordField("password2");
        AuthorizationSteps.clickSignIn();
        AuthorizationSteps.popUpErrorWrongLoginOrPassword();
    }

    @Test
    @DisplayName("#6: Поле Логин состоит из букв разного регистра (Негативный)")
    public void loginFieldLettersOfDifferentCase() {
        AuthorizationSteps.isAuthorizationScreen();
        AuthorizationSteps.clickLoginField("LoGiN2");
        AuthorizationSteps.clickPasswordField("password2");
        AuthorizationSteps.clickSignIn();
        AuthorizationSteps.popUpErrorWrongLoginOrPassword();
    }

    @Test
    @DisplayName("#7: Авторизация с пустым полем Password")
    public void signInWithEmptyPasswordField(){

        AuthorizationSteps.isAuthorizationScreen();
        AuthorizationSteps.clickLoginField("login2");
        AuthorizationSteps.clickPasswordField("");
        AuthorizationSteps.clickSignIn();
        AuthorizationSteps.popUpErrorEmptyField();
    }

    @Test
    @DisplayName("#8: Поле Password заполнено данными незарегистрированного пользователя (Негативный)")
    public void passwordFieldUnregisteredUser() {
        AuthorizationSteps.isAuthorizationScreen();
        AuthorizationSteps.clickLoginField("login2");
        AuthorizationSteps.clickPasswordField("password123");
        AuthorizationSteps.clickSignIn();
        AuthorizationSteps.popUpErrorWrongLoginOrPassword();
    }

    @Test
    @DisplayName("#9:Ввод символов в поле Password (Негативный)")
    public void passwordFieldWithSpecialCharacters() {
        AuthorizationSteps.isAuthorizationScreen();
        AuthorizationSteps.clickLoginField("login2");
        AuthorizationSteps.clickPasswordField("@#$^&**");
        AuthorizationSteps.clickSignIn();
        AuthorizationSteps.popUpErrorWrongLoginOrPassword();
    }

    @Test
    @DisplayName("#10: Поле Password состоит из одного символа (Негативный)")
    public void passwordFieldOneLetter() {
        AuthorizationSteps.isAuthorizationScreen();
        AuthorizationSteps.clickLoginField("login2");
        AuthorizationSteps.clickPasswordField("p");
        AuthorizationSteps.clickSignIn();
        AuthorizationSteps.popUpErrorWrongLoginOrPassword();
    }

    @Test
    @DisplayName("#11: Поле Password состоит из букв разного регистра (Негативный)")
    public void passwordFieldLettersOfDifferentCase() {
        AuthorizationSteps.isAuthorizationScreen();
        AuthorizationSteps.clickLoginField("login2");
        AuthorizationSteps.clickPasswordField("PaSsWoRd2");
        AuthorizationSteps.clickSignIn();
        AuthorizationSteps.popUpErrorWrongLoginOrPassword();
    }
}
