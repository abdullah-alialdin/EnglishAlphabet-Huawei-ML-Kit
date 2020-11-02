package abdoroid.englishalphabet.model;

public class TraceModel {

    private int mImageSource;
    private String mText;

    public TraceModel(int imageSource, String text){
        this.mImageSource = imageSource;
        this.mText = text;
    }

    public int getImageSource() {
        return mImageSource;
    }

    public String getText(){
        return mText;
    }
}
