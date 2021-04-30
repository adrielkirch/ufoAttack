package br.unisul.ufo.attack.utils;

import br.unisul.ufo.attack.exceptions.GameException;
import java.io.File;
import java.util.HashMap;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

/**
 * Armazenador de audio
 *
 * @author Adriel Kirch
 */
public class SoundPool {

    private static SoundPool instance = null;
    private HashMap<String, File> clips = new HashMap();

    /**
     * Construir SoundPool
     */
    private SoundPool() {
        registerClips();
    }

    /**
     * Obter instancia do objeto
     *
     * @return
     */
    public static SoundPool getInstance() {
        if (SoundPool.instance == null) {
            SoundPool instance = new SoundPool();
            SoundPool.instance = instance;
        }
        return SoundPool.instance;
    }

    /**
     * Registar clips de audio.
     */
    public void registerClips() {
          clips.put("song", new File("src//main//java//br//unisul//ufo//attack//resources//ufoAttack.wav"));
        clips.put("laser", new File("src//main//java//br//unisul//ufo//attack//resources//laserKiss.wav"));
        clips.put("cow", new File("src//main//java//br//unisul//ufo//attack//resources//cow.wav"));
        clips.put("explosion", new File("src//main//java//br//unisul//ufo//attack//resources//explosion.wav"));
    }

    /**
     * Executar clipe de audio.
     *
     * @param name
     */
    public boolean playClip(String name) {
        File file = clips.get(name);

        if (file == null) {
            throw new GameException("Clip nâo encontrado");
        }
        try {

            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(file));

            new Thread(new Runnable() {
                @Override
                public void run() {
                    clip.start();
                }
            }).start();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return true;
    }

    public void playClipLoop(String name) {
        File file = clips.get(name);

        if (file == null) {
            throw new GameException("Clip nâo encontrado");
        }

        try {

            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(file));
            new Thread(new Runnable() {
                @Override
                public void run() {
                    clip.loop(Clip.LOOP_CONTINUOUSLY);
                }
            }).start();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
