/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Model;

/**
 *
 * @author akash
 */
public class PlayerStatistics {
    int numberOFGoals;
    int numberOfAssists;
    int numberOFRedCards ;
    int numberOfYellowCards;

    public int getNumberOFGoals() {
        return numberOFGoals;
    }

    public void setNumberOFGoals(int numberOFGoals) {
        this.numberOFGoals = numberOFGoals;
    }

    public int getNumberOfAssists() {
        return numberOfAssists;
    }

    public void setNumberOfAssists(int numberOfAssists) {
        this.numberOfAssists = numberOfAssists;
    }

    public int getNumberOFRedCards() {
        return numberOFRedCards;
    }

    public void setNumberOFRedCards(int numberOFRedCards) {
        this.numberOFRedCards = numberOFRedCards;
    }

    public int getNumberOfYellowCards() {
        return numberOfYellowCards;
    }

    public void setNumberOfYellowCards(int numberOfYellowCards) {
        this.numberOfYellowCards = numberOfYellowCards;
    }
    
}
