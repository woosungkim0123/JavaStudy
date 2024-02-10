package command.sub;

public class Button {

    private Command theCommand;

    public Button(Command theCommand) {
        setCommand(theCommand);
    }

    public void setCommand(Command newCommand) {
        this.theCommand = newCommand;
    }

    // 버튼이 눌르면 Command의 execute() 호출
    public void pressed() {
        theCommand.execute();
    }
}
