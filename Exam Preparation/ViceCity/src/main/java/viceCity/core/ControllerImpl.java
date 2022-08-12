package viceCity.core;

import viceCity.common.ConstantMessages;
import viceCity.core.interfaces.Controller;
import viceCity.models.guns.Gun;
import viceCity.models.guns.Pistol;
import viceCity.models.guns.Rifle;
import viceCity.models.neighbourhood.GangNeighbourhood;
import viceCity.models.neighbourhood.Neighbourhood;
import viceCity.models.players.CivilPlayer;
import viceCity.models.players.MainPlayer;
import viceCity.models.players.Player;
import viceCity.repositories.GunRepository;
import viceCity.repositories.interfaces.Repository;

import java.util.ArrayList;
import java.util.Collection;

public class ControllerImpl implements Controller {

    private Repository<Gun> gunRepository;
    private Collection<Player> players;
    private Player mainPlayer;


    public ControllerImpl() {
        this.gunRepository = new GunRepository();
        this.players = new ArrayList<>();
        this.mainPlayer = new MainPlayer();
    }

    @Override
    public String addPlayer(String name) {
        Player player = new CivilPlayer(name);
        this.players.add(player);
        return String.format(ConstantMessages.PLAYER_ADDED, name);
    }

    @Override
    public String addGun(String type, String name) {
        Gun gun;
        switch (type) {
            case "Pistol":
                gun = new Pistol(name);
                break;
            case "Rifle":
                gun = new Rifle(name);
                break;
            default:
                return ConstantMessages.GUN_TYPE_INVALID;
        }
        this.gunRepository.add(gun);
        return String.format(ConstantMessages.GUN_ADDED, name, type);
    }

    @Override
    public String addGunToPlayer(String name) {
        Player player = null;
        if (name.equals("Vercetti")) {
            player = mainPlayer;
        } else {
            for (Player player1 : players) {
                if (player1.getName().equals(name)) {
                    player = player1;
                }
            }
        }
        if (player == null) {
            return ConstantMessages.CIVIL_PLAYER_DOES_NOT_EXIST;
        }
        if (gunRepository.getModels().isEmpty()) {
            return ConstantMessages.GUN_QUEUE_IS_EMPTY;
        }
        Gun gun = null;
        for (Gun model : gunRepository.getModels()) {
            player.getGunRepository().add(model);
            gun = model;
            gunRepository.remove(model);
            break;
        }
        String result;
        if (player.getName().equals(mainPlayer.getName())) {
            result = String.format(ConstantMessages.GUN_ADDED_TO_MAIN_PLAYER, gun.getName(), player.getName());
        } else {
            result = String.format(ConstantMessages.GUN_ADDED_TO_CIVIL_PLAYER, gun.getName(), player.getName());
        }
        return result;
    }

    @Override
    public String fight() {
        Neighbourhood neighbourhood = new GangNeighbourhood();
        int initialNumberOfCivilPlayers = this.players.size();
        int initialPointsOfMainPlayer = this.mainPlayer.getLifePoints();
        neighbourhood.action(this.mainPlayer, this.players);
        Collection<Player> newCivilPlayersCollection = new ArrayList<>();
        for (Player player : this.players) {
            if (player.isAlive()){
                newCivilPlayersCollection.add(player);
            }
        }
        this.players = newCivilPlayersCollection;
        StringBuilder result = new StringBuilder();
        if (initialPointsOfMainPlayer == this.mainPlayer.getLifePoints() && initialNumberOfCivilPlayers == this.players.size()) {
            result.append(ConstantMessages.FIGHT_HOT_HAPPENED);
        } else {
            result.append(ConstantMessages.FIGHT_HAPPENED).append(System.lineSeparator());
            result.append(String.format(ConstantMessages.MAIN_PLAYER_LIVE_POINTS_MESSAGE, mainPlayer.getLifePoints())).append(System.lineSeparator());
            int killedCivil = initialNumberOfCivilPlayers - this.players.size();
            int leftCivil = this.players.size();
            result.append(String.format(ConstantMessages.MAIN_PLAYER_KILLED_CIVIL_PLAYERS_MESSAGE, killedCivil)).append(System.lineSeparator());
            result.append(String.format(ConstantMessages.CIVIL_PLAYERS_LEFT_MESSAGE, leftCivil)).append(System.lineSeparator());
        }
        return result.toString().trim();
    }
}
