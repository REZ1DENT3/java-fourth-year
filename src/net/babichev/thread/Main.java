package net.babichev.thread;

class EggVoice extends Thread
{
    public long time = 0;

    @Override
    public void run()
    {
        time = System.nanoTime();
        for(int i = 0; i < 500; i++)
        {
            System.out.println("яйцо!");
        }
        time = System.nanoTime() - time;
        //Слово «яйцо» сказано 5 раз
    }
}

public class Main	//Класс с методом main()
{
    static EggVoice mAnotherOpinion;	//Побочный поток

    public static void main(String[] args)
    {
        mAnotherOpinion = new EggVoice();	//Создание потока
        System.out.println("Спор начат...");
        mAnotherOpinion.start(); 			//Запуск потока

        long time = System.nanoTime();
        for(int i = 0; i < 500; i++)
        {
            System.out.println("курица!");
        }
        time = System.nanoTime() - time;
        //Слово «курица» сказано 5 раз

        while (mAnotherOpinion.isAlive());

        System.out.println(time + " " + mAnotherOpinion.time);
        if (time < mAnotherOpinion.time) {
            System.out.println("Первым появилось яйцо!");
        }
        else {
            System.out.println("Первой появилась курица!");
        }

        try{
            mAnotherOpinion.join();	//Подождать пока оппонент закончит высказываться.
        }catch(InterruptedException e){}

        System.out.println("Спор закончен!");
    }
}