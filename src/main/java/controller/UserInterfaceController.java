package controller;

import camp.nextstep.edu.missionutils.Console;

public class UserInterfaceController {
    public UserInterfaceController() {
    }

    public String enterNumber(){
        System.out.print("숫자를 입력해주세요 : ");
        return Console.readLine();
    }

    public void judgeCall(String judge){
        System.out.println(judge);
    }

    public void endCall(){
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public String replay(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return Console.readLine();
    }

}
