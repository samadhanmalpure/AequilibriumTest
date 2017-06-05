package model;

import java.io.Serializable;
import java.util.Comparator;

/**
 * Created by Samadhan on 04-06-2017.
 */
public class TransformersInformation implements Serializable, Comparator<TransformersInformation> {

     private String mTransformerName;

     private String mTransformerType;

     private Integer mStrength;

     private Integer mIntelligence;

     private Integer mSpeed;

     private Integer mEndurence;

     private Integer mRank;

     private Integer mCourage;

     private Integer mFirePower;

     private Integer mSkills;

     private Integer overallRatings;

     private int noOfVictories;

    public String getTransformerName() {
        return mTransformerName;
    }

    public void setTransformerName(String transformerName) {
        this.mTransformerName = transformerName;
    }

    public String getTransformerType() {
        return mTransformerType;
    }

    public void setTransformerType(String transformerType) {
        this.mTransformerType = transformerType;
    }

    public Integer getStrength() {
        return mStrength;
    }

    public void setStrength(Integer strength) {
        this.mStrength = strength;
    }

    public Integer getIntelligence() {
        return mIntelligence;
    }

    public void setIntelligence(Integer intelligence) {
        this.mIntelligence = intelligence;
    }

    public Integer getSpeed() {
        return mSpeed;
    }

    public void setSpeed(Integer speed) {
        this.mSpeed = speed;
    }

    public Integer getEndurence() {
        return mEndurence;
    }

    public void setEndurence(Integer endurence) {
        this.mEndurence = endurence;
    }

    public Integer getRank() {
        return mRank;
    }

    public void setRank(Integer rank) {
        this.mRank = rank;
    }

    public Integer getCourage() {
        return mCourage;
    }

    public void setCourage(Integer courage) {
        this.mCourage = courage;
    }

    public Integer getFirePower() {
        return mFirePower;
    }

    public void setFirePower(Integer firePower) {
        this.mFirePower = firePower;
    }

    public Integer getSkills() {
        return mSkills;
    }

    public void setSkills(Integer skills) {
        this.mSkills = skills;
    }

    public int getNoOfVictories() {
        return noOfVictories;
    }

    public void noOfBattlesWon() {
        this.noOfVictories++;
    }



    public Integer getOverallRatings() {
        return overallRatings;
    }

    public void setOverallRatings(Integer overallRatings) {
        this.overallRatings = overallRatings;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return super.toString();
    }


    /*Comparator for sorting the list by Student Name*/
    public static Comparator<TransformersInformation> transformersInformationComparator = new Comparator<TransformersInformation>() {

        public int compare(TransformersInformation t1, TransformersInformation t2) {
            Integer rank = t1.getRank();
            Integer rankOne = t2.getRank();

            //ascending order
            return rank.compareTo(rankOne);


        }};


    @Override
    public int compare(TransformersInformation o1, TransformersInformation o2) {


        return 0;
    }

    public int calculateOverallRatings(TransformersInformation t){
        return t.getStrength() + t.getIntelligence() + t.getSpeed() + t.getEndurence() + t.getFirePower();
    }
}
