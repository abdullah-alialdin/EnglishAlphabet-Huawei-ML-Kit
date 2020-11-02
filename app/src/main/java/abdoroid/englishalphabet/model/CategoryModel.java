package abdoroid.englishalphabet.model;

import android.os.Parcel;
import android.os.Parcelable;

public class CategoryModel implements Parcelable {

    private String wordString;
    private int photoImageSource;
    private String letterSound;
    private String letterWord;

    public CategoryModel(String wordString, int photoImageSource, String letterSound, String letterWord) {
        this.wordString = wordString;
        this.photoImageSource = photoImageSource;
        this.letterSound = letterSound;
        this.letterWord = letterWord;
    }

    public CategoryModel(String wordString, int photoImageSource) {
        this.wordString = wordString;
        this.photoImageSource = photoImageSource;
    }

    public String getWordString() {
        return wordString;
    }

    public int getPhotoImageSource() {
        return photoImageSource;
    }

    public String getLetterSound() {
        return letterSound;
    }

    public String getLetterWord() {
        return letterWord;
    }


    private CategoryModel(Parcel in) {
        this.wordString = in.readString();
        this.photoImageSource = in.readInt();
        this.letterSound = in.readString();
        this.letterWord = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.wordString);
        dest.writeInt(this.photoImageSource);
        dest.writeString(this.letterSound);
        dest.writeString(this.letterWord);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<CategoryModel> CREATOR = new Creator<CategoryModel>() {
        @Override
        public CategoryModel createFromParcel(Parcel in) {
            return new CategoryModel(in);
        }

        @Override
        public CategoryModel[] newArray(int size) {
            return new CategoryModel[size];
        }
    };
}
