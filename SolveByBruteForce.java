import java.util.Arrays;

public class SolveByBruteForce {

    static int num_rows = 5;
    static int num_cols = 6;

    public static void main(String[] args) {

        System.out.println(Arrays.deepToString(bruteForce()));

    }

    public static int[][][] bruteForce() {
        int[] val = {0, 1};
        int[] array = new int[0];
        // there are 2 unique solutions
        int[][] array_2d = new int[2][30];
        int[][][] sol = new int[2][5][6];
        int i = 0;
        int k = 0;
        for (int one : val) {
            for (int two : val) {
                for (int three : val) {
                    for (int four : val) {
                        for (int five : val) {
                            for (int six : val) {
                                for (int seven : val) {
                                    for (int eight : val) {
                                        for (int nine : val) {
                                            for (int ten : val) {
                                                for (int eleven : val) {
                                                    for (int twelve : val) {
                                                        for (int thirteen : val) {
                                                            for (int fourteen : val) {
                                                                for (int fifteen : val) {
                                                                    for (int sixteen : val) {
                                                                        for (int seventeen : val) {
                                                                            for (int eighteen : val) {
                                                                                for (int nineteen : val) {
                                                                                    for (int twenty : val) {
                                                                                        for (int twentyone : val) {
                                                                                            for (int twentytwo : val) {
                                                                                                for (int twentythree : val) {
                                                                                                    for (int twentyfour : val) {
                                                                                                        for (int twentyfive : val) {
                                                                                                            for (int twentysix : val) {
                                                                                                                for (int twentyseven : val) {
                                                                                                                    for (int twentyeight : val) {
                                                                                                                        for (int twentynine : val) {
                                                                                                                            for (int thirty : val) {
                                                                                                                                array = new int[]{one, two, three, four, five, six, seven, eight, nine, ten, eleven, twelve, thirteen,
                                                                                                                                        fourteen, fifteen, sixteen, seventeen, eighteen, nineteen, twenty, twentyone, twentytwo, twentythree,
                                                                                                                                        twentyfour, twentyfive, twentysix, twentyseven, twentyeight, twentynine, thirty};
                                                                                                                                if ((one + two + three + four != 4) &&
                                                                                                                                    (two + three + four + five !=4) &&
                                                                                                                                    (one + seven + thirteen + nineteen != 4) &&
                                                                                                                                    (one + eight + fifteen + twentytwo !=4) &&
                                                                                                                                    (two + eight + fourteen + twenty !=4) &&
                                                                                                                                    (two + nine + sixteen + twentythree != 4) &&
                                                                                                                                    (three + four + five + six != 4) &&
                                                                                                                                    (three + nine + fifteen + twentyone !=4) &&
                                                                                                                                    (three + ten + seventeen + twentyfour !=4) &&
                                                                                                                                    (four + ten + sixteen + twentytwo !=4) &&
                                                                                                                                    (four + nine + fourteen + nineteen !=4) &&
                                                                                                                                    (five + ten + fifteen + twenty !=4) &&
                                                                                                                                    (five + eleven + seventeen + twentythree !=4) &&
                                                                                                                                    (six + twelve + eighteen + twentyfour !=4) &&
                                                                                                                                    (six + eleven + sixteen + twentyone !=4) &&
                                                                                                                                    (seven + thirteen + nineteen + twentyfive !=4) &&
                                                                                                                                    (seven + eight + nine + ten !=4) &&
                                                                                                                                    (seven + fourteen + twentyone + twentyeight !=4) &&
                                                                                                                                    (eight + nine + ten + eleven !=4) &&
                                                                                                                                    (eight + fourteen + twenty + twentysix !=4) &&
                                                                                                                                    (eight + fifteen+ twentytwo + twentynine !=4) &&
                                                                                                                                    (nine + ten + eleven + twelve !=4) &&
                                                                                                                                    (nine + fifteen + twentyone + twentyseven) !=4 &&
                                                                                                                                    (nine + sixteen + twentythree + thirty !=4) &&
                                                                                                                                    (ten + sixteen + twentytwo + twentyeight !=4) &&
                                                                                                                                    (ten + fifteen + twenty + twentyfive !=4) &&
                                                                                                                                    (eleven + seventeen + twentythree + twentynine !=4) &&
                                                                                                                                    (eleven + sixteen + twentyone + twentysix !=4) &&
                                                                                                                                    (twelve + eighteen + twentyfour + thirty !=4) &&
                                                                                                                                    (twelve + seventeen + twentytwo + twentyseven !=4) &&
                                                                                                                                    (thirteen + fourteen + fifteen + sixteen !=4) &&
                                                                                                                                    (fourteen + fifteen + sixteen + seventeen !=4) &&
                                                                                                                                    (fifteen + sixteen + seventeen + eighteen !=4) &&
                                                                                                                                    (nineteen + twenty + twentyone + twentytwo !=4) &&
                                                                                                                                    (twenty + twentyone + twentytwo + twentythree !=4) &&
                                                                                                                                    (twentyone + twentytwo + twentythree + twentyfour !=4) &&
                                                                                                                                    (twentyfive + twentysix + twentyseven + twentyeight !=4) &&
                                                                                                                                    (twentysix + twentyseven + twentyeight + twentynine !=4) &&
                                                                                                                                    (twentyseven + twentyeight + twentynine + thirty !=4) &&
                                                                                                                                    // least number of 0's we can have is 8
                                                                                                                                    (one + two + three + four + five + six + seven + eight + nine + ten + eleven +
                                                                                                                                    twelve + thirteen + fourteen + fifteen + sixteen + seventeen + eighteen +
                                                                                                                                    nineteen + twenty + twentyone + twentytwo + twentythree + twentyfour + twentyfive +
                                                                                                                                    twentysix + twentyseven + twentyeight + twentynine + thirty == 22)) {
                                                                                                                                    for (int j = 0; j < 30; j++) {
                                                                                                                                        array_2d[i][j] = array[j];
                                                                                                                                    }
                                                                                                                                    i++;
                                                                                                                                    for (int l = 0; l < num_rows; l++) {
                                                                                                                                        for (int m = 0; m < num_cols; m++) {
                                                                                                                                            sol[k][l][m] = array_2d[k][m+6*l];
                                                                                                                                        }
                                                                                                                                    }
                                                                                                                                    k++;
                                                                                                                                }
                                                                                                                            }
                                                                                                                        }
                                                                                                                    }
                                                                                                                }
                                                                                                            }
                                                                                                        }
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return sol;
    }
}
