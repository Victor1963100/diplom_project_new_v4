package screen;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;

public class AboutScreen {
    public static ViewInteraction versionTitle = onView(withId(R.id.about_version_title_text_view));
    public static ViewInteraction versionValue = onView(withId(R.id.about_version_value_text_view));
    public static ViewInteraction privacyPolicy = onView(withId(R.id.about_privacy_policy_label_text_view));
    public static ViewInteraction privacyPolicyUrl = onView(withId(R.id.about_privacy_policy_value_text_view));
    public static ViewInteraction termsOfUse = onView(withId(R.id.about_terms_of_use_label_text_view));
    public static ViewInteraction termsOfUseUrl = onView(withId(R.id.about_terms_of_use_value_text_view));
    public static ViewInteraction copyright = onView(withId(R.id.about_company_info_label_text_view));
    public static ViewInteraction buttonBack = onView(withId(R.id.about_back_image_button));
    }
