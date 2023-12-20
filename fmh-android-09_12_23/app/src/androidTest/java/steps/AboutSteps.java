package steps;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isClickable;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

import androidx.test.espresso.ViewInteraction;

import io.qameta.allure.kotlin.Allure;
import screen.AboutScreen;


public class AboutSteps {

    public static void displayedAllElementsOfAboutScreen(){
        Allure.step("Отображение всех элементов блока О приложении");
        AboutScreen.versionTitle.check(matches(allOf(withText("Version:"), isDisplayed())));
        AboutScreen.versionValue.check(matches(allOf(withText("1.0.0"), isDisplayed())));
        AboutScreen.privacyPolicy.check(matches(allOf(withText("Privacy Policy:"), isDisplayed())));
        AboutScreen.privacyPolicyUrl.check(matches(allOf(withText("https://vhospice.org/#/privacy-policy/"), isDisplayed(), isClickable())));
        AboutScreen.termsOfUse.check(matches(allOf(withText("Terms of use:"), isDisplayed())));
        AboutScreen.termsOfUseUrl.check(matches(allOf(withText("https://vhospice.org/#/terms-of-use"), isDisplayed(), isClickable())));
        AboutScreen.copyright.check(matches(allOf(withText("© I-Teco, 2022"), isDisplayed())));

    }

    public static void backToPreviousFromAboutScreen(){
        Allure.step("Вернуться к предыдущему экрану");
        AboutScreen.buttonBack.perform(click());
    }

    public static void privacyPolicy(ViewInteraction viewInteraction) {
    }

    public static void clickButtonPrivacyPolicy() {
    }

    public static void termsOfUse(int aboutTermsOfUseValueTextView) {
    }

    public static void clickButtonTermsOfUse() {
    }
}
