package abdoroid.englishalphabet.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Pair;

import com.huawei.hms.mlsdk.common.MLApplication;
import com.huawei.hms.mlsdk.tts.MLTtsAudioFragment;
import com.huawei.hms.mlsdk.tts.MLTtsCallback;
import com.huawei.hms.mlsdk.tts.MLTtsConfig;
import com.huawei.hms.mlsdk.tts.MLTtsConstants;
import com.huawei.hms.mlsdk.tts.MLTtsEngine;
import com.huawei.hms.mlsdk.tts.MLTtsError;
import com.huawei.hms.mlsdk.tts.MLTtsWarn;

import abdoroid.englishalphabet.R;
import abdoroid.englishalphabet.ui.DialogActivity;
import abdoroid.englishalphabet.ui.MainActivity;


public class GetTTS {

    private static MLTtsEngine mlTtsEngine;

    public static void initVoice(Context context){

        SharedPreferences prefs = context.getSharedPreferences(DialogActivity.MyPREFERENCES, Context.MODE_PRIVATE);
        String voiceType = prefs.getString(DialogActivity.VOICE_TYPE, "Male-en");
        float voiceSpeed = prefs.getFloat(DialogActivity.VOICE_SPEED,1.0f);
        float voiceVolume = prefs.getFloat(DialogActivity.VOICE_VOLUME, 1.0f);

        MLApplication.getInstance().setApiKey(context.getString(R.string.ApiKey));
        final MLTtsCallback callback = new MLTtsCallback() {
            @Override
            public void onError(String taskId, MLTtsError err) {
            }
            @Override
            public void onWarn(String taskId, MLTtsWarn warn) {
            }
            @Override
            public void onRangeStart(String taskId, int start, int end) {

            }

            @Override
            public void onAudioAvailable(String s, MLTtsAudioFragment mlTtsAudioFragment, int i, Pair<Integer, Integer> pair, Bundle bundle) {

            }

            @Override
            public void onEvent(String taskId, int eventId, Bundle bundle) {

            }
        };
        MLTtsConfig mlTtsConfig = new MLTtsConfig()
                .setLanguage(MLTtsConstants.TTS_EN_US)
                .setPerson(voiceType)
                .setSpeed(voiceSpeed)
                .setVolume(voiceVolume);

        mlTtsEngine = new MLTtsEngine(mlTtsConfig);
        mlTtsEngine.setTtsCallback(callback);
    }

    public static void startVoice(String string){
        String id = mlTtsEngine.speak(string, MLTtsEngine.QUEUE_APPEND);
    }
}
