package capacitor.plugin.screenshot;

import android.app.Activity;
import android.graphics.Bitmap;
import android.view.View;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class Screenshot {

    private Activity bridgeActivity = null;

    public Screenshot(Activity activity) {
        this.bridgeActivity = activity;
    }

    public byte[] echo(String value) {
        if (this.bridgeActivity == null)
            return null;
        View view = this.bridgeActivity.getWindow().getDecorView(); // 获取DecorView
        // 方式一:
//        view.setDrawingCacheEnabled(true);
//        view.buildDrawingCache();
//        Bitmap bitmap1 = view.getDrawingCache();

        // 方式二:
        Bitmap bitmap2 = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.ARGB_8888);
        //        Canvas canvas = new Canvas();
//        canvas.setBitmap(bitmap2);
//        view.draw(canvas);
        ByteArrayOutputStream baos = null;
        try {
            if (bitmap2 != null) {
                baos = new ByteArrayOutputStream();
                bitmap2.compress(Bitmap.CompressFormat.JPEG, 100, baos);

                baos.flush();
                baos.close();

                byte[] bitmapBytes = baos.toByteArray();
                return bitmapBytes;
//                result = Base64.encodeToString(bitmapBytes, Base64.DEFAULT);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (baos != null) {
                    baos.flush();
                    baos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return null;
    }
}
