package Frog;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<FrogCommand> commands = new ArrayList<>();
        int curCommand = -1;
        Frog frog = new Frog();
        Scanner scanner = new Scanner(System.in);
        int tmp = 0;
        int tmp1 = 0;
        List<String> frg = new ArrayList<>(11);
        while (true) {
            System.out.println("Введите команду");
            String str = scanner.next();
            if (str.equals("0"))
                break;
            if (str.equals("<<")) {
                if (curCommand < 0) {
                    System.out.println("Нечего отменять!");
                } else {
                    commands.get(curCommand).undo();
                    curCommand--;
                }
            } else if (str.equals(">>")) {
                if (curCommand == commands.size() - 1) {
                    System.out.println("Нечего отменять!");
                } else {
                    curCommand++;
                    commands.get(curCommand).doit();
                }
            } else {
                while (curCommand != commands.size() - 1) {
                    commands.remove(curCommand + 1);
                }
                if (!str.equals("!!")) {
                    try {
                        tmp = Integer.parseInt(str.trim());
                    } catch (NumberFormatException nfe) {
                        System.out.println("NumberFormatException: " + nfe.getMessage());
                        continue;
                    }
                }
                if (frog.jump(tmp) == true) {
                    FrogCommand cmd = FrogCommands.jumpRightCommand(frog, tmp);
                    curCommand++;
                    commands.add(cmd);
                    cmd.doit();
                    tmp1 = tmp;
                } else {
                    System.out.println("Нельзя туда прыгать");
                    tmp = tmp1;
                }
            }

            System.out.println(frog.position);

            for (int i = 0; i < 11; i++) {
                if (i == frog.position) {
                    frg.add("Л");
                } else {
                    frg.add("_");
                }
            }
            for (String s : frg) {
                System.out.print(s + " ");
            }
            frg.clear();
            System.out.println();
        }
    }
}
