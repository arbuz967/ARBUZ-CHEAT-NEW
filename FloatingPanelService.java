package com.arbuz.cheat;

import android.app.Service;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PixelFormat;
import android.os.IBinder;
import android.view.Gravity;
import android.view.WindowManager;
import android.view.View;
import android.widget.*;

public class FloatingPanelService extends Service {
    private WindowManager wm;
    private View panel;

    @Override public IBinder onBind(Intent intent) { return null; }

    @Override public int onStartCommand(Intent intent, int flags, int startId) {
        if (panel == null) createPanel();
        return START_NOT_STICKY;
    }

    private void createPanel() {
        wm = (WindowManager) getSystemService(WINDOW_SERVICE);
        LinearLayout box = new LinearLayout(this);
        box.setOrientation(LinearLayout.VERTICAL);
        box.setPadding(14, 10, 14, 10);
        box.setBackgroundColor(Color.rgb(25,25,25));

        TextView title = new TextView(this);
        title.setText("ARBuz • PANEL");
        title.setTextColor(Color.rgb(255,55,65));
        title.setTextSize(15);
        title.setTypeface(null, 1);
        box.addView(title);

        TextView desc = new TextView(this);
        desc.setText("Standalone utility overlay");
        desc.setTextColor(Color.WHITE);
        desc.setTextSize(11);
        box.addView(desc);

        Button close = new Button(this);
        close.setText("Закрыть");
        close.setAllCaps(false);
        close.setOnClickListener(v -> stopSelf());
        box.addView(close);

        int type = android.os.Build.VERSION.SDK_INT >= 26 ?
                WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY :
                WindowManager.LayoutParams.TYPE_PHONE;
        WindowManager.LayoutParams p = new WindowManager.LayoutParams(
                WindowManager.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.WRAP_CONTENT,
                type,
                WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE |
                WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN,
                PixelFormat.TRANSLUCENT);
        p.gravity = Gravity.TOP | Gravity.END;
        p.x = 20; p.y = 180;
        panel = box;
        wm.addView(panel, p);
    }

    @Override public void onDestroy() {
        if (wm != null && panel != null) {
            try { wm.removeView(panel); } catch (Exception ignored) {}
        }
        panel = null;
        super.onDestroy();
    }
}
