package algorithms;

import java.io.*;

/**
 * Сервіс перегляду фільмів онлайн має базу даних D вподобань користувачів.
 * Ця база є матрицею. Рядки цієї матриці відповідають користувачам, а стовпці — фільмам.
 * Її розмірність uxm, де usercount — це кількість користувачів, filmCount — кількість фільмів.
 * Кожний елемент матриці statistic[i][j] вказує на позицію фільму j в списку вподобань користувача i.
 * Для спрощення припускаємо, що всі користувачі переглянули всі фільми.
 * */

public class Statistic {
    private int userCount;
    private int filmCount;
    private final File file;

    //матрица данных из файла
    private int[][] statistic;


    //статистика инициализируеться тоько по имени файла
    public Statistic(String fileName){
        this.file = new File(fileName);
        init();
    }

    private void init(){
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            String[] data = reader.readLine().split(" ");
            this.userCount = Integer.parseInt(data[0]);
            this.filmCount = Integer.parseInt(data[1]);
            statistic = new int[userCount][filmCount];

            for(int i = 1; i <= userCount && reader.ready(); i++){
                data = reader.readLine().split(" ");
                int[] stat = new int[filmCount];
                for(int k = 0; k < filmCount; k++)
                    stat[k] = Integer.parseInt(data[k+1]);
                statistic[i-1] = stat;
            }
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public int getUserCount() {
        return userCount;
    }

    public int getFilmCount() {
        return filmCount;
    }

    public int[][] getStatistic() {
        return statistic;
    }

    public File getFile() {
        return file;
    }

    /**
     * @param userNumber номер пользователя, статистику которого мы хотим получить
     * @return массив оценок по фильмам
     * */
    public int[] getUserStat(int userNumber){
        return statistic[userNumber-1];
    }

    /**
     * @param mainUser массив оценок фильмов пользователя, который являеться целевым
     * @param secondaryUser массив оценок пользователя которого хотим сравнить с целевым поьзователем*/
    public int[] getReductionUserStat(int mainUser, int secondaryUser){
        return reductionStat(getUserStat(mainUser), getUserStat(secondaryUser));
    }

    private int[] reductionStat(int[] main, int[] secondary){
        int[] result = new int[filmCount];
        for(int i = 0; i < filmCount; i++){
            int index = main[i]-1;
            result[index] = secondary[i];
        }

        return result;
    }

    @Override
    public String toString() {
        return "Statistic{" +
                "userCount=" + userCount +
                ", filmCount=" + filmCount +
                ", statistic.length=" + statistic.length +
                '}';
    }

    public static void main(String[] args) throws IOException {
        Statistic statistic = new Statistic("test_Inversions.txt");

        int index = 618;
        int i = 1;
//        for(int i = 1; i <= statistic.getUserCount(); i++){
//            if(i == index) continue;
            int[] userStat = statistic.getReductionUserStat(index, i);
            int inv = InvertionCount.countInversion(userStat);
            System.out.print(i + " " + inv);
            System.out.println();
//        }

        index = 951;
        i = 178;
        userStat = statistic.getReductionUserStat(index, i);
        inv = InvertionCount.countInversion(userStat);
        System.out.print(i + " " + inv);
        System.out.println();
    }
}
