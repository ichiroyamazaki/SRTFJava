package SRTFJava;

import java.util.Scanner;

public class SRTF {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char restart;

        do {
            runSRTF(sc);
            System.out.println("");
            System.out.print("Process completed. Do you want to restart? (Y/N): ");
            restart = sc.next().charAt(0);

        } while (restart == 'Y' || restart == 'y');
        System.out.println("");
        System.out.println("Program terminated. Closing in 5 seconds...");
        System.out.println("");
        System.out.println("Created by Ichiro P. Yamazaki");
        System.out.println("From: BSCpE-2A, a Task Performance in Operating System (Finals)");
        System.out.println("Powered by JavaFX");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        sc.close();
    }

    public static void runSRTF(Scanner sc) {
        int n;
        float avgwt, avgta, totalTime;
        System.out.println("----------------------------------------");
        System.out.println("     Shortest Remaining Time First      ");
        System.out.println("----------------------------------------");
        System.out.print("Enter the number of process: ");
        n = sc.nextInt();
        int pid[] = new int[n];
        int at[] = new int[n];
        int bt[] = new int[n];
        int ct[] = new int[n];
        int ta[] = new int[n];
        int wt[] = new int[n];
        int rt[] = new int[n];
        int f[] = new int[n];
        int st = 0;
        int tot = 0;
        avgwt = 0;
        avgta = 0;
        totalTime = 0;
        for (int i = 0; i < n; i++) {
            System.out.print("Enter Arrival Time for Process " + (i + 1) + ": ");
            at[i] = sc.nextInt();
            System.out.print("Enter Burst Time for Process " + (i + 1) + ": ");
            bt[i] = sc.nextInt();
            pid[i] = i + 1;
            rt[i] = bt[i];
            f[i] = 0;
        }
        while (true) {
            int c = n, min = 999;
            if (tot == n) {
                break;
            }

            for (int i = 0; i < n; i++) {
                if ((at[i] <= st) && (f[i] == 0) && (rt[i] < min)) {
                    min = rt[i];
                    c = i;
                }
            }

            if (c == n) {
                st++;
            } else {
                rt[c]--;
                st++;
                if (rt[c] == 0) {
                    ct[c] = st;
                    ta[c] = ct[c] - at[c];
                    wt[c] = ta[c] - bt[c];
                    f[c] = 1;
                    tot++;
                }
            }
        }
        System.out.print("|-----|---------|-------|----------|------|---------|");
        System.out.println("\n| pid | arrival | burst | complete | turn | waiting |");
        System.out.println("|-----|---------|-------|----------|------|---------|");
        for (int i = 0; i < n; i++) {
            avgwt += wt[i];
            avgta += ta[i];
            System.out.printf("| %-3d | %-7d | %-5d | %-8d | %-4d | %-7d |%n",
                    pid[i], at[i], bt[i], ct[i], ta[i], wt[i]);
            totalTime = Math.max(totalTime, ct[i]);
        }
        System.out.println("|-----|---------|-------|----------|------|---------|");
        System.out.println("");
        System.out.printf("Total Time: %d%n", (int) totalTime);
        System.out.printf("\nAverage Waiting Time: %.2fms%n", (avgwt / n));
        System.out.printf("Average Turnaround Time: %.2fms%n", (avgta / n));

        StringBuilder gantt = new StringBuilder();

        gantt.append("\nGantt Chart:\n+");
        for (int i = 0; i < totalTime; i++) {
            gantt.append("---+");
        }
        gantt.append("\n");

        for (int i = 0; i < n; i++) {
            int curr = ct[i];

            if (i > 0 && ct[i - 1] != curr) {
                gantt.append("|");
                gantt.append(String.format("%3d", ct[i - 1] + 1));
                gantt.append("|");
            }

            gantt.append("=");
            gantt.append(String.format("%2d", pid[i]));
            gantt.append("=");

            if (i == n - 1) {
                gantt.append("|");
                gantt.append(String.format("%3d", curr));
                gantt.append("|");
            }
        }

        gantt.append("\n+");
        for (int i = 0; i < totalTime; i++) {
            gantt.append("---+");
        }
        gantt.append("\n");
        System.out.println(gantt.toString());
    }
}
