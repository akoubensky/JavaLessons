import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @author Joshua Bloch
 *
 */
public class Worker extends Thread {
  private static final long time = (new Date()).getTime();
  
  private static long interval() {
    return (new Date()).getTime() - time;
  }
  
  private static void log(String s) {
    System.out.println(interval() + ": " + s);
  }
  
  private volatile boolean quittingTime = false;
  
  @Override
  public void run() {
    while (!quittingTime) {
      pretendToWork();
    }
    log("���� - ��� ������");
  }
  
  private void pretendToWork() {
    try {
      log("��������� ����������");
      Thread.sleep(300);
    } catch (InterruptedException ex) {}
  }
  
  /**
   * ��� ������� ������������ ��������� "�������� ����������".
   * @throws InterruptedException
   */
  synchronized void quit() throws InterruptedException {
    log("�����!");
    quittingTime = true;
    join();
  }
  
  /**
   * ��� ������� ������������ ��������� "������� ����������".
   */
  synchronized void keepWorking() {
    log("���������� ������!");
    quittingTime = false;
  }

  /**
   * @param args
   */
  public static void main(String[] args) throws InterruptedException {
    final Worker worker = new Worker();
    worker.start();
    
    Timer t = new Timer();
    t.schedule(new TimerTask() {
      @Override
      public void run() { worker.keepWorking(); }
    }, 500);
    
    Thread.sleep(400);
    worker.quit();
  }

}
