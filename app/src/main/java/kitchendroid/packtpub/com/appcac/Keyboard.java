package kitchendroid.packtpub.com.appcac;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.ImageView;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by KockR on 18-4-2015.
 */
public class Keyboard {

    private String keybCdu;

    Keyboard() {
    }

    public void setKeybCdu(String cduPos) {

        if (cduPos.equals("R")) {
            keybCdu = "Qh403";
        } else if (cduPos.equals("C")) {
            keybCdu = "Qh402";
        } else {
            keybCdu = "Qh401";
        }
    }

    public static String getMessage(MotionEvent event, ImageView iv) {
        String message="";
        String command="Qh410";

        if (event.getAction() != MotionEvent.ACTION_DOWN) {
   //         if (event.getAction() == MotionEvent.ACTION_UP) {
   //             message = command+"=-1";
   //         }
        } else {
            // Get the colour of the clicked coordinates
            // And yes, I spell it coloUr.

            int x = (int) event.getX();
            int y = (int) event.getY();
            Map<Integer, String> colorMap = new HashMap<Integer, String>();
/**            colorMap.put(-78593, command + "=0");
            colorMap.put(-6789634, command + "=1");
            colorMap.put(-16711783, command + "=2");
            colorMap.put(-6737152, command + "=3");
            colorMap.put(-3407821, command + "=4");
            colorMap.put(-13343129, command + "=5");
            colorMap.put(-6737051, command + "=6");
            colorMap.put(-3421082, command + "=7");
            colorMap.put(-261116, command + "=10");
            colorMap.put(-1574140, command + "=11");
            colorMap.put(-16451057, command + "=12");
            colorMap.put(-15203077, command + "=13");
            colorMap.put(-392218, command + "=14");
            colorMap.put(-16527109, command + "=15");
            colorMap.put(-285436, command + "=16");
            colorMap.put(-6763266, command + "=17");
            colorMap.put(-6789479, command + "=20");
            colorMap.put(-13434625, command + "=21");
            colorMap.put(-6684775, command + "=22");
*/
            colorMap.put(-32986, command + "=26");
            colorMap.put(-6075997, command + "=27");
            colorMap.put(-1238236, command + "=options");

            int touchColour = getHitboxColour(x, y, iv);
            for (Integer col : colorMap.keySet()) {
                if (closeMatch(col, touchColour)) {
                    message = colorMap.get(col);
                }
            }
            Log.e("touchColour", Integer.toString(touchColour));
            StringBuilder sb = new StringBuilder();
            sb.append("ARGB(");
            sb.append(Color.alpha(touchColour));
            sb.append(",");
            sb.append(Color.red(touchColour));
            sb.append(",");
            sb.append(Color.green(touchColour));
            sb.append(",");
            sb.append(Color.blue(touchColour));
            sb.append(")");
            Log.e("Clicked", sb.toString());
        }
        return message;
    }



    public static boolean closeMatch(int color1, int color2) {

        int tolerance = 25;

        if ((int) Math.abs (Color.red (color1) - Color.red (color2)) > tolerance) {
            return false;
        }


        if ((int) Math.abs (Color.green (color1) - Color.green (color2)) > tolerance) {
            return false;
        }


        if ((int) Math.abs (Color.blue (color1) - Color.blue (color2)) > tolerance) {
            return false;
        }

        return true;
    }

    public static int getHitboxColour(int x, int y, ImageView iv) {

        // Fix any offsets by the positioning of screen elements such as Activity titlebar.
        // This part was causing me issues when I was testing out Bill Lahti's code.

        Bitmap bmpHotspots;
        int pixel;
        int[] location = new int[2];

        iv.getLocationOnScreen(location);
        x -= location[0];
        y -= location[1];

        // Prevent crashes, return background noise

        if ((x < 0) || (y < 0)) {
            return Color.WHITE;
        }
        // Draw the scaled bitmap into memory

        iv.setDrawingCacheEnabled(true);
        bmpHotspots = Bitmap.createBitmap(iv.getDrawingCache());
        iv.setDrawingCacheEnabled(false);
        pixel = bmpHotspots.getPixel(x, y);
        bmpHotspots.recycle();
        return pixel;
    }
}



