package screen;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withHint;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

import androidx.test.espresso.ViewInteraction;
import ru.iteco.fmhandroid.R;

public class AuthorizationScreen {
    public static ViewInteraction autorizationScreenTitle = onView(allOf(withText("Authorization"), withParent(withParent(withId(R.id.nav_host_fragment)))));
    public static ViewInteraction loginField = onView(allOf(withHint("Login"), withParent(withParent(withId(R.id.login_text_input_layout)))));
    public static ViewInteraction passwordField = onView(allOf(withHint("Password"), withParent(withParent(withId(R.id.password_text_input_layout)))));
    public static ViewInteraction signInButton = onView(withId(R.id.enter_button));
    public static ViewInteraction manIcon = onView(withId(R.id.authorization_image_button));
    public static ViewInteraction logOut = onView(withId(android.R.id.title));

    public static void textAuthorization() {
    }

    public static Object getAuthorizationElementsButtonExit() {
        return null;
    }

    public static void clickButtonExit(Object authorizationElementsButtonExit) {
    }

    public static Object getAuthorizationElementsButton() {
        return null;
    }

    public static void clickButton(Object authorizationElementsButton) {
    }
}
