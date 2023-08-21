package Chapter02;

import java.util.Objects;

interface Player {
    void run();
}


class TennisPlayer implements Player {

    @Override
    public void run() {
        System.out.println("TennisPlayer");
    }
}

class FootBallPlayer implements Player {

    @Override
    public void run() {
        System.out.println("FootBallPlayer");
    }
}

class SnookerPlayer implements Player {

    @Override
    public void run() {
        System.out.println("SnookerPlayer");
    }
}


enum PlayerType {
    TENNIS,
    FOOTBALL,
    SNOOKER,
    UNKNOWN,
}

public class Chapter55 {

    private static Player createPlayer(PlayerType playerType) {
        switch (playerType)  {
            case TENNIS :
                return new TennisPlayer();
            case FOOTBALL:
                return new FootBallPlayer();
            case SNOOKER:
                return new SnookerPlayer();
            default:
                throw new IllegalArgumentException();
        }

    }

    // jdk 12
    // default를 생략할 수는 있지만, enum 추가 시 컴파일 에러
    private static Player createPlayerV2(PlayerType playerType) {
        return switch (playerType)  {
            case TENNIS ->
                new TennisPlayer();
            case FOOTBALL ->
                new FootBallPlayer();
            case SNOOKER ->
                new SnookerPlayer();
            default->
                throw new IllegalArgumentException();
        };
    }

    public static void main(String[] args) {
        createPlayer(PlayerType.UNKNOWN).run();
        createPlayerV2(PlayerType.UNKNOWN).run();
    }
}
