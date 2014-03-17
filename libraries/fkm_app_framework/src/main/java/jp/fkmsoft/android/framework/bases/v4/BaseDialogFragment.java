package jp.fkmsoft.android.framework.bases.v4;

import jp.fkmsoft.android.framework.App;
import jp.fkmsoft.android.framework.UI;
import android.support.v4.app.DialogFragment;

public class BaseDialogFragment<T extends UI, U extends App> extends DialogFragment {
    protected T ui;
    protected U app;
}
