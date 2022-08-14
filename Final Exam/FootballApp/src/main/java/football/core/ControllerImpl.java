package football.core;


import football.common.ConstantMessages;
import football.common.ExceptionMessages;
import football.entities.field.ArtificialTurf;
import football.entities.field.Field;
import football.entities.field.NaturalGrass;
import football.entities.player.Men;
import football.entities.player.Player;
import football.entities.player.Women;
import football.entities.supplement.Liquid;
import football.entities.supplement.Powdered;
import football.entities.supplement.Supplement;
import football.repositories.SupplementRepository;
import football.repositories.SupplementRepositoryImpl;

import java.util.ArrayList;
import java.util.Collection;

public class ControllerImpl implements Controller {

    private SupplementRepository supplement;
    private Collection<Field> fields;

    public ControllerImpl() {
        this.supplement = new SupplementRepositoryImpl();
        this.fields = new ArrayList<>();
    }

    @Override
    public String addField(String fieldType, String fieldName) {
        Field field;
        switch (fieldType) {
            case "ArtificialTurf":
                field = new ArtificialTurf(fieldName);
                break;
            case "NaturalGrass":
                field = new NaturalGrass(fieldName);
                break;
            default:
                throw new NullPointerException(ExceptionMessages.INVALID_FIELD_TYPE);
        }
        this.fields.add(field);
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_FIELD_TYPE, fieldType);
    }

    @Override
    public String deliverySupplement(String type) {
        Supplement supplementToBeDelivered;
        switch (type) {
            case "Powdered":
                supplementToBeDelivered = new Powdered();
                break;
            case "Liquid":
                supplementToBeDelivered = new Liquid();
                break;
            default:
                throw new IllegalArgumentException(ExceptionMessages.INVALID_SUPPLEMENT_TYPE);
        }
        this.supplement.add(supplementToBeDelivered);
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_SUPPLEMENT_TYPE, type);
    }

    private Field findFieldByName(String fieldName) {
        for (Field field : this.fields) {
            if (field.getName().equals(fieldName)) {
                return field;
            }
        }
        return null;
    }

    @Override
    public String supplementForField(String fieldName, String supplementType) {
        Supplement supplementToBeAdded = this.supplement.findByType(supplementType);
        if (supplementToBeAdded == null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.NO_SUPPLEMENT_FOUND, supplementType));
        }
        Field field = findFieldByName(fieldName);
        field.addSupplement(supplementToBeAdded);
        this.supplement.remove(supplementToBeAdded);
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_SUPPLEMENT_IN_FIELD, supplementType, fieldName);
    }

    @Override
    public String addPlayer(String fieldName, String playerType, String playerName, String nationality, int strength) {
        Field field = findFieldByName(fieldName);
        Player player;
        switch (playerType) {
            case "Men":
                player = new Men(playerName, nationality, strength);
                break;
            case "Women":
                player = new Women(playerName, nationality, strength);
                break;
            default:
                throw new IllegalArgumentException(ExceptionMessages.INVALID_PLAYER_TYPE);
        }

        boolean validSituationOne = player.getClass().getSimpleName().equals("Women") && field.getClass().getSimpleName().equals("ArtificialTurf");
        boolean validSituationTwo = player.getClass().getSimpleName().equals("Men") && field.getClass().getSimpleName().equals("NaturalGrass");

        String result;
        if (validSituationOne || validSituationTwo) {
            field.addPlayer(player);
            result = String.format(ConstantMessages.SUCCESSFULLY_ADDED_PLAYER_IN_FIELD, playerType, fieldName);
        } else {
            result = ConstantMessages.FIELD_NOT_SUITABLE;
        }
        return result;
    }

    @Override
    public String dragPlayer(String fieldName) {
        Field field = findFieldByName(fieldName);
        field.drag();
        return String.format(ConstantMessages.PLAYER_DRAG, field.getPlayers().size());
    }

    @Override
    public String calculateStrength(String fieldName) {
        Field field = findFieldByName(fieldName);
        int sum = field.getPlayers().stream().mapToInt(Player::getStrength).sum();
        return String.format(ConstantMessages.STRENGTH_FIELD, fieldName, sum);
    }

    @Override
    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        for (Field field : this.fields) {
            sb.append(field.getInfo()).append(System.lineSeparator());
        }
        return sb.toString().trim();
    }
}
