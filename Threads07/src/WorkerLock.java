import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @author Joshua Bloch
 *
 */
public class WorkerLock extends Thread {
  private static final long time = (new Date()).getTime();
  
  private static long interval() {
    return (new Date()).getTime() - time;
  }
  
  private static void log(String s) {
    System.out.println(interval() + ": " + s);
  }
  
  private volatile boolean quittingTime = false;
  
  private final Object lock = new Object();
  
  @Override
  public void run() {
    while (!quittingTime) {
      pretendToWork();
    }
    log("���� - ��� ������");
  }
  
  void pretendToWork() {
    try {
      log("��������� ����������");
      Thread.sleep(300);
    } catch (InterruptedException ex) {}
  }
  
  /**
   * ��� ������� ��������� ��������� "��������" ����������
   * @throws InterruptedException
   */
  void quit() throws InterruptedException {
    synchronized (lock) {
      log("�����!");
      quittingTime = true;
      join();
    }
  }
  
  /**
   * ��� ������� ��������� ��������� "�������" ����������.
   */
  private void keepWorking() {
    synchronized (lock) {
      log("���������� ��������!");
      quittingTime = false;
    }
  }

  /**
   * @param args
   */
  public static void main(String[] args) throws InterruptedException {
    final WorkerLock worker = new WorkerLock();
    worker.start();
    
    Timer t = new Timer();
    t.schedule(new TimerTask() {
      @Override
      public void run() {
        worker.keepWorking(); }
    }, 500);
    
    Thread.sleep(400);
    worker.quit();
  }

}
