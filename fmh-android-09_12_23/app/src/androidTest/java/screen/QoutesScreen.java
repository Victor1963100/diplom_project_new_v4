package screen;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;

public class QoutesScreen {
    public static ViewInteraction missionTitle = onView(withText("Love is all"));
    public static ViewInteraction listQoute = onView(withId(R.id.our_mission_item_list_recycler_view));
    public static ViewInteraction titleOfQouteItem = onView(withText("«Хоспис для меня - это то, каким должен быть мир.\""));

    public static ViewInteraction descriptionOfQouteItem = onView(withText("\"Ну, идеальное устройство мира в моих глазах. Где никто не оценивает, никто не осудит, где говоришь, и тебя слышат, где, если страшно, тебя обнимут и возьмут за руку, а если холодно тебя согреют.” Юля Капис, волонтер"));
}
