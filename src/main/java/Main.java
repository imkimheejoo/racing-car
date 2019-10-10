import domain.Cars;
import domain.RacingGame;
import domain.RandomStrategy;
import domain.RoundResults;
import view.InputView;
import view.OutputView;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> carNames = InputView.readCarNames();
        int round = InputView.readRound();

        Cars cars = new Cars(carNames);
        RacingGame racingGame = new RacingGame(cars, round);
        RoundResults roundResults = racingGame.play(new RandomStrategy(), new RoundResults());

        roundResults.getResults().forEach((r, roundResult) -> OutputView.printPositionByRound(roundResult.getCars()));

        OutputView.printWinners(racingGame.findWinners());
    }
}
