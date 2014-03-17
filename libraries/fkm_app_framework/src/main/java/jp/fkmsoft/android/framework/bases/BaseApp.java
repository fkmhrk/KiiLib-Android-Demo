package jp.fkmsoft.android.framework.bases;

import jp.fkmsoft.android.framework.UI;

public class BaseApp<T extends UI> {
    protected T ui;
    
    protected BaseApp(T ui) {
        this.ui = ui;
    }
}
