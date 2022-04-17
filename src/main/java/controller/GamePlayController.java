package controller;

import judge.Judge;

public class GamePlayController {
    private static final String END_CALL = "3스트라이크";
    private static final UserInterfaceController userInterfaceController = new UserInterfaceController();
    private Judge judge;

    public GamePlayController() {
    }

    public void startBaseBall() {
        String exit = "1";
        while ("1".equals(exit)) {
            judge = new Judge();
            playBall();
            exit = userInterfaceController.replay();
        }
    }

    private void playBall() {
        boolean exit = false;
        while (!exit) {
            String input = userInterfaceController.enterNumber();
            String output = judge.judge(input);
            userInterfaceController.judgeCall(output);
            exit = END_CALL.equals(output);
        }
        userInterfaceController.endCall();
    }
}
