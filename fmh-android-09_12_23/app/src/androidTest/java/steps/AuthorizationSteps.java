package steps;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isClickable;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isEnabled;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static org.hamcrest.Matchers.allOf;

import static data.DataHelper.waitId;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.R;
import screen.AuthorizationScreen;

public class AuthorizationSteps {

    public static void logOut() {
        Allure.step("Выход из личного кабинета");
        AuthorizationScreen.manIcon.perform(click());
        AuthorizationScreen.logOut.perform(click());
        AuthorizationSteps.isAuthorizationScreen();
    }

    public static void isAuthorizationScreen(){
        Allure.step("Проверка, что это экран Авторизации");
        AuthorizationScreen.autorizationScreenTitle.check(matches(isDisplayed()));
    }

    public static void waitForSignInButton() {
        onView(isRoot()).perform(waitId(R.id.enter_button,7000));
    }

    public static void clickLoginField(String login){
        Allure.step("Ввод  логина в поле login");
        AuthorizationScreen.loginField.check(matches(isEnabled()));
        AuthorizationScreen.loginField.perform(replaceText(login));
    }

    public static void clickPasswordField(String password){
        Allure.step("Ввод пароля в поле password");
        AuthorizationScreen.passwordField.check(matches(isEnabled()));
        AuthorizationScreen.passwordField.perform(replaceText(password), closeSoftKeyboard());
    }

    public static void clickSignIn(){
        Allure.step("Нажать кнопку SignIn");
        AuthorizationScreen.signInButton.check(matches(isClickable()));
        AuthorizationScreen.signInButton.perform(click());
        onView(isRoot()).perform(waitId(R.id.trademark_image_view, 6000));
    }

    public static void popUpErrorWrongLoginOrPassword() {
        Allure.step("Всплывающее окно Неверный логин или пароль");
        onView(allOf(withContentDescription("Wrong login or password"), isDisplayed()));
    }

    public static void popUpErrorEmptyField() {
        Allure.step("Всплывающее окно поле не может быть пустым");
        onView(allOf(withContentDescription("Login and password cannot be empty"), isDisplayed()));
    }

}