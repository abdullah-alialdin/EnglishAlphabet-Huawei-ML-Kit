package abdoroid.englishalphabet.data;

import java.util.ArrayList;

import abdoroid.englishalphabet.model.CategoryModel;
import abdoroid.englishalphabet.R;

public class DataArrays {

    public static ArrayList<CategoryModel> makeAlphabetList(){
        ArrayList<CategoryModel> mAlphabetList = new ArrayList<>();
        mAlphabetList.add(new CategoryModel("A a", R.drawable.apple,"A", "apple"));
        mAlphabetList.add(new CategoryModel("B b", R.drawable.ball, "B", "ball"));
        mAlphabetList.add(new CategoryModel("C c", R.drawable.car, "C","car"));
        mAlphabetList.add(new CategoryModel("D d", R.drawable.duck, "D","duck"));
        mAlphabetList.add(new CategoryModel("E e", R.drawable.egg, "E","egg"));
        mAlphabetList.add(new CategoryModel("F f", R.drawable.fish, "F","fish"));
        mAlphabetList.add(new CategoryModel("G g", R.drawable.giraffe, "G","giraffe"));
        mAlphabetList.add(new CategoryModel("H h", R.drawable.hen, "H","hen"));
        mAlphabetList.add(new CategoryModel("I i", R.drawable.ice_cream, "I","icecream"));
        mAlphabetList.add(new CategoryModel("J j", R.drawable.jug, "J","jug"));
        mAlphabetList.add(new CategoryModel("K k", R.drawable.kite, "K","kite"));
        mAlphabetList.add(new CategoryModel("L l", R.drawable.lion,"L","lion"));
        mAlphabetList.add(new CategoryModel("M m", R.drawable.monkey, "M","monkey"));
        mAlphabetList.add(new CategoryModel("N n", R.drawable.nose, "N","nose"));
        mAlphabetList.add(new CategoryModel("O o", R.drawable.orange, "O","orange"));
        mAlphabetList.add(new CategoryModel("P p", R.drawable.pen, "P","pen"));
        mAlphabetList.add(new CategoryModel("Q q", R.drawable.queen, "Q","queen"));
        mAlphabetList.add(new CategoryModel("R r", R.drawable.rat, "R","rat"));
        mAlphabetList.add(new CategoryModel("S s", R.drawable.sun, "S","sun"));
        mAlphabetList.add(new CategoryModel("T t", R.drawable.tree, "T","tree"));
        mAlphabetList.add(new CategoryModel("U u", R.drawable.umbrella, "U","umbrella"));
        mAlphabetList.add(new CategoryModel("V v", R.drawable.violin, "V","violin"));
        mAlphabetList.add(new CategoryModel("W w", R.drawable.watch, "W","watch"));
        mAlphabetList.add(new CategoryModel("X x", R.drawable.xylophone, "X","xylophone"));
        mAlphabetList.add(new CategoryModel("Y y", R.drawable.yoyo, "Y","yoyo"));
        mAlphabetList.add(new CategoryModel("Z z", R.drawable.zebra, "Z","zebra"));
        return mAlphabetList;
    }

    public static ArrayList<CategoryModel> makeAnimalsList(){
        ArrayList<CategoryModel> mAnimalsList = new ArrayList<>();
        mAnimalsList.add(new CategoryModel("Bear", R.drawable.bear));
        mAnimalsList.add(new CategoryModel("Cat", R.drawable.cat));
        mAnimalsList.add(new CategoryModel("Dog", R.drawable.dog));
        mAnimalsList.add(new CategoryModel("Elephant", R.drawable.elephant));
        mAnimalsList.add(new CategoryModel("Fox", R.drawable.fox));
        mAnimalsList.add(new CategoryModel("Giraffe", R.drawable.giraffe));
        mAnimalsList.add(new CategoryModel("Horse", R.drawable.horse));
        mAnimalsList.add(new CategoryModel("Jaguar", R.drawable.jaguar));
        mAnimalsList.add(new CategoryModel("Kangaroo", R.drawable.kangaroo));
        mAnimalsList.add(new CategoryModel("Lion", R.drawable.lion));
        mAnimalsList.add(new CategoryModel("Monkey", R.drawable.monkey));
        mAnimalsList.add(new CategoryModel("Ostrich", R.drawable.ostrich));
        mAnimalsList.add(new CategoryModel("Rabbit", R.drawable.rabbit));
        mAnimalsList.add(new CategoryModel("Sheep", R.drawable.sheep));
        mAnimalsList.add(new CategoryModel("Tiger", R.drawable.tiger));
        mAnimalsList.add(new CategoryModel("Wolf", R.drawable.wolf));
        mAnimalsList.add(new CategoryModel("Zebra", R.drawable.zebra));
        return mAnimalsList;
    }

    public static ArrayList<CategoryModel> makeNumbersList(){
        ArrayList<CategoryModel> mNumbersList = new ArrayList<>();
        mNumbersList.add(new CategoryModel("0", R.drawable.zero));
        mNumbersList.add(new CategoryModel("1", R.drawable.one));
        mNumbersList.add(new CategoryModel("2", R.drawable.two));
        mNumbersList.add(new CategoryModel("3", R.drawable.three));
        mNumbersList.add(new CategoryModel("4", R.drawable.four));
        mNumbersList.add(new CategoryModel("5", R.drawable.five));
        mNumbersList.add(new CategoryModel("6", R.drawable.six));
        mNumbersList.add(new CategoryModel("7", R.drawable.seven));
        mNumbersList.add(new CategoryModel("8", R.drawable.eight));
        mNumbersList.add(new CategoryModel("9", R.drawable.nine));
        return mNumbersList;
    }

    public static ArrayList<CategoryModel> makeFoodList(){
        ArrayList<CategoryModel> mFoodList = new ArrayList<>();
        mFoodList.add(new CategoryModel("Avocado", R.drawable.avocado));
        mFoodList.add(new CategoryModel("Banana", R.drawable.banana));
        mFoodList.add(new CategoryModel("Carrot", R.drawable.carrot));
        mFoodList.add(new CategoryModel("Cucumber", R.drawable.cucumber));
        mFoodList.add(new CategoryModel("Eggplant", R.drawable.eggplant));
        mFoodList.add(new CategoryModel("Garlic", R.drawable.garlic));
        mFoodList.add(new CategoryModel("Honey", R.drawable.honey));
        mFoodList.add(new CategoryModel("Lemon", R.drawable.lemon));
        mFoodList.add(new CategoryModel("Meat", R.drawable.meat));
        mFoodList.add(new CategoryModel("Onion", R.drawable.onion));
        mFoodList.add(new CategoryModel("Orange", R.drawable.orange));
        mFoodList.add(new CategoryModel("Potato", R.drawable.potato));
        mFoodList.add(new CategoryModel("Strawberry", R.drawable.strawberry));
        mFoodList.add(new CategoryModel("Tomato", R.drawable.tomato));
        mFoodList.add(new CategoryModel("Watermelon", R.drawable.watermelon));
        return mFoodList;
    }

    public static ArrayList<CategoryModel> makeSportsList(){
        ArrayList<CategoryModel> mSportsList = new ArrayList<>();
        mSportsList.add(new CategoryModel("Baseball", R.drawable.baseball));
        mSportsList.add(new CategoryModel("Basketball", R.drawable.basketball));
        mSportsList.add(new CategoryModel("Cricket", R.drawable.cricket));
        mSportsList.add(new CategoryModel("Football", R.drawable.football));
        mSportsList.add(new CategoryModel("Golf", R.drawable.golf));
        mSportsList.add(new CategoryModel("Handball", R.drawable.handball));
        mSportsList.add(new CategoryModel("Rugby", R.drawable.rugby));
        mSportsList.add(new CategoryModel("Swimming", R.drawable.swimming));
        mSportsList.add(new CategoryModel("Tennis", R.drawable.tennis));
        mSportsList.add(new CategoryModel("Volleyball", R.drawable.volleyball));
        mSportsList.add(new CategoryModel("Wrestling", R.drawable.wrestling));
        return mSportsList;
    }

    public static ArrayList<CategoryModel> makeTransportsList(){
        ArrayList<CategoryModel> mTransportsList = new ArrayList<>();
        mTransportsList.add(new CategoryModel("Bicycle", R.drawable.bicycle));
        mTransportsList.add(new CategoryModel("Bus", R.drawable.bus));
        mTransportsList.add(new CategoryModel("Car", R.drawable.car));
        mTransportsList.add(new CategoryModel("Helicopter", R.drawable.helicopter));
        mTransportsList.add(new CategoryModel("Motorcycle", R.drawable.motorcycle));
        mTransportsList.add(new CategoryModel("Plane", R.drawable.plane));
        mTransportsList.add(new CategoryModel("Rocket", R.drawable.rocket));
        mTransportsList.add(new CategoryModel("Ship", R.drawable.ship));
        mTransportsList.add(new CategoryModel("Train", R.drawable.train));
        mTransportsList.add(new CategoryModel("Truck", R.drawable.truck));
        return mTransportsList;
    }

    public static ArrayList<CategoryModel> makeObjectsList(){
        ArrayList<CategoryModel> mObjectsList = new ArrayList<>();
        mObjectsList.add(new CategoryModel("Jug", R.drawable.jug));
        mObjectsList.add(new CategoryModel("Kite", R.drawable.kite));
        mObjectsList.add(new CategoryModel("Pen", R.drawable.pen));
        mObjectsList.add(new CategoryModel("Sun", R.drawable.sun));
        mObjectsList.add(new CategoryModel("Tree", R.drawable.tree));
        mObjectsList.add(new CategoryModel("Umbrella", R.drawable.umbrella));
        mObjectsList.add(new CategoryModel("Violin", R.drawable.violin));
        mObjectsList.add(new CategoryModel("Watch", R.drawable.watch));
        mObjectsList.add(new CategoryModel("Xylophone", R.drawable.xylophone));
        mObjectsList.add(new CategoryModel("Yoyo", R.drawable.yoyo));
        return mObjectsList;
    }
}
