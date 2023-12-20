package screen;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.core.AllOf.allOf;
import static data.DataHelper.childAtPosition;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;

public class MainScreen {

    //HamburgerMenu
    public static ViewInteraction menuButton = onView(withId(R.id.main_menu_image_button));
    public static ViewInteraction mainMenu = onView(withText("Main"));
    public static ViewInteraction newsMenu = onView(withText("News"));
    public static ViewInteraction aboutMenu = onView(withText("About"));

    //Trademark
    public static ViewInteraction tradeMark = onView(withId(R.id.trademark_image_view));

    //Quotes
    public static ViewInteraction quotesButton = onView(withId(R.id.our_mission_image_button));

    //News
    public static ViewInteraction titleOfBlockNews = onView(withText("News"));
    public static ViewInteraction listNews = onView(withId(R.id.news_list_swipe_refresh));
    public static ViewInteraction expandAllNews = onView(allOf(withId(R.id.expand_material_button),
            childAtPosition(childAtPosition(withId(R.id.container_list_news_include_on_fragment_main),0), 4)));
    public static ViewInteraction allNewsButton = onView(withId(R.id.all_news_text_view));
    public static ViewInteraction titleOfFirstNews = onView(withText("Quote"));
    public static ViewInteraction descriptionOfFirstNews = onView(withText("qwerty"));

}