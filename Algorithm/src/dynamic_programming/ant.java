package dynamic_programming;

import java.util.Scanner;

/** 개미 전사
 * 개미 전사는 부족한 식량을 충당하고 메뚜기 마을의 식량창고를 몰래 공격하려고 한다. 메뚜기 마을에는 여러 개의 식량 창고가 있는데 식량창고는 일직선으로 이어져있다.
 *
 * 각 식량 창고에는 정해진 수의 식량을 저장하고 있으며 개미 전사는 식량 창고를 선택적으로 약탈하여 식량을 빼앗을 예정이다. 이때 메뚜기 정찰병들은 일직선상에 존재하는
 * 식량 창고 중에서 서로 인접한 식량 칭고가 공격받으면 바로 알아챌 수 있다.
 *
 * 따라서 개미 전사가 정찰병에게 들키지 않고 식량창고를 약탈하기 위해서는 최소한 한 칸 이상 떨어진 식량창고를 약탈해야 한다.
 *
 * 최소 한 칸 이상 떨어진 식량 창고를 빼앗아 가장 많은 식량을 빼앗을 수 있는 최댓값을 구하는 프로그램
 *
 * 문제 조건
 * 입력 :
 * 첫째 줄에 식량창고의 개수 N이 주어진다.
 * 둘째 줄에 공백을 기준으로 각 식량 창고에 저장된 식량의 개수 K가 주어진다.
 * 출력 :
 * 첫째 줄에 전사가 얻을 수 있는 최댓값을 출력한다.
 * */
public class ant {

    public static int[] d = new int[100];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        d[0] = arr[0];
        d[1] = Math.max(arr[0], arr[1]);

        for (int i = 2; i < n; i++) {

            d[i] = Math.max(d[i - 1], d[i - 2] + arr[i]);
        }

        System.out.println(d[n - 1]);
    }
}
