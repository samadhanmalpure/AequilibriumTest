package controller;


import model.TransformersInformation;
import service.BattleService;
import java.util.ArrayList;


/**
 * Created by Samadhan on 04-06-2017.
 */
public class TransformationController {

    /** The battle service. */
    private BattleService battleService;

    public static void main(String[] args) {
        TransformationController transformationController = new TransformationController();

        BattleService battleService = new BattleService();
        transformationController.setBattleService(battleService);

        transformationController.startBattle(transformationController.init());
    }


    private ArrayList<TransformersInformation> init(){

        ArrayList<TransformersInformation> arrayOfTeams = new ArrayList<>();

        TransformersInformation teamOne = new TransformersInformation();
        TransformersInformation teamTwo = new TransformersInformation();
        TransformersInformation teamThree = new TransformersInformation();

        //Soundwave, D, 8,9,2,6,7,5,6,10

        teamOne.setTransformerName("Soundwave");
        teamOne.setTransformerType("Decepticons");
        teamOne.setStrength(8);
        teamOne.setIntelligence(9);
        teamOne.setSpeed(2);
        teamOne.setEndurence(6);
        teamOne.setRank(7);
        teamOne.setCourage(5);
        teamOne.setFirePower(6);
        teamOne.setSkills(10);

        //Bluestreak, A, 6,6,7,9,5,2,9,7

        teamTwo.setTransformerName("Bluestreak");
        teamTwo.setTransformerType("Autobots");
        teamTwo.setStrength(6);
        teamTwo.setIntelligence(6);
        teamTwo.setSpeed(7);
        teamTwo.setEndurence(9);
        teamTwo.setRank(5);
        teamTwo.setCourage(2);
        teamTwo.setFirePower(9);
        teamTwo.setSkills(7);


        //Hubcap: A, 4,4,4,4,4,4,4,4

        teamThree.setTransformerName("Hubcap");
        teamThree.setTransformerType("Autobots");
        teamThree.setStrength(4);
        teamThree.setIntelligence(4);
        teamThree.setSpeed(4);
        teamThree.setEndurence(4);
        teamThree.setRank(4);
        teamThree.setCourage(4);
        teamThree.setFirePower(4);
        teamThree.setSkills(4);

        arrayOfTeams.add(teamOne);
        arrayOfTeams.add(teamTwo);
        arrayOfTeams.add(teamThree);

        return arrayOfTeams;
    }

    /**
     * Start battle.
     */
    private void startBattle(ArrayList<TransformersInformation> arrayOfTeams) {
        this.battleService.battle(arrayOfTeams);
    }

    /**
     * Sets the battle service.
     *
     * @param battleService
     *            the new battle service
     */
    public void setBattleService(BattleService battleService) {
        this.battleService = battleService;
    }
}


