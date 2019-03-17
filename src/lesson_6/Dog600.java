package lesson_6;

public class Dog600 extends Animal{
    @Override
    public boolean run(int lengthRun) {
        int MAX_LENGTH = 600;
        boolean flag = false;
        if (lengthRun < MAX_LENGTH && lengthRun > 0) {
            flag = true;
            System.out.print("run: " + flag);
            return flag;
        }
        System.out.print("run: " + flag);
        return false;
    }

    @Override
    public boolean swim(int lengthSwim) {
        int MAX_LENGTH = 10;
        boolean flag = false;
        if (lengthSwim < MAX_LENGTH && lengthSwim > 0) {
            flag = true;
            System.out.print("run: " + flag);
            return flag;
        }
        System.out.print("run: " + flag);
        return false;
    }

    @Override
    public boolean jump(double heightJump) {
        System.out.println();
        double MAX_HEIGHT = 2.0;
        boolean flag = false;
        if (heightJump < MAX_HEIGHT && heightJump > 0) {
            flag = true;
            System.out.print("(double) jump: " + flag);
            return flag;
        }
        System.out.print("(double) jump: " + flag);
        return false;
    }

}
