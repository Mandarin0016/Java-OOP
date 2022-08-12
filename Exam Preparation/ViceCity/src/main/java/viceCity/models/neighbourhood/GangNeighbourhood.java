package viceCity.models.neighbourhood;

import viceCity.models.guns.Gun;
import viceCity.models.players.Player;

import java.util.Collection;

public class GangNeighbourhood implements Neighbourhood {
    @Override
    public void action(Player mainPlayer, Collection<Player> civilPlayers) {
        Collection<Gun> guns = mainPlayer.getGunRepository().getModels();
        for (Gun gun : guns) {
            for (Player civilPlayer : civilPlayers) {
                while (gun.canFire() && civilPlayer.isAlive()) {
                    civilPlayer.takeLifePoints(gun.fire());
                }
                if (!gun.canFire()) {
                    break;
                }
            }
        }
        for (Player civilPlayer : civilPlayers) {
            Collection<Gun> currentCivilGuns = civilPlayer.getGunRepository().getModels();
            for (Gun currentCivilGun : currentCivilGuns) {
                while (civilPlayer.isAlive() && currentCivilGun.canFire() && mainPlayer.isAlive()) {
                    mainPlayer.takeLifePoints(currentCivilGun.fire());
                }
                if (!mainPlayer.isAlive()) {
                    return;
                }
            }
        }
    }
}
