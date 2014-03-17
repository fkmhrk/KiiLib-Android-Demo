package jp.fkmsoft.kiilibdemo;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;

/**
 * Utility class for View
 */
public class ViewUtils {
    public static void toNextFragment(FragmentManager manager, Fragment next, String tag, boolean addToBackstack) {
        FragmentTransaction transaction = manager.beginTransaction();
        if (addToBackstack) {
            transaction.addToBackStack("");
        }
        transaction.replace(R.id.main, next, tag);

        transaction.commit();
    }

    public static void setClickListener(View root, View.OnClickListener listener, int... ids) {
        if (root == null) { return; }
        for (int id : ids) {
            View view = root.findViewById(id);
            if (view == null) { continue; }
            view.setOnClickListener(listener);
        }
    }

    public static String getValueOfEditText(View root, int id) {
        if (root == null) { return null; }
        EditText edit = (EditText) root.findViewById(id);
        if (edit == null) { return null; }
        Editable text = edit.getText();
        if (text == null) { return null; }
        return text.toString();
    }
}
