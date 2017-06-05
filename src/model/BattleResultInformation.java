package model;

import java.io.Serializable;

/**
 * Created by Samadhan on 04-06-2017.
 */
public class BattleResultInformation implements Serializable {

    private int mNumberOfBattles;

    private TransformersInformation mWinningTeam;

    private String mLosingTeam;

    private int mGameState;

    public int getNumberOfBattles() {
        return mNumberOfBattles;
    }

    public void setNumberOfBattles(int numberOfBattles) {
        this.mNumberOfBattles = numberOfBattles;
    }

    public TransformersInformation getWinningTeam() {
        return mWinningTeam;
    }

    public void setWinningTeam(TransformersInformation winningTeam) {
        this.mWinningTeam = winningTeam;
    }

    public String getLosingTeam() {
        return mLosingTeam;
    }

    public void setLosingTeam(String losingTeam) {
        this.mLosingTeam = losingTeam;
    }

    public int getGameState() {
        return mGameState;
    }

    public void setGameState(int gameState) {
        this.mGameState = gameState;
    }
}
