package Dependencies.Games;

import Dependencies.Systems.User;

import java.util.ArrayList;
import java.util.HashMap;

public class Crash extends GamblingGame {
    private ArrayList<User> currentPlayers;
    private double multiplier;
    private double bustingPoint;
    private HashMap<Integer, Float> currentPlayerMultiplers;
}
