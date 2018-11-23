package tw.com.lccnet.recycleviewdemo.beans;

/**
 * Created by Student on 2018/3/26.
 */

public class ModelRv {
    private int imaegs;
    private String title;
    private String content;

    public ModelRv(int imaegs, String title, String content) {
        this.imaegs = imaegs;
        this.title = title;
        this.content = content;
    }

    public int getImaegs() {
        return imaegs;
    }

    public void setImaegs(int imaegs) {
        this.imaegs = imaegs;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
