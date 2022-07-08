package footballTeamGenerator;

public class Player {
    private String name;
    private int endurance;
    private int sprint;
    private int dribble;
    private int passing;
    private int shooting;

    public Player(String name, int endurance, int sprint, int dribble, int passing, int shooting) {
        setName(name);
        setEndurance(endurance);
        setSprint(sprint);
        setDribble(dribble);
        setPassing(passing);
        setShooting(shooting);
    }

    private void validateSkill(int value, String skillName) {
        if (value < 0 || value > 100) {
            throw new IllegalArgumentException(skillName + ExceptionMessages.INVALID_SKILL);
        }
    }

    public String getName() {
        return this.name;
    }

    private void setName(String name) {
        if (name.trim().isEmpty()) {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_NAME);
        }
        this.name = name;
    }

    private void setEndurance(int endurance) {
        validateSkill(endurance, "Endurance");
        this.endurance = endurance;
    }

    private void setSprint(int sprint) {
        validateSkill(sprint, "Sprint");
        this.sprint = sprint;
    }

    private void setDribble(int dribble) {
        validateSkill(dribble, "Dribble");
        this.dribble = dribble;
    }

    private void setPassing(int passing) {
        validateSkill(passing, "Passing");
        this.passing = passing;
    }

    private void setShooting(int shooting) {
        validateSkill(shooting, "Shooting");
        this.shooting = shooting;
    }

    public double overallSkillLevel(){
        return (this.endurance + this.sprint + this.dribble + this.passing + this.shooting) / 5.00;
    }
}
