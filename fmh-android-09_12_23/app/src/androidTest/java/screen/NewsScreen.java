package screen;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;

public class NewsScreen {

    //NewsScreen
    public static ViewInteraction newsScreenTitle = onView(withText("News"));
    public static ViewInteraction sortNewsButton = onView(withId(R.id.sort_news_material_button));
    public static ViewInteraction filterNewsButton = onView(withId(R.id.filter_news_material_button));
    public static ViewInteraction controlPanelButton = onView(withId(R.id.edit_news_material_button));
    public static ViewInteraction descriptionOfFirstNews = onView(withId(R.id.news_item_description_text_view));
    public static ViewInteraction titleOfFirstNews = onView(withId(R.id.news_item_title_text_view));

    //Filter
    public static ViewInteraction categoryOfNews = onView(withId(R.id.news_item_category_text_auto_complete_text_view));
    public static ViewInteraction dateStartPeriod = onView(withId(R.id.news_item_publish_date_start_text_input_edit_text));
    public static ViewInteraction dateEndPeriod = onView(withId(R.id.news_item_publish_date_end_text_input_edit_text));
    public static ViewInteraction filterButton = onView(withId(R.id.filter_button));
    public static ViewInteraction cancelButtonOfNews = onView(withId(R.id.cancel_button));

    //ControlPanel

    public static ViewInteraction addNewsButton = onView(withId(R.id.add_news_image_view));
    public static ViewInteraction titleOfCreatingWindow = onView(withText("Creating"));
    public static ViewInteraction titleTextInput = onView(withId(R.id.news_item_title_text_input_edit_text));
    public static ViewInteraction dateField = onView(withId(R.id.news_item_publish_date_text_input_edit_text));
    public static ViewInteraction timeField = onView(withId(R.id.news_item_publish_time_text_input_edit_text));
    public static ViewInteraction descriptionOfNews = onView(withId(R.id.news_item_description_text_input_edit_text));
    public static ViewInteraction saveButton =onView(withId(R.id.save_button));
    public static ViewInteraction editNewsItemButton = onView(withId(R.id.edit_news_item_image_view));
    public static ViewInteraction titleOfEditingWindow = onView(withText("Editing"));
    public static ViewInteraction newsStatusSwitcher = onView(withId(R.id.switcher));
    public static ViewInteraction deleteNewsButton = onView(withId(R.id.delete_news_item_image_view));
    public static ViewInteraction okButton = onView(withText("OK"));
    public static ViewInteraction cancelButton = onView(withText("CANCEL"));
    public static ViewInteraction activeCheckBox = onView(withId(R.id.filter_news_active_material_check_box));
    public static ViewInteraction notActiveCheckBox = onView(withId(R.id.filter_news_inactive_material_check_box));
    private static String text;

    public static void clickButtonDeleteNews() {
    }

    public static void clickOkButton() {
    }

    public static void editNewsItemButton() {
    }

    public static void clickSaveButton() {
    }

    public static void activeCheckBox() {
    }

    public static void notActiveCheckBox() {
    }

    public static void categoryOfNews(String text) {
    }

    public static void filterNewsButton() {
    }


    public static void dateStartPeriod(String text) {
    }

    public static void dateEndPeriod(String text) {
    }
}
