package model;

import android.widget.ImageView;

/**
 * Created by rohan on 25/12/15.
 */
public class NavDrawerItem {

    private boolean showNotify;
    private String title;
    private int icon;
    public NavDrawerItem() {
    }

    public NavDrawerItem(boolean showNotify, String title,int imageID) {
        this.showNotify = showNotify;
        this.title = title;
        this.icon = imageID;
    }

    public boolean isShowNotify() {
        return showNotify;
    }

    public void setShowNotify(boolean showNotify) {
        this.showNotify = showNotify;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setIcon(int id) {
        this.icon = id;
    }

    public int getIcon()
    {
        return icon;
    }

}
