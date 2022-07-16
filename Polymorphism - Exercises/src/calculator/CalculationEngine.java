package calculator;

import java.util.ArrayDeque;

public class CalculationEngine {
    private int result;
    private Operation currentOperation;
    private ArrayDeque<Integer> memorySave;

    public CalculationEngine(){
        this.result = 0;
        this.currentOperation = null;
        this.memorySave = new ArrayDeque<>();
    }

   public void pushNumber(int number) {
        if (this.currentOperation != null) {
            if(currentOperation instanceof MemoryRecallOperation) {
                currentOperation.addOperand(memorySave.pop());
            } else {
                currentOperation.addOperand(number);
            }

            if (currentOperation.isCompleted()) {
                if(currentOperation instanceof MemorySaveOperation) {
                    this.memorySave.push(currentOperation.getResult());
                } else {
                    this.result = currentOperation.getResult();
                }
                this.currentOperation = null;
            }

        } else {
            this.result = number;
        }
    }

    void pushOperation(Operation operation) {
        if (operation.isCompleted()) {
            this.pushNumber(operation.getResult());
        } else if (this.currentOperation != null && operation instanceof MemoryRecallOperation) {
            this.pushNumber(this.memorySave.pop());
        } else {
            this.currentOperation = operation;
            this.pushNumber(this.result);
        }
    }

    int getCurrentResult() {
        return this.result;
    }
}
