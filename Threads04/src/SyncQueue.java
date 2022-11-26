/**
 * Простая очередь целых с операциями, защищенными от ошибок синхронизации.
 */
public class SyncQueue {
	private int size;

	/** Узел очереди */
	private static class QueueNode {
		/** Содержание узла - целое число */
		private int info;

		/** Ссылка на следующий узел */
		private QueueNode next = null;

		public QueueNode(int info) {
			this.info = info;
		}
	}

	/** Голова очереди */
	private QueueNode head = null;

	/** Конец очереди */
	private QueueNode tail = null;

	/**
	 * Добавляет в очередь очередной элемент и записывает его номер.
	 * @return Номер очередного добавленного элемента
	 */
	public synchronized void offer(int i) {
		QueueNode newNode = new QueueNode(i);
		if (head == null) {
			head = tail = newNode;
		} else {
			tail.next = newNode;
			tail = newNode;
		}
		size++;
	}

	/**
	 * Удаляет из очереди первый элемент.
	 * @return Значение удаленного элемента.
	 */
	public synchronized int poll() {
		if (head == null) return 0;
		int result = head.info;
		if (head == tail) {
			head = tail = null;
		} else {
			head = head.next;
		}
		size--;
		return result;
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}
}
