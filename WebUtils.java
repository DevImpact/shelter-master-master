import android.content.Intent;
import android.net.Uri;

public class WebUtils {

    public static void openWebsite(String url, Context context) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));
        context.startActivity(intent);
    }
}
