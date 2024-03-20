package com.example.texttospeech;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;

import com.example.texttospeech.databinding.ActivityMainBinding;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private TextToSpeech textToSpeech;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setUpListener();
    }

    private void setUpListener() {
        binding.textToSpeechBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = binding.inputEt.getText().toString();
                textToSpeech = new TextToSpeech(MainActivity.this, new TextToSpeech.OnInitListener() {
                    @Override
                    public void onInit(int status) {   // this interface listen the successful initialization of textToSpeech engine
                        if (status == TextToSpeech.SUCCESS) {
                            textToSpeech.setLanguage(Locale.US);
                            textToSpeech.setSpeechRate(1.0f); // set the speed of the speech
                            textToSpeech.speak(text, TextToSpeech.QUEUE_ADD, null); // TextToSpeech.QUEUE_ADD -> TextToSpeech engine will speak the pieces of text in the order they were added to the queue:
                        }
                    }
                });
            }
        });
    }
}