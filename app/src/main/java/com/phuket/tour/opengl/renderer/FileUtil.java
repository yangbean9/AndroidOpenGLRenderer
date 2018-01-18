package com.phuket.tour.opengl.renderer;

import android.content.Context;
import android.text.TextUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

/**
 * Created by robin on 2018/1/12.
 */

public class FileUtil {

    public static void copyFileFromAssets(Context context, String fileName, File destFile) {
        try {
            InputStream is = context.getAssets().open(fileName);
            FileOutputStream fos = new FileOutputStream(destFile);
            byte[] buffer = new byte[1024];
            int byteCount;
            while ((byteCount = is.read(buffer)) != -1) {
                fos.write(buffer, 0, byteCount);
            }
            fos.flush();
            is.close();
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean fileExists(String path) {
        if (TextUtils.isEmpty(path)) return false;
        return new File(path).exists();
    }
}
