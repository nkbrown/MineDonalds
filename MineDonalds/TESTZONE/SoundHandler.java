package MineDonalds.TESTZONE;

import net.minecraftforge.client.event.sound.SoundLoadEvent;
import net.minecraftforge.event.ForgeSubscribe;

public class SoundHandler {
@ForgeSubscribe
public void onSound(SoundLoadEvent event) {
event.manager.addSound("minedonalds:tune.ogg");
}

}