package tests;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.Espresso.pressBack;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import android.os.SystemClock;

import androidx.test.espresso.NoMatchingViewException;
import androidx.test.rule.ActivityTestRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.junit4.DisplayName;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.AppActivity;
import steps.AboutSteps;
import steps.AuthorizationSteps;
import steps.MainSteps;

@RunWith(AllureAndroidJUnit4.class)
public class AboutTest {

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
    @DisplayName("Отображение элементов экрана О приложении (Позитивный)")
    public void showAllElementsAndGoBackOfAboutScreen(){
        MainSteps.waitForMainScreen();
        MainSteps.goToScreen("About");
        AboutSteps.displayedAllElementsOfAboutScreen();
        AboutSteps.backToPreviousFromAboutScreen();
        MainSteps.isMainScreen();
    }

    @Test
    @DisplayName("Работа ссылки Политика конфиденциальности (Позитивный)")
    public void transitionPrivacyPolicy() {
        MainSteps.goToScreen("About");
        AboutSteps.privacyPolicy(onView(withId(R.id.about_privacy_policy_label_text_view)));
        AboutSteps.clickButtonPrivacyPolicy();
        pressBack();
    }

    @Test
    @DisplayName("Работа ссылки Пользовательское соглашение (Позитивный)")
    public void transitionTermsOfUse() {
        MainSteps.goToScreen("About");
        AboutSteps.termsOfUse(R.id.about_terms_of_use_value_text_view);
        AboutSteps.clickButtonTermsOfUse();
        pressBack();
    }
}
