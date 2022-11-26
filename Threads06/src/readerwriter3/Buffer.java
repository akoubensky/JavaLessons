package readerwriter3;

/**
 * Реализация задачи о производителе и потребителе.
 * Это решение не приводит к тупиковой ситуации, оно использует механизм извещений о событиях.
 */
public class Buffer {
  final int MAX_COUNT = 10;
  // Буфер на 10 целых чисел.
  private Integer[] buffer = new Integer[MAX_COUNT];
  // Указывает на первую занятую ячейку.
  private int first = 0;
  // Число занятых ячеек.
  private int count = 0;
  
  /**
   * Записывает число в буфер.
   * @param n Записываемое число.
   */
  public synchronized void addObject(Integer n) {
    // Пороверяем, есть ли место, куда можно записать очередное значение.
    while (count == MAX_COUNT) {
      try {
        // Разблокируем буфер и ждем наступления очередного события.
        wait();
      } catch (InterruptedException x) {}
    }
    // Записываем очередное число в буфер.
    buffer[(first + count++) % MAX_COUNT] = n;
    // Извещаем всех о наступлении события.
    notifyAll();
  }
  
  /**
   * Чтение числа из буфера с удалением.
   * @return Прочитанное число.
   */
  public synchronized Integer removeObject() {
    // Проверяем, есть ли в буфере хотя бы одно значение.
    while (count == 0) {
      try {
        // Разблокируем буфер и ждем наступления очередного события.
        wait();
      } catch (InterruptedException x) {}
    }
    Integer toRemove = buffer[first++];
    first %= MAX_COUNT;
    count--;
    // Извещаем всех о наступлении события.
    notifyAll();
    return toRemove;
  }
  
  /**
   * Тестовая функция создает два потока - читателя и писателя - и запускает их.
   * @param args Не используется.
   */
  public static void main (String[] args) {
    final Buffer buffer = new Buffer();
    
    final Reader reader = new Reader(buffer);
    final Writer writer = new Writer(buffer);
    
    reader.start();
    writer.start();
  }
}
