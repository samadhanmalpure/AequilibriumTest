package service;


import model.BattleResultInformation;
import model.TransformersInformation;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Samadhan on 04-06-2017.
 */
public class BattleService {

    private static final int GAME_DESTROYED = -1;
    private static final int WINNER_FOUND = 0;
    private ArrayList<TransformersInformation> arrayListOfTeams;
    private static final String GAME_DESTROYED_STRING = "Game Destroyed";
    private static final String  OPTIMUS_PRIME= "Optimus Prime";
    private static final String PREDAKING = "Predaking";
    private static final int COURAGE_VALUE = 4;
    private static final int STRENGTH_VALUE = 3;
    private static final int SKILL_VALUE = 3;


    public void battle(ArrayList<TransformersInformation> arrayOfTeams) {
        this.arrayListOfTeams = arrayOfTeams;
        BattleResultInformation result =  this.getBattleResult(arrayOfTeams);

        this.showResult(result);
    }

    private void showResult(BattleResultInformation result) {
        switch (result.getGameState()){
            case WINNER_FOUND:
                System.out.println("\n Winning Team Name - " + result.getWinningTeam().getTransformerName() + "\n no of battles - " + result.getNumberOfBattles());
                break;

            case GAME_DESTROYED:
                System.out.println(GAME_DESTROYED_STRING + "\n no of battles -  " + result.getNumberOfBattles());
                break;
        }
    }

    private BattleResultInformation getBattleResult(ArrayList<TransformersInformation> arrayListOfTeams) {
        this.arrayListOfTeams = arrayListOfTeams;
        BattleResultInformation battleResultInformation = new BattleResultInformation();


        Collections.sort(arrayListOfTeams, TransformersInformation.transformersInformationComparator);

        //Display teams sorted by rank.
        System.out.println("Teams sorted by rank are as follows");

        for (TransformersInformation t : arrayListOfTeams) {
            System.out.println("" + t.getTransformerName() + " rank -- " + t.getRank());
        }

        battleResultInformation  = startBattle();
        return battleResultInformation;

    }

    private BattleResultInformation startBattle(){
        BattleResultInformation result = getWinnerTeamOnSpecialCondition();

        if(result != null ) {
            return result;
        } else {
            return getBalttleResult();
        }
    }

    private BattleResultInformation getWinnerTeamOnSpecialCondition(){
        ArrayList<BattleResultInformation> listOfWinners = new ArrayList<>();

        for(int i = 0; i< arrayListOfTeams.size(); i++){
            TransformersInformation t1 = arrayListOfTeams.get(i);

            if(t1.getTransformerName().equals(OPTIMUS_PRIME) || t1.getTransformerName().equals(PREDAKING))
                listOfWinners.add(createWinningTeamObject(t1));

            t1.setOverallRatings(t1.calculateOverallRatings(arrayListOfTeams.get(i)));
        }

        if(listOfWinners.size() == 1) {
            return listOfWinners.get(0);
        } else if(listOfWinners.size() > 1){
            return createGameDestroyedObject();
        }

        return null;
    }


    private BattleResultInformation  getBalttleResult(){
        TransformersInformation t1 = arrayListOfTeams.get(0);
        int i = 1;
        while(i < arrayListOfTeams.size()) {
            TransformersInformation t2 = arrayListOfTeams.get(i);
            t1 = getWinnerTeam(t1, t2);
            if(t1 == null ) {
                BattleResultInformation battle = checkGameStatus(i, arrayListOfTeams);
                if(battle == null)
                    i = i + 1;
                else
                    return battle;
                t1 = arrayListOfTeams.get(i);
            }
            i++;
        }

        return createWinningTeamObject(t1);
    }

    private TransformersInformation getWinnerTeam(TransformersInformation t1, TransformersInformation t2){


        if((t2.getCourage() - t1.getCourage()  >= COURAGE_VALUE) &&  (t2.getStrength() - t1.getStrength() >= STRENGTH_VALUE)) {
            t2.noOfBattlesWon();
            return t2;
        } else if((t1.getCourage() -t2.getCourage()  >= COURAGE_VALUE) &&  (t1.getStrength()- t2.getStrength() >= STRENGTH_VALUE)){
            t1.noOfBattlesWon();
            return t1;
        } else if(t2.getSkills()-  t1.getSkills()  >= SKILL_VALUE){
            t2.noOfBattlesWon();
            return t2;
        }else if((t1.getSkills()) - t2.getSkills() >= SKILL_VALUE){
            t1.noOfBattlesWon();
            return t1;
        } else if(t2.getOverallRatings() > t2.getOverallRatings()){
            t2.noOfBattlesWon();
            return t1;
        } else if(t1.getOverallRatings() > t2.getOverallRatings()) {
            t1.noOfBattlesWon();
            return t1;
        } else if(t1.getOverallRatings() == t2.getOverallRatings()) {
            return null;
        }
        return t1;
    }

    private BattleResultInformation checkGameStatus(int position, ArrayList<TransformersInformation> arrayListOfTeams){

        if(position + 2 == arrayListOfTeams.size()){
            return  createWinningTeamObject(arrayListOfTeams.get(position+1));
        } else if(position+1 < arrayListOfTeams.size()){
            // more team exists.
            return null;
        } else {
            return createGameDestroyedObject();
        }
    }

    private BattleResultInformation createWinningTeamObject(TransformersInformation t){
        BattleResultInformation mBattleResultInformation = new BattleResultInformation();
        mBattleResultInformation.setWinningTeam(t);
        mBattleResultInformation.setNumberOfBattles(t.getNoOfVictories());
        mBattleResultInformation.setLosingTeam("");
        mBattleResultInformation.setGameState(WINNER_FOUND);

        return mBattleResultInformation;
    }

    private BattleResultInformation createGameDestroyedObject(){
        BattleResultInformation battleResultInformation = new BattleResultInformation();
        battleResultInformation.setGameState(GAME_DESTROYED);
        return battleResultInformation;
    }
}
