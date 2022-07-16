package word;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommandImpl implements CommandInterface {
    class ToUpperTransform implements TextTransform {
        @Override
        public void invokeOn(StringBuilder text, int startIndex, int endIndex) {
            for (int i = startIndex; i < endIndex; i++) {
                text.setCharAt(i, Character.toUpperCase(text.charAt(i)));
            }
        }
    }

    class ToCutTransform implements TextTransform {
        @Override
        public void invokeOn(StringBuilder text, int startIndex, int endIndex) {
            lastCut.setLength(0);
            for (int i = startIndex; i < endIndex; i++) {
                lastCut.append(text.charAt(i));
            }
            text.delete(startIndex, endIndex);
        }
    }

    class ToPasteTransform implements TextTransform {
        @Override
        public void invokeOn(StringBuilder text, int startIndex, int endIndex) {
            text.delete(startIndex, endIndex);
            for (int i = 0; i < lastCut.length(); i++) {
                text.insert(startIndex++, lastCut.charAt(i));
            }
        }
    }

    private final Map<String, TextTransform> commandTransforms;
    private StringBuilder text;
    private StringBuilder lastCut;

    public CommandImpl(StringBuilder text) {
        this.commandTransforms = new HashMap<>();
        this.text = text;
        this.lastCut = new StringBuilder();
    }

    @Override
    public void init() {
        this.commandTransforms.clear();
        for (Command p : this.initCommands()) {
            this.commandTransforms.putIfAbsent(p.getText(), p.getTextTransform());
        }
    }

    @Override
    public void handleInput(String input) {
        String[] tokens = input.split("\\s+");

        String commandName = tokens[0];
        int startInd = Integer.parseInt(tokens[1]);
        int endInd = Integer.parseInt(tokens[2]);

        this.commandTransforms.get(commandName).invokeOn(this.text, startInd, endInd);
    }

    protected List<Command> initCommands() {
        List<Command> commands = new ArrayList<>();
        commands.add(new Command("uppercase", new ToUpperTransform()));
        commands.add(new Command("cut", new ToCutTransform()));
        commands.add(new Command("paste", new ToPasteTransform()));
        return commands;
    }
}
